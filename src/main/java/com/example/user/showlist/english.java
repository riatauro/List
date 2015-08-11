package com.example.user.showlist;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class english extends Activity implements
        AdapterView.OnItemClickListener {

    public static final String[] titles = {"AXN",
    "Comedy Central",
            "Star Movies",
            "Star World",
            "HBO",
            "Food Food",
            "WB",
            "World Movies",
            "VH1"
};


   /* public static final String[] descriptions = new String[] {
            "Countries in Asia",
            "Countries in Africa" };*/

    public static final Integer[] images ={R.drawable.t3,
            R.drawable.i77,
            R.drawable.i66,
            R.drawable.i44,
            R.drawable.i88,
            R.drawable.i99,
            R.drawable.i55,
            R.drawable.i22,
            R.drawable.i11
    };
    public static final Integer[] codes={890,888};

    ListView listView;
    List<MyAdapter1> rowItems;



    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);



        rowItems = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            MyAdapter1 item = new MyAdapter1(images[i], titles[i]);
            rowItems.add(item);
        }

        listView = (ListView) findViewById(R.id.list);
        CustomListViewAdapter adapter = new CustomListViewAdapter(this,
                R.layout.row_layout, rowItems);



        listView.setAdapter(adapter);
        int startIndex;
        if(savedInstanceState == null)
            startIndex = 0;
        else
            startIndex = savedInstanceState.getInt("scrollPos");
        listView.setSelectionFromTop(startIndex,0);
        listView.setOnItemClickListener(this);



    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("scrollPos", listView.getFirstVisiblePosition());
        super.onSaveInstanceState(savedInstanceState);
    }





    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        showCustomDialog(position);


    }

    protected void showCustomDialog(final int position) {
        // TODO Auto-generated method stub
        final Dialog dialog = new Dialog(english.this);
        dialog.setTitle("Enter today's date");
        dialog.setContentView(R.layout.customdialog);

        final EditText editText = (EditText)dialog.findViewById(R.id.editText1);
        Button button = (Button)dialog.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // TODO Auto-generated method stub


                EditText edit=(EditText)dialog.findViewById(R.id.editText1);
                String text=edit.getText().toString();
                Intent intent;
                intent = new Intent(getApplicationContext(),Show11.class);
                intent.putExtra("value",2);
                intent.putExtra("pos",position);
                intent.putExtra("Tag",text);
                startActivity(intent);
            }


        });






        dialog.show();

    }


}
