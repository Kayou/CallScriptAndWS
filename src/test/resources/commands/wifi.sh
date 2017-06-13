#!/bin/bash

source ~/.profile

###################
###activer/desactiver wifi (root)
###################

#non root
#adb shell am start -a android.intent.action.MAIN -n com.android.settings/.wifi.WifiSettings
#adb shell input keyevent 20


adb shell su -c "svc wifi $1"