# 기가지니 명령어 모음

<br>

## 버튼

```python
def btn_detect(): #버튼감지
	global btn_status #버튼상태를 전역으로 관리
	with MS.MicrophoneStream(RATE, CHUNK) as stream: #오디오 감지, 버튼상태
		audio_generator = stream.generator()
		
		for content in audio_generator:
			GPIO.output(31, GPIO.HIGH)
			rc = ktkws.detect(content)
			rms = audioop.rms(content,2)
			#print('audio rms = %d' % (rms)) 입력되는 음량의 크기
			GPIO.output(31, GPIO.LOW)
			if (btn_status == True):
				rc = 1
				btn_status = False			
			if (rc == 1):
				GPIO.output(31, GPIO.HIGH)
				MS.play_file("../data/sample_sound.wav")
				return 200
```

```python
def btn_test(key_word = '기가지니'):
	global btn_status #버튼상태를 전역으로 관리
	rc = ktkws.init("../data/kwsmodel.pack")
	print ('init rc = %d' % (rc))
	rc = ktkws.start()
	print ('start rc = %d' % (rc))
	print ('\n버튼을 눌러보세요~\n')
	ktkws.set_keyword(KWSID.index(key_word))
	rc = btn_detect()
	print ('detect rc = %d' % (rc))
	print ('\n\n호출어가 정상적으로 인식되었습니다.\n\n')
	ktkws.stop()
	return rc
```

## 음성인식

```python
def getVoice2Text():	
    print ("\n\n음성인식을 시작합니다.\n\n종료하시려면 Ctrl+\ 키를 누루세요.\n\n\n")
    channel = grpc.secure_channel('{}:{}'.format(HOST, PORT), UA.getCredentials()) #API Key사용
    stub = gigagenieRPC_pb2_grpc.GigagenieStub(channel)
    request = generate_request()
    resultText = ''
    for response in stub.getVoice2Text(request):
        if response.resultCd == 200: # partial
            print('resultCd=%d | recognizedText= %s' 
                  % (response.resultCd, response.recognizedText))
            resultText = response.recognizedText
        elif response.resultCd == 201: # final
            print('resultCd=%d | recognizedText= %s' 
                  % (response.resultCd, response.recognizedText))
            resultText = response.recognizedText
            break
        else:
            print('resultCd=%d | recognizedText= %s' 
                  % (response.resultCd, response.recognizedText))
            break

    print ("\n\n인식결과: %s \n\n\n" % (resultText))
    return resultText
```

<br>

## 음성출력(TTS)

```python
def getText2VoiceStream(inText,inFileName):

	channel = grpc.secure_channel('{}:{}'.format(HOST, PORT), UA.getCredentials())
	stub = gigagenieRPC_pb2_grpc.GigagenieStub(channel)

	message = gigagenieRPC_pb2.reqText()
	message.lang=0
	message.mode=0
	message.text=inText
	writeFile=open(inFileName,'wb')
	for response in stub.getText2VoiceStream(message):
		if response.HasField("resOptions"):
			print ("\n\nResVoiceResult: %d" %(response.resOptions.resultCd))
		if response.HasField("audioContent"):
			print ("Audio Stream\n\n")
			writeFile.write(response.audioContent)
	writeFile.close()
	return response.resOptions.resultCd
```

<br>

## 서버에서 답변가져오기 dds

```python
def generate_request():
	with MS.MicrophoneStream(RATE, CHUNK) as stream:
		audio_generator = stream.generator()
		messageReq = gigagenieRPC_pb2.reqQueryVoice()
		messageReq.reqOptions.lang=0
		messageReq.reqOptions.userSession="1234"
		messageReq.reqOptions.deviceId="aklsjdnalksd"
		yield messageReq
		for content in audio_generator:
			message = gigagenieRPC_pb2.reqQueryVoice()
			message.audioContent = content
			yield message
			rms = audioop.rms(content,2)

def queryByVoice():
	print ("\n\n\n질의할 내용을 말씀해 보세요.\n\n듣고 있는 중......\n")
	channel = grpc.secure_channel('{}:{}'.format(HOST, PORT), UA.getCredentials())
	stub = gigagenieRPC_pb2_grpc.GigagenieStub(channel)
	request = generate_request()
	resultText = ''
	response = stub.queryByVoice(request)
	if response.resultCd == 200:
		print("질의 내용: %s" % (response.uword))
		for a in response.action:
			response = a.mesg
			parsing_resp = response.replace('<![CDATA[', '')
			parsing_resp = parsing_resp.replace(']]>', '')
			resultText = parsing_resp #서버에서 가져온 답변
			print("\n질의에 대한 답변: " + parsing_resp +'\n\n\n')

	else:
		print("\n\nresultCd: %d\n" % (response.resultCd))
		print("정상적인 음성인식이 되지 않았습니다.")
	return resultText
```

<br>

## 파일에 저장

시간, 키워드, rc  --> result.txt에 저장

```python
def test(key_word = '기가지니'): #기본값 : 기가지니
	rc = ktkws.init("../data/kwsmodel.pack")
	print ('init rc = %d' % (rc))
	rc = ktkws.start()
	print ('start rc = %d' % (rc))
	print ('\n호출어를 불러보세요~\n')
	
	for k in KWSID:
		if k == key_word:
			ktkws.set_keyword(KWSID.index(key_word))
			rc = detect()
			break
		else:
			rc = 404 #키워드세팅 잘못

	print ('detect rc = %d' % (rc))
	
	if(rc==200):
		print ('\n\n호출어가 정상적으로 인식되었습니다.\n\n')
	else :
		print ('\n\n호출어가 비정상적으로 인식되었습니다.\n\n')
	ktkws.stop()
	result_test(key_word, rc) #파일기록
    
def result_test(key_word, rc):
	#test 호출시마다 시간, 키워드, 단어 응답 1줄로 result.txt에 저장
	#현재시간 설정
	#result.txt 파일 open
	now = dt.datetime.now()
	now = now.strftime("%Y-%m-%d %H:%M:%S") #datetime타입을 문자열 변환
	print(now)
	
	file = open("result.txt", "a") # result.txt파일 뒤에 추가
	file.write(now + "," + key_word + "," + str(rc) +"\n")
	file.close();
```

<br>

## 파일읽기

```python
def result_read_test():
	#result.txt 파일을 읽는다 - list, directory

	file = open('result.txt', 'r')
	time_list = []
	keyword_list = []
	response_list = []

	file_dict = {}

	for line in file:
		linedata_list = line.rstrip().split(',') # ,로 분리 / rstrip()은 \n 문자를 제거하기위해사용
		time_list.append(linedata_list[0])
		keyword_list.append(linedata_list[1])
		response_list.append(linedata_list[2])

	file_dict['time'] = time_list
	file_dict['keyword'] = keyword_list
	file_dict['response'] = response_list
	
	file.close()
```

