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




'''
print(soup.prettify())

city_list = soup.select("city")
for city in city_list:
    wf = soup.select_one("wf")
    print(wf)
#print(len(city_list))
'''
'''
for city in city_list:
    print(city);
'''
