package com.example.android.drumbass;

/**
 * Created by alexd on 27/07/2018.
 */

public class Song {

    /**Awesome
     Good POJO (Plain Old Java Object) model object here! Objects are key to Object Oriented Programming, so it’s great to see that you’ve got a good handle on writing them.
     If you’d like to learn more about Objects and the role they play in OOP check out the docs here, it’s a nice read!*/

    /** Title of the song */
    private String mTitle;

    /** Name of the artist */
    private String mArtist;

    /** Album the song belongs to */
    private String mSongsAlbum;

    /** Image resource ID for the song */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this song */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**Awesome
     Good and appropriate choice of access modifiers but being an important topic you might want to dive in deep on the subject: https://www.javatpoint.com/access-modifiers*/

    /**
     * Create a new Song object.
     */
    public Song(String title, String artist, String album) {
        mTitle = title;
        mSongsAlbum = album;
        mArtist = artist;
    }

    /**
     * Create a new Song object.
     */
    public Song(String title, String album, String artist, int imageResourceId) {
        mTitle = title;
        mArtist = artist;
        mSongsAlbum = album;
        mImageResourceId = imageResourceId;
    }

    /**Awesome
     Awesome! it's glad to see that our students are following the best practices of Android development, in this case the m prefix before the name of the variable imply that those variables are member variables of this class. By doing that we're able to know that these variables are member variables in any part of our code, just seeing them and we will know about it.
     If you want to know more about this and other best practices for Android development, check out this reference. */

    /**
     * Get the name of the song.
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Get the name of the artist.
     */
    public String getArtist() {
        return mArtist;
    }

    /**
     * Get the name of the album.
     */
    public String getAlbum() {
        return mSongsAlbum;
    }

    /**
     * Return the image resource ID of the album.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**Awesome
     Great work implementing the getters needed and hiding the setters that won't be used.
     I'll take this opportunity to forward an valuable article for reflection on how dangerous getters can be either.*/

    /**
     * Returns whether or not there is an image for this album.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
