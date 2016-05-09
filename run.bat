@echo off
title TBC BAT FILE
TIMEOUT /T 3
set ProjectPath=.
echo %ProjectPath%
set classpath=%ProjectPath%\bin;%ProjectPath%\lib\*;
echo %classpath%
java org.testng.TestNG %ProjectPath%\testng.xml