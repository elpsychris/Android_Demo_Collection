import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import day09.nguyenntt.demosqlite.DatabaseHelper;

/**
 * Created by elpsychris on 02/05/2018.
 */

public class DemoContentProvider extends ContentProvider {

    private DatabaseHelper mDB;
    private static final String AUTHORITY = "com.people.data.PeopleProvider";
    private static final int PEOPLE = 1;
    private static final int PEOPLE_ID = 2;

    public static final String PEOPLE_BASE_PATH = "people";

    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + PEOPLE_BASE_PATH);

    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sUriMatcher.addURI(AUTHORITY, PEOPLE_BASE_PATH, PEOPLE);
        sUriMatcher.addURI(AUTHORITY, PEOPLE_BASE_PATH + "/#");
    }

    @Override
    public boolean onCreate() {
        mDB = new DatabaseHelper(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri,
                        @Nullable String[] strings,
                        @Nullable String selection,
                        @Nullable String[] selectionArgs,
                        @Nullable String sortOrder) {
        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
        builder.setTables(DatabaseHelper.DBTABLE);

        int uriType
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
