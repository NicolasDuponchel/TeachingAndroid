package com.gopro.chucknorrisjokes

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class JokeTouchHelper(
    private val onJokeRemoved: ??? ,
    private val onItemMoved: ???
) : ItemTouchHelper(
    object : ItemTouchHelper.SimpleCallback(
        UP or DOWN,
        LEFT or RIGHT
    ) {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean = TODO("use it to reorder items")

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, swipeDir: Int) =
            TODO("use it to delete items")
    }
)