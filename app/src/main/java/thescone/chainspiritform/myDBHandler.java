package thescone.chainspiritform;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Habibah on 13-Jun-16.
 */
public class myDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "vendor.db";
    private static final String TABLE_VENDOR = "VendorRegister";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_VENDORNAME = "_vendorName";
    private static final String COLUMN_VENDORIC = "_vendorIC";
    private static final String COLUMN_VENDORADDRESS = "_vendorAddress";
    private static final String COLUMN_VENDORMOBILE = "_vendorMobile";
    private static final String COLUMN_VENDOREMAIL = "_vendorEmail";
    private static final String COLUMN_VENDORSIGNINPLATFORM = "_vendorSignInPlatform";

    public myDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_VENDOR + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_VENDORNAME + " TEXT, " +
                COLUMN_VENDORIC + " TEXT, " +
                COLUMN_VENDORADDRESS + " TEXT, " +
                COLUMN_VENDORMOBILE + " REAL, " +
                COLUMN_VENDOREMAIL + " TEXT, " +
                COLUMN_VENDORSIGNINPLATFORM + " TEXT " +
                ");";
        Log.d("query", query);
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VENDOR);
        onCreate(db);
    }

    // add into db
    // pass to Register class
    public void addRegister(Register register) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_VENDORNAME, register.get_vendorName());
        values.put(COLUMN_VENDORIC, register.get_vendorIC());
        values.put(COLUMN_VENDORADDRESS, register.get_vendorAddress());
        values.put(COLUMN_VENDORMOBILE, register.get_vendorMobile());
        values.put(COLUMN_VENDOREMAIL, register.get_vendorEmail());
        values.put(COLUMN_VENDORSIGNINPLATFORM, register.get_vendorSignInPlatform());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_VENDOR, null, values);
        Log.d("query", TABLE_VENDOR);
        Log.d("query", values.toString());
        db.close();
    }

    // delete row *52*

    // print DB
    public String dbToString() {
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        // String query = "SELECT * FROM " + TABLE_VENDOR +" WHERE 1";
        String query = "SELECT " + COLUMN_VENDORNAME +" FROM " + TABLE_VENDOR + " WHERE " + COLUMN_ID + "=1;";

        Cursor c = db.rawQuery(query, null);

        c.moveToFirst();

        while (!c.isAfterLast()) {
            if(c.getString(c.getColumnIndex("vendorName"))!= null) {
                dbString += c.getString(c.getColumnIndex("vendorName"));
                dbString += "\n";
            }
        }
        c.close();
        db.close();
        return dbString;
    }
}
