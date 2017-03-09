package sonnvse04038.fpt.edu.vn.mobilequiz;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity {

    StartTestFragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        //get testID here
        int testID = getIntent().getIntExtra("testID", 0);
        Toast.makeText(getApplicationContext(), "" + testID, Toast.LENGTH_SHORT).show();

        //set title with the name of test
        setTitle("Demo test");

        //Set the fragment initially
        fragment = new StartTestFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.test_fragment_container, fragment);
        fragmentTransaction.commit();
    }

}