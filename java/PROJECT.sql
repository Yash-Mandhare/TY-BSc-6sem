-- Create the PROJECT table
CREATE TABLE PROJECT (
    project_id INT PRIMARY KEY,
    project_name VARCHAR(100),
    project_description VARCHAR(255),
    project_status VARCHAR(50)
);

-- Insert values into the PROJECT table
INSERT INTO PROJECT (project_id, project_name, project_description, project_status)
VALUES
    (1, 'Project 1', 'Description for Project 1', 'Active'),
    (2, 'Project 2', 'Description for Project 2', 'Inactive'),
    (3, 'Project 3', 'Description for Project 3', 'Active');
