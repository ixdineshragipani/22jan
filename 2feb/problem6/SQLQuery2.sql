select * from students where age in (select age from students where age>20 );

select count(*) from students where name in (select name from students where name like '%a%');

select * from courses where fees in (select fees from courses where fees between 120000 and 140000) order by fees;

select * from students where age is not null (select * from students where active_flag=0);

select * from enrolements where course_id in (select course_id from enrolements group by course_id having count(*)>1)vs