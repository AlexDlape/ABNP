package com.example.android.zaragozaisdifferent;

/**
 * Created by alexd on 17/08/2018.
 */

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link ItemAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Item} objects.
 */
public class ItemAdapter extends ArrayAdapter<Item>  {

    /** Resource ID for the background color for this list of items */
    private int mColorResourceId;

    /**
     * Create a new {@link ItemAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param items is the list of {@link Item}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of items
     */
    public ItemAdapter(Context context, ArrayList<Item> items, int colorResourceId) {
        super(context, 0, items);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {

            /**Suggestion
             You don't need to create another View object, you could use convertViewdirectly as follows:
             if(convertView == null){
             The reason is simple, both references are pointing to the same object.
             You can have more information about how references work at this link.*/

            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Item currentItem = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view.
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title_text_view);
        // Get the Miwok translation from the currentWord object and set this text on
        // the Miwok TextView.
        titleTextView.setText(currentItem.getTitleId());

        // Find the TextView in the list_item.xml layout with the ID default_text_view.
        TextView descriptionTextView = (TextView) listItemView.findViewById(R.id.description_text_view);
        // Get the default translation from the currentWord object and set this text on
        // the default TextView.
        descriptionTextView.setText(currentItem.getDescriptionId());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Check if an image is provided for this word or not
        if (currentItem.hasImage()) {

            /**Awesome
             Good job checking if the image exists before trying to retrieve it, this way the app won't crash if some attraction doesn't have an available image.*/

            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentItem.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}

/**Suggestion
 For next projects, if you want to improve your lists you can implement the ViewHolder pattern in your adapter.
 The reason is that if your code call findViewByid() frequently during the ListView scrolling, this will slow down its performance.
 Creating a ViewHolder the objects will only be instantiated once, since every time we call thegetView() method, the ViewHolder created in the first call will be reused.
 You can have more information in the Oficial Android Documentation*/