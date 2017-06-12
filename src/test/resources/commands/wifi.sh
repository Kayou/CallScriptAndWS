#!/bin/bash

source ~/.profile

###################
###activer/desactiver wifi (root?)
###################
adb shell su -c 'svc wifi disable'
adb shell su -c 'svc wifi enable'
