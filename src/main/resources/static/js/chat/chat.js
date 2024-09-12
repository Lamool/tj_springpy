console.log('chat.js')

// 비회원제, 익명 식별 이름 생성
    // Math.random() : 0 ~ 1 사이의 난수
    // Math.random() * 끝값(미만) : 0 ~ 끝값 사이의 난수
    // (Math.random() * 끝값) + 시작값 : 시작값 ~ 끝값 사이의 난수
    // Math.floor() : 소수점 제거 함수
let randomNo = Math.floor(Math.random() * 1001) + 1
let nickName = `익명${randomNo}`
console.log(nickName)

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

console.log(clientSocket);

// [1] clientSocket의 정의 해야한다.
// function 클라이언소켓이서버와접속성공() {
//     alert('서버와 연결 성공')
// }
// (1) WebSocket객체내 onopen 속성은 서버소켓과 접속을 성공했을 때 발동되는 함수 정의해서 대입
// clientSocket.onopen = 클라이언소켓이서버와접속성공
clientSocket.onopen = (e) => {
    // console.log('서버소켓과 연결 성공')
    // 1. 클라이언트 서버와 접속을 성공했을 때 알림 메시지
    let msg = {
        'type' : 'alarm',
        'message' : `${nickName}님이 입장했습니다.`
    }
    // 2. 보내기
    clientSocket.send(JSON.stringify(msg));
}

// (2) WebSocket 객체내 onmessage 속성은 서버소켓이 메시지를 보내왔을 때 발동되는 함수 정의해서 대입
clientSocket.onmessage = (messageEvent) => {    // messageEvent : 매개변수
    console.log(messageEvent);
    console.log(messageEvent.data)  // 받은 내용물이 들어있는 속성
    // 1. 받은 메시지를 출력할 HTML 호출
    let msgBox = document.querySelector('.msgBox')
    // 2. 받은 메시지의 내용물(.data 속성)를 HTML에 대입
    msg = JSON.parse(messageEvent.data)
    // JSON.parse(문자열) : 문자열타입(JSON형식) --> js 객체타입(JSON 형식)
    // msgBox.innerHTML += `<div>
    //                         <div> ${msg.from} </div>
    //                         <div>
    //                             <span> ${msg.date.split(' ')[4]} </span>
    //                             <span> ${msg.message} </span>
    //                         </div>
    //                     </div>`
    //     // 메시지 내용
    //     let message = messageEvent.data.message
    // msgBox.innerHTML += `<div> ${messageEvent.data} </div>`
    console.log(msg);
    console.log(msg.type);

        // 2-1. 알람 메시지
    if (msg.type == 'alarm') {
        msgBox.innerHTML += `<div class="alarmMsgBox">
                                <span> ${msg.message} </span>
                            </div>`;
        return;     // 아래 코드가 실행되지 않도록 함수 종료
    }

        // 2-2. 일반 메시지
    if (msg.from == nickName) {     // 내가 보낸 메시지
        msgBox.innerHTML += `<div class="fromMsgBox">
                                <div> ${msg.from} </div>
                                <div>
                                    <span> ${msg.date.split(' ')[4]} </span>
                                    <span> ${msg.message} </span>
                                </div>
                            </div>`
    } else {     // 남이 보낸 메시지
        msgBox.innerHTML += `<div class="toMsgBox">
                                <div> ${msg.from} </div>
                                <div>
                                    <span> ${msg.message} </span>
                                    <span> ${msg.date.split(' ')[4]} </span>
                                </div>
                            </div>`
    }
}

// [2] 메시지 전송 이벤트
function onMsgSend() {  console.log('onMsgSend()');
    let msgInput = document.querySelector('.msgInput');
    // 메시지 내용 틀을 객체 형식으로 구성
    let msg = {
        'type' : 'msg',
        'message' : msgInput.value,
        'from' : nickName,
        'date' : new Date().toLocaleString()
    }

    // 현재 클라이언트소켓과 연결 유지된 서버소켓에게 메시지 전송 # .send() : 서버소켓에게 메시지 전송
    // clientSocket.send("Hello, ServerSocket!");
    // 입력한 값 보내기
    clientSocket.send(JSON.stringify(msg));
        // [object Object]
        // JSON.stringify(js객체) : js객체타입(JSON형식) --> 문자열타입(JSON형식)
        // ((형식과 타입은 다른 거다. 타입은 언어들이 분류해놓은 거고, 형식은 모양을 뜻한다))
        // "3" (문자열타입 숫자형식) vs 3 (정수타입 숫자형식)
        

        // HTTP는 contentType : application/json 존재한다
        // ws는 contentType : text/plain ((존재한다.))

    msgInput.value = "";
}


