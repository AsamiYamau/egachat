package com.example.demo.controller;

import com.example.demo.service.AiService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

  private final AiService aiService;

  public ChatController(AiService aiService) {
    this.aiService = aiService;
  }

  @PostMapping
  public String chat(@RequestBody String message) {
    return aiService.chat(message);
  }
}
