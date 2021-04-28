#변수 연산자 조건문 반복문 문법
#int i=10 자바
#let j = 20 자바스크립트

k = 30
print(type(k))
k = 3.14
print(type(k))
k=True
print(type(k))
k='abc'
print(type(k))
k
print(type(k))

a = 10
b = 3
print("a/b=" , a / b ) #실수몫
print("a//b=" , a // b ) #정수몫
print("a%b=" , a % b ) #정수몫 구한 이후 나머지
print("a를 2진수로=" , bin(a) ) #2진수
print("a를 8진수로=" , oct(a) ) #8진수
print("a를 16진수로=" , hex(a) ) #16진수

# 문자 연산자
a= "abc"
b = 'def'
c= 100
#print(a+b+c) # 파이썬에서는 문짜끼리만 결합가능
print(a+b) #abcdef
print(a*3) #abcabcabc 문자열에 곱하기 가능

d= '''문자열데이터가 길어지면 두줄로 나눠써야한다
줄을 바꾸기 시작하면 한개의 문자열로 인식해주기 위해
단일 따옴표 or 이중따옴표를 세개를 써주면된다'''

print(d)

print(a[2:3]) #2번부터 3번까지 출력
print(a[:4]) #0번 ~ 4번까지 출력
print(a[-1:4]) 

a="multicampus"
print('cam' in a) # a변수에 'cam'이 포함돼있는지 알려줌
#'cam'문자의 위치가 몇번 인덱스인지 알려줌
print(a.find('cam'))
print(a.rfind('cam')) #오른쪽에서 부터 찾는다

# a 변수에서 'cam'문자열부터 나머지 문자열 출력
print(a[a.find('cam'):])

print(a.count('m')) # m문자 갯수
print(len(a)) #총 문자 갯수
#print(dir(a)) #str타입 포함 함수 목록 확인

a="multi"
b="python";
c=100; 
print("{}는 정수이고 {}는 문자열입니다".format(c,a));

# 10.2f -> 전체 10자리고 소수점 둘째자리까지 표현
print("{:10d}".format(10//3)); #3
print("{:+10.2f}".format(10/3));
#format함수를 사용하면 문자열로 바뀌게된다

#정수/실수 -> 문자열로
print(type(100)) #int
print(type(str(100))) #str

print("abc"+"def"+str(100))

'''
#문자열 -> 정수
#파이썬
int1 = input('정수 1개를 입력하세요');
print(int(int1)); #문자열 -> 정수 변환

float1 = input('실수 1개를 입력하세요');
print(float(float1)); #문자열 -> 실수 변환
print(flaot(float1) + int(int1));

bol = input('논리값 1개를 입력하세요');
print(bool(bol))
#bool(TRUE, true, ......0)
'''
'''

# 파이썬 설치 포함 모듈
import math
a = 3
b = 2
print("math.pow(a,b)=", math.pow(a,b)) #제곱
print("math.trunc(a,b)=", math.trunc(a/b)) #

# 파이썬 기본 내장 함수
print("abs(-10)=",abs(-10)) #절대값
print("round(a/b)=",abs(a/b)) #절대값

#파이썬 기본 내장 함수 확인
print(dir(__builtins__))
'''

import sys
print(sys.argv)
print(sys.argv[1])
print(sys.argv[2])
print(sys.argv[3])
