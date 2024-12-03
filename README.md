Cloning the Repository:

Open your terminal
Navigate to the directory where you want to clone the project.
Run the following command to clone the repository:

git clone https://github.com/hopeforrest2004/Pacman.git

Once the project is cloned, navigate into the project folder:

cd Pacman

Importing the Project into Android Studio

Open Android Studio on your computer.
Click on File in the top menu and select Open.
In the dialog that appears, navigate to the folder where you cloned the repository and select the project folder (Pacman).
Click OK to open the project in Android Studio.


Running the Application
Once the project is opened in Android Studio, wait for Android Studio to finish syncing the project.
Make sure you have an Android emulator running.
In Android Studio, select the Run button (green triangle) .
Select your desired device or emulator from the device selection dialog that appears.
The application will now build and run on the selected device.


Note: There is no additional data required to test/use this application so once you run the app you should be able to get to every View.

Features of the app:
1.  Main Menu with an option to start the game or view the high scores
2.  Intro animation prior to the game starting
3.  A custom built pacman level with a focus on increased difficulty by having more pellets to collect, no power pellet to protect yourself, and ghost ai designed to hunt the player down always
4.  A death screen to indicate gameover upon the loss of all of the players' lives.
5.  A toast bubble congratulating the player if they manage to beat the level.
6.  A high scores screen saving the 10 best performances by the player.

Functionality not included:
There is only 1 level and once the level has been beaten the game ends.

There is no JavaDoc for this project because we spent 4-5 hours attempting to solve the errors that came up:

There was no documentation about anyone encountering this sort of issue online and there was no resources in the class slides that we could use to resolve this.  This happened on multiple people's computers and as such we believe it to be a bug with android studio and or Gradle and we feel that this should be taken into account.  However, we have manually added the comments to the files instead of having the java doc.

C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\pm\PackageManager.java:19: error: cannot find symbol
import android.Manifest;
              ^
  symbol:   class Manifest
  location: package android
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\app\AppOpsManager.java:21: error: cannot find symbol
import android.Manifest;
              ^
  symbol:   class Manifest
  location: package android
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\media\AudioAttributes.java:24: error: package android.audio.policy.configuration.V7_0 does not exist
import android.audio.policy.configuration.V7_0.AudioUsage;
                                              ^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\app\AppOpsManager.java:77: error: cannot find symbol
import com.android.internal.app.IAppOpsActiveCallback;
                               ^
  symbol:   class IAppOpsActiveCallback
  location: package com.android.internal.app
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\app\AppOpsManager.java:78: error: cannot find symbol
import com.android.internal.app.IAppOpsAsyncNotedCallback;
                               ^
  symbol:   class IAppOpsAsyncNotedCallback
  location: package com.android.internal.app
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\app\AppOpsManager.java:79: error: cannot find symbol
import com.android.internal.app.IAppOpsCallback;
                               ^
  symbol:   class IAppOpsCallback
  location: package com.android.internal.app
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\app\AppOpsManager.java:80: error: cannot find symbol
import com.android.internal.app.IAppOpsNotedCallback;
                               ^
  symbol:   class IAppOpsNotedCallback
  location: package com.android.internal.app
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\app\AppOpsManager.java:81: error: cannot find symbol
import com.android.internal.app.IAppOpsService;
                               ^
  symbol:   class IAppOpsService
  location: package com.android.internal.app
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\app\AppOpsManager.java:82: error: cannot find symbol
import com.android.internal.app.IAppOpsStartedCallback;
                               ^
  symbol:   class IAppOpsStartedCallback
  location: package com.android.internal.app
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\pm\PackageInstaller.java:33: error: cannot find symbol
import android.Manifest;
              ^
  symbol:   class Manifest
  location: package android
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\pm\PackageInstaller.java:50: error: cannot find symbol
import android.content.IIntentReceiver;
                      ^
  symbol:   class IIntentReceiver
  location: package android.content
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\pm\PackageInstaller.java:51: error: cannot find symbol
import android.content.IIntentSender;
                      ^
  symbol:   class IIntentSender
  location: package android.content
C:\Users\mdspe\.gradle\caches\modules-2\files-2.1\androidx.core\core\1.13.0\9ae580505557c829bed91310494b3ccd0a386dfd\core-1.13.0-sources.jar(/androidx/core/app/ActivityCompat.java):19: error: cannot find symbol
import android.Manifest;
              ^
  symbol:   class Manifest
  location: package android
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\Context.java:47: error: cannot find symbol
import android.app.IApplicationThread;
                  ^
  symbol:   class IApplicationThread
  location: package android.app
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\Context.java:48: error: cannot find symbol
import android.app.IServiceConnection;
                  ^
  symbol:   class IServiceConnection
  location: package android.app
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\os\Build.java:19: error: cannot find symbol
import android.Manifest;
              ^
  symbol:   class Manifest
  location: package android
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\os\Build.java:30: error: package android.sysprop does not exist
import android.sysprop.DeviceProperties;
                      ^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\os\Build.java:31: error: package android.sysprop does not exist
import android.sysprop.SocProperties;
                      ^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\os\Build.java:32: error: package android.sysprop does not exist
import android.sysprop.TelephonyProperties;
                      ^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\view\ViewGroup.java:78: error: cannot find symbol
import com.android.internal.R;
                           ^
  symbol:   class R
  location: package com.android.internal
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:19: error: cannot find symbol
import static android.content.ConfigurationProto.COLOR_MODE;
                             ^
  symbol:   class ConfigurationProto
  location: package android.content
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:19: error: static import only from classes and interfaces
import static android.content.ConfigurationProto.COLOR_MODE;
^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:20: error: cannot find symbol
import static android.content.ConfigurationProto.DENSITY_DPI;
                             ^
  symbol:   class ConfigurationProto
  location: package android.content
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:20: error: static import only from classes and interfaces
import static android.content.ConfigurationProto.DENSITY_DPI;
^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:21: error: cannot find symbol
import static android.content.ConfigurationProto.FONT_SCALE;
                             ^
  symbol:   class ConfigurationProto
  location: package android.content
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:21: error: static import only from classes and interfaces
import static android.content.ConfigurationProto.FONT_SCALE;
^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:22: error: cannot find symbol
import static android.content.ConfigurationProto.FONT_WEIGHT_ADJUSTMENT;
                             ^
  symbol:   class ConfigurationProto
  location: package android.content
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:22: error: static import only from classes and interfaces
import static android.content.ConfigurationProto.FONT_WEIGHT_ADJUSTMENT;
^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:23: error: cannot find symbol
import static android.content.ConfigurationProto.GRAMMATICAL_GENDER;
                             ^
  symbol:   class ConfigurationProto
  location: package android.content
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:23: error: static import only from classes and interfaces
import static android.content.ConfigurationProto.GRAMMATICAL_GENDER;
^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:24: error: cannot find symbol
import static android.content.ConfigurationProto.HARD_KEYBOARD_HIDDEN;
                             ^
  symbol:   class ConfigurationProto
  location: package android.content
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:24: error: static import only from classes and interfaces
import static android.content.ConfigurationProto.HARD_KEYBOARD_HIDDEN;
^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:25: error: cannot find symbol
import static android.content.ConfigurationProto.KEYBOARD;
                             ^
  symbol:   class ConfigurationProto
  location: package android.content
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:25: error: static import only from classes and interfaces
import static android.content.ConfigurationProto.KEYBOARD;
^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:26: error: cannot find symbol
import static android.content.ConfigurationProto.KEYBOARD_HIDDEN;
                             ^
  symbol:   class ConfigurationProto
  location: package android.content
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:26: error: static import only from classes and interfaces
import static android.content.ConfigurationProto.KEYBOARD_HIDDEN;
^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:27: error: cannot find symbol
import static android.content.ConfigurationProto.LOCALES;
                             ^
  symbol:   class ConfigurationProto
  location: package android.content
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:27: error: static import only from classes and interfaces
import static android.content.ConfigurationProto.LOCALES;
^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:28: error: cannot find symbol
import static android.content.ConfigurationProto.LOCALE_LIST;
                             ^
  symbol:   class ConfigurationProto
  location: package android.content
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:28: error: static import only from classes and interfaces
import static android.content.ConfigurationProto.LOCALE_LIST;
^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:29: error: cannot find symbol
import static android.content.ConfigurationProto.MCC;
                             ^
  symbol:   class ConfigurationProto
  location: package android.content
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:29: error: static import only from classes and interfaces
import static android.content.ConfigurationProto.MCC;
^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:30: error: cannot find symbol
import static android.content.ConfigurationProto.MNC;
                             ^
  symbol:   class ConfigurationProto
  location: package android.content
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:30: error: static import only from classes and interfaces
import static android.content.ConfigurationProto.MNC;
^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:31: error: cannot find symbol
import static android.content.ConfigurationProto.NAVIGATION;
                             ^
  symbol:   class ConfigurationProto
  location: package android.content
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:31: error: static import only from classes and interfaces
import static android.content.ConfigurationProto.NAVIGATION;
^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:32: error: cannot find symbol
import static android.content.ConfigurationProto.NAVIGATION_HIDDEN;
                             ^
  symbol:   class ConfigurationProto
  location: package android.content
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:32: error: static import only from classes and interfaces
import static android.content.ConfigurationProto.NAVIGATION_HIDDEN;
^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:33: error: cannot find symbol
import static android.content.ConfigurationProto.ORIENTATION;
                             ^
  symbol:   class ConfigurationProto
  location: package android.content
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:33: error: static import only from classes and interfaces
import static android.content.ConfigurationProto.ORIENTATION;
^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:34: error: cannot find symbol
import static android.content.ConfigurationProto.SCREEN_HEIGHT_DP;
                             ^
  symbol:   class ConfigurationProto
  location: package android.content
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:34: error: static import only from classes and interfaces
import static android.content.ConfigurationProto.SCREEN_HEIGHT_DP;
^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:35: error: cannot find symbol
import static android.content.ConfigurationProto.SCREEN_LAYOUT;
                             ^
  symbol:   class ConfigurationProto
  location: package android.content
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:35: error: static import only from classes and interfaces
import static android.content.ConfigurationProto.SCREEN_LAYOUT;
^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:36: error: cannot find symbol
import static android.content.ConfigurationProto.SCREEN_WIDTH_DP;
                             ^
  symbol:   class ConfigurationProto
  location: package android.content
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:36: error: static import only from classes and interfaces
import static android.content.ConfigurationProto.SCREEN_WIDTH_DP;
^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:37: error: cannot find symbol
import static android.content.ConfigurationProto.SMALLEST_SCREEN_WIDTH_DP;
                             ^
  symbol:   class ConfigurationProto
  location: package android.content
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:37: error: static import only from classes and interfaces
import static android.content.ConfigurationProto.SMALLEST_SCREEN_WIDTH_DP;
^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:38: error: cannot find symbol
import static android.content.ConfigurationProto.TOUCHSCREEN;
                             ^
  symbol:   class ConfigurationProto
  location: package android.content
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:38: error: static import only from classes and interfaces
import static android.content.ConfigurationProto.TOUCHSCREEN;
^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:39: error: cannot find symbol
import static android.content.ConfigurationProto.UI_MODE;
                             ^
  symbol:   class ConfigurationProto
  location: package android.content
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:39: error: static import only from classes and interfaces
import static android.content.ConfigurationProto.UI_MODE;
^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:40: error: cannot find symbol
import static android.content.ConfigurationProto.WINDOW_CONFIGURATION;
                             ^
  symbol:   class ConfigurationProto
  location: package android.content
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:40: error: static import only from classes and interfaces
import static android.content.ConfigurationProto.WINDOW_CONFIGURATION;
^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:41: error: cannot find symbol
import static android.content.ResourcesConfigurationProto.CONFIGURATION;
                             ^
  symbol:   class ResourcesConfigurationProto
  location: package android.content
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:41: error: static import only from classes and interfaces
import static android.content.ResourcesConfigurationProto.CONFIGURATION;
^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:42: error: cannot find symbol
import static android.content.ResourcesConfigurationProto.SCREEN_HEIGHT_PX;
                             ^
  symbol:   class ResourcesConfigurationProto
  location: package android.content
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:42: error: static import only from classes and interfaces
import static android.content.ResourcesConfigurationProto.SCREEN_HEIGHT_PX;
^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:43: error: cannot find symbol
import static android.content.ResourcesConfigurationProto.SCREEN_WIDTH_PX;
                             ^
  symbol:   class ResourcesConfigurationProto
  location: package android.content
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:43: error: static import only from classes and interfaces
import static android.content.ResourcesConfigurationProto.SCREEN_WIDTH_PX;
^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:44: error: cannot find symbol
import static android.content.ResourcesConfigurationProto.SDK_VERSION;
                             ^
  symbol:   class ResourcesConfigurationProto
  location: package android.content
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:44: error: static import only from classes and interfaces
import static android.content.ResourcesConfigurationProto.SDK_VERSION;
^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\content\res\Configuration.java:53: error: cannot find symbol
import android.content.LocaleProto;
                      ^
  symbol:   class LocaleProto
  location: package android.content
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\graphics\drawable\Drawable.java:58: error: cannot find symbol
import com.android.internal.R;
                           ^
  symbol:   class R
  location: package com.android.internal
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\view\View.java:108: error: package android.sysprop does not exist
import android.sysprop.DisplayProperties;
                      ^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\view\InputDevice.java:19: error: cannot find symbol
import android.Manifest;
              ^
  symbol:   class Manifest
  location: package android
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\view\Window.java:19: error: package android.Manifest does not exist
import static android.Manifest.permission.HIDE_NON_SYSTEM_OVERLAY_WINDOWS;
                              ^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\view\Window.java:19: error: static import only from classes and interfaces
import static android.Manifest.permission.HIDE_NON_SYSTEM_OVERLAY_WINDOWS;
^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\view\Window.java:20: error: package android.Manifest does not exist
import static android.Manifest.permission.HIDE_OVERLAY_WINDOWS;
                              ^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\view\Window.java:20: error: static import only from classes and interfaces
import static android.Manifest.permission.HIDE_OVERLAY_WINDOWS;
^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\view\accessibility\AccessibilityNodeInfo.java:64: error: cannot find symbol
import com.android.internal.R;
                           ^
  symbol:   class R
  location: package com.android.internal
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\view\View.java:171: error: cannot find symbol
import com.android.internal.R;
                           ^
  symbol:   class R
  location: package com.android.internal
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\view\WindowManager.java:53: error: cannot find symbol
import static android.view.WindowLayoutParamsProto.ALPHA;
                          ^
  symbol:   class WindowLayoutParamsProto
  location: package android.view
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\view\WindowManager.java:53: error: static import only from classes and interfaces
import static android.view.WindowLayoutParamsProto.ALPHA;
^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\view\WindowManager.java:54: error: cannot find symbol
import static android.view.WindowLayoutParamsProto.APPEARANCE;
                          ^
  symbol:   class WindowLayoutParamsProto
  location: package android.view
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\view\WindowManager.java:54: error: static import only from classes and interfaces
import static android.view.WindowLayoutParamsProto.APPEARANCE;
^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\view\WindowManager.java:55: error: cannot find symbol
import static android.view.WindowLayoutParamsProto.BEHAVIOR;
                          ^
  symbol:   class WindowLayoutParamsProto
  location: package android.view
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\view\WindowManager.java:55: error: static import only from classes and interfaces
import static android.view.WindowLayoutParamsProto.BEHAVIOR;
^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\view\WindowManager.java:56: error: cannot find symbol
import static android.view.WindowLayoutParamsProto.BUTTON_BRIGHTNESS;
                          ^
  symbol:   class WindowLayoutParamsProto
  location: package android.view
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\view\WindowManager.java:56: error: static import only from classes and interfaces
import static android.view.WindowLayoutParamsProto.BUTTON_BRIGHTNESS;
^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\view\WindowManager.java:57: error: cannot find symbol
import static android.view.WindowLayoutParamsProto.COLOR_MODE;
                          ^
  symbol:   class WindowLayoutParamsProto
  location: package android.view
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\view\WindowManager.java:57: error: static import only from classes and interfaces
import static android.view.WindowLayoutParamsProto.COLOR_MODE;
^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\view\WindowManager.java:58: error: cannot find symbol
import static android.view.WindowLayoutParamsProto.FIT_IGNORE_VISIBILITY;
                          ^
  symbol:   class WindowLayoutParamsProto
  location: package android.view
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\view\WindowManager.java:58: error: static import only from classes and interfaces
import static android.view.WindowLayoutParamsProto.FIT_IGNORE_VISIBILITY;
^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\view\WindowManager.java:59: error: cannot find symbol
import static android.view.WindowLayoutParamsProto.FIT_INSETS_SIDES;
                          ^
  symbol:   class WindowLayoutParamsProto
  location: package android.view
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\view\WindowManager.java:59: error: static import only from classes and interfaces
import static android.view.WindowLayoutParamsProto.FIT_INSETS_SIDES;
^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\view\WindowManager.java:60: error: cannot find symbol
import static android.view.WindowLayoutParamsProto.FIT_INSETS_TYPES;
                          ^
  symbol:   class WindowLayoutParamsProto
  location: package android.view
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\view\WindowManager.java:60: error: static import only from classes and interfaces
import static android.view.WindowLayoutParamsProto.FIT_INSETS_TYPES;
^
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\view\WindowManager.java:61: error: cannot find symbol
import static android.view.WindowLayoutParamsProto.FLAGS;
                          ^
  symbol:   class WindowLayoutParamsProto
  location: package android.view
C:\Users\mdspe\AppData\Local\Android\Sdk\sources\android-34\android\view\WindowManager.java:61: error: static import only from classes and interfaces
import static android.view.WindowLayoutParamsProto.FLAGS;
^
100 errors
