latestDir=`ls -td -- */ | head -n 1 | cut -d'/' -f1`
reportsDir="/data/automationFiles/ciamsgo-cucumber-test-framework/output/$latestDir/ExtentPdfReport"

cmd=`cd /data/automationFiles/ciamsgo-cucumber-test-framework/output/ && ls -td -- */ | head -n 1 | cut -d'/' -f1`
cmd &
echo " cmd output is "\"$cmd"\""

cmd2=`ls -ltr  "\"/data/automationFiles/ciamsgo-cucumber-test-framework/output/$cmd/ExtentPdfReport/ExtentPdf.pdf"\"`
ls -ltr  "/data/automationFiles/ciamsgo-cucumber-test-framework/output/$cmd/ExtentPdfReport/ExtentPdf.pdf"