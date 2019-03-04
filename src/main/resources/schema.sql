
CREATE TABLE IF NOT EXISTS Driver (
     id        INTEGER  PRIMARY KEY AUTO_INCREMENT,
     dName VARCHAR(25),
     route integer,
     username varchar(25),
     password varchar(25)
);

INSERT INTO Driver (dName) VALUES('Kyle');


--create table if not exist Driver (
--    Id int,
--    Dnamne varchar(25),
--    primary key  (Id)
--);
--
--create table if not exist Rider (
--    username varchar(25),
--    balance int,
--    Upassword varchar(25),
--    primary key (username)
--);
--
--create table if not exist Van (
--    VanId int,
--    numRiders int,
--    route int,
--    primary key (VanId),
--    foreign key (route)
--);
--
--create table if not exist Route (
--    route int,
--    startLoc location,
--    endLoc location,
--    primary key(route)
--);

