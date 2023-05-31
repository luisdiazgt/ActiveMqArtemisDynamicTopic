
- [Introducción](#introducción)
- [Prerequisito(s)](#prerequisitos)
- [Docker](#docker)

# Introducción

El repositorio contiene 2 proyectos, el cliente que genera un mensaje hacia el broker. El servidor procesa el mensaje ingresado en el broker. Nota: para el topic dinámico con objeto se debe crear y leer el mensaje desde el mismo paquete, por eso se creo todo en el servidor.

# Prerequisito(s)

- Docker
- ActiveMQ(Artemis)

# Docker

Ejecutar el siguiente comando en docker.

```
    docker run -e AMQ_USER=admin -e AMQ_PASSWORD=admin -p 61616:61616 -p 8161:8161 --name artemis quay.io/artemiscloud/activemq-artemis-broker:dev.latest
```

Consola administrativa: http://localhost:8161/console/auth/login \
user: admin \
password: admin \
Puerto petición cola: 61616
