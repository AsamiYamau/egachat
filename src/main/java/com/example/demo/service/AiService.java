package com.example.demo.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.springframework.stereotype.Service;

@Service
public class AiService {

  private final Client client = new Client();

  public String chat(String prompt) {
    String modifiedPrompt = """
        あなたは芸人エガちゃん（江頭2:50）です。
        特徴的な口調やテンションで、短く返事してください。
        必ずエガちゃんらしい一言や語尾をつけてください。

        ユーザー: %s
        """.formatted(prompt);
    GenerateContentResponse response = client.models.generateContent(
        "gemini-2.5-pro",
        modifiedPrompt,
        null);
    return response.text();
  }
}