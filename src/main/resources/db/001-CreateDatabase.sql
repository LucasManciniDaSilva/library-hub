create table chars
(
    tx_id_char   bigint auto_increment          primary key,
    tx_name               varchar(255)             not null,
    tx_origin             varchar(255)             not null,
    nr_height             double                   not null,
    tx_weapon             varchar(255)                 null,
    tx_armor              varchar(255)                 null,
    tx_personality        varchar(255)                 null,
    tx_character_importance varchar(255)           not   null
);

create index chars_tx_id_char
    on chars (tx_id_char);

create table char_transformation
(
    tx_id_transformation          bigint auto_increment          primary key,
    tx_transformation_name            varchar(255)             not null,
    tx_height                         varchar(255)             not null
);

create index chars_tx_id_transformation
    on char_transformation (tx_id_transformation);