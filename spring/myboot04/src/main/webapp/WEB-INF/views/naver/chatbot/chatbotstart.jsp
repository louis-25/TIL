<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#enter").on('click', function(){
		$("#chatbox").css("display", "block");
		send();
	});// 입장
	$("#exit").on('click', function(){
		$("#chatbox").css("display", "none");
	});// 퇴장
});//ready end

function send(){
	var inputMessage = $("#inputMessage").val();
	if(inputMessage != ""){
		$("#messageWindow").append("<div><span style=background-color:yellow;margin:10px;float:right;border-radius:5px>나 : "+inputMessage+"</span></div><br><br>");
	}
	$.ajax({
		//요청
		url : "/chatbot",
		type : "post",
		data : {"message" : inputMessage},
		//응답
		dataType : 'json',
		success : function(a){ //a는 서버에서 받아온 응답결과
		//$("#messageWindow").text(JSON.stringify(a));
		console.log("응답: "+JSON.stringify(a));
		var bubbles = a.bubbles;
		for(var b in bubbles){			
			if(bubbles[b].type == 'text'){ //image button template
				$("#messageWindow").append("chatbot : "+bubbles[b].data.description+"<br>");
				$.ajax({
					url: '/chatbotvoice',
					type:'get',
					data:{"text": bubbles[b].data.description,"speaker":"shinji"},
					success: function(mp3){
						//alert(mp3);
						//$("#voice").attr('src', "/voice/"+mp3);
						//$("#voice").play();
						var audio = new Audio("/voice/"+mp3);
						audio.play();
					}
				})
				if(bubbles[b].data.url != null) {
					$("#messageWindow").append
					("<a href='"+bubbles[b].data.url+"'>"+bubbles[b].data.url+"</a><br>");
				}
			}
		}		
			
		}
	});//ajax end
	$("#inputMessage").val(""); //메세지 전송 후 초기화 
	
	var obj = $("#messageWindow").get(0);
	obj.scrollTop = obj.scrollHeight;//자동 스크롤 아래로
	
	//scrollTop - jquery함수 아니다
	//$("#messageWindow").scrollTop($("#messageWindow").prop("scrollHeight"));
}

function enterkey(){
	//엔터키 입력하면 send 함수 동일 효과 (엔터키 - 13)
	if(window.event.keyCode == 13){
		send();
	}
}
</script>
<style>
#chatbox {
	display:none;
}

#messageWindow {
	width:500px;
	height: 600px;
	background-color:#abcdef;
	overflow:scroll;
}
#inputMessage {
	width:400px;
	
}
</style>
</head>
<body>
<button id=enter>입장</button>&nbsp;&nbsp; <button id=exit>퇴장</button>
<div id="chatbox">
	<div id="messageWindow"></div>
	<input type=text id="inputMessage" onkeyup="enterkey()">
	<input type=submit value="send" onclick="send()">
	<button id="rec_start">녹음</button>
	<button id="rec_stop">정지</button>
	<audio id="voice" src=""></audio>
</div>
<script>
//녹음 정지 기능 구현
const record = document.getElementById("rec_start")
const stop = document.getElementById("rec_stop")
const inputtext = document.getElementById("inputMessage");
if (navigator.mediaDevices) {
    console.log('getUserMedia supported.')
    const constraints = {
        audio: true
    }
    let chunks = []
    navigator.mediaDevices.getUserMedia(constraints)
        .then(stream => {
            const mediaRecorder = new MediaRecorder(stream)
            record.onclick = () => {
                mediaRecorder.start()
                console.log(mediaRecorder.state)
                console.log("recorder started")
                record.style.background = "red"
                record.style.color = "black"
            }
            stop.onclick = () => {//정지 버튼 클릭시에
                mediaRecorder.stop()//녹음 정지시켜라
                console.log(mediaRecorder.state)
                console.log("recorder stopped")
                record.style.background = ""
                record.style.color = ""
            }
	  		//녹음 정지시킨 상태가 되면 실행하라
            mediaRecorder.onstop = e => {
                console.log("data available after MediaRecorder.stop() called.")
                const clipName = "mictest"+new Date().getTime().toString().substring(10);
                
                //chunks에 저장된 녹음 데이터를 audio 양식으로 만들어라
                const blob = new Blob(chunks, {
                    'type': 'audio/mp3'
                })
                chunks = []                                 
                
                //내 스프링 서버 녹음 데이터 업로드
                //FormData - html의 form태그기능
                var formData = new FormData();//<form>
                formData.append("file", blob, clipName+".mp3");//<input>
                $.ajax({
                	url:'/mp3upload',
                	type:'post',
                	data: formData,
                	processData: false, //파일을 전송한다고 알려줌
                	contentType: false, //파일을 전송한다고 알려줌
                	success : function(naver_response){
                		// 스프링 서버 mp3 파일 업로드 성공
                		alert(naver_response);
                		//업로드된 mp3파일을 네이버 서버로 보내는작업
                		$.ajax({
                			url:'/chatbotspeech',//mp3파일 이름만 보낸다
                			type: 'get',
                			data:{"mp3file":clipName+".mp3", "lang":"Kor"},
                			success: function(response){
                				//네이버에서 음성을 텍스트로 변환된 결과를 반환한다
                				var json = JSON.parse(response);
                				
                				inputtext.value = json.text; 
                			
                				alert(response);
                			}
                				
                		});
                		
                	}
                });
                                
            }//mediaRecorder.onstop

            //녹음 시작시킨 상태가 되면 chunks에 녹음 데이터를 저장하라 
            mediaRecorder.ondataavailable = e => {
                chunks.push(e.data)
            }
        })
        .catch(err => {
            console.log('The following error occurred: ' + err)
        })
}
</script>

</body>
</html>