package com.raizlabs.android.dbflow.config;

import com.codepath.apps.restclienttemplate.MyDatabase;
import com.codepath.apps.restclienttemplate.models.FlickrPhoto;
import com.codepath.apps.restclienttemplate.models.FlickrPhoto_Adapter;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;

/**
 * This is generated code. Please do not modify */
public final class MyDatabaseRestClientDatabase_Database extends DatabaseDefinition {
  public MyDatabaseRestClientDatabase_Database(DatabaseHolder holder) {
    holder.putDatabaseForTable(FlickrPhoto.class, this);
    models.add(FlickrPhoto.class);
    modelTableNames.put("FlickrPhoto", FlickrPhoto.class);
    modelAdapters.put(FlickrPhoto.class, new FlickrPhoto_Adapter(holder, this));
  }

  @Override
  public final Class getAssociatedDatabaseClassFile() {
    return MyDatabase.class;
  }

  @Override
  public final boolean isForeignKeysSupported() {
    return false;
  }

  @Override
  public final boolean isInMemory() {
    return false;
  }

  @Override
  public final boolean backupEnabled() {
    return false;
  }

  @Override
  public final boolean areConsistencyChecksEnabled() {
    return false;
  }

  @Override
  public final int getDatabaseVersion() {
    return 1;
  }

  @Override
  public final String getDatabaseName() {
    return "RestClientDatabase";
  }
}
