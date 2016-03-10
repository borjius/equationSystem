#!/bin/sh

#Create a new symbol

if [ "$#" -lt 1 ]; then
	echo "format: ./createSymbol.sh symbolxmlfile.xml"
else
	curl http://localhost:7000/symbols -POST -d@$1 -HContent-type:application/xml -v
fi
