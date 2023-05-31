package com.example.cliente.model;

import lombok.Data;

@Data
public class MensajeActiveMQ implements java.io.Serializable {
    String mensaje;
    String id;
}
