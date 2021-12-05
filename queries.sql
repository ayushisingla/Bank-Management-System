create database bank;
use bank;
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
create table loan(
	loanid int primary key auto_increment  not null,
	loantype varchar(20)  not null,
	loanamount int  not null,
	date varchar(20)  not null,
	rateofinterest int  not null,
    duration int  not null,
    username varchar(20) not null,
    loanstatus boolean DEFAULT false
    );
select * from loan;
select * from customer;
drop table customer;
drop table loan;
    