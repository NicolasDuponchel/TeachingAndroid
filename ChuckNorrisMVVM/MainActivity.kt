package com.your.package.here

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gopro.chucknorrisjokes.JokesViewModel.LoadingStatus

class MainActivity : AppCompatActivity() {

    /**
     * Our ViewModel instance, built with our Factory
     *
     * @see androidx.activity.viewModels
     */
    private val viewModel: JokesViewModel by viewModels {
        TODO("Give a new instance of your JokesViewModelFactory here.")
    }

    private val jokeAdapter: JokeAdapter = TODO("init jokeAdapter here")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TODO("Init activity UI here, then observe your ViewModel")
    }

    private fun observeViewModel() {
        viewModel.jokeModels.observe(
            this,
            Observer { jokes: List<JokeView.Model> ->
                TODO(
                    "Called when $jokes changes. " +
                            "Use it to update your adapter data set."
                )
            })

        viewModel.jokesSetChangedAction.observe(
            this,
            Observer { listAction: JokesViewModel.ListAction ->
                TODO(
                    "Called when $listAction changes. " +
                            "Use it to notify your adapter with correct method."
                )
            })

        viewModel.jokesLoadingStatus.observe(
            this,
            Observer { loadingStatus: LoadingStatus ->
                TODO(
                    "Called when $loadingStatus changes. " +
                            "Use it to update your loader visibility."
                )
            })
    }


    /**
     * Convenient class used to build the instance of our JokeViewModel,
     * passing some params to its constructor.
     *
     * @see androidx.lifecycle.ViewModelProvider
     */
    private class JokesViewModelFactory(
        private val context: Context,
        private val sharedPrefs: SharedPreferences
    ) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T =
            JokesViewModel(context, sharedPrefs) as T
    }

}
