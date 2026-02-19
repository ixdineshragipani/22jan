select o1.*,c1.* from orders o1 right join customers c1 on c1.customer_id=o1.customer_id;

select* from orders;

select * from customers;

select * from products;

select c1.customer_id,count(c1.customer_id) 
from orders o1 right join customers c1 on c1.customer_id = o1.customer_id;

