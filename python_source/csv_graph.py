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
plt.hist(count)
plt.title("중고차")
plt.xlabel("차량상태")
plt.ylabel("개수")
plt.show()

