package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class InfoService {
    @Value("${server.port:8080}")
    private String port;

    public String getPort() {
        return port;
    }
}
