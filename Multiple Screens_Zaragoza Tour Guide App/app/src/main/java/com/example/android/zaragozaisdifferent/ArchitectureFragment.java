package com.example.android.zaragozaisdifferent;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * {@link Fragment} that displays a list of number vocabulary words.
 */
public class ArchitectureFragment extends Fragment {

    public ArchitectureFragment() {
    // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        // Create a list of words
        final ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item(R.string.arch_one, R.string.arch_d_one,
                R.drawable.arch_one));
        items.add(new Item(R.string.arch_two, R.string.arch_d_two,
                R.drawable.arch_two));
        items.add(new Item(R.string.arch_three, R.string.arch_d_three,
                R.drawable.arch_three));
        items.add(new Item(R.string.arch_four, R.string.arch_d_four,
                R.drawable.arch_four));
        items.add(new Item(R.string.arch_five, R.string.arch_d_five,
                R.drawable.arch_five));

        // Create an {@link ItemAdapter}, whose data source is a list of {@link Item}s. The
        // adapter knows how to create list items for each item in the list.
        ItemAdapter adapter = new ItemAdapter(getActivity(), items, R.color.colorLightPrimary);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        return rootView;
    }}
