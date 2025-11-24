package com.example.demo.controller;

import com.example.demo.model.Message;
import com.example.demo.repository.MessageRepository;
import com.example.demo.service.AiService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

  private final AiService aiService;
  private final MessageRepository messageRepository;

  public ChatController(AiService aiService, MessageRepository messageRepository) {
    this.aiService = aiService;
    this.messageRepository = messageRepository;
  }

  @PostMapping
  public Message chat(@RequestParam String sessionId, @RequestParam String message) {
    String aiReply = aiService.getAiReply(message);

    Message m = new Message();
    m.setSessionId(sessionId);
    m.setUserMessage(message);
    m.setAiReply(aiReply);

    return messageRepository.save(m);
  }

  @GetMapping("/history")
  public List<Message> history(@RequestParam String sessionId) {
    return messageRepository.findBySessionIdOrderByCreatedAt(sessionId);
  }
}
