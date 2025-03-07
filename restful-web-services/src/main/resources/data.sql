insert into user_details(id,birth_date,name)
values(10001, CURRENT_DATE, 'Yatindra');

insert into user_details(id,birth_date,name)
values(10002, CURRENT_DATE, 'Pradnya');

insert into user_details(id,birth_date,name)
values(10003, CURRENT_DATE, 'Ashwini');


insert into post(id, description, user_id)
values(20001, 'New to Twitter', 10001);

insert into post(id, description, user_id)
values(20002,'New to Meta', 10001);


insert into post(id, description, user_id)
values(20003, 'learn spring', 10002);

insert into post(id, description, user_id)
values(20004,'Learn bootstrap', 10002);