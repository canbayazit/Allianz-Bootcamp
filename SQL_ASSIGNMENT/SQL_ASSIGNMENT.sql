-- CREATE TABLE USERS

CREATE TABLE users (
	user_id SERIAL PRIMARY KEY,
	username VARCHAR(50) UNIQUE NOT NULL,
	email VARCHAR(100) UNIQUE NOT NULL,
	creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	is_active BOOLEAN
);

-- CREATE TABLE CATEGORIES

CREATE TABLE categories (
	category_id SERIAL PRIMARY KEY,
	name VARCHAR(50) UNIQUE NOT NULL,
	creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- CREATE TABLE POSTS

CREATE TABLE posts (
    post_id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    category_id INTEGER NOT NULL,
    title VARCHAR(50) NOT NULL,
    content TEXT NOT NULL,
    view_count INTEGER DEFAULT 0,
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_published BOOLEAN,
    FOREIGN KEY (user_id) REFERENCES users (user_id),
    FOREIGN KEY (category_id) REFERENCES categories (category_id)
);

-- CREATE TABLE COMMENTS

CREATE TABLE comments (
	comment_id SERIAL PRIMARY KEY,
	post_id INTEGER NOT NULL,
	user_id INTEGER,
	comment VARCHAR(50) NOT NULL,
	creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	is_confirmed BOOLEAN,
	FOREIGN KEY (post_id) REFERENCES posts (post_id),
    	FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-----------------------------------------------------------------

--	INSERTS --

-- users Table Insert

insert into users (user_id, username, email, creation_date, is_active) values (1, 'lsally0', 'fditty0@google.com.hk', '2012-07-16 13:08:11', false);
insert into users (user_id, username, email, creation_date, is_active) values (2, 'amaciaszczyk1', 'abawles1@ucoz.ru', '2010-05-09 07:38:57', true);
insert into users (user_id, username, email, creation_date, is_active) values (3, 'ygiacopetti2', 'nmatfield2@symantec.com', '2015-04-10 19:41:53', true);
insert into users (user_id, username, email, creation_date, is_active) values (4, 'acaghy3', 'wcellier3@sphinn.com', '2017-03-23 00:26:58', true);
insert into users (user_id, username, email, creation_date, is_active) values (5, 'dfryman4', 'gspaight4@php.net', '2020-12-18 00:43:10', true);
insert into users (user_id, username, email, creation_date, is_active) values (6, 'cbreakwell5', 'klivingstone5@pagesperso-orange.fr', '2013-07-06 16:49:54', false);
insert into users (user_id, username, email, creation_date, is_active) values (7, 'thehl6', 'arenshall6@sitemeter.com', '2015-12-13 04:09:44', true);
insert into users (user_id, username, email, creation_date, is_active) values (8, 'gwethered7', 'calesi7@desdev.cn', '2021-07-03 08:50:23', false);
insert into users (user_id, username, email, creation_date, is_active) values (9, 'skingsford8', 'bkeavy8@google.ca', '2016-06-09 05:56:59', true);
insert into users (user_id, username, email, creation_date, is_active) values (10, 'snasi9', 'fconstantine9@gravatar.com', '2016-05-02 03:48:52', false);

--categories Table Insert

insert into categories (category_id, name, creation_date) values (1, 'Food', '2022-11-19 00:49:45');
insert into categories (category_id, name, creation_date) values (2, 'Travel', '2021-11-05 19:45:41');
insert into categories (category_id, name, creation_date) values (3, 'Health', '2012-07-31 02:05:58');
insert into categories (category_id, name, creation_date) values (4, 'Fashion', '2020-06-12 09:26:58');
insert into categories (category_id, name, creation_date) values (5, 'Technology', '2023-01-14 18:07:28');

--posts Table Insert

insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (1, 4, 5, 'quam', 'non pretium quis lectus suspendisse potenti', 10697, '2013-05-23 01:59:07', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (2, 2, 3, 'ornare', 'lectus in quam fringilla', 53083, '2019-12-30 10:29:59', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (3, 2, 5, 'porttitor', 'libero convallis eget eleifend luctus ultricies', 92563, '2018-03-20 23:06:45', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (4, 5, 5, 'tortor duis mattis', 'nibh ligula nec sem duis aliquam', 51387, '2014-09-22 23:05:49', true);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (5, 3, 1, 'turpis', 'habitasse platea dictumst maecenas ut', 81144, '2015-01-16 12:59:04', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (6, 1, 5, 'nunc', 'vivamus in felis eu sapien cursus vestibulum', 82089, '2018-07-28 10:02:03', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (7, 8, 3, 'mauris non ligula', 'sit amet sapien dignissim vestibulum', 59955, '2015-03-22 05:16:57', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (8, 8, 5, 'proin at turpis', 'magna at nunc commodo placerat praesent blandit', 61258, '2017-06-18 08:11:02', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (9, 5, 3, 'elit proin interdum', 'lectus in est risus auctor sed', 11419, '2019-10-19 02:01:58', true);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (10, 1, 3, 'convallis tortor', 'erat quisque erat eros', 29017, '2015-07-17 00:30:33', true);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (11, 6, 1, 'bibendum', 'id ornare imperdiet sapien urna pretium', 54316, '2011-12-12 09:22:33', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (12, 3, 1, 'vitae', 'sagittis dui vel nisl duis ac', 23899, '2015-09-10 21:22:34', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (13, 4, 2, 'in', 'volutpat erat quisque erat eros', 73287, '2011-02-05 00:11:30', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (14, 2, 5, 'volutpat convallis', 'eros viverra eget congue', 56522, '2018-08-27 09:46:05', true);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (15, 6, 1, 'ridiculus mus vivamus', 'risus praesent lectus vestibulum quam sapien varius', 28786, '2013-03-28 18:50:40', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (16, 9, 1, 'amet', 'tellus nulla ut erat id', 58304, '2015-02-19 10:59:20', true);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (17, 7, 5, 'massa id nisl', 'tortor risus dapibus augue vel accumsan tellus', 8455, '2010-12-20 11:55:31', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (18, 10, 3, 'fusce', 'iaculis justo in', 29879, '2022-10-10 21:36:41', true);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (19, 10, 4, 'risus dapibus', 'fusce lacus purus aliquet at feugiat non', 71919, '2022-05-27 03:53:09', true);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (20, 10, 2, 'adipiscing elit proin', 'lorem id ligula', 85675, '2013-04-21 09:28:20', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (21, 7, 5, 'vel ipsum praesent', 'dictumst maecenas ut massa quis augue', 49869, '2014-11-15 20:36:52', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (22, 6, 1, 'sagittis nam congue', 'dictumst morbi vestibulum velit id pretium iaculis', 87779, '2012-10-19 18:07:22', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (23, 5, 2, 'tempus semper est', 'rhoncus sed vestibulum', 88622, '2022-02-15 15:45:42', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (24, 10, 2, 'erat id mauris', 'aenean fermentum donec ut mauris eget', 55629, '2019-11-15 14:46:34', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (25, 4, 2, 'justo', 'velit eu est congue', 75674, '2019-01-29 22:00:26', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (26, 3, 3, 'ut rhoncus aliquet', 'donec dapibus duis at velit eu', 20767, '2022-09-06 12:09:16', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (27, 2, 2, 'justo sit amet', 'lectus aliquam sit amet diam in magna', 80749, '2015-08-09 18:15:14', true);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (28, 4, 4, 'integer non velit', 'adipiscing elit proin risus praesent lectus vestibulum', 51901, '2019-09-29 12:12:20', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (29, 4, 1, 'leo maecenas', 'nunc rhoncus dui', 74182, '2014-10-21 12:47:43', true);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (30, 10, 3, 'curabitur', 'id ornare imperdiet sapien', 26814, '2021-04-08 21:58:23', true);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (31, 3, 5, 'phasellus', 'morbi odio odio elementum eu interdum eu', 70740, '2019-01-22 22:00:07', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (32, 5, 2, 'curae', 'at feugiat non pretium', 29688, '2013-07-10 03:59:45', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (33, 4, 1, 'etiam pretium', 'et magnis dis parturient montes', 19918, '2016-03-04 05:33:30', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (34, 7, 3, 'tellus nisi eu', 'ut ultrices vel augue vestibulum ante', 89816, '2015-12-12 06:20:54', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (35, 1, 2, 'lorem quisque ut', 'dui nec nisi volutpat', 97978, '2023-01-11 06:00:20', true);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (36, 4, 5, 'turpis integer', 'ac enim in tempor turpis nec', 66069, '2020-11-13 01:28:05', true);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (37, 2, 5, 'aenean auctor', 'nulla justo aliquam quis turpis eget', 97049, '2022-04-03 07:13:56', true);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (38, 7, 1, 'lorem', 'in hac habitasse platea dictumst', 76215, '2013-02-05 05:09:22', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (39, 2, 3, 'cras in purus', 'nulla quisque arcu', 33592, '2018-10-19 04:08:28', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (40, 1, 1, 'accumsan tellus', 'nisi at nibh', 25286, '2018-08-09 15:06:29', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (41, 4, 5, 'amet lobortis', 'felis sed interdum venenatis', 31302, '2019-01-30 16:46:54', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (42, 4, 5, 'sem mauris', 'rhoncus sed vestibulum sit', 80084, '2012-10-16 17:38:30', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (43, 3, 4, 'eget eros elementum', 'in ante vestibulum ante ipsum primis', 15432, '2015-10-06 19:28:36', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (44, 6, 2, 'ante', 'sed lacus morbi sem mauris laoreet ut', 52481, '2014-10-07 11:42:56', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (45, 9, 5, 'congue', 'vel lectus in quam fringilla', 24723, '2015-08-28 04:53:01', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (46, 10, 4, 'consectetuer adipiscing elit', 'amet nulla quisque arcu', 53717, '2014-09-08 05:37:10', true);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (47, 10, 3, 'blandit non', 'velit eu est congue elementum', 73987, '2013-06-22 09:24:06', true);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (48, 4, 5, 'amet consectetuer adipiscing', 'ultrices mattis odio', 9930, '2015-02-14 01:04:00', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (49, 2, 1, 'vulputate ut ultrices', 'erat fermentum justo', 16540, '2022-08-22 23:25:29', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (50, 5, 5, 'congue', 'aliquam quis turpis eget elit sodales scelerisque', 28504, '2018-07-27 14:09:45', true);

-- comments Table Insert

insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (48, 2, 'in congue etiam', '2014-05-16 22:11:29', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (25, 7, 'faucibus accumsan odio curabitur convallis', '2019-06-23 20:40:50', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (39, null, 'eros viverra', '2013-06-04 22:29:49', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (47, 8, 'suspendisse accumsan tortor quis turpis sed ante vivamus', '2020-10-27 12:04:42', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (39, 1, 'sit amet eleifend pede', '2011-02-24 12:05:29', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (22, 7, 'ornare consequat lectus in est risus auctor sed', '2010-10-07 10:49:05', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (44, 2, 'magna ac consequat metus sapien', '2011-12-17 23:22:42', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (39, null, 'aliquam erat volutpat in', '2013-09-16 01:20:31', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (33, 10, 'enim', '2022-09-03 06:26:19', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (27, 8, 'nec nisi', '2014-07-24 11:10:39', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (12, 2, 'nunc commodo placerat praesent blandit nam nulla integer', '2017-09-12 00:46:11', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (42, 3, 'vehicula consequat morbi a', '2014-05-11 03:30:57', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (16, 7, 'morbi sem mauris', '2018-10-13 00:59:51', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (10, 5, 'libero quis orci nullam molestie nibh in lectus', '2011-02-27 00:35:54', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (28, 6, 'ipsum praesent blandit lacinia erat', '2020-11-22 12:08:28', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (31, 2, 'sed ante vivamus tortor duis', '2019-03-23 22:48:05', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (34, 10, 'ac neque duis bibendum morbi non quam', '2015-09-02 07:01:16', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (18, 5, 'enim', '2015-03-11 23:15:42', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (21, 7, 'amet cursus', '2013-11-15 18:03:37', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (34, 7, 'sem duis aliquam convallis nunc proin at turpis', '2016-09-10 09:57:41', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (31, 5, 'ante ipsum', '2017-06-26 10:11:06', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (48, null, 'non interdum in ante vestibulum ante ipsum primis', '2010-12-30 08:36:50', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (5, 9, 'ut volutpat', '2023-04-21 22:39:10', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (20, 2, 'praesent id massa id nisl venenatis lacinia aenean', '2022-04-20 19:24:13', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (23, 1, 'quam', '2019-05-31 01:49:26', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (1, 5, 'id nulla ultrices aliquet maecenas leo odio', '2018-10-03 08:30:47', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (18, 8, 'a libero nam dui proin leo odio', '2011-12-07 14:32:12', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (26, null, 'id turpis integer aliquet massa id lobortis convallis', '2013-12-21 01:08:53', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (2, 4, 'sem sed sagittis nam congue', '2011-08-31 01:32:49', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (33, 10, 'mi pede malesuada', '2021-08-27 03:09:57', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (43, 5, 'turpis a pede posuere', '2020-10-25 22:47:27', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (46, 4, 'massa volutpat convallis morbi odio odio', '2022-03-07 10:16:55', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (11, null, 'massa', '2016-07-18 01:32:20', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (2, null, 'dui proin leo odio porttitor id consequat', '2012-01-29 04:45:48', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (41, 2, 'vel lectus in quam fringilla rhoncus', '2011-06-05 21:19:21', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (49, null, 'risus auctor sed', '2021-07-31 05:33:44', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (41, 5, 'nisi vulputate nonummy maecenas tincidunt lacus', '2019-04-15 01:17:33', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (48, 10, 'aliquam non mauris morbi non lectus aliquam sit', '2021-06-21 06:28:58', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (31, 8, 'risus semper porta volutpat quam', '2012-08-01 05:57:38', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (16, null, 'ligula in', '2012-06-10 21:43:03', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (23, 9, 'sociis natoque', '2016-06-11 23:50:50', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (10, 1, 'congue risus semper porta volutpat quam pede lobortis', '2012-09-01 03:49:07', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (49, 3, 'felis donec semper sapien', '2019-01-04 12:47:05', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (32, 10, 'nec nisi vulputate nonummy maecenas tincidunt lacus', '2022-07-31 16:59:54', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (8, 10, 'dis parturient montes nascetur ridiculus', '2011-07-06 08:04:22', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (31, 3, 'vulputate justo', '2022-01-17 23:52:02', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (1, 9, 'quis lectus suspendisse potenti in eleifend', '2011-10-18 01:10:57', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (39, null, 'in porttitor pede justo eu massa donec', '2018-03-06 14:46:26', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (40, 3, 'tellus nulla ut erat', '2020-05-27 08:32:46', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (32, 3, 'consequat lectus in', '2022-03-01 00:29:35', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (31, 10, 'proin eu mi nulla', '2015-05-09 12:11:06', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (30, null, 'egestas metus aenean fermentum donec ut mauris', '2012-11-22 07:59:09', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (33, null, 'dolor quis odio consequat varius', '2015-01-13 22:48:39', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (41, 7, 'ornare imperdiet sapien urna', '2016-07-15 09:26:25', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (32, 10, 'mi nulla ac enim in tempor turpis', '2013-05-30 11:35:23', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (42, 6, 'vestibulum vestibulum ante ipsum primis in', '2010-12-18 00:50:13', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (8, 8, 'faucibus orci', '2015-01-15 10:21:35', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (25, 2, 'viverra pede ac diam cras', '2020-02-22 23:01:41', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (37, null, 'ipsum primis in faucibus orci luctus et', '2015-07-20 00:09:50', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (2, 9, 'vestibulum ac est', '2015-03-02 09:33:23', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (44, 8, 'donec quis orci eget orci', '2013-10-04 03:28:42', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (21, 9, 'erat curabitur', '2012-07-30 08:30:37', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (33, 10, 'aenean lectus pellentesque eget nunc donec', '2019-10-18 15:20:14', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (20, 4, 'elementum pellentesque', '2012-06-11 00:42:31', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (39, 8, 'sapien placerat ante', '2018-11-25 05:54:11', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (7, 5, 'ut at dolor quis', '2022-04-05 15:10:50', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (6, 5, 'sapien a libero', '2019-04-11 09:20:13', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (22, 4, 'felis sed', '2011-09-18 23:57:30', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (28, 1, 'ullamcorper augue a suscipit nulla elit', '2011-10-09 00:33:27', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (23, 9, 'ipsum primis in faucibus orci', '2018-07-04 01:46:56', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (24, 2, 'venenatis turpis enim blandit mi in', '2020-09-19 09:05:24', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (8, 9, 'nec condimentum neque sapien placerat ante nulla justo', '2019-04-15 15:19:10', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (5, 4, 'massa donec dapibus duis at velit eu', '2012-11-22 21:58:27', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (49, 1, 'lectus aliquam sit amet diam in magna bibendum', '2014-01-25 12:21:00', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (13, 4, 'ac neque duis bibendum morbi non quam nec', '2011-07-15 16:52:13', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (24, 7, 'felis sed lacus morbi', '2018-03-20 02:16:08', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (50, 7, 'in', '2019-08-23 05:19:31', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (6, 6, 'sapien cum sociis natoque penatibus et magnis', '2010-10-21 22:49:13', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (6, 2, 'semper', '2012-05-22 12:51:38', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (21, 10, 'in est risus auctor sed tristique in tempus', '2015-04-09 05:29:26', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (17, null, 'tincidunt lacus at', '2014-10-23 01:59:21', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (45, 4, 'leo', '2019-02-01 02:51:56', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (4, 1, 'magna at nunc', '2019-08-05 12:24:06', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (46, 3, 'curae', '2010-06-27 18:40:17', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (30, null, 'lobortis vel dapibus at diam nam tristique tortor', '2013-09-10 13:13:16', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (45, 2, 'metus aenean fermentum donec ut mauris eget massa', '2012-09-14 11:57:04', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (30, 1, 'diam in', '2016-05-10 06:15:42', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (18, null, 'est', '2021-03-11 06:19:41', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (34, null, 'eros vestibulum ac est lacinia nisi venenatis', '2023-03-02 14:25:32', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (23, 10, 'ultrices aliquet maecenas leo odio', '2015-05-04 11:46:15', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (43, 6, 'sit amet', '2019-07-02 19:09:03', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (27, 5, 'dui luctus rutrum nulla tellus', '2015-10-01 03:35:45', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (39, 10, 'massa id nisl venenatis lacinia aenean', '2019-05-11 05:37:32', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (39, 2, 'leo maecenas pulvinar lobortis est phasellus sit', '2016-12-03 15:04:41', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (38, 1, 'est donec odio justo sollicitudin ut', '2013-09-23 02:06:56', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (43, 1, 'in', '2010-12-01 16:50:55', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (37, 3, 'sapien in sapien iaculis congue vivamus metus arcu', '2018-12-01 18:27:37', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (42, 4, 'habitasse platea dictumst morbi', '2017-08-14 01:48:47', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (2, 3, 'ridiculus mus etiam vel augue vestibulum', '2013-09-08 09:44:38', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (44, 6, 'erat volutpat in congue etiam', '2019-06-23 23:39:20', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (18, 8, 'purus eu magna', '2022-09-09 05:27:17', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (6, 10, 'dapibus at diam nam tristique tortor eu', '2014-02-12 20:13:41', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (47, 8, 'vulputate', '2015-03-08 09:26:24', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (27, 10, 'euismod scelerisque quam turpis adipiscing', '2014-11-25 03:05:18', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (41, 8, 'libero non mattis pulvinar nulla pede ullamcorper augue', '2018-01-12 11:46:06', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (1, 5, 'at nulla suspendisse potenti', '2011-08-13 03:45:50', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (44, 9, 'in congue etiam justo etiam', '2016-07-28 18:18:04', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (32, 5, 'in est risus auctor sed', '2011-06-11 08:15:48', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (28, 6, 'lacus morbi sem mauris laoreet', '2022-04-15 05:37:38', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (26, 10, 'quam', '2017-10-09 23:11:06', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (23, 5, 'orci nullam molestie nibh in lectus pellentesque at', '2013-01-13 08:01:56', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (27, 8, 'quam nec dui luctus rutrum nulla tellus in', '2017-01-30 13:15:02', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (2, null, 'fusce consequat nulla nisl', '2017-01-04 09:51:25', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (25, 4, 'faucibus orci luctus et', '2019-04-15 22:58:04', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (45, null, 'interdum mauris ullamcorper purus sit amet nulla', '2023-04-17 13:43:27', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (26, 1, 'nibh', '2015-11-06 08:25:19', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (38, 1, 'posuere cubilia curae mauris', '2017-11-15 14:44:25', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (33, null, 'tortor quis turpis sed ante vivamus tortor duis', '2011-03-31 18:56:37', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (50, 10, 'pellentesque quisque porta volutpat erat quisque', '2012-07-17 00:32:01', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (2, null, 'praesent', '2021-12-21 10:44:12', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (4, 10, 'augue vel accumsan tellus nisi eu orci mauris', '2019-07-18 07:44:01', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (21, 1, 'justo in hac', '2023-01-30 08:42:48', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (36, null, 'libero ut massa volutpat convallis morbi odio', '2014-12-05 01:02:20', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (39, 10, 'mauris non ligula pellentesque ultrices phasellus', '2022-06-09 12:15:02', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (3, 9, 'est risus auctor sed', '2014-07-24 18:46:21', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (16, 10, 'posuere cubilia', '2012-06-15 05:32:37', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (28, 7, 'lacus curabitur at ipsum ac tellus semper interdum', '2015-11-30 19:53:51', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (33, 8, 'nisi at nibh in hac habitasse platea', '2011-06-05 10:20:56', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (50, 4, 'magnis dis parturient montes nascetur ridiculus mus etiam', '2023-05-04 22:40:03', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (50, null, 'curabitur at ipsum', '2012-07-27 18:07:26', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (38, 3, 'nulla suspendisse potenti cras in', '2021-08-27 00:49:10', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (46, 7, 'ut rhoncus aliquet pulvinar sed nisl nunc', '2010-07-17 10:51:05', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (17, 4, 'rhoncus sed vestibulum', '2018-05-10 08:05:21', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (23, 3, 'pede posuere nonummy integer', '2014-06-10 01:07:25', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (15, 4, 'tortor id nulla', '2017-12-10 22:37:33', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (29, 7, 'primis in faucibus orci luctus', '2011-10-03 22:13:59', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (28, 2, 'ligula suspendisse ornare consequat lectus in est risus', '2023-03-30 06:40:40', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (42, 1, 'cursus vestibulum proin eu mi nulla ac', '2019-05-07 14:22:15', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (32, 9, 'orci luctus et ultrices posuere cubilia curae mauris', '2018-09-05 12:24:12', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (17, 4, 'sapien', '2013-03-24 04:52:57', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (10, 2, 'rutrum nulla nunc purus phasellus in felis donec', '2015-03-20 15:26:57', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (6, 2, 'est et', '2014-01-22 08:45:39', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (44, 8, 'rutrum at lorem integer tincidunt', '2010-07-26 19:48:59', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (1, 8, 'dapibus at diam nam tristique', '2022-04-17 15:45:50', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (12, 3, 'placerat ante nulla justo aliquam quis turpis', '2013-05-16 07:24:15', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (30, 2, 'nunc vestibulum ante ipsum primis', '2014-05-13 20:24:04', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (26, 6, 'facilisi cras non', '2011-06-12 08:01:24', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (32, null, 'eu magna', '2010-09-18 09:47:10', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (48, null, 'porta volutpat quam pede lobortis ligula sit', '2012-05-28 17:03:54', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (29, 8, 'vestibulum ante ipsum primis in faucibus orci', '2016-05-28 21:28:58', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (44, 9, 'neque duis bibendum morbi non quam nec dui', '2021-09-10 14:47:13', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (47, 10, 'lorem integer tincidunt ante vel ipsum', '2023-01-11 21:51:16', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (28, 7, 'libero rutrum ac lobortis', '2014-10-05 10:05:47', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (47, 6, 'nisl duis', '2012-09-19 05:47:14', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (24, 3, 'proin risus', '2013-04-22 05:53:38', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (38, 7, 'amet turpis elementum', '2011-05-27 19:10:20', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (28, 10, 'sapien varius ut', '2017-07-18 03:26:24', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (30, 8, 'eget nunc donec quis orci eget orci', '2019-12-22 01:19:25', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (12, 10, 'nulla suscipit ligula in lacus', '2011-12-01 13:57:03', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (8, null, 'cursus vestibulum proin eu', '2014-09-26 01:19:14', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (22, 3, 'hac habitasse platea dictumst etiam faucibus cursus', '2010-12-18 04:50:15', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (21, 5, 'cum sociis', '2010-09-30 00:25:35', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (20, null, 'duis bibendum felis', '2012-03-21 10:40:38', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (46, null, 'aliquet ultrices', '2014-10-21 09:28:48', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (14, 10, 'pretium quis lectus', '2017-11-02 07:33:12', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (47, 10, 'sed augue aliquam erat volutpat', '2015-12-10 21:51:42', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (40, 1, 'et ultrices posuere cubilia curae', '2017-10-31 23:52:50', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (20, 9, 'erat vestibulum sed', '2012-02-13 00:35:54', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (18, 6, 'lectus aliquam', '2021-11-25 07:44:40', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (45, 2, 'libero non', '2016-10-19 10:35:33', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (28, 6, 'fringilla rhoncus mauris enim leo rhoncus sed vestibulum', '2021-04-29 20:12:00', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (5, 2, 'interdum', '2020-09-15 21:21:17', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (19, null, 'sit amet cursus', '2018-12-02 10:57:20', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (33, 3, 'parturient montes nascetur ridiculus', '2020-10-07 12:03:53', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (40, 9, 'libero quis orci nullam molestie nibh', '2013-02-20 02:20:37', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (10, null, 'hac', '2015-05-27 22:10:26', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (10, null, 'ut tellus nulla', '2013-11-06 09:56:26', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (20, null, 'massa quis augue', '2015-08-13 01:49:23', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (50, 3, 'magna vulputate luctus cum sociis natoque', '2016-09-01 20:36:52', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (42, 5, 'ante vestibulum ante ipsum primis in', '2014-07-17 20:08:07', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (33, 3, 'ligula nec sem duis', '2012-11-09 16:20:16', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (11, 5, 'amet eleifend pede libero quis', '2021-08-08 12:11:56', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (45, 5, 'donec quis orci eget orci vehicula condimentum', '2019-06-02 23:32:34', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (24, null, 'parturient montes nascetur', '2022-12-11 12:46:21', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (47, 4, 'nibh in quis justo maecenas rhoncus', '2014-12-13 01:35:10', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (47, 10, 'tristique fusce congue diam id', '2011-09-23 15:46:22', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (12, 6, 'consequat nulla nisl nunc', '2016-07-17 12:34:22', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (16, 7, 'et magnis dis parturient montes nascetur ridiculus mus', '2023-04-14 22:53:34', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (21, 1, 'mattis egestas metus', '2010-08-25 19:31:25', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (11, 3, 'est', '2017-12-05 00:57:42', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (27, 10, 'vitae', '2019-10-18 12:31:52', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (31, 3, 'felis donec semper', '2020-01-06 02:35:05', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (33, 7, 'aliquet', '2012-09-28 01:37:07', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (30, null, 'dictumst morbi vestibulum', '2020-01-05 13:54:06', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (5, 8, 'posuere', '2013-06-21 01:51:02', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (1, 4, 'tellus nulla ut erat', '2018-05-25 13:09:24', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (5, 1, 'lobortis ligula sit amet', '2021-02-23 04:47:42', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (13, 2, 'mauris', '2017-09-07 14:30:51', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (4, 1, 'orci luctus et ultrices posuere cubilia', '2012-06-19 00:01:06', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (15, 6, 'ac est lacinia nisi', '2015-01-20 23:23:22', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (35, 4, 'ut dolor morbi vel', '2010-12-09 02:18:50', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (5, 7, 'ipsum primis in faucibus orci luctus et ultrices', '2018-02-01 02:15:39', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (40, 1, 'ligula nec sem duis aliquam convallis nunc proin', '2013-08-10 15:43:58', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (33, 6, 'lacus curabitur at ipsum ac tellus semper interdum', '2015-05-08 04:41:21', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (23, 5, 'turpis eget', '2013-08-29 06:02:50', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (1, 3, 'potenti nullam porttitor lacus at', '2011-04-27 16:34:42', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (43, 2, 'vestibulum proin eu', '2018-07-25 08:16:14', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (5, null, 'rhoncus mauris enim leo rhoncus sed', '2023-05-29 06:21:31', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (9, 1, 'augue a', '2017-02-18 08:39:24', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (29, 1, 'nulla tempus vivamus in felis eu', '2021-07-20 00:34:59', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (25, 1, 'integer', '2019-08-31 23:45:04', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (16, 4, 'primis in faucibus', '2012-10-30 03:40:42', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (13, 3, 'aliquet pulvinar', '2021-07-12 21:21:18', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (28, 8, 'consequat dui nec nisi volutpat', '2021-05-25 20:12:42', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (1, 8, 'metus arcu adipiscing molestie', '2014-11-13 04:24:36', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (45, 1, 'amet consectetuer adipiscing elit proin', '2020-01-19 08:39:40', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (35, 2, 'sapien sapien non', '2011-05-10 23:04:12', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (29, 1, 'erat quisque', '2018-08-12 03:25:35', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (17, null, 'congue elementum in hac habitasse platea', '2010-10-09 10:14:41', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (8, 3, 'odio consequat varius', '2010-09-01 19:59:00', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (16, 7, 'ut', '2019-06-01 12:57:06', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (20, 7, 'massa donec dapibus duis', '2017-02-23 06:33:28', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (29, 9, 'sit', '2011-08-28 13:29:54', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (36, 6, 'eget tempus vel pede morbi porttitor lorem id', '2020-03-18 22:41:32', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (34, 10, 'mauris lacinia sapien', '2014-09-13 01:02:22', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (3, 7, 'vitae consectetuer eget rutrum at lorem integer tincidunt', '2016-05-04 14:32:09', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (19, 9, 'nulla neque libero', '2014-05-26 07:02:40', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (20, 7, 'nisi at nibh in hac habitasse platea dictumst', '2019-01-08 15:31:37', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (33, 9, 'consectetuer adipiscing elit proin risus praesent lectus vestibulum', '2011-12-09 03:59:42', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (30, 8, 'enim leo rhoncus sed vestibulum sit amet cursus', '2011-10-16 02:00:11', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (24, 6, 'eget eleifend', '2020-04-21 18:51:03', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (34, 1, 'nibh in lectus pellentesque at nulla suspendisse potenti', '2012-12-27 15:40:56', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (8, 5, 'lacinia erat vestibulum sed magna', '2016-05-10 21:25:34', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (35, 2, 'quam fringilla rhoncus mauris enim leo', '2011-09-08 05:59:40', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (48, 1, 'cras pellentesque volutpat dui maecenas tristique est', '2013-09-13 23:39:58', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (25, 2, 'consequat morbi a ipsum', '2019-08-01 21:06:24', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (44, null, 'cum sociis natoque penatibus et magnis dis', '2020-10-21 15:19:50', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (12, null, 'sed magna at nunc commodo placerat', '2013-03-03 20:19:03', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (2, 5, 'vestibulum aliquet ultrices erat tortor sollicitudin mi', '2015-11-26 02:10:01', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (23, 5, 'cursus urna', '2021-08-12 15:19:53', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (43, 5, 'cursus vestibulum', '2011-02-09 13:40:35', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (29, 3, 'hac habitasse platea dictumst aliquam', '2022-10-09 00:25:50', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (48, null, 'volutpat', '2011-12-01 23:50:07', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (28, 4, 'amet consectetuer adipiscing elit proin risus praesent', '2018-02-02 07:05:39', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (43, 10, 'platea dictumst etiam faucibus cursus urna ut tellus', '2019-03-10 10:04:34', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (45, 2, 'enim lorem ipsum dolor sit', '2017-04-13 15:30:16', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (47, 8, 'penatibus et magnis dis parturient montes nascetur ridiculus', '2010-11-29 15:57:11', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (49, 5, 'sapien', '2010-12-22 10:41:59', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (38, null, 'lacus at velit vivamus vel', '2020-09-04 18:59:51', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (13, 4, 'sagittis sapien', '2021-01-27 17:34:57', true);

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- SQL QUERY SORULARI --

-- 1. Tüm blog yazılarını başlıkları, yazarları ve kategorileriyle birlikte getirin.
SELECT 
	posts.title, 
	users.username, 
	categories.name
FROM posts
JOIN users ON users.user_id = posts.user_id
JOIN categories ON categories.category_id = posts.category_id;

-- 2. En son yayınlanan 5 blog yazısını başlıkları, yazarları ve yayın tarihleriyle birlikte alın.
SELECT 
	posts.title, users.username, 
	posts.creation_date as post_date 
FROM posts
JOIN users ON posts.user_id = users.user_id
ORDER BY posts.creation_date DESC
LIMIT 5;

-- 3. Her blog yazısı için yorum sayısını gösterin
SELECT 
	posts.title as post_title, 
	COUNT(comments) AS comment_count
FROM posts
JOIN comments ON comments.post_id = posts.post_id
GROUP BY posts.title;

-- 4. Tüm kayıtlı kullanıcıların kullanıcı adlarını ve e-posta adreslerini gösterin
SELECT username, email FROM users;

-- 5. En son 10 yorumu, ilgili gönderi başlıklarıyla birlikte alın.
SELECT 
	posts.title, 
	comments.comment
FROM  posts
JOIN comments ON comments.post_id = posts.post_id
ORDER BY comments.creation_date DESC
LIMIT 10;

-- 6. Belirli bir kullanıcı tarafından yazılan tüm blog yazılarını bulun.
SELECT 
	users.username, 
	posts.content
FROM users
JOIN posts ON users.user_id = posts.user_id
WHERE users.username = 'amaciaszczyk1';

-- 7. Her kullanıcının yazdığı toplam gönderi sayısını alın.
SELECT 
	users.username, 
	COUNT(posts) AS post_count
FROM posts
JOIN users ON users.user_id = posts.user_id
GROUP BY users.username;

-- 8. Her kategoriyi, kategorideki gönderi sayısıyla birlikte gösterin.
SELECT
	categories.name as category_name,
	COUNT(posts) as post_count
FROM posts
JOIN categories ON categories.category_id = posts.category_id
GROUP BY categories.name;

-- 9. Gönderi sayısına göre en popüler kategoriyi bulun.
SELECT
	categories.name as category_name,
	COUNT(posts) as post_count
FROM posts
JOIN categories ON categories.category_id = posts.category_id
GROUP BY categories.name
ORDER BY post_count DESC
LIMIT 1;

-- 10. Gönderilerindeki toplam görüntülenme sayısına göre en popüler kategoriyi bulun.
SELECT
	categories.name as category_name,
	SUM(view_count) as view_count
FROM posts
JOIN categories ON categories.category_id = posts.category_id
GROUP BY categories.name
ORDER BY view_count DESC
LIMIT 1;

-- 11. En fazla yoruma sahip gönderiyi alın.
SELECT
	posts.title,
	COUNT(*) as comment_count
FROM posts
JOIN comments ON comments.post_id = posts.post_id
GROUP BY posts.title
HAVING COUNT (*) = (
	SELECT MAX(comment_count)
	FROM (
		SELECT
			posts.title,
		COUNT(*) as comment_count
		FROM posts
		JOIN comments ON comments.post_id = posts.post_id
		GROUP BY posts.title
) as Q
);

-- 12. Belirli bir gönderinin yazarının kullanıcı adını ve e-posta adresini gösterin.
SELECT 
	posts.title as post_title, 
	users.username as title_username, 
	users.email as username_mail
FROM posts
INNER JOIN users ON posts.user_id = users.user_id
WHERE posts.title = 'enim';

-- 13. Başlık veya içeriklerinde belirli bir anahtar kelime bulunan tüm gönderileri bulun.
SELECT *
FROM posts
WHERE title ILIKE '%ipsum%' OR content ILIKE '%ipsum%';

-- 14. Belirli bir kullanıcının en son yorumunu gösterin.
SELECT 
	users.username, 
	comments.comment, 
	comments.creation_date
FROM users
JOIN comments ON comments.user_id = users.user_id
WHERE users.username = 'lsally0'
ORDER BY comments.creation_date DESC
LIMIT 1;

-- 15. Gönderi başına ortalama yorum sayısını bulun.
SELECT 
	AVG(gönderi_başına_gelen_yorum_sayısı) as tüm_yorumların_ortalaması 
FROM (
	SELECT 
		comments.post_id, 
		COUNT(comments.comment) as gönderi_başına_gelen_yorum_sayısı
	FROM posts
	JOIN comments ON posts.post_id = comments.post_id
	GROUP BY comments.post_id
) as Q

-- 16. Son 30 günde yayınlanan gönderileri gösterin.
SELECT *
FROM posts 
WHERE creation_date > NOW() - interval '60' day;

-- 17. Belirli bir kullanıcının yaptığı yorumları alın.
SELECT 
	users.username,
	comments.comment
FROM users
JOIN comments ON comments.user_id = users.user_id
WHERE users.username = 'lsally0';

-- 18. Belirli bir kategoriye ait tüm gönderileri bulun.
SELECT 
	categories.name, 
	posts.title, 
	posts.content
FROM posts
JOIN categories ON posts.category_id = categories.category_id
WHERE categories.name = 'Travel';

-- 19. 5'ten az yazıya sahip kategorileri bulun.
SELECT 
	categories.name,
	COUNT(*)
FROM posts
JOIN categories ON posts.category_id = categories.category_id
GROUP BY categories.name
HAVING COUNT(*) < 5

-- 20. Hem bir yazı hem de bir yoruma sahip olan kullanıcıları gösterin.
SELECT DISTINCT
	users.username
FROM users
JOIN posts ON posts.user_id = users.user_id
JOIN comments ON comments.user_id = users.user_id 
WHERE posts.title IS NOT NULL AND comments.comment IS NOT NULL

-- 21. En az 2 farklı yazıya yorum yapmış kullanıcıları alın.
SELECT 
	comments.user_id, 
	COUNT(DISTINCT post_id)
FROM users
JOIN comments ON users.user_id = comments.user_id
GROUP BY comments.user_id
HAVING COUNT(DISTINCT post_id) > 2

-- 22. En az 3 yazıya sahip kategorileri görüntüleyin.
SELECT categories.name, COUNT(*)
FROM posts
JOIN categories ON posts.category_id = categories.category_id
GROUP BY categories.name
HAVING COUNT(*) >= 3

--  23. 5'ten fazla blog yazısı yazan yazarları bulun
SELECT users.username, COUNT(*)
FROM users
JOIN posts ON posts.user_id = users.user_id
GROUP BY users.username
HAVING COUNT(*) > 5

-- 24. Bir blog yazısı yazmış veya bir yorum yapmış kullanıcıların e-posta adreslerini görüntüleyin. (UNION kullanarak)
(SELECT username, email FROM users 
JOIN posts ON users.user_id = posts.user_id)
UNION
(SELECT username, email FROM users 
JOIN comments ON users.user_id = comments.user_id);

-- 25. Bir blog yazısı yazmış ancak hiç yorum yapmamış yazarları bulun.
SELECT username 
FROM users
WHERE 
(
	SELECT COUNT(*) 
	FROM posts 
	WHERE users.user_id = posts.user_id
) > 0
AND
(
	SELECT COUNT(*) 
	FROM comments 
	WHERE users.user_id = comments.user_id
) = 0

