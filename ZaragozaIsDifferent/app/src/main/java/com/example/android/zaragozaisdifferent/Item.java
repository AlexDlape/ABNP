package com.example.android.zaragozaisdifferent;

/**
 * Created by alexd on 17/08/2018.
 */

/**
 * {@link Item} represents an item that the user  should visit.
 * It contains resource IDs for the title, description and
 * optional image file for that item.
 */
public class Item {

    /**Awesome
     Good model class!
     All member variables are declared private and are being instantiated in the constructor. Also, you are including all needed getter methods for them.*/

    /** String resource ID for the title of the item */
    private int mTitle;

    /** String resource ID for the description of the item */
    private int mDescription;

    /** Image resource ID for the item */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this item */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new Item object.
     *
     * @param titleId is the string resource ID for the title of the item
     * @param descriptionId is the string resource Id for the description of the item
     */
    public Item (int titleId, int descriptionId) {
        mTitle = titleId;
        mDescription = descriptionId;
    }

    /**
     * Create a new Item object.
     *
     * @param titleId is the string resource ID for the title of the item
     * @param descriptionId is the string resource Id for the description of the item
     * @param imageResourceId is the drawable resource ID for the image associated with the item
     */
    public Item(int titleId, int descriptionId, int imageResourceId) {
        mTitle = titleId;
        mDescription = descriptionId;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the string resource ID for the default translation of the word.
     */
    public int getTitleId() {
        return mTitle;
    }

    /**
     * Get the string resource ID for the Miwok translation of the word.
     */
    public int getDescriptionId() {
        return mDescription;
    }

    /**
     * Return the image resource ID of the word.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
