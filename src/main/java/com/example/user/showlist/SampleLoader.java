package com.example.user.showlist;

import android.content.AsyncTaskLoader;
import android.content.ContentValues;
import android.content.Context;
import android.net.ParseException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by User on 6/3/2015.
 */
public class SampleLoader extends AsyncTaskLoader<ArrayList<Actors>> {
    String url;
    ArrayList<Actors> actorsList;
    public SampleLoader(Context context, String url1) {

        super(context);
        url=url1;


    }







    @Override
    public ArrayList<Actors> loadInBackground() {
        actorsList=new ArrayList<Actors>();
        ContentValues values = new ContentValues();
        try {

            //------------------>>
            HttpGet httppost = new HttpGet(url);
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response = httpclient.execute(httppost);

            // StatusLine stat = response.getStatusLine();
            int status = response.getStatusLine().getStatusCode();

            if (status == 200) {
                HttpEntity entity = response.getEntity();
                String data = EntityUtils.toString(entity);


                JSONObject jsono = new JSONObject(data);
                JSONArray jarray = jsono.getJSONArray("listOfShows");


                    for (int i = 0; i < jarray.length(); i++) {
                    JSONObject object = jarray.getJSONObject(i);
                    Actors actor = new Actors();






                    actor.setName(object.getString("showTitle"));
                    actor.setDescription(object.getString("showTime"));
                        actor.setImage(object.getString("showThumb"));




                    actorsList.add(actor);


                }

                return actorsList;

            }


        } catch (ParseException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;

            }
}