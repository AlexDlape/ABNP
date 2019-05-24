package com.example.android.theguardian;

/**
 * Created by alexd on 18/08/2018.
 */

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class NewsLoader extends android.support.v4.content.AsyncTaskLoader<List<News>> {

    /**Awesome
     Excellent you used AsyncTaskLoader which extends a Loader!
     To improve your knowledge about AsyncTaskLoader you can find a great deal of information on this link.*/

    private String mUrl;

    /**
     * New NewsLoader.
     *
     * @param context of the activity
     * @param url     url for
     */
    public NewsLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    // Background thread.

    @Override
    public List<News> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Make the network request and after extraction of list of news parse the response.
        List<News> News = null;
        try {
            News = Utils.fetchNewsData(mUrl);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return News;
    }
}
