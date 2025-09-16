@echo off
echo Compiling ARISE Bank ATM Application...
javac -cp src/main/java -d target/classes src/main/java/ARISEBANK/*.java
if %errorlevel% equ 0 (
    echo Compilation successful!
    echo You can now run: java -cp target/classes ARISEBANK.ARISE
) else (
    echo Compilation failed!
    pause
)
