package sonnvse04038.fpt.edu.vn.mobilequiz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import sonnvse04038.fpt.edu.vn.mobilequiz.Object.Test;

/**
 * Created by admin on 3/9/2017.
 */


public class ResultFragment extends android.support.v4.app.Fragment implements android.view.View.OnClickListener {


    android.widget.Button btnDone;
    android.widget.TextView tvUserName, tvTestName, tvTimeStart, tvTimeComplete, tvTestDuration, tvMark;
    int testID, totalMark, maxMark, userID = 1;
    DBHelper myDB;
    Test test;
    double mark;


    Calendar startTime;

    @Override
    public android.view.View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        testID = getArguments().getInt("testID");//get test ID
        totalMark = getArguments().getInt("totalMark");
        maxMark = getArguments().getInt("maxMark");
        startTime = (Calendar) getArguments().getSerializable("startTTime");
        myDB = new DBHelper(getContext(), DBHelper.DB_NAME, null, DBHelper.DB_VERSION);

        test = myDB.getTestByID(testID);
        return inflater.inflate(R.layout.fragment_result, container, false);
    }

    @Override
    public void onViewCreated(View view, @android.support.annotation.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnDone = (Button) view.findViewById(R.id.btnDone);
        btnDone.setOnClickListener(this);

        tvUserName = (TextView) view.findViewById(R.id.tvUserName);
        tvTestName = (TextView) view.findViewById(R.id.tvTestName);
        tvTimeStart = (TextView) view.findViewById(R.id.tvTimeStart);
        tvTimeComplete = (TextView) view.findViewById(R.id.tvTimeComplete);
        tvTestDuration = (TextView) view.findViewById(R.id.tvTestDuration);
        tvMark = (TextView) view.findViewById(R.id.tvMark);

        tvUserName.setText("Isaac Newton");
        tvTestName.setText(test.gettName());
        mark = totalMark * 1.0 / maxMark * 10;
        tvMark.setText(String.format("%.1f", mark));


        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss aa");
        tvTimeStart.setText(dateformat.format(startTime.getTime()).toString());

        long difference = Calendar.getInstance().getTimeInMillis() - startTime.getTimeInMillis();
        int sec = (int) (difference/ 1000 % 60);
        int min = (int) ((difference / 1000 / 60) % 60);
        tvTimeComplete.setText(min + " mins " + sec + " seconds");

        int testDuration = test.getTime();
        sec = (int) (testDuration % 60);
        min = (int) ((testDuration / 60) % 60);
        tvTestDuration.setText(min + " mins " + sec + " seconds");
    }

    @Override
    public void onClick(View view) {
        int Gui_Id = view.getId();
        switch (Gui_Id) {
            case R.id.btnDone:

                myDB.insertResult(userID, testID, tvTimeStart.getText().toString(), tvTimeComplete.getText().toString(), mark);
                getActivity().finish();
                Toast.makeText(getContext(), "Done", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
