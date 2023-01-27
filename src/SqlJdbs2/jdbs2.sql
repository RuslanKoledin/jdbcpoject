create table cafes(
                      id int primary key not null ,
                      title varchar(100) not null unique,
                      cuisine_type varchar(100) not null
);
create table food(
                     id int primary key not null,
                     title_of_food varchar(200) not null ,
                     about_food varchar(200) not null,
                     fk_cafesId int references cafes(id) not null
);

create table orders(
                       id int primary key not null,
                       fk_cafesId int references cafes(id) not null,
                       fk_foodId int references food(id) not null,
                       who_take_order varchar(200) not null
);
insert into cafes
values (1,'Arabesk','Арабская,Турецкая,Европейская'),
       (2,'Joma','Национальная'),
       (3,'Империя пиццы','Европейская'),
       (4,'Istambul','Арбаская,Турецкая,Национальная'),
       (5,'Кофейня Бублик','Европейская');
insert into food
values (1,'Бейти сарма','Шаклык в лаваше',1),
       (2,'Мясо по-французски','Мясо,картофель,сыр,помидоры,грибы',4),
       (3,'Сендвич с лососем','хлеб,лосось,соус,овощи',5),
       (4,'Пицца Цили','фарш,острый соус , сыр',3),
       (5,'Босо лагма','Жаренный лагман',2);
insert into food
values (6,'Сан-торо','Острый суп',1);
insert into orders
values (1,2,5,'Руслан'),
       (2,1,1,'Арсен'),
       (3,5,3,'Bob'),
       (4,3,4,'Tom'),
       (5,3,4,'Sam');
select * from cafes join food f on cafes.id = f.fk_cafesId;
select * from orders where fk_cafesId = 3; -- заказы полученные в 'империя пиццы'
select * from food order by title_of_food; -- цены на блюдо нет , сортировака по названию блюда;



select * from cafes;
select *from food;
select *from orders;