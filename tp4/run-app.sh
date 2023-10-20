#!/bin/bash

# Lancer le conteneur
docker run -d \
  --name tp4-app \
  --network net-tp4 \
  -p 5001:5001 \
  im-tp4
