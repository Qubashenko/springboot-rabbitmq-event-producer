package com.eventproducer.rabbitmq.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,property="@id", scope = RequestedMsg.class)
public class RequestedMsg {

    public RequestedMsg(String requestedBody){
        this.requestedBody = requestedBody;
    }

    @Getter @Setter
    String requestedHeader;
    @Getter @Setter
    String requestedCode;
    @Getter @Setter
    String requestedBody;

}