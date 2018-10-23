package com.example.android.inventoryappstage2;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.inventoryappstage2.data.BookContract;

public class DetailsActivity extends AppCompatActivity {

    Uri mCurrentUri;
    Uri mNewUri;

    Integer genre;
    Integer quantity;
    TextView titleTextView;
    TextView authorTextView;
    TextView priceTextView;
    TextView quantityTextView;
    TextView genreTextView;
    TextView supnameTextView;
    TextView supphoneTextView;

    Button editButton;
    Button deleteButton;
    Button callButton;

    Button minusButton;
    Button plusButton;

    public String bookSupphone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        mCurrentUri = intent.getData();

        Intent i = getIntent();
        mNewUri = i.getData();
        titleTextView = (TextView) findViewById(R.id.book_title);
        authorTextView = (TextView) findViewById(R.id.book_author);
        genreTextView = (TextView) findViewById(R.id.book_genre);
        priceTextView = (TextView) findViewById(R.id.book_price);
        quantityTextView = (TextView) findViewById(R.id.book_quantity);
        supnameTextView = (TextView) findViewById(R.id.book_supname);
        supphoneTextView = (TextView) findViewById(R.id.book_supphone);

        editButton = (Button) findViewById(R.id.edit_button);
        deleteButton = (Button) findViewById(R.id.delete_button);
        callButton = (Button) findViewById(R.id.call_button);

        minusButton = (Button) findViewById(R.id.minus_button);
        plusButton = (Button) findViewById(R.id.plus_button);

        Cursor c = managedQuery(mCurrentUri, null, null, null, "title");

        if (c.moveToFirst()) {
            do {
                String bookTitle = c.getString(c.getColumnIndex(BookContract.BookEntry.COLUMN_BOOK_TITLE));
                String bookAuthor = c.getString(c.getColumnIndex(BookContract.BookEntry.COLUMN_BOOK_AUTHOR));
                String bookGenre = c.getString(c.getColumnIndex(BookContract.BookEntry.COLUMN_BOOK_GENRE));
                String bookPrice = c.getString(c.getColumnIndex(BookContract.BookEntry.COLUMN_BOOK_PRICE));
                String bookQuantity = c.getString(c.getColumnIndex(BookContract.BookEntry.COLUMN_BOOK_QUANTITY));
                String bookSupname = c.getString(c.getColumnIndex(BookContract.BookEntry.COLUMN_BOOK_SUPNAME));
                bookSupphone = c.getString(c.getColumnIndex(BookContract.BookEntry.COLUMN_BOOK_SUPPHONE));
                genre = c.getInt(c.getColumnIndex(BookContract.BookEntry.COLUMN_BOOK_GENRE));
                quantity = c.getInt(c.getColumnIndex(BookContract.BookEntry.COLUMN_BOOK_QUANTITY));

                titleTextView.setText(" " + bookTitle);
                authorTextView.setText(" " + bookAuthor);
                priceTextView.setText(" " + bookPrice);
                genreTextView.setText(" " + bookGenre.toString());
                quantityTextView.setText(" " + bookQuantity);
                supnameTextView.setText(" " + bookSupname);
                supphoneTextView.setText(" " + bookSupphone);

            } while (c.moveToNext());
        }

        Cursor cNew = managedQuery(mNewUri, null, null, null, "title");

        if (cNew.moveToFirst()) {
            do {
                String bookTitle = cNew.getString(cNew.getColumnIndex(BookContract.BookEntry.COLUMN_BOOK_TITLE));
                String bookAuthor = cNew.getString(cNew.getColumnIndex(BookContract.BookEntry.COLUMN_BOOK_AUTHOR));
                String bookPrice = cNew.getString(cNew.getColumnIndex(BookContract.BookEntry.COLUMN_BOOK_PRICE));
                String bookQuantity = cNew.getString(cNew.getColumnIndex(BookContract.BookEntry.COLUMN_BOOK_QUANTITY));
                String bookGenre = cNew.getString(cNew.getColumnIndex(BookContract.BookEntry.COLUMN_BOOK_GENRE));
                String bookSupname = cNew.getString(cNew.getColumnIndex(BookContract.BookEntry.COLUMN_BOOK_SUPNAME));
                String bookSupphone = cNew.getString(cNew.getColumnIndex(BookContract.BookEntry.COLUMN_BOOK_SUPPHONE));
                genre = cNew.getInt(cNew.getColumnIndex(BookContract.BookEntry.COLUMN_BOOK_GENRE));
                quantity = cNew.getInt(cNew.getColumnIndex(BookContract.BookEntry.COLUMN_BOOK_QUANTITY));

                titleTextView.setText(" " + bookTitle);
                authorTextView.setText(" " + bookAuthor);
                priceTextView.setText(" " + bookPrice);
                quantityTextView.setText(" " + bookQuantity);
                genreTextView.setText(" " + bookGenre);
                supnameTextView.setText(" " + bookSupname);
                supphoneTextView.setText(" " + bookSupphone);

            } while (cNew.moveToNext());
        }

        editButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(DetailsActivity.this, EditorActivity.class);

                intent.setData(mCurrentUri);
                startActivity(intent);
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                if (quantity > 1) {

                    quantity = quantity - 1;

                    ContentValues values = new ContentValues();
                    values.put(BookContract.BookEntry.COLUMN_BOOK_QUANTITY, quantity);
                    getContentResolver().update(mCurrentUri, values, null, null);

                    quantityTextView.setText(quantity.toString());
                }else if (quantity == 1) {
                    quantity = quantity - 1;

                    ContentValues values = new ContentValues();
                    values.put(BookContract.BookEntry.COLUMN_BOOK_QUANTITY, quantity);
                    getContentResolver().update(mCurrentUri, values, null, null);

                    quantityTextView.setText(quantity.toString());
                    Toast.makeText(DetailsActivity.this, "This was the last in stock!", Toast.LENGTH_SHORT).show();
                }else if (quantity == 0) {

                    Toast.makeText(DetailsActivity.this, "Unsuccessful sale. Book out of stock", Toast.LENGTH_SHORT).show();
                    ;}
            }
        });

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (quantity < 100 && quantity != 0) {

                    quantity = quantity + 1;

                    ContentValues values = new ContentValues();
                    values.put(BookContract.BookEntry.COLUMN_BOOK_QUANTITY, quantity);
                    getContentResolver().update(mCurrentUri, values, null, null);
                    quantityTextView.setText(quantity.toString());
                }else if (quantity == 0) {
                    quantity = quantity + 1;

                    ContentValues values = new ContentValues();
                    values.put(BookContract.BookEntry.COLUMN_BOOK_QUANTITY, quantity);
                    getContentResolver().update(mCurrentUri, values, null, null);
                    quantityTextView.setText(quantity.toString());
                    Toast.makeText(DetailsActivity.this, "Book in stock again!", Toast.LENGTH_SHORT).show();;}
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDeleteConfirmationDialog();
            }
        });

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + bookSupphone));
                startActivity(intent);
            }
        });

    }

    private void showDeleteConfirmationDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.delete_dialog_msg);
        builder.setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                deleteBook();
            }
        });


        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void deleteBook() {
        if (mCurrentUri != null) {

            int rowsDeleted = getContentResolver().delete(mCurrentUri, null, null);

            if (rowsDeleted == 0) {

                Toast.makeText(this, getString(R.string.editor_delete_book_failed),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, getString(R.string.editor_delete_book_successful),
                        Toast.LENGTH_SHORT).show();
            }
        }

        finish();
    }

}
