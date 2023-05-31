package com.example.cliente.service;

import org.springframework.jms.core.JmsTemplate;

import javax.jms.ObjectMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.cliente.model.MensajeActiveMQ;
import lombok.extern.java.Log;

@Log
@Service
public class SenderService {

    @Autowired
    JmsTemplate jmsTemplate;

    @Value("${jms.topic1}")
    String jmsColaTest1;

    @Value("${jms.topic2}")
    String jmsColaTest2;

    @Value("${jms.topic3}")
    String jmsColaTest3;

    @Value("${jms.colaTestEntidad}")
    String jmsColaTestEntidad;

    public void enviaCola1(String request)
    {
        log.info("Cliente - mensaje enviado. Topic1 Mensaje: " + request);
        jmsTemplate.convertAndSend(jmsColaTest1, request);
    }

    public void enviaCola2(String request)
    {
        log.info("Cliente - mensaje enviado. Topic2 Mensaje: " + request);
        jmsTemplate.convertAndSend(jmsColaTest2, request);
    }

    public void enviaCola3(MensajeActiveMQ request)
    {
        log.info("Cliente - mensaje enviado. Topic3 Mensaje: " + request);
        // jmsTemplate.convertAndSend(jmsColaTest3, request);
        jmsTemplate.send(jmsColaTest3, session->{
            ObjectMessage textMessage=session.createObjectMessage(request);
            textMessage.setJMSCorrelationID("1234");
            return textMessage;
        });
    }

    public void enviaColaEntidad(String request)
    {
        log.info("Cliente - mensaje entidad enviado. Mensaje: " + request);
        jmsTemplate.convertAndSend(jmsColaTestEntidad, request);
    }
    
}
