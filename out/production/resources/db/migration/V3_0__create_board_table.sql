CREATE TABLE board  (
                         board_id      bigint        NOT NULL AUTO_INCREMENT primary key,
                         member_id     bigint,
                         content       text,
                         created_time   timestamp,
                         FOREIGN KEY (member_id) REFERENCES member(member_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci