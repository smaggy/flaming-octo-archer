@echo off

echo Expecting a Total of '1' Argument
echo Argument passed is '%1'
pause

set JARS=
set CLASSPATH=

cd c:\AutomationExecution\

for %%i in (.\lib\*.jar) do call append.bat %%i
set CLASSPATH=%JARS%;JaM-CertSuite-2013.1-SNAPSHOT-tests.jar;JaM-CertSuite-2013.1-SNAPSHOT.jar

echo "Setting CLASSPATH to the following."
echo %CLASSPATH%
pause

java -cp %CLASSPATH% org.junit.runner.JUnitCore com.medplus.test.unit.TestGenericObjectFactory
