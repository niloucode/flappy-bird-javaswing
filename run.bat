@echo off

del /s /q *.class

javac -d out -cp src src/Main.java
if %errorlevel% neq 0 pause && exit /b

java -cp out Main "%1" bot

pause