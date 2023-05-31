package com.example.servidor.service;

import javax.jms.ObjectMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.example.servidor.model.MensajeActiveMQ;

import lombok.extern.java.Log;

@Log
@Service
public class SenderService {
    
    @Autowired
    JmsTemplate jmsTemplate;

    @Value("${jms.topic3}")
    String jmsColaTest3;

    public void enviaCola3(MensajeActiveMQ request)
    {
        log.info("Servidor - mensaje enviado. Topic3 Mensaje: " + request);
        // jmsTemplate.convertAndSend(jmsColaTest3, request);
        jmsTemplate.send(jmsColaTest3, session->{
            ObjectMessage textMessage=session.createObjectMessage(request);
            textMessage.setJMSCorrelationID("1234");
            return textMessage;
        });
    }

}
