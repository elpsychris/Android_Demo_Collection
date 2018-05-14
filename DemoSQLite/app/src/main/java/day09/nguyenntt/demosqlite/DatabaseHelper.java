package day09.nguyenntt.demosqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by elpsychris on 02/02/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String DBTABLE = "NameDB2";
    private static String COL1 = "ID";
    private static String COL2 = "Name";


    public DatabaseHelper(Context context) {
        super(context, DBTABLE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + DBTABLE + " (" + COL1 + " INTEGER PRIMARY KEY, " + COL2 + " TEXT);";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addData(String name) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, name);

        long result = db.insert(DBTABLE, null, contentValues);
        return result > -1;
    }

    public Cursor getData() {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "SELECT * FROM " + DBTABLE;
        Cursor data = db.rawQuery(sql, null);
        return data;
    }
}
