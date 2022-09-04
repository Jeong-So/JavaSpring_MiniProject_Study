show databases;

use faststore_manager;

show tables;

insert into book(`id`,`created_at`,`created_by`,`updated_at`,`updated_by`, `title`,`author`,`price`) values(1, now(),'jeong', now(), 'dennis',  '단 하나의 문장', '구병모', 30000);

insert into book(`id`,`created_at`,`created_by`,`updated_at`,`updated_by`, `title`,`author`,`price`) values(2, now(),'dennis', now(), 'jeong', '혼자 공부하는 파이썬', '윤인성', 26000);

insert into book(`id`,`created_at`,`created_by`,`updated_at`,`updated_by`, `title`,`author`,`price`) values(3, now(),'sophia', now(), 'sophia', 'C 프로그래밍', '윤성우', 35000);
