package com.lysenko.fragment.Fragment5

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import com.lysenko.R

class MainActivity : FragmentActivity(), HeadlinesFragment.OnHeadlineSelectedListener {

    /** Called when the activity is first created.  */
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.news_articles)

        // Check whether the activity is using the layout version with
        // the fragment_container FrameLayout. If so, we must add the first fragment
        if (findViewById<View>(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return
            }

            // Create an instance of ExampleFragment
            val firstFragment = HeadlinesFragment()

            // In case this activity was started with special instructions from an Intent,
            // pass the Intent's extras to the fragment as arguments
            firstFragment.arguments = intent.extras

            // Add the fragment to the 'fragment_container' FrameLayout
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, firstFragment).commit()
        }
    }

    override fun onArticleSelected(position: Int) {
        // The user selected the headline of an article from the HeadlinesFragment

        // Capture the article fragment from the activity layout
        val articleFrag =
            supportFragmentManager.findFragmentById(R.id.article_fragment) as ArticleFragment?

        if (articleFrag != null) {
            // If article frag is available, we're in two-pane layout...

            // Call a method in the ArticleFragment to update its content
            articleFrag.updateArticleView(position)

        } else {
            // If the frag is not available, we're in the one-pane layout and must swap frags...

            // Create fragment and give it an argument for the selected article
            val newFragment = ArticleFragment()
            val args = Bundle()
            args.putInt(ArticleFragment.ARG_POSITION, position)
            newFragment.arguments = args
            val transaction = supportFragmentManager.beginTransaction()

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.fragment_container, newFragment)
            transaction.addToBackStack(null)

            // Commit the transaction
            transaction.commit()
        }
    }
}