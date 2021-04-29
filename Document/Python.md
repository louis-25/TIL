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

