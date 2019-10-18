package com.lysenko.fragment.Fragment5

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment
import com.lysenko.R

class HeadlinesFragment : ListFragment() {
    internal lateinit var mCallback: OnHeadlineSelectedListener

    // The container Activity must implement this interface so the frag can deliver messages
    interface OnHeadlineSelectedListener {
        /** Called by HeadlinesFragment when a list item is selected  */
        fun onArticleSelected(position: Int)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create an array adapter for the list view, using the Ipsum headlines array
        listAdapter = ArrayAdapter(activity!!, android.R.layout.simple_list_item_activated_1, Ipsum.Headlines)
    }

    override fun onStart() {
        super.onStart()

        // When in two-pane layout, set the listview to highlight the selected list item
        // (We do this during onStart because at the point the listview is available.)
        if (fragmentManager!!.findFragmentById(R.id.article_fragment) != null) {
            listView.choiceMode = ListView.CHOICE_MODE_SINGLE
        }
    }

//    override fun onAttach(activity: Activity?) {
//        super.onAttach(activity)
//
//        // This makes sure that the container activity has implemented
//        // the callback interface. If not, it throws an exception.
//        try {
//            mCallback = activity as OnHeadlineSelectedListener
//        } catch (e: ClassCastException) {
//            throw ClassCastException(activity!!.toString() + " must implement OnHeadlineSelectedListener")
//        }
//
//    }

//    override fun onListItemClick(l: ListView?, v: View?, position: Int, id: Long) {
//        // Notify the parent activity of selected item
//        mCallback.onArticleSelected(position)
//
//        // Set the item as checked to be highlighted when in two-pane layout
//        listView.setItemChecked(position, true)
//    }
}