#!/bin/bash

source ~/.profile

isOn=$(adb shell dumpsys power | grep mScreenOn=true)

###################
###verrouiller
###################
if ! [ -z "$isOn" ]
then
	adb shell input keyevent 26 # wakeup / sleep
fi
