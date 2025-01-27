CREATE TABLE USER_CREDENTIAL (
    id         int AUTO_INCREMENT primary key,
    email      varchar(255) null,
    name       varchar(255) NOT NULL,
    password   varchar(255) NOT NULL
);

--    записываем пользователя с логином = "test_user" и паролем = "root"

INSERT INTO USER_CREDENTIAL (id, email, name, password)
VALUES (1, 'test_user@gmail.com', 'test_user', '$2a$10$QPL13q/bIqC.mGUuP2f6qObn1gEW.whBbJGQCA5DKGX0vXk2/W/Qu');

