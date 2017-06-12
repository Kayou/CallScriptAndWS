#!/bin/bash

source ~/.profile

###################
###deverouiller
###################
adb shell input keyevent 26 # wakeup / sleep
adb shell input touchscreen swipe 930 880 930 380 #Swipe UP

adb shell input text XXXX #Entering your passcode
adb shell input keyevent 66 #Pressing Enter
