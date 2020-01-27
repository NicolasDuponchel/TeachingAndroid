# TP MyFirstApp

## Main goal

In this TP you will deal with 
* some xml and UI attributes
* activity lifecyle
* resources
* Git


## Getting Started

Following instructions will help you init your first android project

1. Install and run Android Studio 
2. Configure your development tool : 
    * If you use an Android device, turn it on developer mode
    * If not, you can configure an emulator on Android Studio
3. Android project 
    * Start a new Android Studio project
    * Select Empty Activity
    * Name your app *MyFirstAndroidApp* for example
    * Do not care about packageName
    * Select your project path directory
    * Use Kotlin as language
    * Select Android 5.0 as minimal supported version (or lower if your device is not compatible)
    * Use AndroidX
    * Finish and wait gradle sync
    * You should now be able to make and run your app

Is **"Hello world!"** prompted on the screen ? Well you can keep on reading. 



## Instructions


#### 1- Replace wording **"Hello world!"** with **"Hello ESIEE"**

* Open `activity_main.xml` and change wording.
* There is a warning on the string you just changed. Follow the warning instructions *(see TIP)*. 
* Run the app 

***TIP***: Resolve a warning - put moose on warning and use **alt+Enter**


#### 2- Add an image 

* In `activity_main.xml` add tag [<**ImageView**>](https://developer.android.com/reference/android/widget/ImageView)
* Add dimensions to match parent's width and match image content height (see [wrap_content & match_parent](https://developer.android.com/reference/android/view/ViewGroup.LayoutParams#xml-attributes_1))
* Add constraints to place it on bottom of screen (follow TextView's example)
* Download [ESIEE logo](https://www.esiee.fr/sites/all/themes/custom/esiee_theme/logo.png) and rename it to `esiee_logo.png`
* Copy you logo to `app/src/main/res/drawable` 
* Run the app 

***TIP 1***: Add an image source in ImageView with `android:src="@drawable/your_image_source`

***TIP 2***: [This](https://medium.com/@loutry/guide-to-constraintlayout-407cd87bc013) is a nice post about `ConstraintLayout` basics


#### 3- Add a button 

* In `activity_main.xml` add tag [Button](https://developer.android.com/reference/android/widget/Button)
* Add dimensions to wrap button content
* Add constraints to place it on top of screen
* Add following text on button : "try me !"
* Run app


#### 4- Handle button click

Make your button add a 'E' at the end of "Hello ESIEE" : 

* Add an id to your button in `activity_main.xml` 
* Import your ids in the acitivity with `import kotlinx.android.synthetic.main.activity_main.*`
* Call `setOnClickListener { TODO("Add 'E' at the end of "Hello ESIEE") }` on the btn id in the activity
* Run app

***TIP***: Add an id with `android:id="@+id/my_item_id"` 
 

#### 5- Move button

* Use button item ids to place button just on top of the TextView


#### 6- Create a List

* Create a list of 5 names as a value
* Sort this list by number of char in each name
* Print this list in the Logcat when the app starts
* Print this list in a new TextView on top of your button 
* Run app

***TIP***: Print something using `Log.d(...)` 


#### 7- Use le List with the button

when clicking on **"try me"** button :
* Pick a name randomly on the list
* Replace "Hello ESIEE" with this name
* Run app

***TIP***: Search random method on List 


#### 8- Modify the app icon
* Find and open `ic_launcher_foreground.xml`
* Change Android robot's color
* Flip Android robot to 180° 
* Run app

***TIP 1***: rotate - use tag group around a path and apply a rotation

***TIP 2***: set a rotating point with PivotX and PivotY
 

#### 9- Play with activity life cycle
* Override activity life cycle methods `onStart`, `onResume`, `onPause`, `onStop`, `onDestroy`.
* Use it to print each activity life cycle event in Logcat
* Run app
* Try to rotate/quit/re-open/clean/etc. Does it match the [wanted beahavior](https://developer.android.com/guide/components/activities/activity-lifecycle#alc) ?   

***TIP***: Try **ctrl+O** to search overridable methods



## Save your project on GitHub

Following instructions will help you push your android project to a GitHub repo

#### 1- GitHub account
* Create a GitHub account
* Create new GitHub repository
* Init your local git with `git init`  _(be shure to do it at app root path)_
* Link your GitHub repo with `git remote add origin _your_repository_url_`
* Save your changes in a commit 
    * `git add .` to add everything
    * `git commit -m "_your_commit_message_"` to create commit
* Set credential helper with `git config --global credential.helper foo`
* Upstream your commit to GitHub repo with  `git push -u origin master`

```
git init
git remote add origin your_repository_url
git add the_files_you_want
git commit -m "your_commit_message"
git config --global credential.helper foo
git push -u origin master
```

***TIP 1***: You can add by files with `git add _file_path_`

***TIP 2***: You can add by hunks _(parts of code changes)_ with `git add -p`

***TIP 3***: You can add and commit everything with single command `git commit -a`

## Android Studio global tips

* **cmd + alt + l** → reformat and rearange code + clean imports
* **alt + enter** on a warning → resolve it 



## Conclusion

You should now be able to understand and work with :
* init new Android Studio project
* xml attributes
* link xml and kotlin code
* activity lifecyle
* resources (images, layout, string, ...)
* Github and Git basics


###### :clap: The End :clap:
