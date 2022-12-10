-- execute with `sudo mysql -uroot < create-db.sql`
-- or, for password auth: `sudo mysql -uroot -p < create-db.sql`

-- password is insecure, but this is only being used for a demo
CREATE USER taskman@localhost IDENTIFIED BY 'namksat';
CREATE DATABASE taskman;
GRANT ALL PRIVILEGES ON taskman.* TO taskman@localhost;
FLUSH PRIVILEGES;
