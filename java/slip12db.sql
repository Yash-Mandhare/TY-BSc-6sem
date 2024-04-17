-- Create the PROJECT table
CREATE TABLE PROJECT (
    project_id SERIAL PRIMARY KEY,
    project_name VARCHAR(100),
    project_description TEXT,
    project_status VARCHAR(50)
);

-- Insert sample values into the PROJECT table
INSERT INTO PROJECT (project_name, project_description, project_status) VALUES
('Project A', 'Description for Project A', 'Active'),
('Project B', 'Description for Project B', 'Inactive'),
('Project C', 'Description for Project C', 'Active');
