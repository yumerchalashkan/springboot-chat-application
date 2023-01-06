package com.example.ChatApplication.controller;

import com.example.ChatApplication.response.MessageResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin
public class MainController {

    private SimpMessagingTemplate simpMessagingTemplate;

    public MainController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    //@SendTo("/channel")
    @MessageMapping("/message")
    public void sendMessage(@Payload MessageResponse messageResponse) {
        System.out.println(messageResponse);
        simpMessagingTemplate.convertAndSend("/channel", messageResponse);
    }
}
