import random
#lottoset에 1-45번호 (random.randint(1,45))6개 생성 저장
#while반복문 set변수.add

lottoset =set();
count = 0
while count < 6 :
    lottoset.add(random.randint(1,45))
    count+=1

print(lottoset)

a = {1, 2, 3, 4, 5}
a.add(6)
a.pop()

print(a)
#데이터 없는 SET 생성함수
#중복데이터 허용X ADD 무시

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


print(range(1, 11, 1)) # 1~10까지 1씩 증가

for i in range(1, 11, 1):
    print(i);

print("-----------------")
for i in range(11): # 0~10
    print(i);

a=[1, 2, 3, 4 ,5]
print(a); #[1,2,3,4,5]

for i in range(0, len(a), 1):
    print("{}번째 인덱스값은 {}입니다".format(i, a[i]))

d = {"k1":1, "k2":2, "k3":3, "k4":4, "k5":5}
for key, value in d.items():
    print("{}키의 값은 {}입니다".format(key, value))


    
