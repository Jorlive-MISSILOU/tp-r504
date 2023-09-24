#!/usr/bin/bash

for i in $(seq $1 $2); do
	echo "$i"
done

if [ -z $2 ]; then
	non=$(expr -l "$1")+10
	seq "$1" "$non"
fi

if [ -z $1 ]; then
	d=5
	f=15
	seq "$d" "$f"
fi



