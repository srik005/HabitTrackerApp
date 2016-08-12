package srikanth.habittracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Dbhelper extends SQLiteOpenHelper {
    private SQLiteDatabase sqLiteDatabase;
    private ContentValues cValues;
    private Cursor cursor;
    /*public static final String CREATE_TABLE *//*= "CREATE TABLE " + ContractClass.DbUser.TABLE_NAME + "(" + ContractClass.DbUser.ID + " INTEGER PRIMARY KEY autoincrement,"
            + ContractClass.DbUser.NAME + "TEXT" + ContractClass.DbUser.SALARY + "TEXT)";*/
    public static final String CREATE_TABLE = "CREATE TABLE " + ContractClass.DbUser.TABLE_NAME + "(" + ContractClass.DbUser.ID
    + " INTEGER PRIMARY KEY autoincrement, " + ContractClass.DbUser.NAME
    + " TEXT, " +  ContractClass.DbUser.SALARY + " TEXT)";

    public Dbhelper(Context context) {
        super(context, ContractClass.DbInfo.DBNAME, null, ContractClass.DbInfo.DBVERSION);
    }

    public Dbhelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(ContractClass.DbUser.DROP_TABLE + ContractClass.DbUser.TABLE_NAME);
        onCreate(db);
    }

    public void insertRecord(String name, String salary) {
        sqLiteDatabase = getWritableDatabase();
        cValues = new ContentValues();
        cValues.put(ContractClass.DbUser.NAME, name);
        cValues.put(ContractClass.DbUser.SALARY, salary);
        sqLiteDatabase.insert(ContractClass.DbUser.TABLE_NAME, null, cValues);

    }

    public void updateRecord(String name, int salary) {
        sqLiteDatabase = getWritableDatabase();
        cValues = new ContentValues();
        cValues.put(ContractClass.DbUser.NAME, name);
        cValues.put(ContractClass.DbUser.SALARY, salary);
        sqLiteDatabase.update(ContractClass.DbUser.TABLE_NAME, cValues, null, null);
        sqLiteDatabase.close();
    }

    public Cursor selectRecords() {
        sqLiteDatabase = getReadableDatabase();
        cursor = sqLiteDatabase.rawQuery("select * from " + ContractClass.DbUser.TABLE_NAME, null);
        return cursor;
    }

    public void deleteRecord() {
        sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete(ContractClass.DbUser.TABLE_NAME, null, null);
        sqLiteDatabase.close();
    }
}
