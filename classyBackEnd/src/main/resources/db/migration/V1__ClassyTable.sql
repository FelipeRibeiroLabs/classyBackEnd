CREATE TABLE school(
                       id SERIAL PRIMARY KEY,
                       school_name VARCHAR(250),
                       city VARCHAR(250),
                       state VARCHAR(250)
);

CREATE TABLE university(
                       id SERIAL PRIMARY KEY,
                       university_name VARCHAR(250),
                       city VARCHAR (250),
                       state VARCHAR(250)
);

CREATE TABLE course(
                       id SERIAL PRIMARY KEY,
                       course_name VARCHAR(250),
                       university_id INT REFERENCES university(id)
);

CREATE TABLE esport(
                       id SERIAL PRIMARY KEY,
                       game_name VARCHAR(250),
                       plataform VARCHAR(250)
);


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

CREATE TABLE admin(
    id INT PRIMARY KEY REFERENCES crew(id)
);

CREATE TABLE person(
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(250),
                       nickname VARCHAR(250),
                       phone_number VARCHAR(250),
                       email VARCHAR(250),
                       number INT,
                       crew_id INT REFERENCES crew(id),
                       created_at TIMESTAMP
);

create table uniform(
                        id serial primary key,
                        type varchar(100),
                        uniform_url varchar(255),
                        crew_id int references crew(id),
                        person_id int references person(id),
                        votes_yes int,
                        votes_no int
);