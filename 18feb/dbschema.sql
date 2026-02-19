create table customer_details(
	customer_id bigint primary key,
    customer_name varchar(30),
    customer_address varchar(20),
    customer_phone_number bigint unique,
    customer_email varchar(30) unique,
    created_at datetime,
    updated_at datetime,
    customer_status varchar(30)
)

create table customer_location_history(
	customer_location_id bigint primary key, --same grid 
    customer_id bigint,
    latitude decimal(10,8),
    longitude decimal(10,8),
    recorded_at timestamp

	foreign key (customer_id) references customer_details(customer_id)
)

create table driver_details (
	driver_id bigint primary key,
    driver_name varchar(30),
    driver_address varchar(100),
    driver_license varchar(40),
    driver_rc varchar(20),
    driver_phone_number bigint unique,
    driver_email varchar(30) unique,
    driver_rating decimal(2,2),
    driver_status varchar(10),
);

alter table driver_details
alter column driver_rating decimal(3,2)


create table driver_account_details(
	driver_account_id bigint primary key,
    driver_id bigint,
    driver_upi_id bigint unique,
    driver_pan_number varchar(20),
    driver_aadhar_number bigint unique
	foreign key (driver_id) references driver_details(driver_id)
);


create table vehicle_details(
	vehicle_id bigint primary key,
    driver_id bigint,
    vehicle_name varchar(30),
    vehicle_number bigint unique,
    vehicle_insurence_number bigint unique
	foreign key (driver_id) references driver_details(driver_id)
)


create table pickup_request(
	pickup_id bigint primary key,
	customer_id bigint,
	pickup_latitude decimal(10, 8),
	pickup_longitude decimal(10,8),
	pickup_contact bigint unique,
	pickup_contact_name varchar(40),
	pickup_city varchar(30),
	pickup_state varchar(30),
	postal_code int,
	actual_pickup_time timestamp,
	expected_pickup_time datetime,
	current_status varchar(20), --(SCHEDULED / ASSIGNED / IN_PROGRESS / COMPLETED / CANCELLED)
	pickup_created_at datetime,
	pickup_updated_at datetime

	foreign key (customer_id) references customer_details(customer_id)
)


create table driver_location_history(
	location_id bigint primary key,  --divided each location in the form of grid
	driver_id  bigint,
	latitude decimal(10,8),
	longitude decimal(10,8),
	recorded_at datetime,
	first_Activation_Timestamp timestamp,
    last_completed_trip_Timestamp datetime

	foreign key (driver_id) references driver_details(driver_id)
)

alter table driver_location_history
drop column first_Activation_Timestamp;

alter table driver_location_history
add first_Activation_Timestamp datetime;

create table shipment_details(
	shipment_id bigint primary key,
	pickup_id bigint,
	shipment_weight decimal(10,5),
	shipment_type varchar(20),
	shipment_status varchar(10)

	foreign key (pickup_id) references pickup_request(pickup_id)
)

create table pickup_driver_assignment(
	assignment_id bigint primary key,
	pickup_id bigint,
	driver_id bigint,
	assigned_at datetime,
	unassigned_at datetime,
	assignment_status varchar(10)

	foreign key (pickup_id) references pickup_request (pickup_id),
	foreign key (driver_id) references driver_details(driver_id)
)

create table pickup_status_history(
	status_id bigint primary key,
	pickup_id bigint,
	pickup_status varchar(30),
	old_status varchar(20),
	new_status varchar(20),
	changed_at timestamp,
	changed_by varchar(20)

	foreign key (pickup_id) references pickup_request(pickup_id)
)

create table delivery_details(
	delivery_id bigint primary key,
	driver_id bigint,
	customer_id bigint,
	delivery_address varchar,
	delivery_latitude decimal(10, 8),
	delivery_longitude decimal(10,8),
	delivery_contact bigint,
	delivery_contact_name varchar(30),
	delivery_city varchar(20),
	deliery_state varchar(30),
	postal_code bigint unique,
	delivery_created_at datetime,
	delivery_updated_at timestamp

	foreign key (driver_id) references driver_details(driver_id),
	foreign key (customer_id) references customer_details(customer_id)
)

alter table delivery_details
alter column delivery_address varchar(30)

alter table pickup_request
drop column actual_pickup_time ;

alter table pickup_request
add actual_pickup_time datetime;

update pickup_request 
set actual_pickup_time = '2026-02-18 10:30:00'
where pickup_id = 601;

update pickup_request 
set actual_pickup_time = '2026-02-18 11:00:00'
where pickup_id = 602;

update pickup_request 
set actual_pickup_time = '2026-02-18 11:34:00'
where pickup_id = 603;

update pickup_request 
set actual_pickup_time = '2026-02-18 09:45:00'
where pickup_id = 604;

update pickup_request 
set actual_pickup_time = '2026-02-19 10:15:00'
where pickup_id = 605;

update pickup_request 
set actual_pickup_time = '2026-02-19 12:30:00'
where pickup_id = 606;

update pickup_request 
set actual_pickup_time = '2026-02-19 14:30:00.000'
where pickup_id = 607;

update pickup_request 
set actual_pickup_time = '2026-02-20 09:10:00'
where pickup_id = 608;

update pickup_request 
set actual_pickup_time = '2026-02-20 11:45:00'
where pickup_id = 609;

update pickup_request 
set actual_pickup_time = '2026-02-20 13:30:00'
where pickup_id = 610;


create table payment_details(
	transaction_id varchar(30) primary key,
    driver_id bigint,
    customer_id bigint,
    payment_status varchar(10)

	foreign key (driver_id) references driver_details(driver_id)
)

