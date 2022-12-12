CREATE TABLE board_like  (
                         id            bigint        NOT NULL AUTO_INCREMENT primary key,
                         board_id      bigint,
                         member_id     bigint,
                         created_time   timestamp,
                         FOREIGN KEY (board_id) REFERENCES  board(board_id) ON DELETE CASCADE,
                         FOREIGN KEY (member_id) REFERENCES member(member_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci