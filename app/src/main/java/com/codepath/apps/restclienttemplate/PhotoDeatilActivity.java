package com.codepath.apps.restclienttemplate;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

public class PhotoDeatilActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_deatil);

        ImageView ivImage = (ImageView) findViewById(R.id.imageView);
        ImageLoader imageLoader = ImageLoader.getInstance();
        ivImage.setImageResource(android.R.color.transparent);
        imageLoader.displayImage(getIntent().getExtras().getString("PHOTO_URL"), ivImage);

        TextView title = (TextView) findViewById(R.id.textView);
        title.setText(getIntent().getExtras().getString("PHOTO_NAME"));
    }
}
