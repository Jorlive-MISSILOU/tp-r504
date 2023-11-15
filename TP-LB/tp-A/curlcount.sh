#!/bin/bash

count_server1=0
count_server2=0

for i in {1..500}; do
    reponse=$(curl -s localhost:83) # -s: pour ne pas afficher la sortie
    if [[ $reponse == *"Hello 1"* ]]; then
        ((count_server1++))
    elif [[ $reponse == *"Hello 2"* ]]; then
        ((count_server2++))
    fi
done

echo "Réponses du Serveur 1 : $count_server1"
echo "Réponses du Serveur 2 : $count_server2"

# Vérification de la répartition
if [ $count_server1 -eq $count_server2 ]; then
    echo "La répartition est 50/50."
else
    echo "La répartition n'est pas 50/50."
fi

