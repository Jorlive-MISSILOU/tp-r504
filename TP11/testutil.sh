#!/bin/bash

# dialog  --clear --menu "Séléctionnez" 15 40 4 \
# 1 "- Vérifier l’existence d’un utilisateur" \
# 2 "- Connaître l’UID d’un utilisateur" \
# q "- Quitter"

# Fonction pour afficher le menu
afficher_menu() {
  ps3="Sélectionnez une option : "
  options=("Vérifier l’existence d’un utilisateur" "Connaître l’UID d’un utilisateur" "Quitter")

  select choix in "${options[@]}"; do
    case $REPLY in
      1)
        verifier_existence_utilisateur
        ;;
      2)
        connaitre_uid_utilisateur
        ;;
      3)
        echo "Au revoir !"
        exit 0
        ;;
      *)
        echo "Option invalide. Veuillez sélectionner un nombre entre 1 et ${#options[@]}"
        ;;
    esac
  done
}

# Fonction pour vérifier l'existence d'un utilisateur
verifier_existence_utilisateur() {
  read -p "Entrez le nom de l'utilisateur à vérifier : " utilisateur
  #
  echo "Vérification de l'existence de l'utilisateur : $utilisateur"
  echo $(id $utilisateur)
}

# Fonction pour connaître l'UID d'un utilisateur
connaitre_uid_utilisateur() {
  read -p "Entrez le nom de l'utilisateur pour connaître son UID : "
  #
  echo "L'UID de l'utilisateur $utilisateur est :" $(id $utilisateur -u)
}

# Appel de la fonction pour afficher le menu
afficher_menu
