package com.example.lin.testapplication.contentprovider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.CancellationSignal;
import android.support.annotation.Nullable;

import com.example.lin.testapplication.db.MyDBOpenHelper;

/**
 * Created by 101912 on 2017/7/27.
 */

public class MyContentProvider extends ContentProvider {

    private MyDBOpenHelper dbOpenHelper;
    private static final UriMatcher MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
    private static final int PERSONS = 1;
    private static final int PERSON = 2;
    static {
        MATCHER.addURI("com.example.lin.testapplication.contentprovider.MyContentProvider", "person", PERSONS);
        MATCHER.addURI("com.example.lin.testapplication.contentprovider.MyContentProvider", "person/#", PERSON);
    }

    UriMatcher uriMatcher;
    public MyContentProvider() {
        super();
    }

    @Override
    public boolean onCreate() {
        this.dbOpenHelper = new MyDBOpenHelper(this.getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        switch (MATCHER.match(uri)) {
            case PERSONS:
                return db.query("person", projection, selection, selectionArgs, null, null, sortOrder);

            case PERSON:
                long id = ContentUris.parseId(uri);
                String where = "_id =" + id;
                if (selection != null && !"".equals(selection)) {
                    where = selection + " and " + where;
                }
                return db.query("person/#", projection, where, selectionArgs, null, null, sortOrder);

            default:
                throw new IllegalArgumentException("Unkown Uri:" + uri.toString());
        }

    }


    @Nullable
    @Override
    public String getType(Uri uri) {
        switch (MATCHER.match(uri)) {
            case PERSONS:
                return "vnd.android.cursor.dir/person";

            case PERSON:
                return "vnd.android.cursor.item/person";

            default:
                throw new IllegalArgumentException("Unkwon Uri:" + uri.toString());
        }
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        int count = 0;
        switch (MATCHER.match(uri)) {
            case PERSONS:
                count = db.update("person", values, selection, selectionArgs);
                return count;
            case PERSON:
                long id = ContentUris.parseId(uri);
                String where = "_id=" + id;
                if (selection != null && !"".equals(selection)) {
                    where = selection + " and " + where;
                }
                count = db.update("person", values, where, selectionArgs);
                return count;
            default:
                throw new IllegalArgumentException("Unkwon Uri:" + uri.toString());
        }
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        int count = 0;
        switch (MATCHER.match(uri)) {
            case PERSONS:
                count = db.delete("person", selection, selectionArgs);
                return count;

            case PERSON:
                long id = ContentUris.parseId(uri);
                String where = "_id=" + id;
                if (selection != null && !"".equals(selection)) {
                    where = selection + " and " + where;
                }
                count = db.delete("person", where, selectionArgs);
                return count;

            default:
                throw new IllegalArgumentException("Unkwon Uri:" + uri.toString());
        }
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        switch (MATCHER.match(uri)) {
            case PERSONS:
                // 特别说一下第二个参数是当name字段为空时，将自动插入一个NULL。
                long rowid = db.insert("person", "name", values);
                Uri insertUri = ContentUris.withAppendedId(uri, rowid);// 得到代表新增记录的Uri
                this.getContext().getContentResolver().notifyChange(uri, null);
                return insertUri;

            default:
                throw new IllegalArgumentException("Unkwon Uri:" + uri.toString());
        }
    }
}
