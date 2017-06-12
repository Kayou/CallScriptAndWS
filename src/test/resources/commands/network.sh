#!/bin/bash

###################
###activer/desactiver reseau (root?)
###################
adb shell su -c 'svc data disable'
adb shell su -c 'svc data enable'