select s1.course_name,s1.fees from courses s1 outer apply (select * from enrolements c1 where c1.course_id=s1.course_id) as mine;

select * from courses;