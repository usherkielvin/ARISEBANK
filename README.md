# ARISE Bank ATM Application

A Java-based ATM simulation application with a modern GUI interface.

## Project Structure

```
ARISEBANK/
├── src/
│   └── main/
│       ├── java/
│       │   └── ARISEBANK/
│       │       ├── ARISE.java              # Main application class
│       │       ├── ARISEatm.java           # Welcome screen
│       │       ├── ARISEinsertCard.java    # Card insertion screen
│       │       ├── ARISEloading.java       # Loading screen
│       │       ├── ARISEloading1.java      # Secondary loading screen
│       │       ├── ARISElogin.java          # Login screen
│       │       ├── ARISEmenu.java          # Main menu
│       │       ├── ARISEexit.java          # Exit screen
│       │       ├── CheckBalance.java       # Balance checking
│       │       ├── Withdraw.java           # Withdrawal functionality
│       │       ├── Deposit.java           # Deposit functionality
│       │       ├── Transfer.java           # Transfer functionality
│       │       ├── Paybills.java           # Bill payment menu
│       │       ├── MobileTopup.java        # Mobile top-up
│       │       ├── ChangePin.java          # PIN change
│       │       ├── History.java            # Transaction history
│       │       ├── MiniStatement.java      # Mini statement
│       │       ├── AccountTypeSelectionPanel.java
│       │       └── Bank transfer classes:
│       │           ├── bdo.java
│       │           ├── bpi.java
│       │           ├── chinabank.java
│       │           ├── landbank.java
│       │           ├── metroBank.java
│       │           └── pnb.java
│       └── resources/
│           ├── Photos/                     # Image assets
│           │   ├── ARISElogo.png
│           │   ├── headerLogo.png
│           │   ├── p.png
│           │   ├── q.png
│           │   ├── ab.png
│           │   ├── bv.gif
│           │   ├── loading.gif
│           │   └── ... (other images)
│           ├── Sounds/                     # Audio assets
│           │   ├── clickButton.wav
│           │   ├── errorSound.wav
│           │   └── cardsound.wav
│           ├── *.png                       # Additional images
│           ├── *.gif                       # Additional animations
│           └── *.wav                       # Additional sounds
├── target/
│   └── classes/                           # Compiled classes
├── pom.xml                                # Maven configuration
├── compile.bat                            # Compilation script
├── run.bat                                # Run script
├── .gitignore                             # Git ignore rules
└── README.md                              # This file
```

## How to Run

### Option 1: Using Batch Scripts (Windows)
1. **Compile**: Double-click `compile.bat` or run in terminal
2. **Run**: Double-click `run.bat` or run in terminal

### Option 2: Using Command Line
```bash
# Compile
javac -cp src/main/java -d target/classes src/main/java/ARISEBANK/*.java

# Run
java -cp target/classes ARISEBANK.ARISE
```

### Option 3: Using Maven
```bash
mvn compile
mvn exec:java -Dexec.mainClass="ARISEBANK.ARISE"
```

## Features

- **Modern GUI**: Clean, professional ATM interface
- **Sound Effects**: Audio feedback for user interactions
- **Multiple Banks**: Support for various bank transfers
- **Bill Payments**: Electric, water, internet, loan payments
- **Mobile Top-up**: Mobile credit loading
- **Transaction History**: View past transactions
- **PIN Management**: Change PIN functionality
- **Balance Checking**: Real-time balance inquiry

## Requirements

- Java 11 or higher
- Windows OS (for batch scripts)

## Notes

- All resources (images, sounds) are properly organized in the `src/main/resources` directory
- The application follows Maven standard directory layout
- Sound files require proper audio system support
- Images are optimized for ATM display resolution
