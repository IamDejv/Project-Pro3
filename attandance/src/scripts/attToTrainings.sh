#!/usr/bin/env bash

atts="files/attendees.csv"
url="http://localhost:8081/dochazka/assignAttendee"

trainingsID=("1745" "1746" "1743" "1744" "1747" "1742" "1749")

while read -r line; do
    IFS=',' read -r -a items <<< ${line}
    if [[ ${items[1]} == *"1"* ]]
    then
        data="{
                \"attendeeid\" : ${items[0]},
                \"trainingid\": ${trainingsID[0]}
                }"
        echo \"curl\" -d ${data} ${url} >> "files/output.txt"
    fi

done <<< $(cat ${atts})
