#!/bin/bash

echo "#######Générer la clé privée pour le CA"
openssl genrsa 2048 > ca-key.pem

echo "########Générer le certificat X509 pour le CA"
openssl req -new -x509 -nodes -days 365000 \
	-key ca-key.pem \
	-out ca-cert.pem

echo "##########Générer la clé privée et la requete du certificat "
openssl req -newkey rsa:2048 -nodes -days 365000 \
	-keyout server-key.pem \
	-out server-req.pem

echo "###########Générer le certificat X509 pour le serveur "
openssl x509 -req -days 365000 -set_serial 01 \
	-in server-req.pem \
	-out server-cert.pem \
	-CA ca-cert.pem \
	-CAkey ca-key.pem

echo "#############Vérifier le certificat du serveur en utilisant le certificat qui a été généré précedemment "
openssl verify -CAfile ca-cert.pem \
	ca-cert.pem \
	server-cert.pem

echo "#############Générer une clé TLS "
openvpn --genkey secret ta.key

echo "#############Génération de la clé 'Diffie Hellman'"
openssl dhparam -out dhparams.pem 2048

echo "copie du certificat sur le client"
scp ca-cert.pem ca-key.pem user@192.168.0.10:~/tp-r504/TPVPN
