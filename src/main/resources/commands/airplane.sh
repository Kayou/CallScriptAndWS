#!/bin/bash

source ~/.profile

###################
###mode avion
###################

adb shell settings put global airplane_mode_on $1 #O to activate or 1 to deactivate
adb shell am broadcast -a android.intent.action.AIRPLANE_MODE
adb shell input keyevent KEYCODE_ENTER
