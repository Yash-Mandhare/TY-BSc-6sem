CREATE TABLE EMP (
    eno INT PRIMARY KEY,
    ename VARCHAR(50),
    designation VARCHAR(50),
    salary DECIMAL(10, 2)
);

INSERT INTO EMP (eno,ename, designation, salary) VALUES
    (1,'John Doe', 'Manager', 50000.00),
    (2,'Jane Smith', 'Developer', 45000.00),
    (3,'Alice Johnson', 'HR Manager', 48000.00),
    (4,'Bob Williams', 'Analyst', 52000.00),
    (5,'Emma Brown', 'Designer', 47000.00);