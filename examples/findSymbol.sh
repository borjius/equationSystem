#!/bin/sh

#Find existing symbol

if [ "$#" -lt 1 ]; then
	echo "format: ./findSymbol.sh {symbol}"
else
	curl http://localhost:7000/symbols/$1 -GET -HContent-type:application/json -v
fi