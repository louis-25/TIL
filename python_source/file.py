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
    print(num,line, end=" ")
    num+=1

#읽은내용 다시 파일에 저장
file4 = open("copy.txt", "w");

for index in range(0, len(file_list), 1):
    line = str(index+1) + " 번 라인 : "+file_list[index];
    file4.write(line);
file4.close();
        
