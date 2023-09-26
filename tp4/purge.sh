#!/bin/bash
docker rm -f $(docker ps -aq)

#purge  tous les réseaux
docker volume prune -f

#purge  tous les volumes
docker volume prune -f
