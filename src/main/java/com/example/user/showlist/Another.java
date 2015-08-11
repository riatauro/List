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

public class Another extends Activity implements
        AdapterView.OnItemClickListener {

    public static final String[] titles = { "COLORS","SONY","ZEE TV","STAR PLUS","LIFE OK","SONY MAX","ZEE CINEMA","9XM","CHANNEL V","MTV" };

   /* public static final String[] descriptions = new String[] {
            "Countries in Asia",
            "Countries in Africa" };*/

    public static final Integer[] images = { R.drawable.im1,
            R.drawable.i3,R.drawable.i2,R.drawable.i5,R.drawable.i4,R.drawable.im6,R.drawable.im7,R.drawable.image8,R.drawable.image9,R.drawable.im9};
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
        final Dialog dialog = new Dialog(Another.this);
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
                intent.putExtra("value",1);
                intent.putExtra("pos",(position+9));
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

