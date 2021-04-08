create table Student (
	No int constraint Student_name_pk primary key,
	name char(10), 
	det char(20),
	addr char(80),
	tel char(20)
)

insert into Student values(1, '홍길동', '국문학과', '서울', '010-1111-1111')
insert into Student values(2, '고길동', '수학과', '인천', '010-2222-2222')