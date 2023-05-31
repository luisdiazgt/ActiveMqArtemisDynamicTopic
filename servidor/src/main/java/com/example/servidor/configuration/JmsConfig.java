package com.example.servidor.configuration;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListenerConfigurer;
import org.springframework.jms.config.JmsListenerEndpointRegistrar;
import org.springframework.jms.config.SimpleJmsListenerEndpoint;

import com.example.servidor.model.MensajeActiveMQ;

import lombok.extern.java.Log;

@Configuration
@EnableJms
@Log
public class JmsConfig implements JmsListenerConfigurer {

    @Value("${topic.dinamico}")
    private List<String> queueList;

    @Override
    public void configureJmsListeners(JmsListenerEndpointRegistrar registrar) {

        queueList.forEach(queue -> {

            SimpleJmsListenerEndpoint endpoint = new SimpleJmsListenerEndpoint();
            endpoint.setId(queue);
            endpoint.setDestination(queue);
            endpoint.setMessageListener(message -> {
                // processing
                try {

                    

                    String topic = message.getJMSDestination().toString();
                    String idmessage = message.getJMSMessageID().toString();
                    String correlationid = message.getJMSCorrelationID();

                    // Object test2 = message.getBody();
                    // MensajeActiveMQ test3 = (MensajeActiveMQ) test2;

                    // Si fuera topic con clase o objeto
                    ObjectMessage objectMessage = (ObjectMessage) message;
                    Object test2 = (MensajeActiveMQ) objectMessage.getObject();

                    // ObjectMessage test = (ObjectMessage) message;
                    if (message.getJMSDestination().equals("topic3")) {
                        MensajeActiveMQ test = (MensajeActiveMQ) message;
                    }                    

                    // Si fuera topic con string 
                    String mensajeTexto = ((TextMessage) message).getText();

                    log.info("Receieved ID: " +  message.getJMSMessageID() +" ,Topic: " + message.getJMSDestination() +" ,Mensaje: " + mensajeTexto );

                    
                }
                catch (Exception e) {
                    log.info("Exception while reading message - " + e);
                }

            });
            registrar.registerEndpoint(endpoint);

        });

        
    }

    // @Override
    // public void configureJmsListeners2(JmsListenerEndpointRegistrar registrar) {

    //     queueList.forEach(queue -> {
    //         SimpleJmsListenerEndpoint endpoint = new SimpleJmsListenerEndpoint();
    //         endpoint.setId(queue);
    //         endpoint.setDestination(queue);
    //         try {
    //             endpoint.setMessageListener(message -> {
    //                 try {
    //                     log.info("Receieved ID: " +  message.getJMSMessageID() +" Destination " + message.getJMSDestination());
    //                 }
    //                 catch (Exception e) {
    //                     log.info("Exception while reading message - " + e);
    //                 }
    //             });
    //             registrar.setContainerFactory(mqJmsListenerContainerFactory());
    //         }
    //         catch (Exception e) {
    //             log.info("Exception - " + e);
    //         }
    //         registrar.registerEndpoint(endpoint);
    //     });

    // }

    
}
