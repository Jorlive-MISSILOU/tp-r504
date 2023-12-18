#!/bin/bash

# Vérifie si le nombre d'arguments est égal à 1
if [ "$#" -ne 1 ]; then
  echo "Veuillez spécifier le numéro du strip XKCD en argument."
  exit 1
fi

# Numéro du strip XKCD passé en argument
strip_number="$1"

# URL du strip XKCD
url="http://xkcd.com/$strip_number/"

# Télécharge la page web du strip XKCD
wget -q -O - "$url" | grep -oP '<meta property="og:image" content="\K[^"]+' | xargs wget -q -O $strip_number.png

# Affiche l'image avec l'application par défaut
xdg-open $strip_number.png
sleep 5
# Supprime l'image téléchargée après l'affichage
rm $strip_number.png
