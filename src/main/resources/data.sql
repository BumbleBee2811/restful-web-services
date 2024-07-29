INSERT INTO user_details (id,birth_date,name)
VALUES
(100,current_date(),'Rohit'),
(101,current_date(),'Yashashvi'),
(102,current_date(),'Shubhman'),
(103,current_date(),'Rahul');

INSERT INTO user_login (id,user_name, password, email_id)
VALUES
(100,'Rohit', 'pass123','rohit@test.com'),
(101,'Yashashvi','pass123','yashashvi@test.com'),
(102,'Shubhman','pass123','shubhman@test.com'),
(103,'Rahul','pass123','rahul@test.com');

INSERT INTO post (id,description,user_id)
VALUES
(1,'I want to learn AWS',100),
(2,'I want to learn DevOps',101),
(3,'I want to learn Azure',102),
(4,'I want to learn Micro Services',103),
(5,'I want to learn Machine Learning',100),
(6,'I want to learn SpringBoot',101),
(7,'I want to learn Java',102),
(8,'I want to learn Kafka',103);