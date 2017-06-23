#!/bin/bash

source ~/.profile

###################
### Simulate system stop
###################

adb shell am force-stop $1
