#!/bin/bash

TO="noreply@ciamsgo.com"
FROM="rakshith@mailinator.com"
SUBJECT="test subject"
MESSAGE="<B>Test Message</B><br /> test message"

date="$(date -R)"
access_key="AKIA3SNNKKOHQ2Q5O7Z6"
priv_key="BFpmQD+NnGt8A4D4L/7ilC4QMniEzNdNd4cpT2RdGvCM"
signature="$(echo -n "$date" | openssl dgst -sha256 -hmac "$priv_key" -binary | base64 -w 0)"
auth_header="X-Amzn-Authorization: AWS3-HTTPS AWSAccessKeyId=$access_key, Algorithm=HmacSHA256, Signature=$signature"
endpoint="http://email-smtp.us-east-2.amazonaws.com:587"
content_type="Content-Type: text/html"
mime_version="MIME-Version: 1.0"
action="Action=SendEmail"
source="Source=$FROM"
to="Destination.ToAddresses.member.1=$TO"
subject="Message.Subject.Data=$SUBJECT"
message="Message.Body.text.Data=$MESSAGE"

curl -v -X POST -H "$auth_header" -H "Date: $date" -H "$content_type" -H "$mime_version" -H "Content-Length: 50" --data-urlencode "$message" --data-urlencode "$to" --data-urlencode "$source" --data-urlencode "$action" --data-urlencode "$subject"  "$endpoint"