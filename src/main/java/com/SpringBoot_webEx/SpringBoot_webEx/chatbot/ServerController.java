package com.SpringBoot_webEx.SpringBoot_webEx.chatbot;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class ServerController {
    @GetMapping("/chatbot/{query}")
    public ResponseEntity<String> sendDataToServer(@PathVariable("query") String query) {
        String data = String.format("{\"query\":\"%s\"}", query);
        RestTemplate restTemplate = new RestTemplate();
        // Server A로 POST 요청 보냅니다.
        String serverAUrl = "http://127.0.0.1:5000/query/TEST";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> chatRequest = new HttpEntity<>(data, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(serverAUrl, chatRequest, String.class);

        System.out.println("Server A에서 받은 응답: " + response.getBody());
        return response;
    }
}