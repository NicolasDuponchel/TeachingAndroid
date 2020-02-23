
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


## Steps

1. [UI List component](#part1)
2. [Fetch jokes using API](#part2)
3. [Display jokes on screen](#part3)



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


<p align="center"><img src="https://i.stack.imgur.com/twIm6.png" height="100"><p/>


## Part 1 - Create a UI List component <a name="part1"/>
The main useful android component to display lists is [RecyclerView]. This part goal is to build a simple `RecyclerView`. Create a new Android Studio project with an empty activity.


#### 1. Create a static list of jokes
Let's use an hardcoded source of data for the first part of the work.

* Create a new Object as a file. This Object should contain a list of ~10 jokes. You can find some on [chuckApi]. Your list should be accessible everywhere.

* Display that list in the Logcat 


#### 2. RecyclerView instantiation
A `RecyclerView` is an optimized and flexible view for providing a limited window into a large data set. 

* Add `androidx.recyclerview:recyclerview` to your dependencies in module file `build.gradle (app)` to import `RecyclerView` package.

> :mag: *Last `RecyclerView` version can be found [here][recyclerViewVersion].*
>
> :mag: *Learn more about gradle [`implementation`][implementation] config.*

* Add a new `RecyclerView` in you main layout and bind it in your main activity.

* A `RecyclerView` needs a manager to control its child views arrangements. Take a look at `LinearLayoutManager`.

* A `RecyclerView` also needs an adapter to populate its content. You can move on next part to build your custom adapter.


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

> :mag: ***cmd+n** in layout folder to create a new Layout res file.*
>
> :mag: *TextView [doc][TextView].*

* Custom joke usage: Remember in your `JokeAdapter` when its `ViewHolder` is created? Replace the `TextView` instance with your `joke_layout`. You need a `LayoutInflater` to inflate your view. 

> :mag: *LayoutInflater [doc][LayoutInflater].* 


#### 5. Conclusion
You're now able to create your custom `RecyclerView`, using a custom adapter and custom layout resources. Don't forget to save your work.


<p align="center" href="https://api.chucknorris.io/">
    <img src="https://cdn0.iconfinder.com/data/icons/user-interface-255/100/more-512.png" height="100">
<p/>


## Part 2 - Fetch jokes <a name="part2"/>
This part goal is to get jokes from Chuck Norris web API. 

#### 1. Create the data model matching the API
Here is the returned json : 
```json
{
  "categories": [
    
  ],
  "created_at": "2020-01-05 13:42:26.766831",
  "icon_url": "https://assets.chucknorris.host/img/avatar/chuck-norris.png",
  "id": "pyNXTV7WThiNLRykGsQmrg",
  "updated_at": "2020-01-05 13:42:26.766831",
  "url": "https://api.chucknorris.io/jokes/pyNXTV7WThiNLRykGsQmrg",
  "value": "The hills are alive with the sound of Chuck Norris' dong slapping against his legs while he walks."
}
```
First of all, this json file needs to be changed into kotlin class so that we can use it in the app. [Kotlinx Serilaization][kotlinSerial] will help us achieve this *conversion*. 


* Import `Kotlinx.serialization` lib into your app. You will need to import both [plugin][kotlinSerialPlugin] and [runtime library][kotlinSerialLib]. Prefer usage of groovy DSL for now.

* Once you're done with imports, create a class `Joke` matching json format and tag it as `Serializable`. 

> :mag: *Is `Joke` as simple class ?*

* `created_at`, `icon_url`, and `updated_at` don't match the Kotlin **camel case** convention. We would prefer those val to be named `createdAt`, `iconUrl`, and `updatedAt`. Use `@SerialName` annotation to achieve this.

> :mag: *Kotlinx Serialization [annotations][kotlinSerialAnnotation]*

* Use [`JokeSerializationTest.kt`][testFile] to be sure everything is correct. You can download file and past it in `test` folder (same level that `main`). Note that you shouldn't edit this file content, just *Run Test*.

* Replace all `String` used in previous part with `Joke` object: `JokeAdapter` should not contain a `List<String>` anymore but a `List<Joke>`. 

> :mag: *Think about `Extension fun` and `map` operator to avoid changing your hardcoded list of string-jokes.* 

* Run the app.
 
 
#### 2. Import Retrofit & Rx Java
[Retrofit][https://square.github.io/retrofit/] is a type-safe HTTP client for Android and Java. We'll use it to request Chuck API. There are multiple ways to achieve async operations on Android. We'll use [Rx][http://reactivex.io/], which is known to be a combination of the best ideas from the **Observer** pattern, the **Iterator** pattern, and **functional programming** 

* Import [Retrofit] last version -  `com.squareup.retrofit2:retrofit:x.y.z`

* Import `RxJava2` last version for `rxkotlin` and `rxandroid` - `io.reactivex.rxjava2:rx....:x.y.z`

* To make Rx works with Retrofit, an adapter may be used. Thanks to Jake Wharton's [Adapter][RxAdapter], we won't need to build it. Import the adapter.

* To make Retrofit answers serialization works, a converter may be used. Thanks again to JW, we'll use a existing [solution][RxConverter]. Import the converter. 

* We are going to use internet in our app. Specify in the Manifest that the app needs `android.permission.INTERNET`. 

> :mag: *The manifest tag to use is `<uses-permission/>`*


#### 3. Retrofit usage

###### Api interface

* The API we are using needs to be interfaced. In order to do so, create an interface `JokeApiService`. 

* This interface should declare a fun `giveMeAJoke()` which returns a `Single<Joke>`.

> :mag: *[Single][RxSingle] is an Observable variant in Rx. It always emits one value or an error*

* To tell Retrofit this fun is an http GET, just add the annotation `@GET("url_path_extension")` to your function.


###### Retrofit Factory
Retrofit will help you creating an instance of `JokeApiService`. To do so we need to build a Factory and use `Retrofit.Builder`.

* Create an object `JokeApiServiceFactory` with a function of return type `JokeApiService`. Move on next steps to build this methods body.

* Create a `Retrofit.Builder` instance and add following details :
    * set api base url
    * add a converter factory - `Json.asConverterFactory(MediaType.get("application/json"))`
    * add a call adapter factory - Create a RxJava2CallAdapterFactory
    
> :mag: *Builder is a common Java instance maker pattern. Most of the time it works as follow:*
>```kotlin
>val builder = Builder()
>   .setSomething()
>   .addSomething()
>   .addSomething()
>   .build()
>```

* Tell your builder to create a `JokeApiService` instance. Make your function return this instance. 
 

#### 4. Call Api to get one Joke
Now that we laid the foundations, let's play with it. 

* In your activity create a `jokeService` and use it to get a `Single<Joke>`.

* Now we want to get the result of this call. We need to observe this `Single` and decide what to do when we have the event. To do so, use the kotlin `subscribeBy()` function. 

> :mag: *You can give 2 lambda arguments to `subscribeBy`. See following javadoc:*
>```kotlin
>fun <T : Any> Single<T>.subscribeBy(
>        onError: (Throwable) -> Unit = onErrorStub,
>        onSuccess: (T) -> Unit = onNextStub
>        ): Disposable
>```

> :mag: *Lambda argument example : `onSuccess = { joke -> TODO("Tell your $joke to the world") }`*

* If you test your code at this step you'll get a `NetworkOnMainThreadException`. Web call are asynchronous and require not to be executed on the **MainThread**. What you need to do is to force the subscription of your Single on a different Thread. Android most common thread to execute network call is `Schedulers.io()`. 

> :mag: *Have a look at method `Single.subscribeOn(...)`*  

* You are now ready to Log your first Joke in Logcat. Run the app and read your joke.

> :warning: Retrofit2 requires at minimum Java 8+. For some reasons your code might crash with [`NoSuchMethodError: No static method metafactory`][RetrofitError]. You can fix it by switching Java8 compatibility, add following code to your Gradle :
>```groovy
> android {
>    ...
>    compileOptions {
>        sourceCompatibility JavaVersion.VERSION_1_8
>        targetCompatibility JavaVersion.VERSION_1_8
>    }
>}
>```

#### 5. Leaks killer
At this point we subscribed to a `Single` observable, but we do never unsubscribe to it, which is a bad thing because it creates leaks. Android Studio should be warning: *"The result of subscribeBy is not used"*.

* Add a member field of type `CompositeDisposable` to your activity.

* Add the result of your subscription to your `CompositeDisposable` instance.

* You need to clear your composite, but when ? 


#### 6. Conclusion
You're now able to use the Chuck REST API to get a random joke with your android device.  


<p align="center"><img src="https://i.stack.imgur.com/twIm6.png" height="100"><p/>


## Part 3 - Display jokes on screen <a name="part3"/>
Goal now: add a `Joke` we get from the web inside our `RecyclerView`.

#### 1. Display a single Joke

* Instead of Logging your fetched `Joke`, add it to your `JokeAdapter` data content. Drop your hardcoded list of jokes, you don’t need it anymore. 

* If you run your code at this step you'll get a `CalledFromWrongThreadException`. It means that you're asking Android to update Views on a different Thread that the **MainThread**, which is not allowed. What you need to do is to force the observation of your `Single` observable on `AndroidSchedulers.mainThread()`.

> :mag: *Have a look at method `Single.observeOn(...)`*

> :mag: *If you're curious to learn more about subscribeOn & observeOn methods, [here][threadingArticle] is a very helpful article.*

* Add a button on your screen and make it add a new `Joke` to your list on each click.  

#### 2. Add a loader
What we need now is to tell the user he needs to wait while his Joke is being downloaded. To do so we’ll use a `ProgressBar`.

* Add a `ProgressBar` to your layout. By default you want this loader not to be visible on screen. 

> :mag: *Manage a `View` visibility using tag [`visibility`][viewVisibility]*

* Make your loader visible whenever a joke is fetched and during the all task duration.  

> :mag: *I guess you want to:* 
> * *show loader when subscribing to your `Observable`.*
> * *hide it after your `Observable` is terminated.*

> :mag: *The call to random joke API will probably be very quick for a single Joke, and the loader may not have time to appear on screen. Take a look at method `Observable.delay()`, It could be helpful for testing.* 

#### 3. Make the call for multiple jokes with Observable
Of course we won't get stuck here with a stupid single joke. Don't you want some more funny stories ? 

* Change your `Single` emission of `Joke` into an `Observable` which emits a set of 10 `Jokes` one after the other. 

> :mag: *What you would like to do here is to **`repeat`** n times the single emission of a `Joke`* 

> :mag: *Remember a `Single` is a particular case of an `Observable`. It emits result in `onSuccess` whereas an `Observable` emits each result in `onNext`, then `onComplete` when it's done.*


#### 4. Reload new jokes 
The goal here is to dynamically reload new jokes when we are done with previous one. In this part, we will reload new set of jokes when we scroll to the last jokes displayed.

* Remove your dummy button.

* Add a callback `onBottomReached` to your adapter. This callback should be :
    * a class member value
    * passed as param in the adapter constructor
    * a lambda function
    
> :mag: *Have a look at kotlin [function types documentation][kotlinFunctionTypeDoc] to learn more about how to pass function as param. For further reading, [here][kotlinFunctionArticle] is a well written article on Kotlin functions features.*

* Make your Activity code compile : complete your Adapter instantiation with missing param. What do you want to do on your list bottom reached ? 

* In your Adapter, you need to call `onBottomReached()` when you scroll to the bottom of your list. There might be different ways to achieve this. Be creative !

#### 5. Conclusion
Here we are ! You built a simple single screen app displaying Chuck Norris jokes.


<p align="center"><img src="https://i.stack.imgur.com/twIm6.png" height="100"><p/>








[//]: # (links)
[testFile]: JokeSerializationTest.kt
[chuckApi]: https://api.chucknorris.io/
[RecyclerView]: https://developer.android.com/reference/androidx/recyclerview/widget/RecyclerView
[TextView]: https://developer.android.com/reference/kotlin/android/widget/TextView
[LayoutInflater]: https://developer.android.com/reference/android/view/LayoutInflater
[recyclerViewVersion]: https://developer.android.com/jetpack/androidx/releases/recyclerview
[implementation]: https://developer.android.com/studio/build/dependencies#dependency_configurations
[kotlinSerial]: https://github.com/Kotlin/kotlinx.serialization
[kotlinSerialPlugin]: https://github.com/Kotlin/kotlinx.serialization#using-apply-plugin-the-old-way
[kotlinSerialLib]: https://github.com/Kotlin/kotlinx.serialization#dependency-on-the-runtime-library
[kotlinSerialAnnotation]: https://github.com/Kotlin/kotlinx.serialization/blob/master/docs/examples.md#annotations
[RxAdapter]: https://github.com/square/retrofit/tree/master/retrofit-adapters/rxjava2
[RxConverter]: https://github.com/JakeWharton/retrofit2-kotlinx-serialization-converter
[RxSingle]: http://reactivex.io/documentation/single.html
[Retrofit]: https://github.com/square/retrofit 
[RetrofitUsage]: https://github.com/square/retrofit/tree/master/retrofit-adapters/rxjava2#usage 
[RetrofitError]: https://stackoverflow.com/a/59448917/10030894
[threadingArticle]: https://proandroiddev.com/understanding-rxjava-subscribeon-and-observeon-744b0c6a41ea
[viewVisibility]: https://developer.android.com/reference/android/view/View.html#setVisibility(int)
[kotlinFunctionTypeDoc]: https://kotlinlang.org/docs/reference/lambdas.html#function-types
[kotlinFunctionArticle]: https://blog.kotlin-academy.com/kotlin-programmer-dictionary-function-type-vs-function-literal-vs-lambda-expression-vs-anonymous-edc97e8873e