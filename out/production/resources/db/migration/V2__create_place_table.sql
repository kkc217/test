CREATE TABLE place  (
                         place_id      bigint        NOT NULL AUTO_INCREMENT primary key,
                         title         varchar(100),
                         address       varchar(200),
                         short_introduction  text,
                         dial_num      varchar(50),
                         type          varchar(20),
                         image_url     varchar(200),
                         zip_code      varchar(20),
                         tag           varchar(100),
                         latitude      numeric(10,7),
                         longitude     numeric(10,7),
                         introduction  text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci