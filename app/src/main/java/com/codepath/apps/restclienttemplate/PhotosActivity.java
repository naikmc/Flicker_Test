package com.codepath.apps.restclienttemplate;

import com.codepath.apps.restclienttemplate.models.FlickrPhoto;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class PhotosActivity extends Activity {

    FlickrClient client;

    ArrayList<FlickrPhoto> photoItems;

    GridView gvPhotos;

    PhotoArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);
        client = FlickrClientApp.getRestClient();
        photoItems = new ArrayList<FlickrPhoto>();
        gvPhotos = (GridView) findViewById(R.id.gvPhotos);
        adapter = new PhotoArrayAdapter(this, photoItems);
        gvPhotos.setAdapter(adapter);
        gvPhotos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PhotoArrayAdapter.PhotoMetaData photoData = (PhotoArrayAdapter.PhotoMetaData) view.getTag();
                Intent i = new Intent(PhotosActivity.this, PhotoDeatilActivity.class);
                i.putExtra("PHOTO_URL" , photoData.getUrl());
                i.putExtra("PHOTO_NAME" , photoData.getTitle());
                startActivity(i);
            }
        });
        loadPhotos();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.photos, menu);
        return true;
    }

    public void loadPhotos() {
        client.getInterestingnessList(new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers,
                    JSONObject json) {
                Log.d("DEBUG", "result: " + json.toString());
                // Add new photos to SQLite
                try {
                    JSONArray photos = json.getJSONObject("photos").getJSONArray("photo");
                    for (int x = 0; x < photos.length(); x++) {
                        String uid = photos.getJSONObject(x).getString("id");
                        FlickrPhoto p = FlickrPhoto.byPhotoUid(uid);
                        if (p == null) {
                            p = new FlickrPhoto(photos.getJSONObject(x));
                        }

                        p.save();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.e("debug", e.toString());
                }

                // Load into GridView from DB
                for (FlickrPhoto p : FlickrPhoto.recentItems()) {
                    adapter.add(p);
                }
                Log.d("DEBUG", "Total: " + photoItems.size());
            }
        });
    }

}
