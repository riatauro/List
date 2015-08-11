package com.example.user.showlist;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User on 6/3/2015.
 */
public class Show11 extends Activity implements LoaderManager.LoaderCallbacks<ArrayList<Actors>>{
    int pos,value;
    String text,url;
    String[] array;

    private static final int THE_LOADER = 0x01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int startIndex;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        array=getResources().getStringArray(R.array.show_names);
        Intent intent = getIntent();
        value=intent.getIntExtra("value",0);
        pos = intent.getIntExtra("pos", 0);
         text = intent.getExtras().getString("Tag");
        url ="http://indian-television-guide.appspot.com/indian_television_guide?channel="+array[pos]+"&date="+text;


        getLoaderManager().initLoader(0, null, this).forceLoad();


    }

    @Override
    public Loader<ArrayList<Actors>> onCreateLoader(int id, Bundle args) {
        SampleLoader loader = new SampleLoader(this,url);
        return loader;
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<Actors>> loader, ArrayList<Actors> data) {
        ListView listview = (ListView)findViewById(R.id.list);
        Adapter adapter = new Adapter(this, R.layout.row1, data);

        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(getApplicationContext(),SingleActivity.class);
               String name=((TextView)findViewById(R.id.tvName)).getText().toString();
                String time=((TextView)findViewById(R.id.description)).getText().toString();
                i.putExtra("name",name);
                i.putExtra("date",time);
                startActivity(i);


            } });



        }

    @Override
    public void onLoaderReset(Loader<ArrayList<Actors>> loader) {
        ListView listview = (ListView) findViewById(R.id.list);
        listview.setAdapter(null);

    }
}