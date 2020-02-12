use social_network;

ALTER TABLE DirectMessages
CHANGE user_id2 receiver int;

SELECT *
FROM DirectMessages dm LEFT JOIN Users u ON u.id = dm.sender;

SELECT *
FROM (Posts pt LEFT JOIN Users u ON pt.user_id = u.id) LEFT JOIN Photos ph ON ph.post_id = pt.id

SELECT * FROM Users u LEFT JOIN Genders g ON u.gender_id = g.id;

SELECT t.id, t.date_created, t.description, MAX(likes) as max_likes
FROM (SELECT p.id, p.date_created, p.description, COUNT(*) as likes FROM Posts p LEFT JOIN Likes lk ON p.id = lk.post_id
	  LEFT JOIN Users u ON p.user_id = u.id WHERE u.first_name = "Sandino" GROUP BY p.id) t 
GROUP BY t.id 
ORDER BY max_likes DESC LIMIT 1;

SELECT *
FROM Posts p LEFT JOIN Likes l ON p.id = l.post_id;

USE social_network;
SELECT u.id, u.first_name, u.last_name, u.email, g.id as gender_id, g.name, p.id as post_id, p.date_created, p.description,
	   f.folower_id as follower_id, f.followed_date, dm.id as dm_id, dm.sender, dm.receiver, dm.date_created as dm_date_created
FROM Users u LEFT JOIN Genders g ON u.gender_id = g.id 
LEFT JOIN Posts p ON u.id = p.user_id LEFT JOIN DirectMessages dm ON u.id = dm.sender
LEFT JOIN Followers f ON u.id = f.user_id;

SELECT *
FROM DirectMessages;

SELECT * FROM Users u LEFT JOIN Genders g ON u.gender_id = g.id;

SELECT * FROM Users u INNER JOIN Followers f ON u.id = f.user_id WHERE u.id = 1;