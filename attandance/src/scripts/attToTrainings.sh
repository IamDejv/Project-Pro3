#!/usr/bin/env bash

atts="files/attendees.csv"
url="http://localhost:8081/api/v1/attendance/assignAttendee"

trainingsID=("1745" "1746" "1743" "1744" "1747" "1742" "1749")

a=0

while read -r line; do
    IFS=',' read -r -a items <<< ${line}
    if [[ ${items[1]} == *"1"* ]]
    then
        data="{
                \"attendeeid\" : ${items[0]},
                \"trainingid\": ${trainingsID[${a}]}
                }"
        curl -d "${data}" -H 'Content-type: application/json' ${url}
    fi
    a=$(( ${a} + 1 ))
    if [[ ${a} -gt 6 ]]
    then
        a=0
    fi

done <<< $(cat ${atts})
