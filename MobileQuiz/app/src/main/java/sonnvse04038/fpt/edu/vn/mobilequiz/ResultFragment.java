package sonnvse04038.fpt.edu.vn.mobilequiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
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
    android.widget.TextView tvUserName, tvTestName, tvTimeStart, tvDuration, tvMark;
    int testID, totalMark, maxMark;
    DBHelper myDB;
    Test test;

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
        tvDuration = (TextView) view.findViewById(R.id.tvDuration);
        tvMark = (TextView) view.findViewById(R.id.tvMark);

        tvUserName.setText("cai gi do");
        tvTestName.setText(test.gettName());
        double mark = totalMark * 1.0 / maxMark * 10;
        tvMark.setText(String.format("%.1f", mark));


        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss aa");
        tvTimeStart.setText(dateformat.format(startTime.getTime()).toString());

        long difference = Calendar.getInstance().getTimeInMillis() - startTime.getTimeInMillis();
        int sec = (int) (difference/ 1000 % 60);
        int min = (int) ((difference / 1000 / 60) % 60);
        tvDuration.setText(min + " mins " + sec + " seconds");
    }

    @Override
    public void onClick(View view) {
        int Gui_Id = view.getId();
        switch (Gui_Id) {
            case R.id.btnDone:
                getActivity().finish();
                Toast.makeText(getContext(), "Done", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
