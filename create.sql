
    create table tb_cliente (
       id integer not null auto_increment,
        dn varchar(255),
        nome varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table tb_compras (
       id integer not null auto_increment,
        data_compra date,
        total_compra double precision,
        cliente_id integer,
        primary key (id)
    ) engine=InnoDB;

    alter table tb_compras 
       add constraint FKto1hl9btn8n1ssr1yglhog601 
       foreign key (cliente_id) 
       references tb_cliente (id);
INSERT INTO tb_cliente(nome, dn) VALUES ('Maria', '28/10/1966');
INSERT INTO tb_compras(cliente_id,total_compra, data_compra) VALUES (1, 68.90, '2021-05-15');
