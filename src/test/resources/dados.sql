insert into restaurante(nome, imagem) values('Restaurante 1', 'restaurante1.png');
insert into restaurante(nome, imagem) values('Restaurante 2', 'restaurante2.png');
insert into restaurante(nome, imagem) values('Restaurante 3', 'restaurante3.png');
insert into restaurante(nome, imagem) values('Restaurante 4', 'restaurante4.png');

insert into votante(nome, email) values('Votante 1', 'votante1@mail.com');
insert into votante(nome, email) values('Votante 2', 'votante2@mail.com');

insert into voto(restaurante1_id, restaurante2_id, vencedor_id, votante_id) values(1, 2, 1, 1);
insert into voto(restaurante1_id, restaurante2_id, vencedor_id, votante_id) values(1, 3, 3, 1);
insert into voto(restaurante1_id, restaurante2_id, vencedor_id, votante_id) values(1, 4, 1, 1);
insert into voto(restaurante1_id, restaurante2_id, vencedor_id, votante_id) values(1, 2, 2, 2);
insert into voto(restaurante1_id, restaurante2_id, vencedor_id, votante_id) values(1, 3, 1, 2);
insert into voto(restaurante1_id, restaurante2_id, vencedor_id, votante_id) values(1, 4, 4, 2);

insert into votante_voto(votante_id, votos_id) values(1, 1);
insert into votante_voto(votante_id, votos_id) values(1, 2);
insert into votante_voto(votante_id, votos_id) values(1, 3);
insert into votante_voto(votante_id, votos_id) values(2, 4);
insert into votante_voto(votante_id, votos_id) values(2, 5);
insert into votante_voto(votante_id, votos_id) values(2, 6);
