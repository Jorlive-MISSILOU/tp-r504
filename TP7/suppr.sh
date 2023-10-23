#!/bin/bash

# Suppression des utilisateurs du fichier liste1.txt
for user in $(cat liste1.txt)
do
    sudo userdel -r "$user" 2>/dev/null
done

sudo  /usr/sbin/groupdel t_users 2>/dev/null

echo "Utilisateurs supprimés avec succès"
