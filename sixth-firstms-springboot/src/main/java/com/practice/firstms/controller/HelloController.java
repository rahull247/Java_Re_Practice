package com.practice.firstms.controller;

import com.practice.firstms.service.ProfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @Autowired
    private ProfilesService profilesService;

    @Value("${db.url}")
    private String dbURL;

    @Value("${otherms.url}")
    private String otherMSURL;


    @GetMapping("/hello")
    private String helloWrold(){
        return "Hello from controller...!";
    }


    @GetMapping("/profiles")
    public String getProfileData(){
        return profilesService.getProfiles();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private Map<String, String> getProperty(){
        HashMap<String, String> hashMap=new HashMap<>();
        hashMap.put("DB URL:", dbURL);
        hashMap.put("MS URL:", otherMSURL);
        return  hashMap;
    }

}
