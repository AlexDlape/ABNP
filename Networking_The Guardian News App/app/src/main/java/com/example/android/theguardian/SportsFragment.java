package com.example.android.theguardian;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.preference.ListPreference;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SportsFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<News>> {

    private static final String REQUEST_URL = "http://content.guardianapis.com/search?";
    private ProgressBar progressBar;
    private TextView emptyTextView;

    // Constant for the API search Key
    private static final String API_KEY = "api-key";

    // Constant value for the API Key
    private static final String KEY = "f5e1bbb0-68e1-4cdc-9fac-9484b0cb600c";

    public SportsFragment(){
        //Required empty constructor
    }

    public NewsAdapter newsAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        progressBar = rootView.findViewById(R.id.loading_info);
        emptyTextView = rootView.findViewById(R.id.noNews);

        ListView listView = rootView.findViewById(R.id.newsList);
        newsAdapter = new NewsAdapter(getActivity(), new ArrayList<News>());
        listView.setAdapter(newsAdapter);
        listView.setEmptyView(emptyTextView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                News currentNews = newsAdapter.getItem(position);

                Uri newsUri = Uri.parse(currentNews.getUrl());
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, newsUri);
                startActivity(websiteIntent);

            }
        });

        if(hasInternetAccess()){

            getLoaderManager().initLoader(NEWS_LOADER_ID, null, SportsFragment.this);

        }
        else{
            progressBar.setVisibility(View.GONE);
            emptyTextView.setText(R.string.no_internet_connection);
        }

        return rootView;

    }

    private static final int NEWS_LOADER_ID = 1;

    @Override
    public android.support.v4.content.Loader<List<News>> onCreateLoader(int i, Bundle bundle) {

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity());

        String orderBy = sharedPrefs.getString(
                getString(R.string.settings_order_by_key),
                getString(R.string.settings_order_by_default)
        );

        Uri baseUri = Uri.parse(REQUEST_URL);
        Uri.Builder uriBuilder = baseUri.buildUpon();
        uriBuilder.appendQueryParameter("section", "sport");
        uriBuilder.appendQueryParameter("show-tags", "contributor");
        uriBuilder.appendQueryParameter("order-by", orderBy);
        uriBuilder.appendQueryParameter(API_KEY, KEY);

        return new NewsLoader(getActivity(), uriBuilder.toString());
    }

    @Override
    public void onLoadFinished(android.support.v4.content.Loader<List<News>> loader, List<News> data) {
        newsAdapter.clear();

        if(data != null && !data.isEmpty()){
            newsAdapter.addAll(data);

        }else if (hasInternetAccess()==false) {
            emptyTextView.setText(R.string.no_internet_connection);
            progressBar.setVisibility(View.GONE);

        }else {
            emptyTextView.setText(R.string.no_news_found);
            progressBar.setVisibility(View.GONE);
        }
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onLoaderReset(android.support.v4.content.Loader<List<News>> loader) {
        newsAdapter.clear();
    }

    public boolean hasInternetAccess(){
        ConnectivityManager cm =
                (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        return isConnected;
    }

    @Override
    public void onResume() {
        super.onResume();

        // Get a reference to the LoaderManager, in order to interact with loaders.
        LoaderManager loaderManager = getLoaderManager();

        // Restart the loader. Pass in the int ID constant defined above and pass in null for
        // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
        // because this activity implements the LoaderCallbacks interface).//
        loaderManager.restartLoader(NEWS_LOADER_ID, null, this);
    }
}