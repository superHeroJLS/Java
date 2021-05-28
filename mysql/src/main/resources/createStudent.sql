CREATE TABLE test.`student_info` (
    id INT NOT NULL PRIMARY KEY,
    name NVARCHAR(20),
    dept_id INT,
    age INT,
    sex CHAR(1),
    heigh FLOAT,
    login TIMESTAMP
);

INSERT INTO test.`student` values
(1, 'Dany', 1, 25, 'F', 160, timestamp('2021-09-10')),
(2, 'Green  ', 1, 23, 'F', 160, timestamp('2021-08-10')),
(3, 'Henry', 1, 24, 'M', 180, timestamp('2021-07-10')),
(4, 'Jane', 1, 20, 'F', 170, timestamp('2021-06-10')),
(5, 'Jim', 1, 21, 'M', 175, timestamp('2021-05-10')),
(6, 'John', 1, 22, 'M', 178, timestamp('2021-04-10')),
(7, 'Lily', 1, 16, 'F', 160, timestamp('2021-03-10')),
(8, 'Susan', 1, 18, 'M', 158, timestamp('2021-02-10')),
(9, 'Thomas', 1, 13, 'F', 180, timestamp('2021-01-10')),
(10, 'Tom', 1, 30, 'F', 170, timestamp('2020-09-10'))