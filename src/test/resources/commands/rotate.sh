#!/bin/bash

source ~/.profile

###################
###rotation ecran
### 0           # Portrait 
### 1           # Landscape
### 2           # Portrait Reversed
### 3           # Landscape Reversed
###################
adb shell settings put system user_rotation 3
