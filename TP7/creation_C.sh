#!/bin/bash

#passwd=$(date +%s | sha256sum | head -c 8)
#passwd=$(pwgen -1)

while IFS=" " read v_nom v_passwd
do
	echo "nom=$v_nom passwd=$passwd"
	#sudo adduser -p "$v_passwd" "$v_nom"
        sudo adduser --disabled-password --gecos "" "$v_nom"
	passwd=$(pwgen -1)
	echo "$v_nom:$passwd" | sudo chpasswd

done < liste2.txt
