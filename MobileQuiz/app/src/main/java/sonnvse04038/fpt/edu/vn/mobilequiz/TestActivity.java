package sonnvse04038.fpt.edu.vn.mobilequiz;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import sonnvse04038.fpt.edu.vn.mobilequiz.Object.Test;

public class TestActivity extends AppCompatActivity {

    StartTestFragment fragment;
    int testID;
    DBHelper myDB;
    Test test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        //get testID here
        testID = getIntent().getIntExtra("testID", 0);

        myDB = new DBHelper(getApplicationContext(), DBHelper.DB_NAME, null, DBHelper.DB_VERSION);
        test = myDB.getTestByID(testID);

        //set title with the name of test
        setTitle(test.gettName());

        //Set the fragment initially
        fragment = new StartTestFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.test_fragment_container, fragment);
        fragmentTransaction.commit();
    }
}
