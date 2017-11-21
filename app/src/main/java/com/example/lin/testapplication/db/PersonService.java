package com.example.lin.testapplication.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.lin.testapplication.entity.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 101912 on 2017/7/27.
 */

public class PersonService {

    private MyDBOpenHelper dbOpenHelper;

    public PersonService(Context context) {
        dbOpenHelper = new MyDBOpenHelper(context);
    }

    public void onSave(Person person) {
        SQLiteDatabase database = dbOpenHelper.getWritableDatabase();
        database.execSQL("insert into person(name, age) values(?, ?)", new Object[]{person.getName(), person.getAge()});

    }

    public void onDelete(Integer id) {
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        db.execSQL("delete from person where _id = ?", new Object[]{id});
    }

    public Person onFind(Integer id) {
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from person where _id = ?", new String[]{id.toString()});
        if (cursor.moveToFirst()) {
            int idd = cursor.getInt(cursor.getColumnIndex("_id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String age = cursor.getString(cursor.getColumnIndex("age"));
            Person person = new Person();
            person.setId(idd);
            person.setName(name);
            person.setAge(age);
            return person;
        }
        return null;
    }

    public List<Person> onFindAll() {
        List<Person> persons = new ArrayList<Person>();
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from person", null);
        while (cursor.moveToNext()) {
            int idd = cursor.getInt(cursor.getColumnIndex("_id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String age = cursor.getString(cursor.getColumnIndex("age"));
            Person person = new Person();
            person.setId(idd);
            person.setName(name);
            person.setAge(age);
            persons.add(person);
        }
        if (persons.size() != 0)
            return persons;
        return null;
    }

}
