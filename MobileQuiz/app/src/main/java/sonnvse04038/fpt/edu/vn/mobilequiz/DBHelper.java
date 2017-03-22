package sonnvse04038.fpt.edu.vn.mobilequiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by sonnv174 on 2/13/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    private SQLiteDatabase db;
    public static final String DB_NAME = "MobileQuiz.db";
    public static final String TEST_TABLE_NAME = "test";
    public static final String FILLING_TABLE_NAME = "filling";
    public static final String MATCHING_TABLE_NAME = "matching";
    public static final String MULTIPLE_TABLE_NAME = "multiple";
    public static final String RESULT_TABLE_NAME = "result";
    public static final String USER_TABLE_NAME = "user";

    //TEST TABLE
    public static final String TEST_COLUMN_ID = "tID";
    public static final String TEST_COLUMN_NAME = "tName";
    public static final String TEST_COLUMN_INFO = "info";
    public static final String TEST_COLUMN_TIME = "time";
    public static final String TEST_COLUMN_STATUS = "tStatus";

    //FILLING TABLE
    public static final String FILLING_COLUMN_ID = "fID";
    public static final String FILLING_COLUMN_QUESTION = "fQuestion";
    public static final String FILLING_COLUMN_STATUS = "fStatus";
    public static final String FILLING_COLUMN_ANSWER_1 = "fAnswer1";
    public static final String FILLING_COLUMN_ANSWER_2 = "fAnswer2";
    public static final String FILLING_COLUMN_ANSWER_3 = "fAnswer3";
    public static final String FILLING_COLUMN_ANSWER_4 = "fAnswer4";
    public static final String FILLING_COLUMN_ANSWER_5 = "fAnswer5";

    //MULTIPLE TABLE
    public static final String MULTIPLE_COLUMN_ID = "mulID";
    public static final String MULTIPLE_COLUMN_QUESTION = "mulQuestion";
    public static final String MULTIPLE_COLUMN_STATUS = "mulStatus";
    public static final String MULTIPLE_COLUMN_RIGHT_ANSWER = "mulRightAnswer";
    public static final String MULTIPLE_COLUMN_ANSWER_1 = "mulAnswer1";
    public static final String MULTIPLE_COLUMN_ANSWER_2 = "mulAnswer2";
    public static final String MULTIPLE_COLUMN_ANSWER_3 = "mulAnswer3";
    public static final String MULTIPLE_COLUMN_ANSWER_4 = "mulAnswer4";

    //MATCHING TABLE
    public static final String MATCHING_COLUMN_ID = "matID";
    public static final String MATCHING_COLUMN_QUESTION = "matQuestion";
    public static final String MATCHING_COLUMN_STATUS = "matStatus";
    public static final String MATCHING_COLUMN_ANSWER_1 = "matAnswer1";
    public static final String MATCHING_COLUMN_ANSWER_2 = "matAnswer2";
    public static final String MATCHING_COLUMN_ANSWER_3 = "matAnswer3";
    public static final String MATCHING_COLUMN_ANSWER_4 = "matAnswer4";
    public static final String MATCHING_COLUMN_ANSWER_5 = "matAnswer5";

    //RESULT TABLE
    public static final String RESULT_COLUMN_ID = "rID";
    public static final String RESULT_COLUMN_TIME_START = "timeStart";
    public static final String RESULT_COLUMN_DURATION = "duration";
    public static final String RESULT_COLUMN_MARK = "mark";


    //USER TABLE
    public static final String USER_COLUMN_ID = "uID";
    public static final String USER_COLUMN_NAME = "uName";

    public static final int DB_VERSION = 1;

    public DBHelper(Context context, String DB_NAME, SQLiteDatabase.CursorFactory factory, int DB_VERSION) {
        super(context, DB_NAME, factory, DB_VERSION);
        this.db = getWritableDatabase();
    }

    public DBHelper(Context context, String DB_NAME, SQLiteDatabase.CursorFactory factory, int DB_VERSION, DatabaseErrorHandler errorHandler) {
        super(context, DB_NAME, factory, DB_VERSION, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //we need to create sql statement to define contacts table
        String sqlCreateTestTable = "CREATE TABLE `test` (\n" +
                "`tID` mediumint PRIMARY KEY,\n" +
                "`tName` varchar(255) default NULL,\n" +
                "`info` varchar(255) default NULL,\n" +
                "`time` int default 600,\n" +
                "`tStatus` int default 1\n" + //1 is anable, 0 is disable
                ")";

        String sqlCreateFillingTable = "CREATE TABLE `filling` (" +
                "`fID` int PRIMARY KEY," +
                "`tID` int," +
                "`fQuestion` varchar(255) default NULL," +
                "`fStatus` int default 1,\n" + //1 is anable, 0 is disable
                "`fAnswer1`  varchar(255) default NULL," +
                "`fAnswer2`  varchar(255) default NULL," +
                "`fAnswer3`  varchar(255) default NULL," +
                "`fAnswer4`  varchar(255) default NULL," +
                "`fAnswer5`  varchar(255) default NULL" +
                ")";

        String sqlCreateMultipleTable = "CREATE TABLE `multiple` (" +
                "`mulID` int PRIMARY KEY," +
                "`tID` int," +
                "`mulQuestion`  varchar(255) default NULL," +
                "`mulStatus` int default 1,\n" + //1 is anable, 0 is disable
                "`mulRightAnswer`  varchar(255) default NULL," +
                "`mulAnswer1`  varchar(255) default NULL," +
                "`mulAnswer2`  varchar(255) default NULL," +
                "`mulAnswer3`  varchar(255) default NULL," +
                "`mulAnswer4`  varchar(255) default NULL" +
                ")";

        String sqlCreateMatchingTable = "CREATE TABLE `matching` (" +
                "`matID` int PRIMARY KEY," +
                "`tID` int," +
                "`matQuestion`  varchar(255) default NULL," +
                "`matStatus` int default 1,\n" + //1 is anable, 0 is disable
                "`matAnswer1`  varchar(255) default NULL," +
                "`matAnswer2`  varchar(255) default NULL," +
                "`matAnswer3`  varchar(255) default NULL," +
                "`matAnswer4`  varchar(255) default NULL," +
                "`matAnswer5`  varchar(255) default NULL" +
                ")";

        String sqlCreateUserTable = "CREATE TABLE `user` (" +
                "`uID` int PRIMARY KEY," +
                "`uName`  varchar(255) default NULL" +
                ")";

        String sqlCreateResultTable = "CREATE TABLE `result` (" +
                "`rID` int PRIMARY KEY," +
                "`uID` int," +
                "`tID` int," +
                "`timeStart` datetime," +
                "`duration` int," +
                "`mark` int" +
                ");";

        //and after that, execute the sql statement
        db.execSQL(sqlCreateTestTable);
        db.execSQL(sqlCreateFillingTable);
        db.execSQL(sqlCreateMatchingTable);
        db.execSQL(sqlCreateMultipleTable);
        db.execSQL(sqlCreateUserTable);
        db.execSQL(sqlCreateResultTable);


        //now, we have a contacts(id, name, email, phone) table
        //we are trying to insert a new contact record after that
//        sql = "INSERT INTO `contacts` (`id`,`name`,`email`,`phone`) VALUES (1000,\"Chandler Snyder\",\"Donec@blanditmattis.edu\",\"049-565-9950\")";
//        Log.v("SQLite", sql);
//        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

//    //return true if success, others wise return false
//    public boolean insertNewRecord(int id, String name, String email, String phone) {
//        try {
//            ContentValues data = new ContentValues();
//            data.put(CONTACTS_COLUMN_ID, id);
//            data.put(CONTACTS_COLUMN_NAME, name);
//            data.put(CONTACTS_COLUMN_EMAIL, email);
//            data.put(CONTACTS_COLUMN_PHONE, phone);
//
//            db.insert(CONTACTS_TABLE_NAME, null, data);
//            Log.v("Insert new record", "Completed");
//            db.close();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }

//    public ArrayList<Contacts> getAllContacts() {
//        ArrayList<Contacts> list = new ArrayList<>();
//        Cursor rs = null;
//        String sql = "select id, name, email, phone from contacts";
//        rs = db.rawQuery(sql, null);
//        Log.v("Number of selected", "Number: " + rs.getCount());
//        rs.moveToFirst();
//        while (rs.isAfterLast() == false) {
//            Contacts c = new Contacts();
//            c.setId(rs.getInt(rs.getColumnIndex(CONTACTS_COLUMN_ID)));
//            c.setName(rs.getString(rs.getColumnIndex(CONTACTS_COLUMN_NAME)));
//            c.setPhone(rs.getString(rs.getColumnIndex(CONTACTS_COLUMN_PHONE)));
//            c.setEmail(rs.getString(rs.getColumnIndex(CONTACTS_COLUMN_EMAIL)));
//            list.add(c);
//            rs.moveToNext();
//        }
//        return list;
//    }
//
//    public boolean updateARecord(Contacts c) {
//        boolean result = false; //if we can update successfully the passed contect => return true
//        int count = 0;
//        try {
//            ContentValues data = new ContentValues();
//            data.put(CONTACTS_COLUMN_ID, c.getId());
//            data.put(CONTACTS_COLUMN_NAME, c.getName());
//            data.put(CONTACTS_COLUMN_EMAIL, c.getEmail());
//            data.put(CONTACTS_COLUMN_PHONE, c.getPhone());
//
//            //way 1
//            //  String whereClause = CONTACTS_COLUMN_ID + "=" + c.getId();
//            //  String[] whereValue = null;
//
//            //way 2
//            String whereClause = CONTACTS_COLUMN_ID + " = ?";
//            String[] whereValues = {c.getId() + ""};
//            count = this.db.update(CONTACTS_TABLE_NAME, data, whereClause, whereValues);
//            result = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//        if (count == 0) {
//            Log.v("UpdateRecord", "Nothing is updated!");
//            result = false;
//        } else {
//            Log.v("UpdateRecord", count + " record(s) is/are updated!");
//            result = true;
//        }
//        return result;
//    }
//
//    public int deleteRecord(int deleteID) {
////        delete a record
//        String whereClause = CONTACTS_COLUMN_ID + " = ?";
//        String[] whereValues = {deleteID + ""};
//
////        delete all records, pass "1" to whereClause
////        String whereClause = "1";
////        String[] whereValues = null;
//
//        int result = this.db.delete(CONTACTS_TABLE_NAME, whereClause, whereValues);
//        return result;
//    }
}
