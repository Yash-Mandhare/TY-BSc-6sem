CREATE TABLE TEACHER (
    tno INT PRIMARY KEY,
    tname VARCHAR(100),
    qualification VARCHAR(100),
    salary DECIMAL(10, 2)
);
INSERT INTO TEACHER (tno, tname, qualification, salary) VALUES
(1, 'John Doe', 'Ph.D. in Mathematics', 50000.00),
(2, 'Jane Smith', 'Master of Education', 45000.00),
(3, 'Alice Johnson', 'Bachelor of Science in Physics', 48000.00),
(4, 'Michael Brown', 'Ph.D. in History', 55000.00),
(5, 'Emily Wilson', 'Master of Arts in English Literature', 46000.00);
