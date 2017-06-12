#!/bin/bash


###################
###mode avion
###################
adb shell settings put global airplane_mode_on 0 # or 1 to activate
adb shell am broadcast -a android.intent.action.AIRPLANE_MODE
adb shell input keyevent 66
