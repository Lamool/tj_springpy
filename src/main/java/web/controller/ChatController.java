package web.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component  // 해당 클래스를 스프링 컨테이너 빈 등록
public class ChatController extends TextWebSocketHandler {
    // Ctrl + Spacebar 눌러서 함수 재정의

    // 1. 클라이언트가 서버 웹소켓에 접속 성공 했을 때 # Established
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("session = " + session);
        System.out.println("[서버웹소켓 측] JS웹소켓이 들어옴");
    }

    // 2. 클라이언트가 서버 웹소켓에 접속 끊었을 때 # Closed
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("session = " + session);
        System.out.println("[서버웹소켓 측] JS웹소켓이 나감");
    }
}
