#!/usr/bin/env bash

usersList="files/Mock_DATA.csv"
attendeeList="files/Mock_DATA(1).csv"

while IFS= read -r line
do
    echo ${line}
done <<< ${usersList}
