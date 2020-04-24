#!/usr/bin/env bash

usersList="files/MOCK_DATA.csv"
attendeeList="files/genAtt.csv"
exportFile="files/exportFileAtt"

while IFS= read -r line
do
    IFS=',' read -r -a items <<< ${line}
    username=${items[1],,}
    if [[ ${items[0]} == *"Male"* ]]
    then
      gender=0
    else
      gender=1
    fi
    output="{
              \"sex\": ${gender},
              \"paid\": ${items[1]},
              \"person\": {
                  \"firstname\": \"${items[2]}\",
                  \"lastname\": \"${items[3]}\",
                  \"active\": ${items[4]},
                  \"dateOfBirth\": \"${items[5]}\",
                  \"dateofcome\": \"${items[6]}\",
                  \"password\": \"123\",
                  \"roleid\": ${items[7]},
                  \"address\": {
                      \"city\": \"${items[8]}\",
                      \"state\": \"${items[9]}\",
                      \"street\": \"${items[10]}\",
                      \"zip\": \"${items[11]}\"
                  },
                  \"contactInfo\": {
                      \"email\": \"${items[12]}\",
                      \"phone\": \"${items[13]}\"
                  }
              }
          }"
      echo ${output} >> ${exportFile}

done <<< $(cat ${attendeeList})
