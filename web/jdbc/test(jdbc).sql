select * from c_emp;

-- board 테이블 -번호 제목 내용 작성자 작성시간 글암호 조회수
--member 테이블 - id, password, name
create table member(
id varchar2(30) constraint member_id_pk primary key,
password number(5),
name varchar2(30)
);

insert into member values('oracle', 1111, '김회원');
insert into member values('java', 1111, '박신입');
insert into member values('spring', 1111, '홍회원');
insert into member values('jdbc', 1111, '최회원');
insert into member values('python', 1111, '이회원');

select * from member;

create table board(
seq number(5) constraint board_seq_pk primary key,
title varchar2(200) constraint board_title_nn not null,
contents varchar2(4000),
writer varchar2(30) constraint board_writer_fk references member(id),
time date default sysdate,
password number(4),
viewcount number(5)
);
