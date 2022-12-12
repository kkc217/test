CREATE TABLE member  (
                         member_id     bigint        NOT NULL AUTO_INCREMENT primary key,
                         email         varchar(50)   NOT NULL,
                         gender        varchar(10),
                         introduction  varchar(255)            default '자기소개를 입력해주세요.',
                         join_date     timestamp               default now(),
                         nickname      varchar(20)   NOT NULL,
                         password      varchar(100)  NOT NULL,
                         profile_image varchar(110)            default 'default_profile'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci