#!/bin/bash

# Création du groupe t_users
    sudo groupadd t_users

# Lecture du fichier liste1.txt et création des utilisateurs
for user in $(cat liste1.txt)
do
   sudo  adduser --disabled-password --gecos "" "$user"
    sudo usermod -a -G t_users "$user"
done

echo "Utilisateurs créés avec succès."
