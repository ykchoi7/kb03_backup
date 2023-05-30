
--student / teacher / course / coursereg

create table student (
    student_id number(10) constraint student_id_pk primary key,
    name varchar2(20),
    major varchar2(20),
    grade number(10)
);

create table teacher (
    teach_id number(10) constraint teach_id_pk primary key,
    name varchar2(20),
    major varchar2(20)
);

create table course (
    course_no number(10) constraint course_no_pk primary key,
    name varchar2(20),
    teach_id number(10) constraint teach_id_fk references teacher(teach_id),
    total number(10),
    regnum number(10)
);

create table coursereg (
    coursereg_no number(10) constraint coursereg_no_pk primary key,
    course_no number(10) constraint course_no_fk references course(course_no),
    student_id number(10) constraint student_id_fk references student(student_id),
    regdate date
);

-- 교수별 개설과목 갯수
select t.teach_id, t.name, (select count(*) from course c where c.teach_id = t.teach_id) cnt
from teacher t;

-- 학생별 신청과목수
select s.student_id, s.name, s.major, s.grade, (select count(*) from coursereg cr where cr.student_id = s.student_id) cnt
from student s;

-- 수강인원미달과목을 위한 쿼리
select *
from course c 
    join teacher t
    on c.teach_id = t.teach_id;


--수강신청상세정보출력
select a.coursereg_no, a.course_no, b.coursename, b.teach_id, b.teachername, a.student_id, a.name, a.regdate
from (select *
    --c.coursereg_no, c.course_no as course_no1, s.student_id, s.name, c.regdate
    from coursereg c
        join student s
        on c.student_id = s.student_id
    ) as a
    join
    (select c.course_no as course_no, c.name as coursename, t.teach_id as teach_id, t.name as teachername
    from course c
        join teacher t
        on c.teach_id = t.teach_id
    ) as b
        on a.course_no = b.course_no;
