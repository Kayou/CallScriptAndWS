#!/bin/bash

source ~/.profile

###################
###ajouter / supprimer droits 
###################
adb shell pm $1 $2 $3
