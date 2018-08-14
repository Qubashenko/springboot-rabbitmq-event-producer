package com.eventproducer.rabbitmq.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.stereotype.Component;



@AllArgsConstructor
public class User {
    @Setter @Getter
    public int id;
    @Setter @Getter
    public String name;
    @Setter @Getter
    public String mobileNum;
    @Setter @Getter
    public String email;

}
