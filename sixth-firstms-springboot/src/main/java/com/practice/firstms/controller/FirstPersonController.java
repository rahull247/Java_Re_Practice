package com.practice.firstms.controller;

import com.practice.firstms.dto.PersonDto;
import com.practice.firstms.entity.Person;
import com.practice.firstms.exception.MyCustomException;
import com.practice.firstms.repository.PersonRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Api(tags = "API endpoints for operation on Person Resource")
@RestController
public class FirstPersonController {

    @Autowired
    private PersonRepository personRepository;

    @ApiOperation(value = "Fetching all persons", notes = "This returns all person use it well")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Sucessfully Fetched", response = Person.class)
    })
    @GetMapping(path = "/Persons", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    //@CrossOrigin("https://www.w3school.com")
    private List<Person> getPersons(){
        return personRepository.findAll();
    }

    @GetMapping(path = "/Persons-dto", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    private List<PersonDto> getPersonsDto(){

        List<Person> personList = personRepository.findAll();

        List<PersonDto> personDtoList = personList.stream().map(person ->{
            PersonDto personDto=new PersonDto(person.getId(), person.getName(),
                                              person.getAge(), person.getNickName());
            return personDto;
        }).collect(Collectors.toList());
        return personDtoList;
    }

    @PostMapping(path = "/Persons", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
    consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    private ResponseEntity<Person> postPerson(@RequestBody Person person) throws URISyntaxException {
        if(Objects.isNull(person.getName()) || person.getName().trim().length() <= 0){
            return ResponseEntity.badRequest().build();
        }

        Person newPerson = personRepository.save(person);
        if(Objects.nonNull(newPerson.getId())){
            return ResponseEntity.created(new URI(newPerson.getId().toString())).body(newPerson);
        }
        return  ResponseEntity.internalServerError().build();
    }

    @GetMapping(path = "/Persons/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    private ResponseEntity<Person> findById(@PathVariable Integer id){
        if(id == 10){
            throw new MyCustomException(121, "This id is not allowed");
        }
        Optional<Person> person = personRepository.findById(id);
        if(person.isPresent()){
            return ResponseEntity.ok(person.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/persons/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Person> deletePerson(@PathVariable Integer id) {

        personRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }

}
