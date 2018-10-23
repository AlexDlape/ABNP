package com.example.android.zaragozaisdifferent;

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
            return new ArchitectureFragment();
        } else if (position == 1) {
            return new ParksFragment();
        } else if (position == 2) {
            return new NightlifeFragment();
        } else {
            return new AragonFragment();
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
            return mContext.getString(R.string.category_architecture);
        } else if (position == 1) {
            return mContext.getString(R.string.category_parks);
        } else if (position == 2) {
            return mContext.getString(R.string.category_nightlife);
        } else {
            return mContext.getString(R.string.category_aragon);
        }
    }
}

/**Suggestion
 For these two methods, you could use a switch statement instead of the if/else statement for a cleaner code.
 See below an example code:
 @Override
 public CharSequence getPageTitle(int position) {
 switch (position) {
 case 0:
 return context.getString(R.string.category_hotels);
 case 1:
 return context.getString(R.string.category_attractions);
 case 2:
 return context.getString(R.string.category_techparks);
 default:
 return context.getString(R.string.category_malls);
 }
 }
 You can take a look at this link for more information about the switch/case statement.*/