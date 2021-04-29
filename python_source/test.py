'''
def dynamic_ntimes(*msg):
    n=3;
    for i in range(1, n+1, 1):
        print(msg)

dynamic_ntimes("spring", "java")
dynamic_ntimes("spring")
dynamic_ntimes("spring", 1, "python", True, 2.5)

def returnl_func():
    print("리턴전");
    return 0;    

rl = returnl_func();
print(rl)

#리턴값 여러개이면 자동 tuple 함수 정의
def returnl_func2():    
    return 1,2,3,4,5;   #튜플 - 값 수정불가

rl = returnl_func2();
print(rl)

def returnl_func3():    
    return [1,2,3,4,5];   #리스트 - 값 수정가능

rl = returnl_func3();
print(rl)
'''
#매개변수 / 지역변수 / 전역변수
a = "전역변수";
def vartest(b):
    c="지역변수"

global_var = 0
def inc():
    local_var=1;
    local_var += 1;
    global global_var #글로벌함수 쓰는법
    global_var += 1
    print("지역변수{} 값, 전역변수{} 값입니다".format(local_var, global_var))

inc()

#재귀함수
def fact1(n):
    result =1;
    for i in range(1, n+1, 1):
        result = result * i
        print("{}!={}입니다".format(i, result));
    return result;

r1 = fact1(5);
print(r1);


def fact1(n):
    result =1;
    for i in range(1, n+1, 1):
        result = result * i
        print("{}!={}입니다".format(i, result));
    return result;

r1 = fact1(5);
print(r1);

def f1():
    print("출력");
'''
import time
def call_func(f):
    time.sleep(5)
    f()

call_func(f1);
'''

b=["java programming과정", "oracle sql", "spring framework", 'python programming']

def my_upper(s):
    return s[:4].upper();

print(my_upper("java programming과정"))

b = list(map(my_upper, b))
print(b)

#람다식 - 매개변수와 리턴문만 가지는 무명의 함수

print((lambda : 0)())

print((lambda x : x*x)(10))

print((lambda x,y : (x+y, x-y, x*y, x/y))(10,2))
