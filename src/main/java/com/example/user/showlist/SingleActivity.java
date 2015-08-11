package com.example.user.showlist;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.widget.TextView;

public class SingleActivity extends FragmentActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    TextView result=null;
    CursorLoader cursorLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single);
        Intent intent=getIntent();
       String name= intent.getStringExtra("name");
       String date=intent.getStringExtra("date");
        ContentValues values = new ContentValues();
        values.put(MyProvider.name, name);
        values.put(MyProvider.date, date);
        Uri uri = getContentResolver().insert(MyProvider.CONTENT_URI, values);
        result= (TextView) findViewById(R.id.text1);
        getSupportLoaderManager().initLoader(1,null,this).forceLoad();
    }




    @Override
    public Loader<Cursor> onCreateLoader(int arg0, Bundle arg1) {
        cursorLoader= new CursorLoader(this, Uri.parse("content://com.example.user.showlist.MyProvider/cte"), null, null, null, null);
        return cursorLoader;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> arg0, Cursor cursor) {
        cursor.moveToFirst();
        StringBuilder res=new StringBuilder();
        while (!cursor.isAfterLast()) {
            res.append("\n"+cursor.getString(cursor.getColumnIndex("name"))+ "-"+ cursor.getString(cursor.getColumnIndex("date")));
            cursor.moveToNext();
        }
        result.setText(res);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}