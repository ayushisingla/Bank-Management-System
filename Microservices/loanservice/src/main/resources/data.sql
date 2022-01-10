DROP TABLE IF EXISTS loan;

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


INSERT INTO `loan` (`loantype`,`loanamount`,`date`,`rateofinterest`,`duration`,`username`,`loanstatus`)
 VALUES ('monthly',2000,'2020-12-12',12,3,'ayushi46',true);

 