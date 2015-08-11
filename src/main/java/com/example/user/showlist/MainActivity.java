package com.example.user.showlist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends Activity {
    GridView grid;
    String[] web = {
            "HINDI",
            "ENGLISH",
            "NEWS",
            "SPORTS",
            "MUSIC",
            "CARTOONS",


    } ;
    int[] imageId = {
            R.drawable.r1,
            R.drawable.r2,
            R.drawable.r3,
            R.drawable.r6,
            R.drawable.r5,
            R.drawable.r4,

    };
      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomGrid adapter = new CustomGrid(MainActivity.this, web, imageId);
        grid=(GridView)findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
               if(position==0)
               {
                   Intent intent = new Intent(getApplicationContext(), Another.class);

                   startActivity(intent);
               }
                if(position==1)
                {
                    Intent intent = new Intent(getApplicationContext(), english.class);

                    startActivity(intent);
                }
                if(position==2)
                {
                    Intent intent = new Intent(getApplicationContext(), new1.class);

                    startActivity(intent);
                }
                if(position==3)
                {
                    Intent intent = new Intent(getApplicationContext(), sports.class);

                    startActivity(intent);
                }
                if(position==4)
                {
                    Intent intent = new Intent(getApplicationContext(), music.class);

                    startActivity(intent);
                }

                if(position==5)
                {
                    Intent intent = new Intent(getApplicationContext(), cartoon.class);

                    startActivity(intent);
                }
            }
        });

    }

}