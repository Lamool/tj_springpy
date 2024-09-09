package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    // [1] 채팅 관련 템플릿 매핑
    @GetMapping("/chat")
    public String chat() {
        return "/chat/chat.html";
    }
}
