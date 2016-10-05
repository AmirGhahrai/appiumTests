# appiumTests

Instructions to run the tests:

Install Android SDK (brew install android-sdk)
Install appium (npm install -g appium)

set path for Java and Android in ~/.bash_profile

.bash_profile should look like:

export ANDROID_HOME=/usr/local/Cellar/android-sdk/24.4.1_1
export PATH=$ANDROID_HOME/platform-tools:$PATH
export PATH=$ANDROID_HOME/tools:$PATH
export PATH=$PATH:$ANDROID_HOME/bin
export JAVA_HOME=/Library/Java/Home
export JAVA_HOME;

Launch Android SDK Manager
       android sdk  -- install Android SDK Platform 6.0 (API 23)
Launch Android Virtual Device 
       android avd -- create an android device (AVD Name: Nexus5v6) (Target: Android 6.0) (Device: Nexus 5)
Launch device just created 
       emulator @Nexus5v6
Install Wikipedia app 
       adb install <path_to_apk> (note the app is placed under the app folder in project root)
Start appium server
       appium &

Run the tests
mvn clean test
