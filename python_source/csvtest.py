#usedcards.csv
#마일리지 10000 이상 ~ 20000미만 -> "심각한중고" 10000미만 -> "양호한중고"
import csv
import os
print(os.getcwd())
print(os.listdir())

file_list = list()
file = open("usedcars.csv", "r", encoding="UTF-8")
for line in file:
    file_list.append(line); 
file.close();

num = 2;
for line in file_list:    
    print(num,line, end=" ")
    num+=1
