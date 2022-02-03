package com.example.chatbackend.controller;

import com.example.chatbackend.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    public Message recievePublicMessage(@Payload Message message){
        return message;
    }

    @MessageMapping("/private-message")
    public Message recievePrivateMessage(@Payload Message message){
        // /user/david/private
        simpMessagingTemplate.convertAndSendToUser(message.getTo().getFullname(),"/private",message);
        return message;
    }
}
