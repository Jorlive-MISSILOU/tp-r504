#!/bin/bash

# Vérifie si le nombre d'arguments est égal à 1
if [ "$#" -ne 1 ]; then
  echo "Veuillez entrer un chemin"
  exit 1
fi

# Récupère le chemin passé en argument
chemin_absolu="$1"

# Vérifie l'existence de chaque dossier dans le chemin
IFS='/' read -ra dossiers <<< "$chemin_absolu"

chemin_valide=true
chemin_test=""

for dossier in "${dossiers[@]}"; do
  chemin_test+="$dossier/"
  if [ ! -d "$chemin_test" ]; then
    chemin_valide=false
    break
  fi
done

# Affiche le résultat
if [ "$chemin_valide" = true ]; then
  echo "Chemin valide"
else
  echo "Chemin invalide, le dossier $dossier n'existe pas dans $chemin_test"
fi
