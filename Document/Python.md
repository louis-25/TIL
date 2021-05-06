# Python

<br>

## 명령형 매개변수

shift + F5눌러 실행

```python
import sys
print(sys.argv)
print(sys.argv[1])
print(sys.argv[2])
print(sys.argv[3])
```

<br>

## 리스트

```python

a2 = [1,2,3,4,5] #리스트 : 자바의 배열과 같다
print(type(a2))

a = ["title", 30, 4500.23, True, [90,80,70]] #리스트에 다양한 타입 입력가능
print(a[0]) # 0번 인덱스 출력
print(a[1:3]) # a리스트의 1번 ~ 3번 출력
print(a + a2) # 리스트를 더할 수 있다
print(a2 * 5) # a2리스트의 내용 5번출력
print(1 in a2) # a2안에 1이 존재하면 True
print(len(a)) # 5
print(len(a[4])) # 3

a.append(100); # 맨뒤에 100 추가
print(len(a)); # 6

a.insert(1, 200) #1번 인덱스에 200추가
print(a[1]) # 200
print(len(a)); # 7

a.pop(); # 리스트 마지막 데이터 삭제
a.remove(30); #30 이라는 데이터 삭제

del a[0]; #0번 인덱스 데이터 삭제

a2.sort(); #데이터 오름차순으로 정렬
print(a2);

a2.reverse(); #데이터 내림차순으로 정렬
print(a2)

```

<br>

##  튜플

튜플은 값을 변경(추가 삭제 수정)할 수 없는 리스트이다

함수의 리턴값이 여러개인경우 튜플로 반환한다

메모리에 고정영역만 차지하면 되므로 성능에 도움이된다

```python
d = (1,2,3,4,5) #튜플
print(type(d))

d[0] = 100 #안됨
del d[0] #안됨
d.append(6) #안됨
#그냥 조회말고는 암것도 못함

# 괄호가 없거나 하나의변수에 여러값을 넣으면 튜플로 선언된다
a = 1, 2, 3, 4, 5
print(a)
print(type(a))

a, b = 1, 2 #각각의 변수에 튜플데이터를 따로 저장함
print(a)
print(b)
```

<br>

## 셋 / 딕셔너리

셋과 딕셔너리는 인덱스가 없다

셋은 중복데이터를 허용하지 않는다

딕셔너리의 key는 중복되지않고 value값을 수정가능

딕셔너리는 삭제도 가능

```python
a = {1, 2, 3, 4, 5} #셋 : key없는 딕셔너리

a.add(6) #추가됨
a.pop() # 1제거

b = {'name':'lee', "2":200} #딕셔너리 : key와 value의 쌍

print(type(b)) #dict

print(b.items())
print(b.keys())
print(b.values())

b['id']='python'; #id key의 value값을 python으로 변경
b['email'] = 'test@naver.com' # 새로운 key, value추가

#key가 있으면 그냥 두고 없으면 새롭게 추가하는법
print('name' in b) # True
b.pop('name') #name이라는 key를 삭제(value도 같이삭제됨)
```

<br>

## 조건문

파이썬에서 들여쓰기가 상당히 중요하다

why? -> 블럭구조가 아니라 들여쓰기로 구분하기 때문이다

```python
if 10 > 5 :
	print("조건이 맞을경우 출력")
else :
	print("조건이 아닌경우 출력")
    
a = input(); #키보드 입력받기
a = int(a); #int로 형변환

if a == 0 :
    print("0으로 나누기 불가")
    print("프로그램 종료")
else :
    print("3을 {}로 나눈 결과는 {}입니다.".format(a, 3/a);   

#학점계산기          
import sys
print(sys.argv)
print(sys.argv[1])
print(sys.argv[2])
print(sys.argv[3])
          
kor = int(sys.argv[1])
mat = int(sys.argv[2])
eng = int(sys.argv[3])          

total = kor + mat + eng;
avg = total /3;
          
if avg >= 90:
      grade = "A";
else if avg >= 80:
      grade = "B";
else if avg >= 70:
      grade = "C";
else if avg >= 60:
      grade = "D";
else :
      grade = 'F';
          
print(grade);
          
#num 짝수인지 홀수인지 검사
import random          
num=random.randint(1,100) # 1~100까지 정수
print(num)          
if num % 2 == 0:
          print("짝수")
else:
          print("홀수")

#while문          
count = 1;
total = 0;
while count <= 10:
          print(count);
          total = total+count;
          print(total);
          count++;
          
mynum = 50;
a = input(); #키보드 입력받기
a = int(a); #int로 형변환          
while True :
    if a > mynum :
          print("작은 숫자를 생각해보세요")
    else if a < mynum :
          print("큰 숫자를 생각해보세요")
    else :
          print("정답입니다")
          break;
          
#로또번호
lottoset = set();
cnt = 0;
while True:
    lotto = random.randrange(1,46)
    cnt = cnt+1;
    print("{} 번째 난수 {}를 생성합니다".format(cnt,lotto))
    lottoset.add(lotto);
    if len(lottoset) == 6:
        break;

print(lottoset)         

#for문          
print(range(1, 11, 1)) # 1~10까지 1씩 증가
for i in range(1, 11, 1):
    print(i);          
--------------------------------------------------
#list         
a=[1, 2, 3, 4 ,5]
print(a); #[1,2,3,4,5]

for i in range(0, len(a), 1):
    print("{}번째 인덱스값은 {}입니다".format(i, a[i]))
---------------------------------------------------
#dictionary          
d = {"k1":1, "k2":2, "k3":3, "k4":4, "k5":5}
for key, value in d.items():
    print("{}키의 값은 {}입니다".format(key, value))          
```

<br>

## 함수 / 메소드

함수 - 특정 기능 구현

```python
def 함수이름(매개변수):
    들여쓰기문장;
    return 값;

리턴결과 받을변수 = 함수이름(매개변수)

#매개변수가 없는함수
def hello_3times():
    print("hello");
    print("hello");
    print("hello");
	#리턴값없으므로 그냥 호출만해서 사용하자

#매개변수 있는 함수 정의
def hello_ntimes(message, n):
	for i in range(1, n+1, 1):
        print(message);
    #매개변수만 전달해서 사용할것

#기본 매개변수 있는 함수 정의
def basic_ntimes(message="java", n=5):
	for i in range(1, n+1, 1):
        print(message);
        
#순서가 달라도 키워드로 넣어주면 값이 잘 전달된다
basic_ntimes(n=10, message="python") 

#가변매개변수(1개밖에 쓸 수 없고, 일반 매개변수의 뒤에만 선언가능)
def dynamic_message(*msg):
	for i in msg:
        print(i)
    
#전달하는만큼 매개변수가 가변적으로 바뀐다
dynamic_message("python");
dynamic_message("python", "java");
dynamic_message("python", "java", "spring");

    
```

<br>

## 람다식

```python
print((lambda : 0)())

print((lambda x : x*x)(10))

print((lambda x,y : (x+y, x-y, x*y, x/y))(10,2))
```



## 모듈

```python
#모듈에 별칭을 줄 수 있다
import math as ma
ma.trunc(3.14)

import random
print(random.randint(1,100))
print(random.randrange(1,101))
name_list=["abcde","가나다라", "ab가나","xyz"]
print(random.choice(name_list))
print(name_list)
print(random.sample(name_list,2))

import sys
print(sys.version)#파이썬버전
print(sys.getwindowsversion())
print(sys.path)# 내장모듈 + 사용자모듈 + 외부설치 추가모듈 저장경로

import os
print(os.name)
print(os.getcwd()) #현재폴더의 경로명
print(os.listdir()) #현재폴더 파일명

import datetime
now = datetime.datetime.now()
print(now.year)
print(now.month)
print(now.day)
print(now.hour)
print(now.minute)
print(now.second)
```

<br>



## 파일입출력

```python
import os
print(os.getcwd())
print(os.listdir())

try:
    file=open("test.py","r",encoding="utf-8")
    print(file.read())
except FileNotFoundError:
    print("a.txt파일 없어요")
file.close();

file2 = open("a.txt","a") #파일없으면 새로 생성/ 파일 있으면 기존 내용 뒤에 추가 쓰기
file2.write("\n새로운 파일을 생성합니다");
file2.close()

#파일 한라인씩 읽어서 리스트에 저장
file_list = list()
file3 = open("moduletest.py", "r", encoding="UTF-8")
for line in file3:
    file_list.append(line);
file3.close();

num = 1;
for line in file_list:
    print(num,line)
    num+=1

#읽은내용 다시 파일에 저장
file4 = open("copy.txt", "w");

for index in range(0, len(file_list), 1):
    line = str(index+1) + " 번 라인 : "+file_list[index];
    file4.write(line);
file4.close();
```

<br>

## CSV파일읽기

```python
#usedcards.csv
#마일리지 10000 이상 ~ 20000미만 -> "심각한중고" 10000미만 -> "양호한중고"
import csv
import os
print(os.getcwd())
print(os.listdir())

file_list = list()
file = open("usedcars.csv", "r", encoding="UTF-8")
#file.read()
for line in file:
    line_list = line.split(",")
    year = line_list[0]
    model = line_list[1]
    price = line_list[2]
    mile = line_list[3]
    color = line_list[4]
    trans = line_list[5]
    #isdigit = 숫자인지 판별
    if mile.isdigit() and int(mile) >= 20000:
        line_list.append("폐차직전")
    elif mile.isdigit() and int(mile) >= 10000 and int(mile) < 20000:
        line_list.append("심각한 중고")
    else :
        line_list.append("양호한 중고")
    print(line_list)
file.close();


```

csv파일 읽어와서 그래프로 표현하기

```python
#usedcards.csv
#마일리지 10000 이상 ~ 20000미만 -> "심각한중고" 10000미만 -> "양호한중고"
import csv
import os
print(os.getcwd())
print(os.listdir())

file_list = list()
file = open("usedcars.csv", "r", encoding="UTF-8")
#file.read()
count = {"폐차직전":0, "심각한중고":0, "양호한중고":0}
for line in file:
    line_list = line.split(",")
    year = line_list[0]
    model = line_list[1]
    price = line_list[2]
    mile = line_list[3]
    color = line_list[4]
    trans = line_list[5]
    #isdigit = 숫자인지 판별
    if mile.isdigit() and int(mile) >= 20000:
        line_list.append("폐차직전")
        count["폐차직전"] += 1
    elif mile.isdigit() and int(mile) >= 10000 and int(mile) < 20000:
        line_list.append("심각한 중고")
        count["심각한중고"] += 1
    else :
        line_list.append("양호한 중고")
        count["양호한중고"] += 1
    print(line_list)
print(count)
file.close();

import matplotlib.pyplot as plt
#글꼴 세팅
plt.rcParams["font.family"] = "Batang";
plt.rcParams["font.size"] = 10;
plt.rcParams["figure.figsize"] = (10, 6);

plt.rcParams["xtick.labelsize"] =8
plt.rcParams["axes.labelsize"] =10
plt.rcParams["lines.linewidth"] =3
plt.rcParams["lines.linestyle"] ='-.'
plt.rcParams["axes.grid"] =True

x = list(count)
y = list(count.values())
plt.plot(x, y)
plt.title("중고차")
plt.xlabel("차량상태")
plt.ylabel("개수")
plt.show()
```

<br>

## 웹크롤링

```python
import urllib.request as req
from bs4 import BeautifulSoup as bs
response = req.urlopen("http://127.0.0.1:9091/")
soup = bs(response, "html.parser")
#전체 내용 출력
rescontents = soup.prettify();
print(rescontents);

#h3 태그
print(soup.find("h3")); #type-dict 
print(soup.find("img")['src']);

for h3 in soup.findAll("h3"): #h3태그 모두 가져오기
    print(h3.string)
#rescontents = response.read()
#print(rescontents)
response.close();
```

**기상청 API 크롤링 및 그래프표현**

```python
#접속해서 모든태그 출력
#https://www.weather.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=109

import urllib.request as req
from bs4 import BeautifulSoup as bs
#import bs4.BeautifulSoup as bs

response = req.urlopen("https://www.weather.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=109")
soup = bs(response, "html.parser")

#전체 내용 출력

city_list = []
tmx_list = []
tmn_list = []
for loc in soup.select("location"):#41번
    print("--------------------------------------")
    print("도시:", loc.select_one("city").string);
    print("시간:", loc.select_one("tmEf").string);
    print("날씨상황:", loc.select_one("wf").string);
    print("최고기온:", loc.select_one("tmx").string);
    print("최저기온:", loc.select_one("tmn").string);
    print("--------------------------------------")
    city_list.append(loc.select_one("city").string)
    tmx_list.append(loc.select_one("tmx").string)
    tmn_list.append(loc.select_one("tmn").string)

tmx_list = list(map(int ,tmx_list)) #tmx_list의 데이터를 int형으로 바꿔줌
tmx_list = list(map(int ,tmn_list))
#그래프 설정
#컴퓨터 설치 사용 글꼴 정보
import matplotlib.font_manager as fm

fname_list = []
for f in fm.fontManager.ttflist:
    fname_list.append(f.name)
    print(f.name)

fname_list.sort()
for name in fname_list:
    print(name)


import matplotlib.pyplot as plt
#글꼴 세팅
plt.rcParams["font.family"] = "Batang";
plt.rcParams["font.size"] = 10;
plt.rcParams["figure.figsize"] = (10, 6);

plt.rcParams["xtick.labelsize"] =8
plt.rcParams["axes.labelsize"] =10
plt.rcParams["lines.linewidth"] =3
plt.rcParams["lines.linestyle"] ='-.'
plt.rcParams["axes.grid"] =True

plt.plot(city_list, tmx_list)
plt.title("도시별 최고기온")
plt.xlabel("도시명")
plt.ylabel("max")
plt.show()

# 1개 그래프에 도시별 최고기온과 최저기온 동시에 표현
plt.subplots()
plt.plot(city_list, tmx_list)
plt.plot(city_list, tmn_list)
plt.savefig("weather.png")
plt.show()
```

<br>

## raspberryPi - Spring Boot 파일공유

1. Spring Boot에서 파일 업로드를 구현 (~/fileupload)
2. 서버의 ip주소를 알아낸다
3. 파이썬에서 스프링에 requests.post요청으로 각종데이터 전송
4. 서버에 파일이 잘 도착했는지 확인

**Spring 코드**

```java
@RequestMapping(value="/fileupload", method=RequestMethod.POST)
	@ResponseBody //ResponseBody를 붙이면 뷰가 아니고 결과물이된다
	public String uploadresult(@ModelAttribute("vo") UploadVO vo) throws IOException{
		
		//업로드한 파일 객체
		MultipartFile multipartfile1 = vo.getFile1();
		MultipartFile multipartfile2 = vo.getFile2();
		
		System.out.println(multipartfile1.getOriginalFilename());
		
		//업로드한 파일명 추출
		String filename1 = multipartfile1.getOriginalFilename();
		String filename2 = multipartfile2.getOriginalFilename();
		//서버 저장 경로 설정
		String savePath = "c:/upload/";
		
		//서버저장파일명(클라이언트원본파일명.확장자)
		
		// 중복파일처리1 : 
		// api : 랜덤암호화변경이름
		// a.txt --> 123wsdjhfckdjf.txt
		String ext1 = filename1.substring(filename1.lastIndexOf("."));
		String ext2 = filename2.substring(filename2.lastIndexOf("."));	
		
		System.out.println(ext1+":"+ext2);
		filename1 = getUuid() +"("+multipartfile1.getOriginalFilename()+")"+ ext1;
		filename2 = getUuid() +"("+multipartfile2.getOriginalFilename()+")"+ ext2;

		File file1 = new File(savePath + filename1);
		File file2 = new File(savePath + filename2);
		//서버 저장
		multipartfile1.transferTo(file1);
		multipartfile2.transferTo(file2);
		
		return "/upload/uploadresult";
	}
```

**raspberryPi - python 코드**

```python
def result_server_test(): 
	# http://192.168.1.3:9091/fileupload - post
	# result.txt, response.png 파일 업로드
	# 터미널 pip3 install requests
	# import requests
	# graph.py 파일 그래프-서버 전송 구현
	textfile = open("result.txt", 'r')
	graphfile = open("response.png", 'rb') # 이미지파일은 바이너리로 읽어야해서 rb옵션
	
	response = requests.post("http://192.168.1.3:9091/fileupload", 
		data= {"name": "라즈베리", "description": "uploadtest"}, 
		files= {"file1": textfile, "file2": graphfile})
	print(response.status_code)
	print(response.text)
```

<br>

## 에러처리

```python
try:
    money = input("대출금액 상황개월수 입력하세요:");
    two_items = money.split();
    loan = int(two_items[0]);
    payback = int(two_items[1]);
    if payback <= 0:#의도적 에러메세지 발생
        raise ValueError("상환개월은 음수값을 입력할 수 없습니다")
except IndexError:
    print("대출금액이나 개월수 입력 확인하세요 ")
except ValueError as ve:
    print(ve)
else: # 아무런 오류없이 정상 실행됐을때
    monthly_return = loan / payback;
    print(monthly_return , " 을 매달 상환해야 합니다")
finally: #예외가 발생하던 말던 무조건 실행
    print("영업종료 ")
```

<br>

## Jupyter notebook

anaconda3는 다양한 파이썬 라이브러리를 포함하고있어 나름? 편리하고

jupyter notebook이라는 편리한 파이썬 편집기를 내장하고있다

anaconda3 설치 후

anaconda3 프롬프트 실행 -> jupyter notebook 실행가능



**jupyter notebook 시작폴더경로 바꿔주기**

프롬프트에서 jupyter notebook --generate-config

C:\Users\정동현\.jupyter에서 config파일 파이썬편집기로 열기

c.NotebookApp.notebook_dir = '' -> 주석풀고 경로입력



jupyter notebook 명령어



!pip install 모듈명 --> !가 붙으면 시스템명령어로 인식

