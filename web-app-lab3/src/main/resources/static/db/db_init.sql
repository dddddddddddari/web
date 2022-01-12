use coffeeshop;

insert into cities(name) value ('Moscow');
insert into cities(name) value ('Saint Petersburg');
insert into cities(name) value ('Novosibirsk');
insert into cities(name) value ('Perm');
insert into cities(name) value ('Ekaterinburg');
insert into cities(name) value ('Vladivostok');

insert into categories(category_id, description, name) VALUES ('1', 'Tulips are spring flowers that are among the first to delight with their beauty.', 'Tulips');
insert into categories(category_id, description, name) VALUES ('2', 'Roses represent hope, promise, love, care and attention.', 'Roses');
insert into categories(category_id, description, name) VALUES ('3', 'Lily is an ancient symbol of purity, sincerity and noble origin.','Lilies');
insert into categories(category_id, description, name) VALUES ('4', 'Peony looks very romantic, it is considered a symbol of good luck, happiness and prosperity of any marriage.', 'Peons');

insert into products(product_id, count, date, description, image, price) values ('1', '15', '2021-01-01 10:10:17.78', 'БУКЕТ ПОЦЕЛУЙ РОЗ', 'images/img1.jpg', '3200');
insert into products(product_id, count, date, description, image, price) values ('2', '35', '2021-01-01 10:10:17.78', 'БУКЕТ КОРОЛЕВСКИЙ БАЛ', 'images/img2.jpg', '4800');
insert into products(product_id, count, date, description, image, price) values ('3', '25', '2021-01-01 10:10:17.78', 'БУКЕТ ТЮЛЬПАНЫ', 'images/img3.jpg', '2800');
insert into products(product_id, count, date, description, image, price) values ('4', '23', '2021-01-01 10:10:17.78', 'БУКЕТ СЕРДЦЕ ОКЕАНА', 'images/img4.jpg', '4320');
insert into products(product_id, count, date, description, image, price) values ('5', '11', '2021-01-01 10:10:17.78', 'БУКЕТ КУКОЛКА', 'images/img5.jpg', '6200');
insert into products(product_id, count, date, description, image, price) values ('6', '7', '2021-01-01 10:10:17.78', 'БУКЕТ ХРИЗАНТЕМА КУСТОВАЯ', 'images/img6.jpg', '1350');

insert into product_category(product_id, category_id) VALUES ('1', '1');
insert into product_category(product_id, category_id) VALUES ('1', '4');
insert into product_category(product_id, category_id) VALUES ('2', '1');
insert into product_category(product_id, category_id) VALUES ('2', '3');
insert into product_category(product_id, category_id) VALUES ('3', '1');
insert into product_category(product_id, category_id) VALUES ('3', '3');
insert into product_category(product_id, category_id) VALUES ('4', '2');
insert into product_category(product_id, category_id) VALUES ('4', '3');
insert into product_category(product_id, category_id) VALUES ('5', '2');
insert into product_category(product_id, category_id) VALUES ('5', '3');
insert into product_category(product_id, category_id) VALUES ('6', '2');
insert into product_category(product_id, category_id) VALUES ('6', '4');