#!/bin/bash

APP_NAME="TestRunner.Retail.JunitRunnerForAllApps"
mvn_pid=`ps -ef | grep startTestExecution.sh | grep -v 'grep' | awk '{ printf $2 }'`

echo "Waiting for maven command to finish and the PID is $mvn_pid"
wait $mvn_pid

echo "finished waiting"
echo "Sending file via email..."
#latestDir=`cd /data/automationFiles/ciamsgo-cucumber-test-framework/output/ && ls -td -- */ | head -n 1 | cut -d'/' -f1`
#echo " cmd output is "\"$latestDir"\""
#cp "/data/automationFiles/ciamsgo-cucumber-test-framework/output/$latestDir/ExtentPdfReport/ExtentPdf.pdf ~/"

#  AWS_CLI="/usr/bin/aws"
#  SENDER=noreply@ciamsgo.com
#  RECIPIENT=rakshith@mailinator.com
#  SUBJECT="Test mail"
#  BODY=" Find the attached file"
#  ATTACHMENT_TYPE="text/pdf"
#  ATTACHMENT_FILE_NAME="/data/automationFiles/ciamsgo-cucumber-test-framework/output/$latestDir/ExtentPdfReport/ExtentPdf.pdf"
#  ATTACHMENT_FILE_TO_READ_FROM_DISK="/data/automationFiles/ciamsgo-cucumber-test-framework/output/$latestDir/ExtentPdfReport/ExtentPdf.pdf"

#  echo " Sender $SENDER RECIPIENT $RECIPIENT SUBJECT $SUBJECT  BODY $BODY ATTACHMENT_TYPE $ATTACHMENT_TYPE ATTACHMENT_FILE_NAME "\"$ATTACHMENT_FILE_NAME"\" ATTACHMENT_FILE_TO_READ_FROM_DISK $ATTACHMENT_FILE_TO_READ_FROM_DISK"
  # Create message
 # echo '{"Data": "From:'${SENDER}'\nTo:'${RECIPIENT}'\nSubject:'${SUBJECT}'\nMIME-Version: 1.0\nContent-type: Multipart/Mixed; boundary=\"NextPart\"\n\n--NextPart\nContent-Type: text/plain\n\n['${BODY}']\n\n--NextPart\nContent-Type:'${ATTACHMENT_TYPE}';\nContent-Disposition: attachment; filename=\"'${ATTACHMENT_FILE_NAME}'\"\n\n--NextPart--"}' > message.json
  #if [ -f "$AWS_CLI" ]; then
   # $AWS_CLI ses send-raw-email --region us-east-2 --raw-message file://message.json
  #else
   # echo "WARNING: Skipping sending email. AWS CLI not found in path. This should be okay if the script doesn't run in the docker image."
 # fi