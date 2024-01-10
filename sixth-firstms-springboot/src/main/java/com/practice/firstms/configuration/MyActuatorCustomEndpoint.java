package com.practice.firstms.configuration;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "custom")
public class MyActuatorCustomEndpoint {

    private String notReady="Not Ready";

    @ReadOperation
    public String getNotReady(){
        System.out.println("*** Get Ready ***");
        return notReady;
    }

    @WriteOperation
    public String PostReady(){
        System.out.println("*** Post Ready ***");
        return "Post Ready";
    }

    @EventListener(ApplicationReadyEvent.class)
    public void setReady(){
        System.out.println("Set Ready");
        notReady="Ready";
    }

}
