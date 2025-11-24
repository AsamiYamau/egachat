package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.util.Map;

@Service
public class AiService {

  private final String API_KEY = "YOUR_API_KEY";
  private final String ENDPOINT = "https://us-central1-aiplatform.googleapis.com/v1/projects/YOUR_PROJECT/locations/us-central1/publishers/google/models/gemini-1.5-chat:predict";

  private final WebClient client = WebClient.builder()
      .baseUrl(ENDPOINT)
      .defaultHeader("Authorization", "Bearer " + API_KEY)
      .build();

  public String getAiReply(String userMessage) {
    Map<String, Object> payload = Map.of(
        "instances", new Object[] { Map.of("content", userMessage) });

    Mono<Map> response = client.post()
        .bodyValue(payload)
        .retrieve()
        .bodyToMono(Map.class);

    Map result = response.block(); // 簡易例: ブロッキング呼び出し
    // 実際は JSON パースが必要
    // ここでは単純化のため文字列返却
    return result.toString();
  }
}
