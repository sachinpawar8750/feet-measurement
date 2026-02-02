@echo off
echo Compiling and running tests for QuantityMeasurementApp...

REM Create lib directory if it doesn't exist
if not exist "lib" mkdir lib

REM Download JUnit 5 jars if they don't exist
if not exist "lib\junit-platform-console-standalone-1.9.3.jar" (
    echo Downloading JUnit 5...
    curl -L -o "lib\junit-platform-console-standalone-1.9.3.jar" "https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.9.3/junit-platform-console-standalone-1.9.3.jar"
)

REM Compile the main class
echo Compiling QuantityMeasurementApp...
javac QuantityMeasurementApp.java

REM Compile the test class
echo Compiling QuantityMeasurementAppTest...
javac -cp ".;lib\junit-platform-console-standalone-1.9.3.jar" QuantityMeasurementAppTest.java

REM Run the tests
echo Running tests...
java -jar lib\junit-platform-console-standalone-1.9.3.jar --class-path . --scan-class-path

echo.
echo Tests completed!
pause