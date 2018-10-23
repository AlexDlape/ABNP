package com.example.android.inventoryappstage2;

import android.app.AlertDialog;
import android.app.LoaderManager;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.android.inventoryappstage2.data.BookContract;

public class EditorActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final int EXISTING_BOOK_LOADER = 0;

    private Uri mCurrentBookUri;

    private EditText mTitleEditText;

    private EditText mAuthorEditText;

    private EditText mPriceEditText;

    private EditText mQuantityEditText;

    private EditText mSupnameEditText;

    private EditText mSupphoneEditText;

    public Spinner mGenreSpinner;

    public static String titleString;
    public static String authorString;
    public static String priceString;
    public static String quantityString;
    public static String supnameString;
    public static String supphoneString;


    public static String mGenre = BookContract.BookEntry.GENRE_OTHER;

    private boolean mBookHasChanged = false;

    private View.OnTouchListener mTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            mBookHasChanged = true;
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        Intent intent = getIntent();
        mCurrentBookUri = intent.getData();

        if (mCurrentBookUri == null) {

            setTitle(getString(R.string.editor_activity_title_new_product));

            invalidateOptionsMenu();
        } else {

            setTitle(getString(R.string.editor_activity_title_edit_product));

            getLoaderManager().initLoader(EXISTING_BOOK_LOADER, null, this);
        }

        mTitleEditText = findViewById(R.id.edit_book_title);
        mAuthorEditText = findViewById(R.id.edit_book_author);
        mGenreSpinner = findViewById(R.id.spinner_genre);
        mPriceEditText = findViewById(R.id.edit_book_price);
        mQuantityEditText = findViewById(R.id.edit_book_quantity);
        mSupnameEditText = findViewById(R.id.edit_book_suppliername);
        mSupphoneEditText = findViewById(R.id.edit_book_supplierphone);

        /**Suggestion
         Have you heard of ButterKnife library? It can dramatically reduce the amount of code you need to write when manipulating the views. I would encourage you to check it out.*/

        mTitleEditText.setOnTouchListener(mTouchListener);
        mAuthorEditText.setOnTouchListener(mTouchListener);
        mGenreSpinner.setOnTouchListener(mTouchListener);
        mPriceEditText.setOnTouchListener(mTouchListener);
        mQuantityEditText.setOnTouchListener(mTouchListener);
        mSupnameEditText.setOnTouchListener(mTouchListener);
        mSupphoneEditText.setOnTouchListener(mTouchListener);

        setupSpinner();
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }


    private void setupSpinner() {

        ArrayAdapter genreSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_genre_options, android.R.layout.simple_spinner_item);

        genreSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        mGenreSpinner.setAdapter(genreSpinnerAdapter);

        mGenreSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (position != 0) {
                        if (position == 1){
                            mGenre = BookContract.BookEntry.GENRE_TRAGEDY;
                        } else if (position == 2){
                            mGenre = BookContract.BookEntry.GENRE_TRAGICCOMEDY;
                        } else if (position == 3){
                            mGenre = BookContract.BookEntry.GENRE_FANTASY;
                        } else if (position == 4){
                            mGenre = BookContract.BookEntry.GENRE_MYTHOLOGY;
                        } else if (position == 5){
                            mGenre = BookContract.BookEntry.GENRE_ADVENTURE;
                        } else if (position == 6){
                            mGenre = BookContract.BookEntry.GENRE_MYSTERY;
                        } else if (position == 7){
                            mGenre = BookContract.BookEntry.GENRE_SCIENCEFICTION;
                        } else if (position == 8){
                            mGenre = BookContract.BookEntry.GENRE_DRAMA;
                        } else if (position == 9){
                            mGenre = BookContract.BookEntry.GENRE_ROMANCE;
                        } else if (position == 10){
                            mGenre = BookContract.BookEntry.GENRE_SATIRE;
                        } else if (position == 11){
                            mGenre = BookContract.BookEntry.GENRE_HORROR;
                        } else if (position == 12){
                            mGenre = BookContract.BookEntry.GENRE_HORROR;
                        }
                    }
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mGenre = BookContract.BookEntry.GENRE_OTHER;
            }
        });
    }

    private void saveBook() {

        ContentValues values = new ContentValues();
        values.put(BookContract.BookEntry.COLUMN_BOOK_GENRE, mGenre);

        values.put(BookContract.BookEntry.COLUMN_BOOK_TITLE, titleString);
        values.put(BookContract.BookEntry.COLUMN_BOOK_AUTHOR, authorString);
        values.put(BookContract.BookEntry.COLUMN_BOOK_PRICE, priceString);
        values.put(BookContract.BookEntry.COLUMN_BOOK_QUANTITY, quantityString);
        values.put(BookContract.BookEntry.COLUMN_BOOK_SUPNAME, supnameString);
        values.put(BookContract.BookEntry.COLUMN_BOOK_SUPPHONE, supphoneString);

        if (mCurrentBookUri == null) {

            Uri newUri = getContentResolver().insert(BookContract.BookEntry.CONTENT_URI, values);

            if (newUri == null) {
                Toast.makeText(this, getString(R.string.editor_insert_book_failed),
                        Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, getString(R.string.editor_insert_book_successful),
                        Toast.LENGTH_SHORT).show();
            }
        } else {

            int rowsAffected = getContentResolver().update(mCurrentBookUri, values, null, null);

            if (rowsAffected == 0) {
                Toast.makeText(this, getString(R.string.editor_update_product_failed),
                        Toast.LENGTH_SHORT).show();
            } else {

                Intent i = new Intent(EditorActivity.this, CatalogActivity.class);

                i.setData(mCurrentBookUri);

                startActivity(i);

                Toast.makeText(this, getString(R.string.editor_update_product_successful),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);

        if (mCurrentBookUri == null) {
            MenuItem menuItem = menu.findItem(R.id.action_delete);
            menuItem.setVisible(false);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_save:
                titleString = mTitleEditText.getText().toString().trim();
                authorString = mAuthorEditText.getText().toString().trim();
                priceString = mPriceEditText.getText().toString().trim();
                quantityString = mQuantityEditText.getText().toString().trim();
                supnameString = mSupnameEditText.getText().toString().trim();
                supphoneString = mSupphoneEditText.getText().toString().trim();

                /**Awesome
                 All the Validations work perfectly*/

                if (!TextUtils.isEmpty(titleString) && !TextUtils.isEmpty(authorString)
                        && !TextUtils.isEmpty(priceString) && !TextUtils.isEmpty(quantityString)
                        && !TextUtils.isEmpty(supnameString) && !TextUtils.isEmpty(supphoneString)) {

                    saveBook();
                    finish();
                    return true;

                } else {
                    Toast.makeText(this, getString(R.string.editor_insert_book_failed),
                            Toast.LENGTH_SHORT).show();
                    break;
                }
            case R.id.action_delete:
                showDeleteConfirmationDialog();
                return true;

            case android.R.id.home:
                if (!mBookHasChanged) {
                    NavUtils.navigateUpFromSameTask(EditorActivity.this);
                    return true;
                }

                DialogInterface.OnClickListener discardButtonClickListener =
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                NavUtils.navigateUpFromSameTask(EditorActivity.this);
                            }
                        };

                showUnsavedChangesDialog(discardButtonClickListener);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (!mBookHasChanged) {
            super.onBackPressed();
            return;
        }

        DialogInterface.OnClickListener discardButtonClickListener =
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                };

        showUnsavedChangesDialog(discardButtonClickListener);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {

        String[] projection = {
                BookContract.BookEntry._ID,
                BookContract.BookEntry.COLUMN_BOOK_TITLE,
                BookContract.BookEntry.COLUMN_BOOK_AUTHOR,
                BookContract.BookEntry.COLUMN_BOOK_GENRE,
                BookContract.BookEntry.COLUMN_BOOK_PRICE,
                BookContract.BookEntry.COLUMN_BOOK_QUANTITY,
                BookContract.BookEntry.COLUMN_BOOK_SUPNAME,
                BookContract.BookEntry.COLUMN_BOOK_SUPPHONE};

        return new CursorLoader(this,
                mCurrentBookUri,
                projection,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (cursor == null || cursor.getCount() < 1) {
            return;
        }

        if (cursor.moveToFirst()) {
            int titleColumnIndex = cursor.getColumnIndex(BookContract.BookEntry.COLUMN_BOOK_TITLE);
            int authorColumnIndex = cursor.getColumnIndex(BookContract.BookEntry.COLUMN_BOOK_AUTHOR);
            int genreColumnIndex = cursor.getColumnIndex(BookContract.BookEntry.COLUMN_BOOK_GENRE);
            int priceColumnIndex = cursor.getColumnIndex(BookContract.BookEntry.COLUMN_BOOK_PRICE);
            int quantityColumnIndex = cursor.getColumnIndex(BookContract.BookEntry.COLUMN_BOOK_QUANTITY);
            int supnameColumnIndex = cursor.getColumnIndex(BookContract.BookEntry.COLUMN_BOOK_SUPNAME);
            int supphoneColumnIndex = cursor.getColumnIndex(BookContract.BookEntry.COLUMN_BOOK_SUPPHONE);

            String title = cursor.getString(titleColumnIndex);
            String author = cursor.getString(authorColumnIndex);
            Double price = cursor.getDouble(priceColumnIndex);
            int quantity = cursor.getInt(quantityColumnIndex);
            String supName = cursor.getString(supnameColumnIndex);
            int supPhone = cursor.getInt(supphoneColumnIndex);

            mTitleEditText.setText(title);
            mAuthorEditText.setText(author);
            mPriceEditText.setText(Double.toString(price));
            mQuantityEditText.setText(Integer.toString(quantity));
            mSupnameEditText.setText(supName);
            mSupphoneEditText.setText(Integer.toString(supPhone));

        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

        mTitleEditText.setText("");
        mAuthorEditText.setText("");
        mGenreSpinner.setSelection(0);
        mPriceEditText.setText("");
        mQuantityEditText.setText("");
        mSupnameEditText.setText("");
        mSupphoneEditText.setText("");

    }

    private void showUnsavedChangesDialog(
            DialogInterface.OnClickListener discardButtonClickListener) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.unsaved_changes_dialog_msg);
        builder.setPositiveButton(R.string.discard, discardButtonClickListener);
        builder.setNegativeButton(R.string.keep_editing, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
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

        /**Suggestion
         Good job asking for confirmation before deleting the item from the database
         so you will avoid unpleasant surprises to the user if he hits this button by error. */

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void deleteBook() {
        if (mCurrentBookUri != null) {

            int rowsDeleted = getContentResolver().delete(mCurrentBookUri, null, null);

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
