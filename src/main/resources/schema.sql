
CREATE TABLE Driver (
     id        INTEGER  PRIMARY KEY AUTO_INCREMENT,
     dName VARCHAR(25),
     route integer,
     username varchar(25),
     password varchar(25),
     isAuth bit
);

create table Users(
    id integer primary key AUTO_INCREMENT,
    uName varchar(25),
    password varchar(25),
    currentUserType integer,
);

create table Passenger (
    id integer primary key AUTO_INCREMENT,
    pName varchar(25),
    balance integer,
    username varchar(25),
    password varchar(25),
    email varchar(25)
);

create table ROUTE(
    id integer primary key AUTO_INCREMENT,
    startLoc varchar(25),
    endLoc varchar(25),
    startPickUpTime varchar(25),
    endPickUpTime varchar(25),
    capacity integer
);


create table Vehicle (
    vNumber integer primary key AUTO_INCREMENT,
    brand varchar(25),
    model varchar(25),
    vYear integer,
    capacity integer,
    currentRoute integer
);

