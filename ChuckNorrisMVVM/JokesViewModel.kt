package com.your.package.here

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import java.util.*


/**
 * @param context, helpful for sharing joke
 * @param sharedPreferences, helpful for saving jokes
 *
 * @see androidx.lifecycle.ViewModel
 */
class JokesViewModel(
    private val context: Context,
    private val sharedPreferences: SharedPreferences
) : ViewModel() {

    private val service: JokeApiServiceFactory.JokeApiService = TODO("init your service here")
    private val composite: CompositeDisposable = TODO("init your composite here")

    enum class LoadingStatus { LOADING, NOT_LOADING }

    /** Used as a "dynamic enum" to notify Adapter with correct action. */
    sealed class ListAction {
        data class ItemUpdatedAction(val position: Int) : ListAction()
        data class ItemInsertedAction(val position: Int) : ListAction()
        data class ItemRemovedAction(val position: Int) : ListAction()
        data class ItemMovedAction(val fromPosition: Int, val toPosition: Int) : ListAction()
        object DataSetChangedAction : ListAction()
    }

    /**
     * Private members of type MutableLiveData.
     * You can update a MutableLiveData value using setValue() (or postValue() if not main Thread).
     * Belong private because only the ViewModel should be able to update its liveData.
     *
     * @see androidx.lifecycle.MutableLiveData
     * @see androidx.lifecycle.LiveData#setValue()
     * @see androidx.lifecycle.LiveData#postValue()
     */
    private val _jokesLoadingStatus = MutableLiveData<LoadingStatus>()
    private val _jokesSetChangedAction = MutableLiveData<ListAction>()
    private val _jokes = MutableLiveData<List<Joke>>()


    /**
     * Public members of type LiveData.
     * This is what UI will observe and use to update views.
     * They are built with private MutableLiveData above.
     *
     * @see androidx.lifecycle.LiveData
     * @see androidx.lifecycle.Transformations
     */
    val jokesLoadingStatus: LiveData<LoadingStatus> = _jokesLoadingStatus
    val jokesSetChangedAction: LiveData<ListAction> = _jokesSetChangedAction
    val jokeModels: LiveData<List<JokeView.Model>> = Transformations.map(_jokes) {
        it.toJokesViewModel()
    }

    init {
        TODO("Restore saved joke, and fetch new others.")
    }

    fun onNewJokesRequest(jokeCount: Int = 10) {
        TODO(
            "Get jokes with your service and update _jokes list, " +
                    "then update _jokesSetChangedAction with corresponding action"
        )
    }

    fun onJokeRemovedAt(position: Int) {
        TODO(
            "Remove joke at index=$position in _jokes list, " +
                    "then update _jokesSetChangedAction with corresponding action"
        )
    }

    fun onJokePositionChanged(previous: Int, target: Int) {
        TODO(
            "Change joke from $previous to $target index in _jokes list, " +
                    "then update _jokesSetChangedAction with corresponding action"
        )
    }

    private fun onJokeStared(id: String) {
        TODO(
            "Update joke with id=$id in _jokes list, " +
                    "add it to shared preferences, " +
                    "then update _jokesSetChangedAction with corresponding action"
        )
    }

    private fun onJokeUnStared(id: String) {
        TODO(
            "Update joke with id=$id in _jokes list, " +
                    "remove it from shared preferences, " +
                    "then update _jokesSetChangedAction with corresponding action"
        )
    }

    private fun onJokeShared(id: String) {
        TODO("Share joke with id=$id")
    }

    private fun onSavedJokesRestored() {
        TODO(
            "Get saved jokes from shared pref and update _jokes list, " +
                    "then update _jokesSetChangedAction with corresponding action"
        )
    }

    override fun onCleared() {
        TODO("What to do here ? See method documentation.")
    }

    private fun List<Joke>.toJokesViewModel(): List<JokeView.Model> = map { joke ->
        TODO("Build a Model instance using $joke")
    }

    /** Convenient method to change an item position in a List */
    private inline fun <reified T> List<T>.moveItem(sourceIndex: Int, targetIndex: Int): List<T> =
        apply {
            if (sourceIndex <= targetIndex)
                Collections.rotate(subList(sourceIndex, targetIndex + 1), -1)
            else Collections.rotate(subList(targetIndex, sourceIndex + 1), 1)
        }

}