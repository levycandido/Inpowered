package com.inpowered.candidate.levy.config;

import com.inpowered.candidate.levy.domain.Customer;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "server")
@Data
public class ServerConfig {

    private Customer customer;
    private Map<String, String> resourcesPath;

    /**
     * Name of the server.
     */
    private String name;

    /**
     * IP address to listen to.
     */
    private String ip = "127.0.0.1";

    /**
     * Port to listener to.
     */
    private int port = 9797;

}