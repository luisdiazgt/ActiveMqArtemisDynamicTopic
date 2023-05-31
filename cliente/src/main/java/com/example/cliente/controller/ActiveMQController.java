package com.example.cliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cliente.model.MensajeActiveMQ;
import com.example.cliente.service.SenderService;

@RestController
@RequestMapping(value = "/activemq")
public class ActiveMQController {

    @Autowired
	SenderService senderService;

    @PostMapping(value = "/topic1")
	public ResponseEntity<?> sendMessageToKafkaTopic1(@RequestBody String message) {
		this.senderService.enviaCola1(message);
		return ResponseEntity.ok().body("true");
	}

	@PostMapping(value = "/topic2")
	public ResponseEntity<?> sendMessageToKafkaTopic2(@RequestBody String message) {
		this.senderService.enviaCola2(message);
		return ResponseEntity.ok().body("true");
	}

	@PostMapping(value = "/topic3")
	public ResponseEntity<?> sendMessageToKafkaTopic3(@RequestBody MensajeActiveMQ message) {
		this.senderService.enviaCola3(message);
		return ResponseEntity.ok().body("true");
	}

	@PostMapping(value = "/entity")
	public ResponseEntity<?> sendMessageToKafkaTopicEntity(@RequestBody MensajeActiveMQ message) {
		this.senderService.enviaColaEntidad(message.getMensaje());
		return ResponseEntity.ok().body("true");
	}
    
}
