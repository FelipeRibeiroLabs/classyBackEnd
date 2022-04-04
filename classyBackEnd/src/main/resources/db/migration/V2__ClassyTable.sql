DROP table IF EXISTS crew CASCADE;
DROP table IF EXISTS person CASCADE;
DROP table IF EXISTS admin CASCADE;


CREATE TABLE crew(
                     id SERIAL PRIMARY KEY,
                     name VARCHAR(250),
                     school_id INT REFERENCES school(id),
                     schoolYear VARCHAR(100),
                     university_id INT REFERENCES university(id),
                     university_status VARCHAR(250),
                     esport_id INT REFERENCES esport(id),

                     instagram VARCHAR(100),
                     created_at TIMESTAMP
);

CREATE TABLE person(
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(250),
                       nickname VARCHAR(250),
                       phone_number VARCHAR(250),
                       email VARCHAR(250),
                       number INT,
                       created_at TIMESTAMP
);

CREATE TABLE crew_person(
                            crew_id INT NOT NULL references crew(id),
                            person_id INT NOT NULL references person(id)
);

CREATE TABLE admin(
                      crew_id INT NOT NULL references crew(id),
                      person_id INT NOT NULL references person(id)
);