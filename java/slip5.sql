CREATE TABLE questions (
    question_id SERIAL PRIMARY KEY,
    question_text TEXT NOT NULL,
    choice1 TEXT NOT NULL,
    choice2 TEXT NOT NULL,
    choice3 TEXT NOT NULL,
    choice4 TEXT NOT NULL,
    correct_choice INT NOT NULL
);


INSERT INTO questions (question_text, choice1, choice2, choice3, choice4, correct_choice)
VALUES
    ('What is the capital of France?', 'Paris', 'Berlin', 'London', 'Rome', 1),
    ('Which planet is known as the Red Planet?', 'Venus', 'Mars', 'Jupiter', 'Saturn', 2),
    ('Who wrote "To Kill a Mockingbird"?', 'Harper Lee', 'J.K. Rowling', 'Stephen King', 'Ernest Hemingway', 1),
    ('What is the chemical symbol for water?', 'H', 'O', 'CO2', 'H2O', 4),
    ('Who painted the Mona Lisa?', 'Leonardo da Vinci', 'Pablo Picasso', 'Vincent van Gogh', 'Michelangelo', 1);
