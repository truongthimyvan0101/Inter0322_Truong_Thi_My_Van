create database furama1;
use furama1;
create table `position`(
	position_id int primary key auto_increment,
    position_name varchar(45)
);

create table division(
	division_id int primary key auto_increment,
    division_name varchar(45)
);

create table education_degree(
	education_degree_id int primary key auto_increment,
    education_degree_name varchar(45)
);

create table role(
	role_id int primary key auto_increment,
    role_name varchar(255)
);
create table user(
	username varchar(255) primary key,
    password varchar(255)
);

create table user_role(
	role_id int not null,
    username varchar(255) not null,
    primary key (role_id, username),
    foreign key(role_id) references role(role_id),
    foreign key(username) references user(username)
);

create table employee(
	employee_id int primary key auto_increment,
    employee_name varchar(45) not null,
	employee_birthday date not null,
	employee_id_card varchar(45) not null,
	employee_salary double not null,
	employee_phone varchar(45) not null,
	employee_email varchar(45),
	employee_address varchar(45),
    position_id int not null,
    education_degree_id int not null,
    division_id int not null,
	username varchar(255),
    foreign key(division_id) references division(division_id),
    foreign key(education_degree_id) references education_degree(education_degree_id),
    foreign key(position_id) references `position`(position_id),
    foreign key(username) references user(username)
);

create table customer_type(
	customer_type_id int primary key auto_increment,
    customer_type_name varchar(45)
);

create table customer(
	customer_id int primary key auto_increment,
    customer_name varchar(45) not null,
    customer_birthday date not null,
    customer_gender bit(1) not null,
    customer_id_card varchar(45) not null,
    customer_phone varchar(45) not null,
    customer_email varchar(45),
    customer_address varchar(45),
    customer_type_id int not null,
    foreign key(customer_type_id) references customer_type(customer_type_id)
);

create table service_type(
	service_type_id int primary key auto_increment,
    service_type_name varchar(45)
);

create table rent_type(
	rent_type_id int primary key auto_increment,
    rent_type_name varchar(45),
    rent_type_cost double
);

create table service(
	service_id int primary key auto_increment,
    service_name varchar(45) not null,
    service_area int,
    service_cost double not null,
    service_max_people int,
    standard_room varchar(45),
    description_other_convenience varchar(45),
    pool_area double,
    number_of_floors int,
    rent_type_id int not null,
    service_type_id int not null,
    foreign key(rent_type_id) references rent_type(rent_type_id),
    foreign key(service_type_id) references service_type(service_type_id)
);

create table contract(
	contract_id int primary key auto_increment,
    contract_start_date date not null,
    contract_end_date date not null,
    contract_deposit double not null,
    contract_total_money double not null,
    employee_id int not null,
    customer_id int not null,
    service_id int not null,
    foreign key(employee_id) references employee(employee_id),
    foreign key(customer_id) references customer(customer_id),
    foreign key(service_id) references service(service_id)
);

create table attach_service(
	attach_service_id int primary key auto_increment,
    attach_service_name varchar(45) not null,
    attach_service_cost double not null,
    attach_service_unit int not null,
    attach_service_status varchar(45)
);

create table contract_detail(
	contract_detail_id int primary key auto_increment,
    quantity int not null,
    contract_id int not null,
    attach_service_id int not null,
    foreign key(contract_id) references contract(contract_id),
    foreign key(attach_service_id) references attach_service(attach_service_id)
);

INSERT INTO customer(customer_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address, customer_type_id) values(1,"Trần Văn Minh Nhật","1999-10-27",0,"123456789","09023452435","nhat.tranvanminh@gmail.com","Quảng Nam",3);
INSERT INTO customer_type(customer_type.customer_type_id, customer_type.customer_type_name) values(1, "Silver");
INSERT INTO customer_type(customer_type.customer_type_id, customer_type.customer_type_name) values(2, "Gold");
INSERT INTO customer_type(customer_type.customer_type_id, customer_type.customer_type_name) values(3, "Diamond");

-- Tạo trigger khi chúng ta thêm mới nhân viên thì nhân viên đó sẽ nhận được một tài khoản
DELIMITER $$
CREATE TRIGGER create_employee_account
AFTER INSERT ON employee FOR EACH ROW
BEGIN
CALL create_user(new.employee_email, "123");
END $$
DELIMITER ;

-- Tạo procedure
DELIMITER $$
CREATE PROCEDURE create_user(in user_name varchar(255), in user_password varchar(255))
BEGIN
	INSERT INTO user(username, password) VALUES(user_name, user_password);
END $$
DELIMITER ;

-- Thêm dữ liệu cho position
INSERT INTO `position`(position_id, position_name) VALUES (1, "Manager");
INSERT INTO `position`(position_id, position_name) VALUES (2, "Director");
INSERT INTO `position`(position_id, position_name) VALUES (3, "Chairman");

-- Thêm dữ liệu cho education degree
INSERT INTO education_degree(education_degree_id, education_degree_name) VALUES (1, "High School");
INSERT INTO education_degree(education_degree_id, education_degree_name) VALUES (2, "College");
INSERT INTO education_degree(education_degree_id, education_degree_name) VALUES (3, "University");

-- Thêm dữ liệu cho division
INSERT INTO division(division_id, division_name) VALUES(1, "accounting");
INSERT INTO division(division_id, division_name) VALUES(2, "technology");
INSERT INTO division(division_id, division_name) VALUES(3, "marketing");

-- Thêm dữ liệu vào bảng rent_type
INSERT INTO rent_type(rent_type_id, rent_type_name, rent_type_cost) VALUES(1, "Week", 7000000);
INSERT INTO rent_type(rent_type_id, rent_type_name, rent_type_cost) VALUES(2, "Month", 25000000);
INSERT INTO rent_type(rent_type_id, rent_type_name, rent_type_cost) VALUES(3, "Year", 250000000);

-- Thêm dữ liệu vào bảng service_type
INSERT INTO service_type(service_type_id, service_type_name) VALUES(1, "VIP");
INSERT INTO service_type(service_type_id, service_type_name) VALUES(2, "NORMAL");

-- Thêm dữ liệu vào bảng service
INSERT INTO service VALUE (1, "VILLA", 1000, 10000000, 5, "Superior", "Thoáng mát, dễ chịu", 100, 3, 1, 1);

-- Thêm dữ liệu vào bảng attach_service
INSERT INTO attach_service VALUE (1, "Karaoke", 500000, 1, "Yes");
INSERT INTO attach_service VALUE (2, "Massage", 700000, 2, "Yes");
INSERT INTO attach_service VALUE (3, "Food", 500000, 1, "Yes");
INSERT INTO attach_service VALUE (4, "Baverage", 300000, 1, "Yes");

SELECT * FROM contract join employee on employee.employee_id = contract.employee_id join customer on customer.customer_id = contract.customer_id join service on service.service_id = contract.service_id;

SELECT * FROM contract_detail join attach_service on attach_service.attach_service_id = contract_detail.attach_service_id;

SELECT * FROM contract join employee on employee.employee_id = contract.employee_id join customer on customer.customer_id = contract.customer_id join service on service.service_id = contract.service_id HAVING contract_id = 8;

SELECT * FROM contract join employee on employee.employee_id = contract.employee_id join customer on customer.customer_id = contract.customer_id join service on service.service_id = contract.service_id WHERE employee_name like "%n%" and service_name like "%m%" and customer_name like "%m%";

SELECT * FROM contract_detail join contract on contract.contract_id = contract_detail.contract_id join attach_service on attach_service.attach_service_id = contract_detail.attach_service_id WHERE attach_service_name like "%%" and quantity like "%";

SELECT * FROM employee WHERE employee_name like "%Tuyen%" and employee_address = ?;

SELECT * FROM customer join contract on contract.customer_id = customer.customer_id join service on service.service_id = contract.service_id left join contract_detail on contract_detail.contract_id = contract.contract_id left join attach_service on attach_service.attach_service_id = contract_detail.attach_service_id;
