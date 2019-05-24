package com.example.android.inventoryappstage2.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by alexd on 20/08/2018.
 */

public final class BookContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private BookContract() {}

    /**
     * The "Content authority" is a name for the entire content provider, similar to the
     * relationship between a domain name and its website.  A convenient string to use for the
     * content authority is the package name for the app, which is guaranteed to be unique on the
     * device.
     */
    public static final String CONTENT_AUTHORITY = "com.example.android.inventoryappstage2";

    /**
     * Use CONTENT_AUTHORITY to create the base of all URI's which apps will use to contact
     * the content provider.
     */
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    /**
     * Possible path (appended to base content URI for possible URI's)
     * For instance, content://com.example.android.pets/pets/ is a valid path for
     * looking at pet data. content://com.example.android.pets/staff/ will fail,
     * as the ContentProvider hasn't been given any information on what to do with "staff".
     */
    public static final String PATH_BOOKS = "books";

    /**
     * Inner class that defines constant values for the pets database table.
     * Each entry in the table represents a single book.
     */
    public static final class BookEntry implements BaseColumns {

        /** The content URI to access the book data in the provider */
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_BOOKS);

        /**
         * The MIME type of the {@link #CONTENT_URI} for a list of books.
         */
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_BOOKS;

        /**
         * The MIME type of the {@link #CONTENT_URI} for a single book.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_BOOKS;

        /** Name of database table for books */
        public final static String TABLE_NAME = "books";

        /**
         * Unique ID number for the book (only for use in the database table).
         *
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * Title of the book.
         *
         * Type: TEXT
         */
        public final static String COLUMN_BOOK_TITLE ="title";

        /**
         * Author of the book.
         *
         * Type: TEXT
         */
        public final static String COLUMN_BOOK_AUTHOR = "author";

        /**
         * Literary Genre of the book.
         *
         *
         * Type: INTEGER (in the app I want to show a STRING)
         */
        public final static String COLUMN_BOOK_GENRE = "genre";

        /**
         * Unit price of the book.
         *
         * Type: DOUBLE
         */
        public final static String COLUMN_BOOK_PRICE = "price";

        /**
         * Quantity of books.
         *
         * Type: INTEGER
         */
        public final static String COLUMN_BOOK_QUANTITY = "quantity";

        /**
         * Name of the supplier.
         *
         * Type: TEXT
         */
        public final static String COLUMN_BOOK_SUPNAME = "supname";

        /**
         * Phone Number of the supplier.
         *
         * Type: INTEGER
         */
        public final static String COLUMN_BOOK_SUPPHONE = "supphone";


        /**
         * Possible values for the genre of the book.
         */
        public static final String GENRE_TRAGEDY = "Tragedy";
        public static final String GENRE_TRAGICCOMEDY = "Tragic Comedy";
        public static final String GENRE_FANTASY = "Fantasy";
        public static final String GENRE_MYTHOLOGY = "Mythology";
        public static final String GENRE_ADVENTURE = "Adventure";
        public static final String GENRE_MYSTERY = "Mystery";
        public static final String GENRE_SCIENCEFICTION = "Science Fiction";
        public static final String GENRE_DRAMA = "Drama";
        public static final String GENRE_ROMANCE = "Romance";
        public static final String GENRE_SATIRE = "Satire";
        public static final String GENRE_HORROR = "Horror";
        public static final String GENRE_OTHER = "Other";


        public static boolean isValidGenre(String genre) {
            if (genre == GENRE_TRAGEDY || genre == GENRE_TRAGICCOMEDY || genre == GENRE_FANTASY
                    || genre == GENRE_MYTHOLOGY || genre == GENRE_ADVENTURE || genre == GENRE_MYSTERY
                    || genre == GENRE_SCIENCEFICTION || genre == GENRE_DRAMA || genre == GENRE_ROMANCE
                    || genre == GENRE_SATIRE || genre == GENRE_HORROR || genre == GENRE_OTHER)  {
                return true;
            }
            return false;
        }
    }

}