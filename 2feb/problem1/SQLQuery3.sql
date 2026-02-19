create table students(student_id BIGINT  Primary Key ,
name VARCHAR(100) ,
email VARCHAR(255) UNIQUE,     
age INT,
join_date DATE, 
active_flag BIT DEFAULT 1 
);

create table courses(course_id INT primary key,
course_name varchar(100) NOT NULL,
fees decimal(10,3)
);

create table enrolements(
enroll_id BIGINT Primary Key,
student_id BIGINT, 
course_id INT,
enroll_timestamp datetime default GETDATE()
);

select * from students;
select * from courses;

create table student_courses(
student_id bigint,
course_id int,
primary key (student_id,course_id),
foreign key (student_id) references students(student_id),
foreign key (course_id) references courses(course_id)
);

insert into student_courses values (101,12),
(112,12),
(103,11),
(102,10);

insert into student_courses values (101,12),
(10,12);

select * from student_courses;