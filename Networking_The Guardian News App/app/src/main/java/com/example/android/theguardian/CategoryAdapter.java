package com.example.android.theguardian;

/**
 * Created by alexd on 17/08/2018.
 */

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * {@link CategoryAdapter} is a {@link FragmentPagerAdapter} that can provide the menu to swap between different screens.
 */
public class CategoryAdapter extends FragmentPagerAdapter {

    /** Context of the app */
    private Context mContext;

    /**
     * Create a new {@link CategoryAdapter} object.
     *
     * @param context is the context of the app
     * @param fm is the fragment manager that will keep each fragment's state in the adapter
     *           across swipes.
     */
    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new BusinessFragment();
        } else if (position == 1) {
            return new PoliticsFragment();
        } else if (position == 2) {
            return new TechnologyFragment();
        } else {
            return new SportsFragment();
        }
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_business);
        } else if (position == 1) {
            return mContext.getString(R.string.category_politics);
        } else if (position == 2) {
            return mContext.getString(R.string.category_technology);
        } else {
            return mContext.getString(R.string.category_sports);
        }
    }
}
