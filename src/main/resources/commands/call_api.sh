#!/bin/bash

source ~/.profile

###################
### appel de webservices
###################

cmd="curl "

#no need to worry about arguments number
for i in "$@"; do 
    cmd="$cmd $i "
done

echo $cmd

eval $cmd
