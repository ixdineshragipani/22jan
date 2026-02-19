select * from customer_details;
select * from customer_location_history;
select * from driver_details;
select * from driver_location_history;
select * from driver_account_details;
select * from vehicle_details;
select * from pickup_request;
select * from shipment_details;
select * from pickup_driver_assignment;
select * from pickup_status_history;
select * from delivery_details;
select * from payment_details;



select * from pickup_driver_assignment where assignment_status='Assigned' or assigned_at like'2026-02-18%';

select * from pickup_driver_assignment where unassigned_at is not null and 

select driver_id,count(pickup_id) from pickup_driver_assignment where assigned_at between '2025-01-01 00:00:00' and '2026-03-01 00:00:00'
group by driver_id
;

select * from pickup_request where actual_pickup_time>expected_pickup_time;

select pickup_id,actual_pickup_time,expected_pickup_time from pickup_request;