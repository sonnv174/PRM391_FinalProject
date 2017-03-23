package sonnvse04038.fpt.edu.vn.mobilequiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import sonnvse04038.fpt.edu.vn.mobilequiz.Object.FillBlank;
import sonnvse04038.fpt.edu.vn.mobilequiz.Object.Matching;
import sonnvse04038.fpt.edu.vn.mobilequiz.Object.MultipleChoice;
import sonnvse04038.fpt.edu.vn.mobilequiz.Object.Test;

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
                "`tID` INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "`tName` varchar(255) default NULL,\n" +
                "`info` varchar(255) default NULL,\n" +
                "`time` int default 600,\n" +
                "`tStatus` int default 1\n" + //1 is anable, 0 is disable
                ")";

        String sqlCreateFillingTable = "CREATE TABLE `filling` (" +
                "`fID` INTEGER PRIMARY KEY AUTOINCREMENT," +
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
                "`mulID` INTEGER PRIMARY KEY AUTOINCREMENT," +
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
                "`matID` INTEGER PRIMARY KEY AUTOINCREMENT," +
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
                "`uID` INTEGER PRIMARY KEY AUTOINCREMENT," +
                "`uName`  varchar(255) default NULL" +
                ")";

        String sqlCreateResultTable = "CREATE TABLE `result` (" +
                "`rID` INTEGER PRIMARY KEY AUTOINCREMENT," +
                "`uID` int," +
                "`tID` int," +
                "`timeStart` datetime," +
                "`duration` int," +
                "`mark` double" +
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

    public ArrayList<FillBlank> getAllFillBlankByTestID(int testID) {
        ArrayList<FillBlank> list = new ArrayList<>();
        Cursor rs = null;
        String sql = "select fID, tID, fQuestion, fStatus, fAnswer1, fAnswer2, fAnswer3, fAnswer4, fAnswer5 from filling where tID = '" + testID + "'";
        rs = db.rawQuery(sql, null);
        Log.v("Number of selected", "Number: " + rs.getCount());
        rs.moveToFirst();
        while (rs.isAfterLast() == false) {
            FillBlank f = new FillBlank();
            f.setfID(rs.getInt(rs.getColumnIndex(FILLING_COLUMN_ID)));
            f.settID(rs.getInt(rs.getColumnIndex(TEST_COLUMN_ID)));
            f.setfStatus(rs.getInt(rs.getColumnIndex(FILLING_COLUMN_STATUS)));
            f.setfQuestion(rs.getString(rs.getColumnIndex(FILLING_COLUMN_QUESTION)));
            f.setfAnswer1(rs.getString(rs.getColumnIndex(FILLING_COLUMN_ANSWER_1)));
            f.setfAnswer2(rs.getString(rs.getColumnIndex(FILLING_COLUMN_ANSWER_2)));
            f.setfAnswer3(rs.getString(rs.getColumnIndex(FILLING_COLUMN_ANSWER_3)));
            f.setfAnswer4(rs.getString(rs.getColumnIndex(FILLING_COLUMN_ANSWER_4)));
            f.setfAnswer5(rs.getString(rs.getColumnIndex(FILLING_COLUMN_ANSWER_5)));
            list.add(f);
            rs.moveToNext();
        }
        return list;
    }


    public ArrayList<MultipleChoice> getAllMultipleByTestID(int testID) {
        ArrayList<MultipleChoice> list = new ArrayList<>();
        Cursor rs = null;
        String sql = "select mulID, tID, mulQuestion, mulStatus, mulRightAnswer, mulAnswer1, mulAnswer2, mulAnswer3, mulAnswer4 from multiple where tID = '" + testID + "'";
        rs = db.rawQuery(sql, null);
        Log.v("Number of selected", "Number: " + rs.getCount());
        rs.moveToFirst();
        while (rs.isAfterLast() == false) {
            MultipleChoice f = new MultipleChoice();
            f.setMulID(rs.getInt(rs.getColumnIndex(MULTIPLE_COLUMN_ID)));
            f.settID(rs.getInt(rs.getColumnIndex(TEST_COLUMN_ID)));
            f.setMulQuestion(rs.getString(rs.getColumnIndex(MULTIPLE_COLUMN_QUESTION)));
            f.setMulStatus(rs.getInt(rs.getColumnIndex(MULTIPLE_COLUMN_STATUS)));
            f.setMulRighAnswer(rs.getString(rs.getColumnIndex(MULTIPLE_COLUMN_RIGHT_ANSWER)));
            f.setMulAnswer1(rs.getString(rs.getColumnIndex(MULTIPLE_COLUMN_ANSWER_1)));
            f.setMulAnswer2(rs.getString(rs.getColumnIndex(MULTIPLE_COLUMN_ANSWER_2)));
            f.setMulAnswer3(rs.getString(rs.getColumnIndex(MULTIPLE_COLUMN_ANSWER_3)));
            f.setMulAnswer4(rs.getString(rs.getColumnIndex(MULTIPLE_COLUMN_ANSWER_4)));
            list.add(f);
            rs.moveToNext();
        }
        return list;
    }

    public ArrayList<Matching> getAllMatchingByTestID(int testID) {
        ArrayList<Matching> list = new ArrayList<>();
        Cursor rs = null;
        String sql = "select matID, tID, matQuestion, matStatus, matAnswer1, matAnswer2, matAnswer3, matAnswer4 from matching where tID = '" + testID + "'";
        rs = db.rawQuery(sql, null);
        Log.v("Number of selected", "Number: " + rs.getCount());
        rs.moveToFirst();
        while (rs.isAfterLast() == false) {
            Matching f = new Matching();
            f.setmId(rs.getInt(rs.getColumnIndex(MATCHING_COLUMN_ID)));
            f.settID(rs.getInt(rs.getColumnIndex(TEST_COLUMN_ID)));
            f.setmQuestion(rs.getString(rs.getColumnIndex(MATCHING_COLUMN_QUESTION)));
            f.setStatus(rs.getInt(rs.getColumnIndex(MATCHING_COLUMN_STATUS)));
            f.setmAnswer1(rs.getString(rs.getColumnIndex(MATCHING_COLUMN_ANSWER_1)));
            f.setmAnswer2(rs.getString(rs.getColumnIndex(MATCHING_COLUMN_ANSWER_2)));
            f.setmAnswer3(rs.getString(rs.getColumnIndex(MATCHING_COLUMN_ANSWER_3)));
            f.setmAnswer4(rs.getString(rs.getColumnIndex(MATCHING_COLUMN_ANSWER_4)));
            list.add(f);
            rs.moveToNext();
        }
        return list;
    }

    public Test getTestByID(int testID) {
        Test f = new Test();
        Cursor rs = null;
        String sql = "select tID, tName, info, time, tStatus from test where tID = '" + testID + "'";
        rs = db.rawQuery(sql, null);
        rs.moveToFirst();
        f.settID(rs.getInt(rs.getColumnIndex(TEST_COLUMN_ID)));
        f.settName(rs.getString(rs.getColumnIndex(TEST_COLUMN_NAME)));
        f.setInfo(rs.getString(rs.getColumnIndex(TEST_COLUMN_INFO)));
        f.setTime(rs.getInt(rs.getColumnIndex(TEST_COLUMN_TIME)));
        f.settStatus(rs.getInt(rs.getColumnIndex(TEST_COLUMN_STATUS)));

        return f;
    }

    public ArrayList<Test> getAllTest() {
        ArrayList<Test> list = new ArrayList<>();
        Cursor rs = null;
        String sql = "select tID, tName, info, time, tStatus from test";
        rs = db.rawQuery(sql, null);
        Log.v("Number of selected", "Number: " + rs.getCount());
        rs.moveToFirst();
        while (rs.isAfterLast() == false) {
            Test f = new Test();
            f.settID(rs.getInt(rs.getColumnIndex(TEST_COLUMN_ID)));
            f.settName(rs.getString(rs.getColumnIndex(TEST_COLUMN_NAME)));
            f.setInfo(rs.getString(rs.getColumnIndex(TEST_COLUMN_INFO)));
            f.setTime(rs.getInt(rs.getColumnIndex(TEST_COLUMN_TIME)));
            f.settStatus(rs.getInt(rs.getColumnIndex(TEST_COLUMN_STATUS)));
            list.add(f);
            rs.moveToNext();
        }
        return list;
    }

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
