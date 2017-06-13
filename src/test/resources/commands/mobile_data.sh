#!/bin/bash

source ~/.profile

###################
###activer/desactiver reseau (root?)
###################

if [ $1 = 0 ]
then
	adb shell su -c 'svc data disable'
elif [ $1 = 1 ]
then
	adb shell su -c 'svc data enable'
fi