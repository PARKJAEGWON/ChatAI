package com.ll.chat_ai;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
//@RequiredArgsConstructor
@RequestMapping("/api/v1/chat")
public class ChatController {

    private final OpenAiChatModel openAiChatModel;


    public ChatController(OpenAiChatModel openAiChatModel) {
        this.openAiChatModel = openAiChatModel;
    }

    @GetMapping("/ai")
    public Map<String, String > chat(@RequestBody String message){
        Map<String, String> responses = new HashMap<>();


        String openAiResponse = openAiChatModel.call(message);
        responses.put("OpenAI - ChatGPT 응답", openAiResponse);

        return responses;
    }
}
