#!/usr/bin/env bash

url="http://localhost:8081/api/v1/attendee"
attList="files/exportFileAtt"

while IFS= read -r line; do
#  echo ${line}
  curl -d "${line}" -H 'Content-Type: application/json' ${url}
done <<< $(cat ${attList})
