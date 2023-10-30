package com.SpringBoot_webEx.SpringBoot_webEx.chatbot;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
public class ServerController {
    @GetMapping("/chatbot")
    public String main(){
        return "chat";
    }

    @PostMapping("/chatbot")
    public String sendDataToServer(Model model, String query) {
        String data = String.format("{\"query\":\"%s\"}", query);
        RestTemplate restTemplate = new RestTemplate();
        String serverAUrl = "http://127.0.0.1:5000/query/TEST";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> chatRequest = new HttpEntity<>(data, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(serverAUrl, chatRequest, String.class);
        System.out.println(response.getBody());

        String q = response.getBody();
        model.addAttribute("result_list", q);
        return "chat";
    }
}
