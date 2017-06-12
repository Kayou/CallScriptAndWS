#!/bin/bash


#ls -al

#propre a MAC OS, definissant les variables d'environnement du terminal pour adb entre autre
source ~/.profile

adb devices

#dans le cas contraire, chemin absolu vers la commande adb
#/Users/patrickvongpraseuth/Library/Android/sdk/platform-tools/adb shell dumpsys alarm


#########################################################
#########################################################
################### COMMANDES ADB
#########################################################
#########################################################


###################
### deposer fichier
###################
#adb push /Users/patrickvongpraseuth/git/CallScriptAndWS/src/test/resources/MyTextFile.txt /mnt/sdcard/Download/


###################
### supprimer fichier
###################
#adb shell rm -f /mnt/sdcard/Download/MyTextFile.txt


###################
###activer/desactiver wifi (root?)
###################
#adb shell su -c 'svc wifi disable'
#adb shell su -c 'svc wifi enable'


###################
###activer/desactiver reseau (root?)
###################
#adb shell su -c 'svc data disable'
#adb shell su -c 'svc data enable'


###################
###mode avion
###################
#adb shell settings put global airplane_mode_on 0 # or 1 to activate
#adb shell am broadcast -a android.intent.action.AIRPLANE_MODE
#adb shell input keyevent 66


###################
###verouiller / deverouiller
###################
#adb shell input keyevent 26 # wakeup / sleep
#adb shell input touchscreen swipe 930 880 930 380 #Swipe UP

#adb shell input text XXXX #Entering your passcode
#adb shell input keyevent 66 #Pressing Enter


###################
###rotation ecran
### 0           # Portrait 
### 1           # Landscape
### 2           # Portrait Reversed
### 3           # Landscape Reversed
###################
#adb shell settings put system user_rotation 3


###################
###ajouter / supprimer droits 
###################
#adb shell pm grant com.example.myapp android.permission.RECORD_AUDIO


###################
###lister les alarmes
###################
#adb shell dumpsys alarm


###################
###installer / MAJ apk
###################
#adb install /Users/patrickvongpraseuth/git/CallScriptAndWS/src/test/resources/com.saschaha.one_v37_b39374.apk


###################
###suppression apk via package name
###################
#adb uninstall "com.saschaha.one"


###################
###redemarrage telephone
###################
#adb shell reboot


###################
### appel de webservices
###################
#curl http://10.2.32.126:8080/runTests










