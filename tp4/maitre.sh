#!/bin/bash

chmod u+x *

# creation du reseau net-tp4
./create_network.sh
if [ $? -eq 0 ]; then
    echo "Le script creation du réseau s'est bien exécuté."
else
    echo "Le script creation du reseau a rencontré une erreur."
fi

# lancer le conteneur mysql
./run_mysql.sh
if [ $? -eq 0 ]; then
    echo "Le conteneur mysql s'est bien exécuté."
else
    echo "Le conteneur a rencontré une erreur."
fi

# Remplissage de la BDD
./filldb.sh
if [ $? -eq 0 ]; then
    echo "Le remplissage de la bdd s'est bien exécuté."
else
    echo "Le remplissagede la BDD a rencontré une erreur."
fi

# Build image de im-tp4 du Dockerfile1
./build_image.sh
if [ $? -eq 0 ]; then
    echo "L'image im-tp4 a été bien construite"
else
    echo "l'image im-tp4 a rencontré un probleme"
fi

#Lancer le conteneur tp4-app a partir de l'image im-tp4
./run-app.sh
if [ $? -eq 0 ]; then
    echo "le conteneur tp4-app a été bien exécuté"
else
    echo "le conteneur tp4-app a rencontré un probleme"
fi

./buil-image2.sh
if [ $? -eq 0 ]; then
    echo "L'image im2-tp4 a été bien construite"
else
    echo "l'image im2-tp4 a rencontré un probleme"
fi

./run-app2.sh
if [ $? -eq 0 ]; then
    echo "Le conteneur tp4-app2 a été bien exécuté"
else
    echo "le conteneur tp4-app2 a rencontré un probleme"
fi
