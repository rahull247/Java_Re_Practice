package com.practice.secondms.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.practice.secondms.dto.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@EnableHystrix
public class ClientController {

    @Autowired
    private RestTemplate restTemplate;

    

    @GetMapping("/hello-client")
    public String getHello(){
        return "Hello from client";
    }

    @GetMapping("/persons-client")
    public List getClientPerson(){
        System.out.println("getClientPerson called!");
        List personsList = restTemplate.getForObject("http://localhost:8081/Persons", List.class);
        return personsList;
    }

    //Eureka load balance example to call instance first microservice in round robin
    @GetMapping("/persons-load-balance")
    public List getClientPersonWithLoadBalance(){
        System.out.println("getClientPersonWithLoadBalance called!");
        List personsList = restTemplate.getForObject("http://first-microservice/Persons", List.class);
        return personsList;
    }

    @GetMapping("/get-persons-client")
    public List<PersonDto> getClientPersonInDto(){
        System.out.println("getClientPersonInDTO called!");
        List<PersonDto> personsList = restTemplate.getForObject("http://localhost:8081/Persons-dto", List.class);
        return personsList;
    }

    /*Below method will call first microservice and if it's down then it will return static message*/
    @GetMapping(value = "/get-persons-hystrix", produces = MediaType.APPLICATION_JSON_VALUE)
    @HystrixCommand(fallbackMethod = "getMeStaticPersonResponse",
            commandProperties = {
                    @HystrixProperty(
                            name = "execution.isolation.thread.timeoutInMilliseconds",
                            value = "5000"
                    ),
                    @HystrixProperty(
                            name = "execution.isolation.strategy",
                            value = "THREAD"
                    )
            },
            threadPoolKey = "firstmsThreadPoolKey",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "4"),
                    @HystrixProperty(name = "maxQueueSize", value = "5")
            })
    public List getClientPersonInDtoHystrix(){
        System.out.println("getClientPersonInDTO called!");
        List<PersonDto> personsList = restTemplate.getForObject("http://first-microservice/Persons-dto", List.class);
        return personsList;
    }

    public static List getMeStaticPersonResponse(){
       return Arrays.asList("This", "is", "hystrix", "custom", "response");
    }

    @PostMapping(value = "/post-persons-client", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object postClientPersonDto(){
        System.out.println("postClientPersonInDTO called!");
        HttpHeaders httpHeaders=new HttpHeaders();
        /*ArrayList<String> objects=new ArrayList<>();
        objects.add(MediaType.APPLICATION_JSON_VALUE);*/
        //httpHeaders.setAccept();
        httpHeaders.set("accept", MediaType.APPLICATION_JSON_VALUE);
        httpHeaders.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        PersonDto personDto=new PersonDto();
        personDto.setName("Gabbi");
        personDto.setAge(26);
        personDto.setNickName("Gab");
        HttpEntity<String> stringHttpEntity=new HttpEntity(personDto, httpHeaders);
        Object personObject = restTemplate.postForObject("http://localhost:8081/Persons", stringHttpEntity, Object.class);
        return personObject;
    }

    @PostMapping(value = "/post-persons-client-xml",consumes = {MediaType.APPLICATION_XML_VALUE,
                                                                MediaType.APPLICATION_JSON_VALUE})
    public String postClientPersonDtoXml(){
        System.out.println("postClientPersonInDTO called!");
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.set("accept", MediaType.APPLICATION_XML_VALUE);
        httpHeaders.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        PersonDto personDto=new PersonDto();
        personDto.setName("Tom");
        personDto.setAge(32);
        personDto.setNickName("Hank");
        HttpEntity<String> stringHttpEntity=new HttpEntity(personDto, httpHeaders);
        String personObject = restTemplate.postForObject("http://localhost:8081/Persons", stringHttpEntity, String.class);
        return personObject;
    }
}
