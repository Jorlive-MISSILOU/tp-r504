-- Création de la base de données
CREATE DATABASE IF NOT EXISTS dolibarr_db;
USE dolibarr_db;

-- Création de l'utilisateur 'dolibarr' avec des privilèges sur la base de données 'dolibarr_db'
CREATE USER IF NOT EXISTS 'dolibarr'@'%' IDENTIFIED BY 'dolibarr';
GRANT SELECT, SHOW VIEW, RELOAD, EVENT, TRIGGER, REPLICATION CLIENT, SUPER ON *.* TO 'dolibarr'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;
