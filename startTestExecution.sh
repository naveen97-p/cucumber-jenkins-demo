#!/bin/sh

# Author : Rakshith S
# Description : This script starts execution of automation testing

#crontab is not able to find the maven path, setting the path to find the mvn command
#NOTE: DO NOT DELETE THE PATH VARIABLE IF THE SCRIPT SCRIPT IS RUNNING IN CRONTAB
PATH=$PATH:/data/maven/bin
export $PATH
COMPILE_CMD="mvn compile"
APP_NAME="TestRunner.DemoEnvironment.JunitRunnerForAllApps"
MTIME="15"
echo "Starting maven complie"
#sleep 300
#mvn compile >/data/automationFiles/ciamsgo-cucumber-test-framework/mvnCompileOutput.txt
$COMPILE_CMD > mvnCompileOutput.txt
#Sleep for 50 seconds to make sure the command is exited with status 0
sleep 50
wait -n
buildCompileStatus=`grep -i "BUILD SUCCESS" mvnCompileOutput.txt | cut -d' ' -f2-`
echo "Maven compile status is $buildCompileStatus"
#Checking if the mvn compile command was successfull or not
if [ "$buildCompileStatus" == "BUILD SUCCESS" ]; then
        {
                echo "Maven compile was successful"
                echo "Starting test for $APP_NAME"
                #$TEST_CMD  > mvnTestOutput.txt
                mvn clean test -Dtest=$APP_NAME > mvnTestOutput.txt
                #Sleep for 200 seconds to make sure the command is exited with status 0
                #sleep 200
                #wait -n
                buildStatus=`grep -i "BUILD SUCCESS" mvnTestOutput.txt | cut -d' ' -f2-`
                echo "Build status is $buildStatus"
                #checking if the test command was successfull or not
                if [ "$buildStatus" == "BUILD SUCCESS" ]; then
                {
                        echo "Build is successful"
                        latestDir=`cd /data/automationFiles/ciamsgo-cucumber-test-framework/output/ && ls -td -- */ | head -n 1 | cut -d'/' -f1`
                        echo "cmd output is "\"$latestDir"\""
                        #copyCmd=`cp "/data/automationFiles/ciamsgo-cucumber-test-framework/output/$latestDir/ExtentPdfReport/ExtentPdf.pdf" /home/svc_iamadmin`
                        #echo "As a test copying the latest Report.pdf to svc_iamadmin's home directory"
                        #$copyCmd
                         }
                                        else
                                        {
                                                echo "$APP_NAME test was unsuccessful check : /data/automationFiles/ciamsgo-cucumber-test-framework/output/rerun.txt"
                                        }
                                        fi
                                }
                        else
                                {
                                        echo "Maven complie was unsuccessful"
                                }
                        fi
                        countFiles=`find /data/automationFiles/ciamsgo-cucumber-test-framework/output/* -type d -mtime +$MTIME | wc -l`
                        echo "The count is $countFiles"

                        if [ "$countFiles" -gt 0 ]; then
                                {
                                        echo "Deleteing files"
                                        deleteFiles=`find /data/automationFiles/ciamsgo-cucumber-test-framework/output/* -type d -mtime +$MTIME -exec rm -rf {} \;`
                                }
                        else
                                {
                                        echo "No Files to delete"
                                }
                        fi