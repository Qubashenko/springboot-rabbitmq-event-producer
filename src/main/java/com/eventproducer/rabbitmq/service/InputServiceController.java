package com.eventproducer.rabbitmq.service;


import com.eventproducer.rabbitmq.model.EventMsg;
import com.eventproducer.rabbitmq.model.RequestedMsg;
import com.eventproducer.rabbitmq.model.User;
import com.eventproducer.rabbitmq.producer.Producer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class InputServiceController {

    @Autowired
    Producer producer;

    @Autowired
    EventMsg eventMsg;

    @Autowired
    RequestedMsg requestedMsg;

    @Autowired
    ObjectMapper objectMapper;

    @RequestMapping("/addUser")
    User addUser(@RequestParam("id") int id, @RequestParam("name") String name,
                 @RequestParam("mobileNum") String mobileNum, @RequestParam("email") String email) throws JsonProcessingException {

        User user = new User(id, name, mobileNum, email);
        String jsonInString = objectMapper.writeValueAsString(user);

        requestedMsg.setRequestedBody(Arrays.asList(user));
        List<RequestedMsg> requestedMsgs = new ArrayList<>(Arrays.asList(requestedMsg));

        eventMsg.setProducer("/addUser endpoint");
        eventMsg.setRequestedMsgs(requestedMsgs);
        producer.produce(eventMsg);

        return user;
    }

}
