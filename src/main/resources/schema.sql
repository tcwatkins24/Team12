
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

--INSERT INTO Route (STARTLOCATION,ENDLOCATION) VALUES ('Iowa City','Cedar Rapids');
--INSERT INTO Route (STARTLOCATION,ENDLOCATION) VALUES ('Iowa City','Des Moines');
--INSERT INTO Route (STARTLOCATION,ENDLOCATION) VALUES ('Iowa City','Davenport');
--INSERT INTO Route (STARTLOCATION,ENDLOCATION) VALUES ('Iowa City','Ames');
--INSERT INTO Route (STARTLOCATION,ENDLOCATION) VALUES ('Iowa City','Waterloo');


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

