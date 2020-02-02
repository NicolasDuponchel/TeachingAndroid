# Chuck Norris Joke App

<p align="center" href="https://api.chucknorris.io/">
    <img src="https://api.chucknorris.io/img/chucknorris_logo_coloured_small@2x.png" height="200">
<p/>


## Main goal
Build an app to display some Chuck Norris jokes. In these TP you will deal with 
* dynamic list
* json data struct
* public web api call
* asynchronous code
* activity instance state
* data share with other apps


## Instructions
First, init a **git** environment and sync it with your github repo.

In the all training please commit your changes each time you're done with an instruction. 1 instruction ==> at least 1 detailed commit pushed on your repo. Feel free to rework your git story with interactive rebase if needed.

example of :poop: git story : 
```
A.  Create a Jokes class
B.  Change Jokes name to Joke
C.  Create list of jokes
D.  Fix list of jokes - added one joke
```

example of :+1: git story : 
```
A.  Create a Joke class
B.  Create a list of jokes
```

## Part 1 - Create a UI List component
The main useful android component to display lists is [RecyclerView]. This part goal is to build a simple `RecyclerView`. Create a new Android Studio project with an empty activity.


#### 1. Create a static list of jokes
Let's use an hardcoded source of data for the first part of the work.

* Create a new Object as a file. This Object should contain a list of ~10 jokes. You can find some on [chuckApi]. Your list should be accessible everywhere.

* Display that list in the Logcat 


#### 2. RecyclerView instantiation
A `RecyclerView` is an optimized and flexible view for providing a limited window into a large data set. 

* Add `androidx.recyclerview:recyclerview` to your dependencies in module file `build.gradle (app)` to import `RecyclerView` package.

* Add a new `RecyclerView` in you main layout and bind it in your main activity.

* A `RecyclerView` needs a manager to control its child views arrangements. Take a look at `LinearLayoutManager`.

* A `RecyclerView` also needs an adapter to populate its content. You can move on next part to build your custom adapter.

***TIP 1***: Last `RecyclerView` version can be found [here][recyclerViewVersion]

***TIP 2***: Learn more about gradle [`implementation`][implementation] config.

#### 3. Custom Adapter
An `Adapter` is used to put data inside a `RecyclerView`. It provides a binding from an app-specific data set to views that are displayed within a `RecyclerView`. It uses a custom view holder to recycle data.

* Create class `JokeAdapter`.

* Data source: add a list of jokes in your adapter as a member. For now we can use a variable. 

* UI list item: Create an internal class `JokeAdapter.JokeViewHolder` which extends `RecyclerView.ViewHolder`. For now it stores a value of type `TextView`. We will use it to display each joke. Note that it will be replaced later with a custom view.

* Make your `JokeAdapter` extends `RecyclerView.Adapter`. Use your custom view holder as argument, then override abstract methods using your jokes list member and your view holder. For further info, you should read those methods javadoc and check what's their return type.

* Update data: Use a custom setter on your jokes list to notify your adapter that data set has changed.

* *Optional*: Remember usage of **var** is sometime easier, but **val** is definitely a better option to avoid stateful as far as possible. Can you find a way to store a list of jokes as a value ?   

* Your adapter is now ready, use it in your main activity to set your `RecyclerView` adapter. Do not forget to give to your adapter the jokes to display.

* Run the app
 

#### 4. Custom view for items
This looks pretty cool isn't it ? But I'm sure you're not yet fully satisfied. We could improve our UI. Let's do it. 

* Custom joke item: create a new layout `joke_layout.xml` as a single `TextView`. Add some android tag to improve UI as much as you wish(thinks about `textSize`, `textAlignment`, `padding`, `background`, ...).

* Custom joke usage: Remember in your `JokeAdapter` when its `ViewHolder` is created? Replace the `TextView` instance with your `joke_layout`. You need a `LayoutInflater` to inflate your view. 

***TIP 1***: **cmd+n** in layout folder to create a new Layout res file.

***TIP 2***: Here is [TextView] doc.

***TIP 3***: Here is [LayoutInflater] doc. 


#### 5. Conclusion
You're now able to create your custom `RecyclerView`, using a custom adapter and custom layout resources. Don't forget to save your work.

----------------------------------------------------------------------

### ... Work in progress ... 
### :hammer_and_pick: :hammer_and_pick:   :hammer_and_pick:  :hammer_and_pick:  :hammer_and_pick:  :hammer_and_pick:  :hammer_and_pick:  :hammer_and_pick: 


[//]: # (links)
[chuckApi]: https://api.chucknorris.io/
[RecyclerView]: https://developer.android.com/reference/androidx/recyclerview/widget/RecyclerView
[TextView]: https://developer.android.com/reference/kotlin/android/widget/TextView
[LayoutInflater]: https://developer.android.com/reference/android/view/LayoutInflater
[recyclerViewVersion]: https://developer.android.com/jetpack/androidx/releases/recyclerview
[implementation]: https://developer.android.com/studio/build/dependencies#dependency_configurations