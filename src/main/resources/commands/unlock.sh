#!/bin/bash

source ~/.profile

isOn=$(adb shell dumpsys power | grep mScreenOn=true)

###################
###deverouiller
###################

if [ -z "$isOn" ]
then
	adb shell input keyevent 26 # wakeup / sleep
	adb shell input touchscreen swipe 930 880 930 380 #Swipe UP
	
	adb shell input text XXXX #Entering your passcode
	adb shell input keyevent 66 #Pressing Enter
fi