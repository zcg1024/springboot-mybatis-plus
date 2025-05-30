-- data-h2.sql
DELETE FROM "user";

INSERT INTO "user" (id, username,password, age, email) VALUES
(1, 'Jone', '123456', 18, 'test1@baomidou.com'),
(2, 'Jack', '123456', 20, 'test2@baomidou.com'),
(3, 'Tom', '123456', 28, 'test3@baomidou.com'),
(4, 'Sandy', '123456', 21, 'test4@baomidou.com'),
(5, 'Billie', '123456', 24, 'test5@baomidou.com');




DELETE FROM "t_simple";

INSERT INTO "t_simple" (id, username,password, email) VALUES
(1, 'Jone', '123456', 'test1@baomidou.com'),
(2, 'Jack', '123456', 'test2@baomidou.com'),
(3, 'Tom', '123456', 'test3@baomidou.com'),
(4, 'Sandy', '123456', 'test4@baomidou.com'),
(5, 'Billie', '123456', 'test5@baomidou.com');