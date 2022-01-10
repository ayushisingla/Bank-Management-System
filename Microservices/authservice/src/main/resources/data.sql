DROP TABLE IF EXISTS customer;

create table customer (
accountno int auto_increment primary key not null, 
customername varchar(100) not null,
username varchar(20) not null,
password varchar(20) not null,
address varchar(100) not null, 
state varchar(20) not null, 
city varchar(20) not null,
country varchar(20) not null, 
email varchar(100) not null, 
panno varchar(10) not null, 
contactno varchar(10) not null, 
dob varchar(10) not null, 
accounttype varchar(20) not null
);


INSERT INTO `customer` (`customername`,`username`,`password`,`email`,`dob`,`contactno`,`panno`,`accounttype`,`address`,`state`,`city`,`country`)
 VALUES ('Ayushi Singla','ayushi46','Ayushi@1','ayushi@gmail.com','2021-12-21','7347390097','ABCDE1234A','saving account','H.No.24','moga','punjab','india');

 
 