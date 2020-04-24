#!/usr/bin/env bash

usersList="files/MOCK_DATA.csv"
attendeeList="files/MOCK_DATA(1).csv"
exportFile="files/exportFile"

while IFS= read -r line
do
    IFS=',' read -r -a items <<< ${line}
    username=${items[1],,}
    output="{
              \"username\": \"${username}\",
              \"person\": {
                  \"firstname\": \"${items[0]}\",
                  \"lastname\": \"${items[1]}\",
                  \"active\": ${items[2]},
                  \"dateOfBirth\": \"${items[3]}\",
                  \"dateofcome\": \"${items[4]}\",
                  \"password\": \"123\",
                  \"roleid\": ${items[5]},
                  \"address\": {
                      \"city\": \"${items[6]}\",
                      \"state\": \"${items[7]}\",
                      \"street\": \"${items[8]}\",
                      \"zip\": \"${items[9]}\"
                  },
                  \"contactInfo\": {
                      \"email\": \"${items[10]}\",
                      \"phone\": \"${items[11]}\"
                  }
              },
              \"companyid\": ${items[12]}
          }"
      echo ${output} >> ${exportFile}

done <<< $(cat ${usersList})



