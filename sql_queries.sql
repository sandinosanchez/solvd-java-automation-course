INSERT INTO Genders (name) VALUES ('Male');
INSERT INTO Genders	(name) VALUES ('Female');

INSERT INTO Users (email, password, first_name, last_name, gender_id) 
VALUES ('sandino320@gmail.com','12345','Sandino','Sanchez',1);
INSERT INTO Users (email, password, first_name, last_name, gender_id) 
VALUES ('eduardo123@gmail.com','12345','Eduardo','Lopez',1);
INSERT INTO Users (email, password, first_name, last_name, gender_id) 
VALUES ('julieta_1995@gmail.com','jul2234','Julieta','Sanchez',2);
INSERT INTO Users (email, password, first_name, last_name, gender_id) 
VALUES ('maxi_lopez@gmail.com','maa88722','Maximiliano','Lopez',1);
INSERT INTO Users (email, password, first_name, last_name, gender_id) 
VALUES ('alan.turing@gmail.com','010110011','Alan','Turing',1);
INSERT INTO Users (email, password, first_name, last_name, gender_id) 
VALUES ('alexandra.grom@gmail.com','gromalexhj12','Alexandra','Grom',2);
INSERT INTO Users (email, password, first_name, last_name, gender_id) 
VALUES ('agustina.fabrz@gmail.com','fabrzjj88','Agustina','Fabrz',2);

INSERT INTO Followers (user_id,folower_id,followed_date) VALUES (1,2,now());
INSERT INTO Followers (user_id,folower_id,followed_date) VALUES (1,3,now());
INSERT INTO Followers (user_id,folower_id,followed_date) VALUES (1,4,now());
INSERT INTO Followers (user_id,folower_id,followed_date) VALUES (1,5,now());
INSERT INTO Followers (user_id,folower_id,followed_date) VALUES (1,6,now());
INSERT INTO Followers (user_id,folower_id,followed_date) VALUES (2,2,now());
INSERT INTO Followers (user_id,folower_id,followed_date) VALUES (2,3,now());
INSERT INTO Followers (user_id,folower_id,followed_date) VALUES (2,1,now());
INSERT INTO Followers (user_id,folower_id,followed_date) VALUES (4,2,now());
INSERT INTO Followers (user_id,folower_id,followed_date) VALUES (5,2,now());
INSERT INTO Followers (user_id,folower_id,followed_date) VALUES (7,2,now());

SELECT *
FROM Users u LEFT JOIN Followers f on u.id = f.user_id;

INSERT INTO DirectMessages (date_created, user_id1, user_id2) VALUES (now(), 1, 2);
INSERT INTO DirectMessages (date_created, user_id1, user_id2) VALUES (now(), 1, 3);
INSERT INTO DirectMessages (date_created, user_id1, user_id2) VALUES (now(), 2, 3);
INSERT INTO DirectMessages (date_created, user_id1, user_id2) VALUES (now(), 2, 4);

SELECT * FROM DirectMessages;

ALTER TABLE Messages
MODIFY `date_created` DATETIME NOT NULL;

SELECT * FROM DirectMessages dr LEFT JOIN Messages m on dr.id = m.direct_message_id;

INSERT INTO Messages (message, date_created, direct_message_id) VALUES ('Test Message', now(), 2);
INSERT INTO Messages (message, date_created, direct_message_id) VALUES ('Resonse Test Message', now(), 2);

# Adding a post(poster = user_id = 1) with a comment and a photo(tag_user = user_id = 2).
INSERT INTO Posts (date_created, user_id, description) VALUES (now(), 1, 'Some description');
INSERT INTO Photos (file_url, post_id) VALUES ('Some file ulr for the photo', 1);
INSERT INTO Tags (user_id, photo_id) VALUES (2, 1);

INSERT INTO Posts (date_created, user_id, description) VALUES (now(), 1, 'Another description');
INSERT INTO Photos (file_url, post_id) VALUES ('Another file ulr for the photo', 2);
INSERT INTO Tags (user_id, photo_id) VALUES (5, 2);

INSERT INTO Posts (date_created, user_id, description) VALUES (now(), 2, 'Some description');
INSERT INTO Photos (file_url, post_id) VALUES ('Some file ulr for the photo', 3);
INSERT INTO Tags (user_id, photo_id) VALUES (7, 3);

INSERT INTO Posts (date_created, user_id, description) VALUES (now(), 5, 'Some description');
INSERT INTO Photos (file_url, post_id) VALUES ('Some file ulr for the photo', 4);
INSERT INTO Tags (user_id, photo_id) VALUES (4, 4);
INSERT INTO Tags (user_id, photo_id) VALUES (5, 4);

INSERT INTO Likes (user_id, post_id, date_liked) VALUES (1, 4, now());
INSERT INTO Likes (user_id, post_id, date_liked) VALUES (1, 2, now());
INSERT INTO Likes (user_id, post_id, date_liked) VALUES (1, 3, now());
INSERT INTO Likes (user_id, post_id, date_liked) VALUES (2, 1, now());
INSERT INTO Likes (user_id, post_id, date_liked) VALUES (5, 2, now());

SELECT * FROM Likes;

INSERT INTO Comments (text, post_id) VALUES('Sample comment', 1);
INSERT INTO Comments (text, post_id) VALUES('Good post', 1);
INSERT INTO Comments (text, post_id) VALUES('That happened to me last week!', 1);
INSERT INTO Comments (text, post_id) VALUES("That's right", 2);
INSERT INTO Comments (text, post_id) VALUES('Programming is the best (wink wink)', 2);
INSERT INTO Comments (text, post_id) VALUES('You should start with web testing luca', 3);

ALTER TABLE Comments
MODIFY id INT NOT NULL AUTO_INCREMENT;

ALTER TABLE Comments
CHANGE comment text VARCHAR(255) NOT NULL;

ALTER TABLE Comments
MODIFY comment VARCHAR(255) NOT NULL;

SET SQL_SAFE_UPDATES = 0;

UPDATE Comments 
SET text = 'Programming is the best'
WHERE id = 4;

UPDATE Comments 
SET `text` = 'Programming is the best'
WHERE `text` LIKE 'Programmin is the %';

SELECT *
FROM Comments;

# Likes per post
SELECT p.id, COUNT(l.post_id) as likes_count
FROM (Posts p LEFT JOIN Photos ph on p.id = ph.post_id) LEFT JOIN Likes l on p.id = l.post_id
GROUP BY p.id;

# Show all info about one post that the user with first_name = Sandino
SELECT u.first_name, u.last_name, p.id as post_id, p.date_created, p.description, ph.file_url, tg.user_id as Users_tagged
FROM ((Users u LEFT JOIN Posts p on u.id = p.user_id) 
LEFT JOIN Photos ph on p.id = ph.post_id) LEFT JOIN Tags tg on ph.id = tg.photo_id
WHERE u.first_name = 'Sandino';

SELECT * FROM (Users u LEFT JOIN Posts p ON u.id = p.user_id) LEFT JOIN Genders g ON u.gender_id = g.id;

SELECT t.id,  MAX(likes)
FROM (SELECT p.id, COUNT(*) as likes
				FROM (Users u LEFT JOIN Posts p ON u.id = p.user_id)
				LEFT JOIN Likes l ON p.id = l.post_id
				WHERE u.first_name = "Sandino"
				GROUP BY p.id) t
GROUP BY t.id

SELECT t.id, t.date_created, t.description, MAX(likes) as max_likes
FROM (SELECT p.id, p.date_created, p.description, COUNT(*) as likes
	FROM Posts p LEFT JOIN Likes lk ON p.id = lk.post_id 
    LEFT JOIN Users u ON p.user_id = u.id
    WHERE u.first_name = "Alan"
	GROUP BY p.id) t
GROUP BY t.id
ORDER BY max_likes DESC
LIMIT 1;

SELECT *
FROM Posts p LEFT JOIN Likes l ON p.id = l.post_id;

SELECT *
FROM Users
WHERE first_name = "Alan";

SELECT t.id, t.date_created, MAX(likes) as max_likes
            FROM (SELECT p.id, p.date_created, COUNT(*) as likes FROM Posts p LEFT JOIN Likes lk ON p.id = lk.post_id
            LEFT JOIN Users u ON p.user_id = u.id WHERE u.first_name = "Sandino" GROUP BY p.id) t GROUP BY t.id
            ORDER BY max_likes DESC LIMIT 1;