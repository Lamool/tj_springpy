console.log('chat.js')

// JS 클라이언트 웹소켓
let clientSocket = new WebSocket("ws://localhost:8080/chat/conn")
/*
    new WebSocket("ws://localhost:8080/chat/conn")

    ((WebSocketConfigurer 클래스에
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // registry.addHandler("핸들러객체", "ws서버소켓주소");
        registry.addHandler(chatController, "/chat/conn");
    }
    ws서버소켓주소랑 같아야 함))
*/

