package com.example.servidor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.servidor.model.MensajeActiveMQ;
import com.example.servidor.service.SenderService;

@RestController
@RequestMapping(value = "/activemqserver")
public class ActiveMQController {

    @Autowired
	SenderService senderService;

    @PostMapping(value = "/topic3")
	public ResponseEntity<?> sendMessageToKafkaTopic3(@RequestBody MensajeActiveMQ message) {
		this.senderService.enviaCola3(message);
		return ResponseEntity.ok().body("true");
	}
    
}
