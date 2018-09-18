/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chat.controller;

import com.chat.dto.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

/**
 *
 * @author abhisheksingh01
 */
@Controller
public class ChatController {
    
	/**
	 *
	 * This method receive the message which is send to chat.sendMessage
	 * It also send the same message to /topic/message
	 * All method at client side which subscribe to it will receive this message
	 */
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/message")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }

    /**
	 *
	 * This method add new user in memory storage
	 * All method at client side which subscribe to /topic/join 
	 * will receive this message
	 */
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/join")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, 
                               SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
    
}
