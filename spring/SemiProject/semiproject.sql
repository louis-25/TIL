select * from c_emp;

create table member(
id varchar2(30) constraint member_id_pk primary key,
password number(10),
name varchar2(30)
);

insert into member values('semi', 1111, '프로젝트');

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

/*시퀸스 생성*/
CREATE SEQUENCE BOARD_SEQ
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 10000
NOCYCLE

insert into board (seq, title, contents, writer, password, viewcount) values(board_seq.nextval,'제목', '내용', 'semi', 1234, 0)
insert into board (seq, title, contents, writer, password, viewcount) values(board_seq.nextval,'안녕하세요', '세미프로젝트입니다', 'semi', 2222, 0)
