-- Create the database
CREATE DATABASE school;

-- Connect to the newly created database
\c school;

-- Create the Teacher table
CREATE TABLE Teacher (
    TID SERIAL PRIMARY KEY,
    TName VARCHAR(100) NOT NULL,
    Salary NUMERIC(10, 2) NOT NULL
);


-- Insert sample data into the Teacher table
INSERT INTO Teacher (TName, Salary) VALUES ('John Smith', 50000.00);
INSERT INTO Teacher (TName, Salary) VALUES ('Emily Johnson', 55000.00);
INSERT INTO Teacher (TName, Salary) VALUES ('Michael Brown', 48000.00);
INSERT INTO Teacher (TName, Salary) VALUES ('Sarah Williams', 52000.00);
INSERT INTO Teacher (TName, Salary) VALUES ('David Jones', 51000.00);
