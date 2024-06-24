CREATE TABLE job (
    id UUID DEFAULT RANDOM_UUID() PRIMARY KEY,
    title varchar(255) NOT NULL
);

INSERT INTO job (title) VALUES
    ('Architect'),
    ('Software engineer'),
    ('Quantity surveyor'),
    ('Accountant');
