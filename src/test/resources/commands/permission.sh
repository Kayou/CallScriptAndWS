#!/bin/bash

source ~/.profile

###################
###ajouter / supprimer droits 
###################
adb shell pm grant com.example.myapp android.permission.RECORD_AUDIO
