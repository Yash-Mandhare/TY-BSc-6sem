CREATE TABLE employees (
    eno INT PRIMARY KEY,
    ename VARCHAR(50),
    designation VARCHAR(50),
    salary DECIMAL(10, 2)
);

INSERT INTO employees (eno, ename, designation, salary) VALUES
(1, 'John Doe', 'Manager', 50000.00),
(2, 'Jane Smith', 'Developer', 40000.00),
(3, 'Alice Johnson', 'HR Manager', 45000.00),
(4, 'Bob Williams', 'Sales Executive', 38000.00);
