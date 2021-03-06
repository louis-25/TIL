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

