DROP TABLE IF EXISTS membershiptiers;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS itemtransaction;
DROP TABLE IF EXISTS accounttransaction;
DROP TABLE IF EXISTS account;

CREATE TABLE membershiptiers (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  price FLOAT NOT NULL,
  freesales INT NOT NULL,
  percentage FLOAT NOT NULL,
  length VARCHAR(250) NOT NULL,
  status VARCHAR(250) NOT NULL,
  stamp DATE NOT NULL
);
CREATE TABLE users (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(25) NOT NULL,
  age INT NOT NULL,
  accountcreation DATE NOT NULL,
  dateofbirth DATE NOT NULL,
  firstname VARCHAR(75) NOT NULL,
  middlename VARCHAR(110) DEFAULT NULL,
  lastname VARCHAR(75) NOT NULL,
  mobile VARCHAR(20) NOT NULL,
  country VARCHAR(3) NOT NULL,
  region VARCHAR(75) NOT NULL,
  town VARCHAR(75) NOT NULL,
  zip VARCHAR(5) DEFAULT NULL
);
CREATE TABLE itemtransaction (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  sellerid INT NOT NULL,
  buyerid INT NOT NULL,
  itemid VARCHAR(255) NOT NULL,
  itemname VARCHAR(255) NOT NULL,
  amount FLOAT NOT NULL,
  stamp DATE NOT NULL,
  foreign key (sellerid) references users(id),
  foreign key (buyerid) references users(id)
);
CREATE TABLE account (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  userid INT NOT NULL,
  status VARCHAR(50) NOT NULL,
  imgurl VARCHAR(250) DEFAULT NULL,
  isactive BOOLEAN NOT NULL,
  datecreated DATE NOT NULL,
  foreign key (userid) references users(id)
);
CREATE TABLE accounttransaction (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  accountid INT NOT NULL,
  price FLOAT NOT NULL,
  paid FLOAT NOT NULL,
  stamp DATE NOT NULL,
  foreign key (accountid) references account(id)
);

INSERT INTO membershiptiers (price,freesales,percentage,length,status,stamp) VALUES 
		(0.00,0,.30,'FREE','FREE',current_timestamp),
		(0.00,10,.25,'TWOWEEK','BASIC',current_timestamp),
		(4.99,10,.25,'MONTH','BASIC',current_timestamp),
		(13.99,10,.25,'THREEMONTH','BASIC',current_timestamp),
		(24.99,10,.25,'SIXMONTH','BASIC',current_timestamp),
		(44.99,10,.25,'YEAR','BASIC',current_timestamp),
		(0.00,20,.15,'TWOWEEK','PREMIUM',current_timestamp),
		(9.99,20,.15,'MONTH','PREMIUM',current_timestamp),
		(24.99,20,.15,'THREEMONTH','PREMIUM',current_timestamp),
		(49.99,20,.15,'SIXMONTH','PREMIUM',current_timestamp),
		(99.99,20,.15,'YEAR','PREMIUM',current_timestamp),
		(0.00,50,.10,'TWOWEEK','PLATINUM',current_timestamp),
		(19.99,50,.10,'MONTH','PLATINUM',current_timestamp),
		(49.99,50,.10,'THREEMONTH','PLATINUM',current_timestamp),
		(99.99,50,.10,'SIXMONTH','PLATINUM',current_timestamp),
		(179.99,50,.10,'YEAR','PLATINUM',current_timestamp),
		(99.99,250,.05,'MONTH','BUSINESS_BASIC',current_timestamp),
		(279.99,250,.05,'THREEMONTH','BUSINESS_BASIC',current_timestamp),
		(529.99,250,.05,'SIXMONTH','BUSINESS_BASIC',current_timestamp),
		(899.99,250,.05,'YEAR','BUSINESS_BASIC',current_timestamp),
		(1499.99,250,.05,'THREEYEAR','BUSINESS_BASIC',current_timestamp);

INSERT INTO users (username,password,age,accountcreation,dateofbirth,
firstname,middlename,lastname,mobile,country,region,town,zip) VALUES
('firstUser', 'F1r5tU53r!', 28, current_timestamp, '1991-10-02', 'John','', 'Doe', '8885553333', 'USA', 'New York', 'New York', '55555'),
('secondUser', '53C0ndU53r!', 19, current_timestamp, '2000-09-05', 'Jane','', 'Doe', '8885554444', 'USA', 'New York', 'New York', '55555'),
('thirdUser', 'Th1rdU53r!', 42, current_timestamp, '1977-02-25', 'Chandra','', 'Acharya', '8885556666', 'IND', 'West Bengal', 'Kolkata', null),
('fourthUser', 'F0urthU53r!', 86, current_timestamp, '1933-12-05', 'Eisa','', 'Ahmed', '8885557777', 'UAE', 'Abu Dhabi', 'Al Wathba', null),
('fifthUser', 'F1fthU53r!', 33, current_timestamp, '1987-01-18', 'Wong','', 'Fu', '8885558888', 'CHN', 'Jiangsu', 'Yangzhou', null);

INSERT INTO itemtransaction (sellerid,buyerid,itemid,itemname,amount,stamp) VALUES
(2, 1, 3, 'RAM', '99.99', current_timestamp);

INSERT INTO account (userid,status,imgurl,isactive,datecreated) VALUES
(1, 'FREE', null, true, current_timestamp),
(2, 'BASIC', null, true, current_timestamp),
(3, 'BUSINESS', null, true, current_timestamp),
(4, 'PREMIUM', null, true, current_timestamp),
(5, 'FREE', null, true, current_timestamp);

INSERT INTO accounttransaction (accountid,price,paid,stamp) VALUES
(2, '99.99', '0.00', current_timestamp),
(1, '99.99', '99.99', current_timestamp);