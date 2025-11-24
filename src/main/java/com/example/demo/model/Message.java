package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String sessionId;

  @Column(columnDefinition = "TEXT")
  private String userMessage;

  @Column(columnDefinition = "TEXT")
  private String aiReply;

  private LocalDateTime createdAt = LocalDateTime.now();

  // getters/setters
  public Long getId() {
    return id;
  }

  public String getSessionId() {
    return sessionId;
  }

  public void setSessionId(String sessionId) {
    this.sessionId = sessionId;
  }

  public String getUserMessage() {
    return userMessage;
  }

  public void setUserMessage(String userMessage) {
    this.userMessage = userMessage;
  }

  public String getAiReply() {
    return aiReply;
  }

  public void setAiReply(String aiReply) {
    this.aiReply = aiReply;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }
}
