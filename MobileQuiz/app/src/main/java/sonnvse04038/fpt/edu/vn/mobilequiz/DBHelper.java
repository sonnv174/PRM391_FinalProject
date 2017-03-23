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
import sonnvse04038.fpt.edu.vn.mobilequiz.Object.History;
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
                "`matAnswer4`  varchar(255) default NULL" +
                ")";

        String sqlCreateUserTable = "CREATE TABLE `user` (" +
                "`uID` INTEGER PRIMARY KEY AUTOINCREMENT," +
                "`uName`  varchar(255) default NULL" +
                ")";

        String sqlCreateResultTable = "CREATE TABLE `result` (" +
                "`rID` INTEGER PRIMARY KEY AUTOINCREMENT," +
                "`uID` int," +
                "`tID` int," +
                "`timeStart`  varchar(255)," +
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


        //now, init default data
        String sql = "INSERT INTO `test` (`tName`,`info`,`time`,`tStatus`) VALUES (\"English Test 1\",\"Test for 1 grade\",900,1)";
        db.execSQL(sql);

        sql = "INSERT INTO `user` (`uID`,`uName`) VALUES (1,\"Isaac Newton\")";
        db.execSQL(sql);

        sql = "INSERT INTO `matching` (`tID`,`matQuestion`,`matStatus`,`matAnswer1`,`matAnswer2`,`matAnswer3`,`matAnswer4`) VALUES (1,\"Matching 1\",1,\"Birthplace|the place where someone was born\",\"hometown|The town in which one is born or raised.\",\"interpreter|A person who translates from one language to another\",\"salesperson|a person whose job is selling things in a shop or directly to customers\")";
        db.execSQL(sql);
        sql = "INSERT INTO `matching` (`tID`,`matQuestion`,`matStatus`,`matAnswer1`,`matAnswer2`,`matAnswer3`,`matAnswer4`) VALUES (1,\"Matching 2\",1,\"symptoms|(n) physical signs of illness\",\"dizzy|(adj) having or causing a whirling sensation\",\"nauseous|(adj) sickening, makes you feel sick, or turns your stomach\",\"weak|(adj) lacking physical strength or vitality\")";
        db.execSQL(sql);
        sql = "INSERT INTO `matching` (`tID`,`matQuestion`,`matStatus`,`matAnswer1`,`matAnswer2`,`matAnswer3`,`matAnswer4`) VALUES (1,\"Matching  3\",1,\"vomiting|(v) the reflex act of ejecting the contents of the stomach through the mouth\",\"coughing|(v) the act of exhaling air suddenly with a noise\",\"sneezing|(v) the involuntary expulsion (forcing out) of air from the nose\",\"wheezing|to breath with a whistling sound\")";
        db.execSQL(sql);
        sql = "INSERT INTO `matching` (`tID`,`matQuestion`,`matStatus`,`matAnswer1`,`matAnswer2`,`matAnswer3`,`matAnswer4`) VALUES (1,\"Matching 4\",1,\"pain in my hip|(n) discomfort caused by illness or injury in the area between the pelvis and upper thighbone on each side of the body\",\"pain in my ribs|(n) discomfort caused by injury to the bones under the chest\",\"pain in my stomach|(n) discomfort caused by illness or injury in the tummy (belly).\",\"medical procedures|(n) refers to those practices used to cure illness or injury such as surgery, examinations etc\")";
        db.execSQL(sql);
        sql = "INSERT INTO `matching` (`tID`,`matQuestion`,`matStatus`,`matAnswer1`,`matAnswer2`,`matAnswer3`,`matAnswer4`) VALUES (1,\"Matching  5\",1,\"examination|(n) an inspection by a doctor or other medically qualified person to establish the extent and nature of any sickness or injury\",\"shot|(n) the act of putting a liquid into the body by means of a syringe\",\"injection|(n) If you have an injection, a doctor or nurse puts a medicine into your body using a device with a needle called a syringe.\",\"EKG|(n) (electrocardiogram) a procedure using an instrument that measures the electrical potential during a heartbeat\")";
        db.execSQL(sql);

        sql = "INSERT INTO `filling` (`tID`,`fQuestion`,`fStatus`,`fAnswer1`,`fAnswer2`,`fAnswer3`,`fAnswer4`,`fAnswer5`) VALUES (1,\"Take me to your ___①___  take me to your ___②___ \nGive me your ___③___ before I'm old\nShow me what ___④___  is - haven't got a clue\nShow me that ___⑤___  can be true\",1,\"heart\",\"soul\",\"hand\",\"love\",\"wonders\")";
        db.execSQL(sql);
        sql = "INSERT INTO `filling` (`tID`,`fQuestion`,`fStatus`,`fAnswer1`,`fAnswer2`,`fAnswer3`,`fAnswer4`,`fAnswer5`) VALUES (1,\"It feels like nobody ever ___①___   me until you knew me\nFeels like nobody ever ___②___  me until you ___③___  me\nFeels like nobody ever ___④___   me until you ___⑤___   me\nBaby nobody, nobody, until you\",1,\"knew\",\"loved\",\"loved\",\"touched\",\"touched\")";
        db.execSQL(sql);

        sql = "INSERT INTO `multiple` (`tID`,`mulQuestion`,`mulStatus`,`mulRightAnswer`,`mulAnswer1`,`mulAnswer2`,`mulAnswer3`,`mulAnswer4`) VALUES (1,\"Question 1: Excuse me! Where’s the post office?\",1,\"B. It’s over there.\",\"A. Don’t worry.\",\"B. It’s over there.\",\"C. Yes, I think so.\",\"D. I'm afraid not.\")";
        db.execSQL(sql);
        sql = "INSERT INTO `multiple` (`tID`,`mulQuestion`,`mulStatus`,`mulRightAnswer`,`mulAnswer1`,`mulAnswer2`,`mulAnswer3`,`mulAnswer4`) VALUES (1,\"Question 2: What shall we do this evening?\",1,\"B. Let’s go out for dinner.\",\"A. No problem.\",\"B. Let’s go out for dinner.\",\"C. Oh, that’s good!\",\"D. I went out for dinner.\")";
        db.execSQL(sql);
        sql = "INSERT INTO `multiple` (`tID`,`mulQuestion`,`mulStatus`,`mulRightAnswer`,`mulAnswer1`,`mulAnswer2`,`mulAnswer3`,`mulAnswer4`) VALUES (1,\"Question 3: Where do you come from?\",1,\"D. I come from London.\",\"A. In London.\",\"B. Yes, I have just come here.\",\"C. I’m living in London.\",\"D. I come from London.\")";
        db.execSQL(sql);
        sql = "INSERT INTO `multiple` (`tID`,`mulQuestion`,`mulStatus`,`mulRightAnswer`,`mulAnswer1`,`mulAnswer2`,`mulAnswer3`,`mulAnswer4`) VALUES (1,\"Question 4: Congratulations!\",1,\"C. Thank you.\",\"A. What a pity!\",\"B. You are welcome.\",\"C. Thank you.\",\"D. I’m sorry.\")";
        db.execSQL(sql);
        sql = "INSERT INTO `multiple` (`tID`,`mulQuestion`,`mulStatus`,`mulRightAnswer`,`mulAnswer1`,`mulAnswer2`,`mulAnswer3`,`mulAnswer4`) VALUES (1,\"Question 5: How did you get here?\",1,\"A. I came here by train.\",\"A. I came here by train.\",\"B. I came here last night.\",\"C. The train is so crowded.\",\"D. Is it far from here?\")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public boolean insertTest(Test t) {
        try {
            ContentValues data = new ContentValues();
            data.put(TEST_COLUMN_NAME, t.gettName());
            data.put(TEST_COLUMN_INFO, t.getInfo());
            data.put(TEST_COLUMN_TIME, t.getTime());
            data.put(TEST_COLUMN_STATUS, t.gettStatus());

            db.insert(TEST_TABLE_NAME, null, data);
            Log.v("Insert new record", "Completed");
      //      db.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertMultiple(MultipleChoice input) {
        try {
            ContentValues data = new ContentValues();
            data.put(TEST_COLUMN_ID, input.gettID());
            data.put(MULTIPLE_COLUMN_QUESTION, input.getMulQuestion());
            data.put(MULTIPLE_COLUMN_STATUS, input.getMulStatus());
            data.put(MULTIPLE_COLUMN_RIGHT_ANSWER, input.getMulRighAnswer());
            data.put(MULTIPLE_COLUMN_ANSWER_1, input.getMulAnswer1());
            data.put(MULTIPLE_COLUMN_ANSWER_2, input.getMulAnswer2());
            data.put(MULTIPLE_COLUMN_ANSWER_3, input.getMulAnswer3());
            data.put(MULTIPLE_COLUMN_ANSWER_4, input.getMulAnswer4());

            db.insert(MULTIPLE_TABLE_NAME, null, data);
            Log.v("Insert new record", "Completed");
   //         db.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertFilling(FillBlank input) {
        try {
            ContentValues data = new ContentValues();
            data.put(TEST_COLUMN_ID, input.gettID());
            data.put(FILLING_COLUMN_QUESTION, input.getfQuestion());
            data.put(FILLING_COLUMN_STATUS, input.getfStatus());
            data.put(FILLING_COLUMN_ANSWER_1, input.getfAnswer1());
            data.put(FILLING_COLUMN_ANSWER_2, input.getfAnswer2());
            data.put(FILLING_COLUMN_ANSWER_3, input.getfAnswer3());
            data.put(FILLING_COLUMN_ANSWER_4, input.getfAnswer4());
            data.put(FILLING_COLUMN_ANSWER_5, input.getfAnswer5());

            db.insert(FILLING_TABLE_NAME, null, data);
            Log.v("Insert new record", "Completed");
        //    db.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertMatching(Matching input) {
        try {
            ContentValues data = new ContentValues();
            data.put(TEST_COLUMN_ID, input.gettID());
            data.put(MATCHING_COLUMN_QUESTION, input.getmQuestion());
            data.put(MATCHING_COLUMN_STATUS, input.getStatus());
            data.put(MATCHING_COLUMN_ANSWER_1, input.getmAnswer1());
            data.put(MATCHING_COLUMN_ANSWER_2, input.getmAnswer2());
            data.put(MATCHING_COLUMN_ANSWER_3, input.getmAnswer3());
            data.put(MATCHING_COLUMN_ANSWER_4, input.getmAnswer4());

            db.insert(MATCHING_TABLE_NAME, null, data);
            Log.v("Insert new record", "Completed");
        //    db.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean insertResult(int uID, int tID, String timeStart, String duration, double mark) {
        try {
            ContentValues data = new ContentValues();
            data.put(USER_COLUMN_ID, uID);
            data.put(TEST_COLUMN_ID, tID);
            data.put(RESULT_COLUMN_TIME_START, timeStart);
            data.put(RESULT_COLUMN_DURATION, duration);
            data.put(RESULT_COLUMN_MARK, mark);

            db.insert(RESULT_TABLE_NAME, null, data);
            Log.v("Insert new record", "Completed");
        //    db.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

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

    public ArrayList<History> getAllHistory() {
        ArrayList<History> list = new ArrayList<>();
        Cursor rs = null;
        String sql = "select uName, tName, time, timeStart, duration, mark from (result INNER JOIN user ON result.uID = user.uID) INNER JOIN test ON result.tID = test.tID";
        rs = db.rawQuery(sql, null);
        Log.v("Number of selected", "Number hiastory: " + rs.getCount());
        rs.moveToFirst();
        while (rs.isAfterLast() == false) {
            History f = new History();
            f.setUserName(rs.getString(rs.getColumnIndex(USER_COLUMN_NAME)));
            f.setTestName(rs.getString(rs.getColumnIndex(TEST_COLUMN_NAME)));
            f.setDuration(rs.getInt(rs.getColumnIndex(TEST_COLUMN_TIME)));
            f.setTimeStart(rs.getString(rs.getColumnIndex(RESULT_COLUMN_TIME_START)));
            f.setTimeComplete(rs.getString(rs.getColumnIndex(RESULT_COLUMN_DURATION)));
            f.setMark(rs.getDouble(rs.getColumnIndex(RESULT_COLUMN_MARK)));
            list.add(f);
            rs.moveToNext();
        }
        return list;
    }

    public int deleteAllHistory() {

//        delete all records, pass "1" to whereClause
        String whereClause = "1";
        String[] whereValues = null;

        int result = this.db.delete(RESULT_TABLE_NAME, whereClause, whereValues);
        return result;
    }

    public int getNewTestID() {
        String sql = "SELECT MAX(tID) FROM test";
        Cursor rs = db.rawQuery(sql, null);
        rs.moveToFirst();
        int newTestID = rs.getInt(0);
        return newTestID;
    }
}
