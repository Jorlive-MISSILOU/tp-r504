#!/bin/bash

# Créer un réseau de type bridge nommé net-tp4
docker network create --driver bridge net-tp4
if [ $? != 0 ]; then
	exit 2
fi
