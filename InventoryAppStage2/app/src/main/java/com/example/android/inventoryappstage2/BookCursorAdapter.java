package com.example.android.inventoryappstage2;

/**
 * Created by alexd on 20/08/2018.
 */

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.inventoryappstage2.data.BookContract;


public class BookCursorAdapter extends CursorAdapter {

    public BookCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    /**Suggestion
    You can dramatically increase the performance of your application by implementing the ViewHolder design pattern.
            https://developer.android.com/training/improving-layouts/smooth-scrolling*/

    @Override
    public void bindView(View view, final Context context, final Cursor cursor) {

        TextView titleTextView = (TextView) view.findViewById(R.id.title);
        TextView authorTextView = (TextView) view.findViewById(R.id.author);
        final TextView genreTextView = (TextView) view.findViewById(R.id.genre);
        TextView priceTextView = (TextView) view.findViewById(R.id.euros);
        final TextView quantityTextView = (TextView) view.findViewById(R.id.quantity);
        Button saleButton = (Button) view.findViewById(R.id.sell);
        Button orderButton = (Button) view.findViewById(R.id.order);

        int titleColumnIndex = cursor.getColumnIndex(BookContract.BookEntry.COLUMN_BOOK_TITLE);
        int authorColumnIndex = cursor.getColumnIndex(BookContract.BookEntry.COLUMN_BOOK_AUTHOR);
        final int genreColumnIndex = cursor.getColumnIndex(BookContract.BookEntry.COLUMN_BOOK_GENRE);
        int quantityColumnIndex = cursor.getColumnIndex(BookContract.BookEntry.COLUMN_BOOK_QUANTITY);
        final int quantity = cursor.getInt(cursor.getColumnIndexOrThrow(BookContract.BookEntry.COLUMN_BOOK_QUANTITY));
        int priceColumnIndex = cursor.getColumnIndex(BookContract.BookEntry.COLUMN_BOOK_PRICE);

        final String bookTitle = cursor.getString(titleColumnIndex);
        final String bookAuthor = cursor.getString(authorColumnIndex);
        final String bookGenre = cursor.getString(genreColumnIndex);
        final String bookPrice = cursor.getString(priceColumnIndex);
        final String bookQuantity = cursor.getString(quantityColumnIndex);

        final Uri uri = ContentUris.withAppendedId(BookContract.BookEntry.CONTENT_URI,
                cursor.getInt(cursor.getColumnIndexOrThrow(BookContract.BookEntry._ID)));

        titleTextView.setText(bookTitle);
        authorTextView.setText(bookAuthor);
        genreTextView.setText(bookGenre);
        priceTextView.setText(" " + bookPrice);
        quantityTextView.setText(" " + bookQuantity);

        saleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (quantity > 1) {
                    Integer afterSale = quantity - 1;

                    ContentValues values = new ContentValues();
                    values.put(BookContract.BookEntry.COLUMN_BOOK_QUANTITY, afterSale);
                    context.getContentResolver().update(uri, values, null, null);

                    quantityTextView.setText(afterSale.toString());
                }else if (quantity == 1) {
                    Integer afterSale = quantity - 1;

                    ContentValues values = new ContentValues();
                    values.put(BookContract.BookEntry.COLUMN_BOOK_QUANTITY, afterSale);
                    context.getContentResolver().update(uri, values, null, null);

                    Toast.makeText(context, R.string.book_last_stock, Toast.LENGTH_SHORT).show();

                    quantityTextView.setText(afterSale.toString());
                }else if (quantity == 0) {

                    Toast.makeText(context, R.string.book_out_of_stock, Toast.LENGTH_SHORT).show();;}
            }
        });
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (quantity == 0) {
                    Integer afterSale = quantity + 1;

                    ContentValues values = new ContentValues();
                    values.put(BookContract.BookEntry.COLUMN_BOOK_QUANTITY, afterSale);
                    context.getContentResolver().update(uri, values, null, null);

                    Toast.makeText(context, R.string.book_stock_again, Toast.LENGTH_SHORT).show();

                    quantityTextView.setText(afterSale.toString());
                }else if (quantity > 0) {
                    Integer afterSale = quantity + 1;

                    ContentValues values = new ContentValues();
                    values.put(BookContract.BookEntry.COLUMN_BOOK_QUANTITY, afterSale);
                    context.getContentResolver().update(uri, values, null, null);

                    quantityTextView.setText(afterSale.toString());}
            }
        });
    }
}
