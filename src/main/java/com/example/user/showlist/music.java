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

public class music extends Activity implements
        AdapterView.OnItemClickListener {

    public static final String[] titles = { "9XM","B4U MUSIC","BINDAAS PLAY","MUSIC EXPRESS","MTV","VH1","ZOOM"};

   /* public static final String[] descriptions = new String[] {
            "Countries in Asia",
            "Countries in Africa" };*/

    public static final Integer[] images = { R.drawable.pic1,
            R.drawable.b4u,R.drawable.bindaas,R.drawable.music,R.drawable.mtv,R.drawable.vh1,R.drawable.zoom};
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
        listView.setOnItemClickListener(this);



    }




    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        showCustomDialog(position);


    }

    protected void showCustomDialog(final int position) {
        // TODO Auto-generated method stub
        final Dialog dialog = new Dialog(music.this);
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
                intent.putExtra("pos",(position+42));
                intent.putExtra("Tag",text);
                startActivity(intent);
            }


        });






        dialog.show();

    }


}

 /*   @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {



        Toast toast = Toast.makeText(getApplicationContext(),
                "You Selected"+ (position + 1) + ": " + rowItems.get(position),
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }*/

