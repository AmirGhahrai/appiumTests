# appiumTests

Instructions to run the tests:

Install Android SDK (brew install Caskroom/cask/android-sdk)
Install appium (npm install -g appium)

set path for Java and Android in ~/.bash_profile

.bash_profile should look like:

export ANDROID_HOME=/usr/local/Cellar/android-sdk/24.4.1_1<br/>
export PATH=$ANDROID_HOME/platform-tools:$PATH<br/>
export PATH=$ANDROID_HOME/tools:$PATH<br/>
export PATH=$PATH:$ANDROID_HOME/bin<br/>
export JAVA_HOME=/Library/Java/Home<br/>
export JAVA_HOME;<br/>

Launch Android SDK Manager<br/>
       android sdk  -- install Android SDK Platform 6.0 (API 23)
Launch Android Virtual Device <br/>
       android avd -- create an android device (AVD Name: Nexus5v6) (Target: Android 6.0) (Device: Nexus 5) <br/>
Launch device just created -- emulator @Nexus5v6<br/>

Install Wikipedia app -- adb install path_to_apk (note the app is placed under the app folder in project root) <br/>
       
Start appium server<br/>
       appium &

Run the tests<br/>
mvn clean test
