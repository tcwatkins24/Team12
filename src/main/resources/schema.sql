
CREATE TABLE IF NOT EXISTS Driver (
     id        INTEGER  PRIMARY KEY AUTO_INCREMENT,
     dName VARCHAR(25),
     route integer,
     username varchar(25),
     password varchar(25)
);

--INSERT INTO Driver (dName) VALUES('Kyle');

create table Users(
    id integer primary key AUTO_INCREMENT,
    uName varchar(25),
    password varchar(25),
    currentUserType integer, -- 0 == passenger, 1 == driver, 3 == administrator
    remainingSignInAttempts integer
);

INSERT INTO Users (uName,password,currentUserType,remainingSignInAttempts) VALUES ('user1','tempPass',0, 3);




create table Passenger (
    id integer primary key AUTO_INCREMENT,
    pName varchar(25),
    balance integer,
    username varchar(25),
    password varchar(25),
    email varchar(25)
);

create table Route(
    rNumber integer primary key,
    startLoc varchar(25),
    endLoc varchar(25)
);

create table Vehicle (
    vNumber integer primary key AUTO_INCREMENT,
    brand varchar(25),
    model varchar(25),
    vYear integer,
    capacity integer,
    currentRoute integer
);


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

