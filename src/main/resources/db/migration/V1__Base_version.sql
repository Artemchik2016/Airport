CREATE TABLE ticket(
ID INT NOT NULL,
Voyage_id VARCHAR(10),
Class VARCHAR(10),
Passenger_id INT,
Seat_number VARCHAR(5),
PRIMARY KEY (ID),
FOREIGN KEY (Voyage_id) REFERENCES voyage(ID),
FOREIGN KEY (Passenger_id) REFERENCES passengers(ID)
)

CREATE TABLE voyage(
ID INT NOT NULL,
Flight_number VARCHAR(20),
Arrival_port VARCHAR(20),
Departure_port VARCHAR(20),
PRIMARY KEY(ID)
)


CREATE TABLE airplanes(
Voyage_id VARCHAR(10) NOT NULL,
Name VARCHAR(10),
Seats_capacity INT,
FOREIGN KEY(Voyage_id) REFERENCES voyage(id),
PRIMARY KEY(Voyage_id)
)

CREATE TABLE passengers(
ID INT NOT NULL,
First_name VARCHAR(20),
Last_name VARCHAR(20),
Nationality VARCHAR(10),
Passport VARCHAR(10),
DOB VARCHAR(10),
SEX VARCHAR(10),
PRIMARY KEY(ID)
)


CREATE TABLE departure(
Voyage_id VARCHAR(10) NOT NULL,
Date VARCHAR(20),
Time VARCHAR(20),
Terminal VARCHAR(10),
Flight_status VARCHAR(10),
Gate VARCHAR(10),
PRIMARY KEY(Voyage_id),
FOREIGN KEY(Voyage_id) REFERENCES voyage(id),
)

CREATE TABLE arrival(
Voyage_id VARCHAR(10) NOT NULL,
Date VARCHAR(20),
Time VARCHAR(20),
Terminal VARCHAR(10),
Flight_status VARCHAR(10),
Gate VARCHAR(10),
PRIMARY KEY(Voyage_id),
FOREIGN KEY(Voyage_id) REFERENCES voyage(id)
)
