package com.lysenko.fragment.Fragment5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.lysenko.R

class ArticleFragment : Fragment() {
    internal var mCurrentPosition = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // If activity recreated (such as from screen rotate), restore
        // the previous article selection set by onSaveInstanceState().
        // This is primarily necessary when in the two-pane layout.
        if (savedInstanceState != null) {
            mCurrentPosition = savedInstanceState.getInt(ARG_POSITION)
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.article_view, container, false)
    }

    override fun onStart() {
        super.onStart()

        // During startup, check if there are arguments passed to the fragment.
        // onStart is a good place to do this because the layout has already been
        // applied to the fragment at this point so we can safely call the method
        // below that sets the article text.
        val args = arguments
        if (args != null) {
            // Set article based on argument passed in
            updateArticleView(args.getInt(ARG_POSITION))
        } else if (mCurrentPosition != -1) {
            // Set article based on saved instance state defined during onCreateView
            updateArticleView(mCurrentPosition)
        }
    }

    fun updateArticleView(position: Int) {
        val article = activity!!.findViewById<View>(R.id.article) as TextView
        article.text = Ipsum.Articles[position]
        mCurrentPosition = position
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        // Save the current article selection in case we need to recreate the fragment
        outState.putInt(ARG_POSITION, mCurrentPosition)
    }

    companion object {
        internal val ARG_POSITION = "position"
    }
}