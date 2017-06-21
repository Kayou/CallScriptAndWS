#!/bin/bash

source ~/.profile

###################
###start application
###################


if [ -n "$2" ]; then
    echo "not empty"
	adb shell am start -n $1"/."$2
else
	echo "empty"
    adb shell monkey -p $1 1
fi
