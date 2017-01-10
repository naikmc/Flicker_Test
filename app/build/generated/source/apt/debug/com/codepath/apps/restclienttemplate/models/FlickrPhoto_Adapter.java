package com.codepath.apps.restclienttemplate.models;

import android.content.ContentValues;
import android.database.Cursor;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.DatabaseHolder;
import com.raizlabs.android.dbflow.sql.language.ConditionGroup;
import com.raizlabs.android.dbflow.sql.language.Method;
import com.raizlabs.android.dbflow.sql.language.Select;
import com.raizlabs.android.dbflow.sql.language.property.BaseProperty;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;

public final class FlickrPhoto_Adapter extends ModelAdapter<FlickrPhoto> {
  public FlickrPhoto_Adapter(DatabaseHolder holder, DatabaseDefinition databaseDefinition) {
    super(databaseDefinition);
  }

  @Override
  public final Class<FlickrPhoto> getModelClass() {
    return FlickrPhoto.class;
  }

  public final String getTableName() {
    return "`FlickrPhoto`";
  }

  @Override
  public final IProperty[] getAllColumnProperties() {
    return FlickrPhoto_Table.getAllColumnProperties();
  }

  @Override
  public final void bindToInsertValues(ContentValues values, FlickrPhoto model) {
    if (model.getUid() != null) {
      values.put(FlickrPhoto_Table.uid.getCursorKey(), model.getUid());
    } else {
      values.putNull(FlickrPhoto_Table.uid.getCursorKey());
    }
    if (model.getName() != null) {
      values.put(FlickrPhoto_Table.name.getCursorKey(), model.getName());
    } else {
      values.putNull(FlickrPhoto_Table.name.getCursorKey());
    }
    if (model.getUrl() != null) {
      values.put(FlickrPhoto_Table.url.getCursorKey(), model.getUrl());
    } else {
      values.putNull(FlickrPhoto_Table.url.getCursorKey());
    }
  }

  @Override
  public final void bindToContentValues(ContentValues values, FlickrPhoto model) {
    bindToInsertValues(values, model);
  }

  @Override
  public final void bindToInsertStatement(DatabaseStatement statement, FlickrPhoto model, int start) {
    if (model.getUid() != null) {
      statement.bindString(1 + start, model.getUid());
    } else {
      statement.bindNull(1 + start);
    }
    if (model.getName() != null) {
      statement.bindString(2 + start, model.getName());
    } else {
      statement.bindNull(2 + start);
    }
    if (model.getUrl() != null) {
      statement.bindString(3 + start, model.getUrl());
    } else {
      statement.bindNull(3 + start);
    }
  }

  @Override
  public final void bindToStatement(DatabaseStatement statement, FlickrPhoto model) {
    bindToInsertStatement(statement, model, 0);
  }

  @Override
  public final String getInsertStatementQuery() {
    return "INSERT INTO `FlickrPhoto`(`uid`,`name`,`url`) VALUES (?,?,?)";
  }

  @Override
  public final String getCompiledStatementQuery() {
    return "INSERT INTO `FlickrPhoto`(`uid`,`name`,`url`) VALUES (?,?,?)";
  }

  @Override
  public final String getCreationQuery() {
    return "CREATE TABLE IF NOT EXISTS `FlickrPhoto`(`uid` TEXT,`name` TEXT,`url` TEXT, PRIMARY KEY(`uid`)" + ");";
  }

  @Override
  public final void loadFromCursor(Cursor cursor, FlickrPhoto model) {
    int indexuid = cursor.getColumnIndex("uid");
    if (indexuid != -1 && !cursor.isNull(indexuid)) {
      model.setUid(cursor.getString(indexuid));
    } else {
      model.setUid(null);
    }
    int indexname = cursor.getColumnIndex("name");
    if (indexname != -1 && !cursor.isNull(indexname)) {
      model.setName(cursor.getString(indexname));
    } else {
      model.setName(null);
    }
    int indexurl = cursor.getColumnIndex("url");
    if (indexurl != -1 && !cursor.isNull(indexurl)) {
      model.setUrl(cursor.getString(indexurl));
    } else {
      model.setUrl(null);
    }
  }

  @Override
  public final boolean exists(FlickrPhoto model, DatabaseWrapper wrapper) {
    return new Select(Method.count()).from(FlickrPhoto.class).where(getPrimaryConditionClause(model)).count(wrapper) > 0;
  }

  @Override
  public final ConditionGroup getPrimaryConditionClause(FlickrPhoto model) {
    ConditionGroup clause = ConditionGroup.clause();
    clause.and(FlickrPhoto_Table.uid.eq(model.getUid()));return clause;
  }

  @Override
  public final FlickrPhoto newInstance() {
    return new FlickrPhoto();
  }

  @Override
  public final BaseProperty getProperty(String name) {
    return FlickrPhoto_Table.getProperty(name);
  }
}
