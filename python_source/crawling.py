#웹크롤링 기상청정보 + 그래프
# 데이터 가져와서 - 전처리 - 테이블, 그래프 - 분석 - 결과 테이블

# 그래프 그리는방법
# pip3 install matplotlib 설치

import matplotlib.pyplot as plt

a = [1,2,3,4,5]
b = [2,4,6,8,10]

plt.plot(a,b) # x, y 좌표
plt.title("graph") # 제목
plt.xlabel("a") # x축 제목
plt.ylabel("b") # y축 제목
#plt.savefig("test.png") #그래프 저장

plt.show() #그래프를 그려줌

import random
c=[]
for i in range(1, 11, 1):
    c.append(random.randint(1,10))

'''
plt.subplots() #한 그래프에 여러개 표현
plt.plot(a,b)
plt.hist(c) #빈도수 체크
print(c)
plt.show()
'''
#여러개의 그래프를 분할하여 그리기
plt.subplot(2,2,1)
plt.plot(a,b)

plt.subplot(2,2,2)
plt.plot(a,b,'o')

plt.subplot(2,2,3)
plt.hist(c)
plt.savefig("test.png")
plt.show()

#웹크롤링 기상청정보 + 그래프 + 파일저장 + spring 파일 업로드 구현
#import urllib.request as req
#import bs4.BeautifulSoup as bs

import requests

#get
#response = requests.get("http://127.0.0.1:9090")

#post
#test.png파일 업로드
graphfile = open("test.png", "rb")
response = requests.post("http://127.0.0.1:9091/fileupload",
                        data={"name":"python", "description":"file upload"},
                        files={"file1":graphfile, "file2":graphfile}
                        )
print(response.status_code) # 404, 400, 500, 200
print(response.text) #스프링에서 받아온데이터 출력

#웹크롤링


