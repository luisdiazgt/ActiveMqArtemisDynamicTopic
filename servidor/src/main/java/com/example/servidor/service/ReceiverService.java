package com.example.servidor.service;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.annotation.JmsListenerConfigurer;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerEndpointRegistrar;
import org.springframework.jms.config.SimpleJmsListenerEndpoint;
import org.springframework.jms.support.destination.DynamicDestinationResolver;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

// @Log
@Component
public class ReceiverService {

    
    
    // @JmsListener(destination = "${jms.colaTest}")
    // public void leerMensaje(String mensaje){
    //     log.info("Servidor - procesando colaTest, mensaje: " + mensaje);
    // }

    // @JmsListener(destination = "${jms.colaTestEntidad}")
    // public void leerMensajeEntidad(String mensaje){
    //     log.info("Servidor - procesando colaTestEntidad, mensaje: " + mensaje);
    // }

    

    

}
