#module

import random
import math
import time
import sys

random.randint(1,10)
math.trunc(3.14)
#time.sleep(5)
print(sys.argv)

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

#현재로부터 1년뒤
after_year = now.replace(year=(now.year+1))

# pypi.org사이트 검색 - 설치명령어 복사
# pip install beautifulsoup4
# pip list -> 현재 설치된 pip모듈확인
# pip show beautifulsoup4 - location정보

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

#에러처리
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






