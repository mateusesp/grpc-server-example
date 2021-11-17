package com.example.grpcserverspring;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import service.UserService;

import java.io.IOException;
import java.util.logging.Logger;

@SpringBootApplication
public class GrpcServerSpringApplication {

    private static final Logger logger = Logger.getLogger(GrpcServerSpringApplication.class.getName());

    public static void main(String[] args) throws IOException, InterruptedException {

        SpringApplication.run(GrpcServerSpringApplication.class, args);

        Server server = ServerBuilder.forPort(50051).addService(new UserService()).build();

        server.start();

        logger.info("Server started on " + server.getPort());

        server.awaitTermination();
    }

}
