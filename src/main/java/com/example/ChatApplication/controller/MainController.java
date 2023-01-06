package com.example.ChatApplication.controller;

import com.example.ChatApplication.response.MessageResponse;
import com.example.ChatApplication.service.UserListService;
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
    private UserListService userListService;

    public MainController(SimpMessagingTemplate simpMessagingTemplate, UserListService userListService) {
        this.simpMessagingTemplate = simpMessagingTemplate;
        this.userListService = userListService;
    }

    //@SendTo("/channel")
    @MessageMapping("/message")
    public void sendMessage(@Payload MessageResponse messageResponse) {
        System.out.println(messageResponse);
        simpMessagingTemplate.convertAndSend("/channel", messageResponse);
    }

    @MessageMapping("/disconnect")
    public void disconnect(@Payload MessageResponse messageResponse) {
        userListService.removeUser(messageResponse.getSender());
        System.out.println(userListService.getUserList());
        MessageResponse messageResponse1 = new MessageResponse();
        messageResponse1.setSender("disconnected");
        messageResponse1.setMessage(userListService.getUserList());
        simpMessagingTemplate.convertAndSend("/update", messageResponse1);
    }

    @MessageMapping("/connect")
    public void connect(@Payload MessageResponse messageResponse) {
        userListService.addUser(messageResponse.getSender());
        System.out.println(userListService.getUserList());
        MessageResponse messageResponse1 = new MessageResponse();
        messageResponse1.setSender("connected");
        messageResponse1.setMessage(userListService.getUserList());
        simpMessagingTemplate.convertAndSend("/update", messageResponse1);
    }
}
