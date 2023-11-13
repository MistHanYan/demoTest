package com.example.util.tools;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetAccount {
    public String generateRandomString() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "").substring(0, 10);
    }
}
