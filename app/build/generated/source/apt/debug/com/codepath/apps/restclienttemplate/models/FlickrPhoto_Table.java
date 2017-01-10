package com.codepath.apps.restclienttemplate.models;

import com.raizlabs.android.dbflow.runtime.BaseContentProvider.PropertyConverter;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.language.property.BaseProperty;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import java.lang.IllegalArgumentException;
import java.lang.String;

/**
 * This is generated code. Please do not modify */
public final class FlickrPhoto_Table {
  public static final PropertyConverter PROPERTY_CONVERTER = new PropertyConverter(){ 
  public IProperty fromName(String columnName) {
  return com.codepath.apps.restclienttemplate.models.FlickrPhoto_Table.getProperty(columnName); 
  }
  };

  public static final Property<String> uid = new Property<String>(FlickrPhoto.class, "uid");

  public static final Property<String> name = new Property<String>(FlickrPhoto.class, "name");

  public static final Property<String> url = new Property<String>(FlickrPhoto.class, "url");

  public static final IProperty[] getAllColumnProperties() {
    return new IProperty[]{uid,name,url};
  }

  public static BaseProperty getProperty(String columnName) {
    columnName = QueryBuilder.quoteIfNeeded(columnName);
    switch (columnName)  {
      case "`uid`":  {
        return uid;
      }
      case "`name`":  {
        return name;
      }
      case "`url`":  {
        return url;
      }
      default:  {
        throw new IllegalArgumentException("Invalid column name passed. Ensure you are calling the correct table's column");
      }
    }
  }
}
