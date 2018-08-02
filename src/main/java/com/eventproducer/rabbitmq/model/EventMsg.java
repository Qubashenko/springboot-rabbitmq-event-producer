package com.eventproducer.rabbitmq.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

@Component
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,property="@id", scope = EventMsg.class)
public class EventMsg {

    @Getter @Setter
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    @Getter @Setter
    String producer;
    @Getter @Setter
    String internalCode;
    @Getter @Setter
    List<RequestedMsg> requestedMsgs;
    @Override
    public String toString(){
        JSONObject jsonObject = new JSONObject();
        try {

            jsonObject.put(String.valueOf(new Timestamp(System.currentTimeMillis())), this.timestamp);

            JSONArray requestedMsgArray = new JSONArray();
            if (this.requestedMsgs != null) {
                this.requestedMsgs.forEach(requestedMsg -> {
                    JSONObject subJson = new JSONObject();
                    try {
                        subJson.put("requestedMsgBody", requestedMsg.getRequestedBody());
                    } catch (JSONException e) {}

                    requestedMsgArray.put(subJson);
                });
            }


        } catch (JSONException ex){

        }

        return jsonObject.toString();
    }
}
