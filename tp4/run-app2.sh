  GNU nano 5.4                       run-app.sh                                 
#!/bin/bash

# Lancer le conteneur
docker run -d \
  --name tp4-app2 \
  --network net-tp4 \
  --mount type=bind,source=$(pwd)/srv/,target=/srv/ \
  -p 5000:5000 \
  im2-tp4


