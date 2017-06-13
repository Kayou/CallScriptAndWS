#!/bin/bash

source ~/.profile

###################
###activer/desactiver wifi (root)
###################

#non root
#adb shell am start -a android.intent.action.MAIN -n com.android.settings/.wifi.WifiSettings
#adb shell input keyevent 20

if [ $1 = 0 ]
then
	adb shell su -c 'svc wifi disable'
elif [ $1 = 1 ]
then
	adb shell su -c 'svc wifi enable'
fi