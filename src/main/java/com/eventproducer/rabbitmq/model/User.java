package com.eventproducer.rabbitmq.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
