package com.example.lin.testapplication.activity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.lin.testapplication.R;

/**
 * Created by 101912 on 2017/7/28.
 */

public class ResolverDemoActivity extends Activity {
    /** Called when the activity is first created. */
    private SimpleCursorAdapter adapter;
    private ListView listView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        listView=(ListView) this.findViewById(R.id.listView);
        ContentResolver contentResolver = getContentResolver();
        Uri selectUri = Uri.parse("content://com.example.lin.testapplication.contentprovider.MyContentProvider/person");
        Cursor cursor=contentResolver.query(selectUri, null, null, null, null);
        adapter = new SimpleCursorAdapter(this, R.layout.item, cursor,
                new String[]{"_id", "name", "age"}, new int[]{R.id.id, R.id.name, R.id.age});
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListView lView = (ListView)parent;
                Cursor data = (Cursor)lView.getItemAtPosition(position);
                int idd = data.getInt(data.getColumnIndex("_id"));
                Toast.makeText(ResolverDemoActivity.this, idd+"", Toast.LENGTH_LONG).show();
            }
        });

        Button button = (Button) this.findViewById(R.id.insertbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentResolver contentResolver = getContentResolver();
                Uri insertUri = Uri.parse("content://com.example.lin.testapplication.contentprovider.MyContentProvider");
                ContentValues values = new ContentValues();
                values.put("name", "wangkuifeng");
                values.put("age", 23);
                contentResolver.insert(insertUri, values);
                Toast.makeText(ResolverDemoActivity.this, "添加完成", Toast.LENGTH_LONG).show();
            }
        });
    }
}
