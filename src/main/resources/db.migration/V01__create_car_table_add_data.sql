create table if not exists car(
    id bigint not null auto_increment,
    name varchar(50) not null,
    model varchar(50) not null,
    primary key(id)
);

insert into car values(1, 'Golf', 'VW');
insert into car values(2, 'Civic', 'Honda');
insert into car values(3, 'Corolla', 'Toyota');
insert into car values(4, 'Fusion', 'Ford');
insert into car values(5, 'Renegade', 'Jeep');
insert into car values(6, 'Tucson', 'Hyundai');
insert into car values(7, 'Onix', 'Chevrolet');
insert into car values(8, 'Argo', 'Fiat');
insert into car values(9, 'Kicks', 'Nissan');
insert into car values(10, 'Sandero', 'Renault');
insert into car values(11, 'HB20', 'Hyundai');
insert into car values(12, 'Polo', 'VW');
insert into car values(13, 'Cruze', 'Chevrolet');
insert into car values(14, 'Compass', 'Jeep');
insert into car values(15, 'HR-V', 'Honda');
insert into car values(16, 'Virtus', 'VW');
insert into car values(17, 'C4 Cactus', 'Citroen');
insert into car values(18, 'Focus', 'Ford');
insert into car values(19, 'Série 3', 'BMW');
insert into car values(20, 'Classe C', 'Mercedes-Benz');
insert into car values(21, 'UP!', 'VW');