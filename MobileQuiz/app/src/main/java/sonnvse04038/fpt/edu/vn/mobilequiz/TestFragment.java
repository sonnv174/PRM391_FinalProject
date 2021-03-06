package sonnvse04038.fpt.edu.vn.mobilequiz;


import android.app.AlertDialog;
import android.app.TabActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

import sonnvse04038.fpt.edu.vn.mobilequiz.Object.FillBlank;
import sonnvse04038.fpt.edu.vn.mobilequiz.Object.Matching;
import sonnvse04038.fpt.edu.vn.mobilequiz.Object.MultipleChoice;


/**
 * A simple {@link Fragment} subclass.
 */
public class TestFragment extends Fragment implements View.OnClickListener {

    Button btnFinishNow, btnPrev, btnNext, btnReset;
    ProgressBar prbStatus;
    private FragmentTabHost mTabHost;
    int testID, posCurTab, totalQuestion;
    int totalMark = 0;
    int maxMark = 0;

    Calendar startTime;
    DBHelper myDB;

    ArrayList<FillBlank> listFilling;
    ArrayList<Matching> listMatching;
    ArrayList<MultipleChoice> listMultiple;

    ArrayList<Integer> arrMark;

    public TestFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        listMultiple = new ArrayList<>();
        listFilling = new ArrayList<>();
        listMatching = new ArrayList<>();
        arrMark = new ArrayList<>();

        startTime = Calendar.getInstance();

        testID = getArguments().getInt("testID");//get test ID
        myDB = new DBHelper(getContext(), DBHelper.DB_NAME, null, DBHelper.DB_VERSION);

        listFilling = myDB.getAllFillBlankByTestID(testID); // get all fill blank question
        listMultiple = myDB.getAllMultipleByTestID(testID);
        listMatching = myDB.getAllMatchingByTestID(testID);

        totalQuestion = listMatching.size() + listFilling.size() + listMultiple.size();
        maxMark = listFilling.size() * 5 + listMatching.size() * 4 + listMultiple.size();
        //init mark
        for (int i = 0; i < totalQuestion; i++) {
            arrMark.add(0);
        }

        return inflater.inflate(R.layout.fragment_test, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnFinishNow = (Button) view.findViewById(R.id.btnFinishNow);
        btnFinishNow.setOnClickListener(this);
        btnPrev = (Button) view.findViewById(R.id.btnPrev);
        btnPrev.setOnClickListener(this);
        btnNext = (Button) view.findViewById(R.id.btnNext);
        btnNext.setOnClickListener(this);
        btnReset = (Button) view.findViewById(R.id.btnReset);
        btnReset.setOnClickListener(this);

        prbStatus = (ProgressBar) view.findViewById(R.id.prbStatus);
        prbStatus.setMax(totalQuestion);
        prbStatus.getProgressDrawable().setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
        prbStatus.setProgress(posCurTab + 1);

        mTabHost = (FragmentTabHost) getActivity().findViewById(android.R.id.tabhost);
        mTabHost.setup(getContext(), getActivity().getSupportFragmentManager(), android.R.id.tabcontent);
        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {

            }
        });

        int i = 0;

        //add all tab what is filling blank question
        for (FillBlank f : listFilling) {
            i++;
            Bundle bundle = new Bundle();
            bundle.putSerializable("fQuestion", f);
            TabHost.TabSpec fTabSpec = mTabHost.newTabSpec("tab" + i).setIndicator("Q" + i, null);
            mTabHost.addTab(fTabSpec, FillBlankFragment.class, bundle);
        }
        for (MultipleChoice m : listMultiple) {
            i++;
            Bundle bundle = new Bundle();
            bundle.putSerializable("mulQuestion", m);
            TabHost.TabSpec fTabSpec = mTabHost.newTabSpec("tab" + i).setIndicator("Q" + i, null);
            mTabHost.addTab(fTabSpec, MultipleChoiceFragment.class, bundle);
        }

        for (Matching m : listMatching) {
            i++;
            Bundle bundle = new Bundle();
            bundle.putSerializable("matQuestion", m);
            TabHost.TabSpec fTabSpec = mTabHost.newTabSpec("tab" + i).setIndicator("Q" + i, null);
            mTabHost.addTab(fTabSpec, MatchingFragment.class, bundle);
        }

        posCurTab = 0;
        show_hide_Button();
        mTabHost.setCurrentTab(posCurTab);
    }

    public void markTab(int posTab) {
        if (posTab >= 0 && posTab < listFilling.size()) {
            markFilling(posTab);
        } else {
            if (posTab < listFilling.size() + listMultiple.size()) {
                markMultiple(posTab);
            } else {
                markMatching(posTab);
            }
        }
    }

    private void markMatching(int posTab) {
        int markMat = 0;
        int posQuetion = posTab - listFilling.size() - listMultiple.size();
        Matching fb = listMatching.get(posQuetion);
        View v = mTabHost.getChildAt(0);

        EditText edt1 = (EditText) v.findViewById(R.id.choice_1);
        EditText edt2 = (EditText) v.findViewById(R.id.choice_2);
        EditText edt3 = (EditText) v.findViewById(R.id.choice_3);
        EditText edt4 = (EditText) v.findViewById(R.id.choice_4);

        if (edt1.getText().toString().equalsIgnoreCase(fb.getmAnswer1())) {
            markMat += 1;
        }
        if (edt2.getText().toString().equalsIgnoreCase(fb.getmAnswer2().trim())) {
            markMat += 1;
        }
        if (edt3.getText().toString().equalsIgnoreCase(fb.getmAnswer3().trim())) {
            markMat += 1;
        }
        if (edt4.getText().toString().equalsIgnoreCase(fb.getmAnswer4().trim())) {
            markMat += 1;
        }
        arrMark.set(posTab, markMat);
    }

    private void markMultiple(int posTab) {
        int markMul = 0;
        int posQuetion = posTab - listFilling.size();
        MultipleChoice mc = listMultiple.get(posQuetion);
        View v = mTabHost.getChildAt(0);

        RadioButton radA = (RadioButton) v.findViewById(R.id.radA);
        RadioButton radB = (RadioButton) v.findViewById(R.id.radB);
        RadioButton radC = (RadioButton) v.findViewById(R.id.radC);
        RadioButton radD = (RadioButton) v.findViewById(R.id.radD);

        RadioButton right = new RadioButton(getContext());
        if (radA.isChecked()) {
            right = radA;
        }
        if (radB.isChecked()) {
            right = radB;
        }
        if (radC.isChecked()) {
            right = radC;
        }
        if (radD.isChecked()) {
            right = radD;
        }
        if (right.getText().toString().equals(mc.getMulRighAnswer())) {
            markMul = 1;
        }
        arrMark.set(posTab, markMul);
    }

    public void markFilling(int posTab) {
        int markFill = 0;
        int posQuetion = posTab;
        FillBlank fb = listFilling.get(posQuetion);
        View v = mTabHost.getChildAt(0);

        EditText edt1 = (EditText) v.findViewById(R.id.edtAnswer1);
        EditText edt2 = (EditText) v.findViewById(R.id.edtAnswer2);
        EditText edt3 = (EditText) v.findViewById(R.id.edtAnswer3);
        EditText edt4 = (EditText) v.findViewById(R.id.edtAnswer4);
        EditText edt5 = (EditText) v.findViewById(R.id.edtAnswer5);

        if (edt1.getText().toString().trim().equalsIgnoreCase(fb.getfAnswer1().trim())) {
            markFill += 1;
        }
        if (edt2.getText().toString().trim().equalsIgnoreCase(fb.getfAnswer2().trim())) {
            markFill += 1;
        }
        if (edt3.getText().toString().trim().equalsIgnoreCase(fb.getfAnswer3().trim())) {
            markFill += 1;
        }
        if (edt4.getText().toString().trim().equalsIgnoreCase(fb.getfAnswer4().trim())) {
            markFill += 1;
        }
        if (edt5.getText().toString().trim().equalsIgnoreCase(fb.getfAnswer5().trim())) {
            markFill += 1;
        }
        arrMark.set(posTab, markFill);
    }

    public void countTotalMark() {
        totalMark = 0;
        for (int i : arrMark) {
            totalMark += i;
        }
    }

    private void show_hide_Button() {
        if (posCurTab < totalQuestion - 1) {
            btnNext.setVisibility(View.VISIBLE);
        } else {
            btnNext.setVisibility(View.INVISIBLE);
        }
        if (posCurTab > 0) {
            btnPrev.setVisibility(View.VISIBLE);
        } else {
            btnPrev.setVisibility(View.INVISIBLE);
        }
        if(posCurTab < totalQuestion && posCurTab >= totalQuestion - listMatching.size()) {
            btnReset.setVisibility(View.VISIBLE);
        }else {
            btnReset.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onClick(View view) {
        int GUI_id = view.getId();
        switch (GUI_id) {
            case R.id.btnFinishNow:
                try {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

                    builder.setTitle("Finish Test");
                    builder.setMessage("Do you want to finish now?");

                    builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {
                            // Do do my action here
                            markTab(posCurTab);
                            countTotalMark();
                            Toast.makeText(getContext(), totalMark + "/" + maxMark + " haha", Toast.LENGTH_SHORT).show();

                            //Finish and go to Result fragment
                            ResultFragment fragment = new ResultFragment();

                            Bundle bundleMark = new Bundle();
                            bundleMark.putInt("totalMark", totalMark);
                            bundleMark.putInt("maxMark", maxMark);
                            bundleMark.putInt("testID", testID);
                            bundleMark.putSerializable("startTTime", startTime);
                            fragment.setArguments(bundleMark);

                            android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.test_fragment_container, fragment);
                            fragmentTransaction.commit();
                            dialog.dismiss();
                        }

                    });

                    builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // I do not need any action here you might
                            dialog.dismiss();
                        }
                    });

                    AlertDialog alert = builder.create();
                    alert.show();
                } catch (Exception e) {

                }
                break;

            case R.id.btnNext:
                try {
                    markTab(posCurTab);

                    posCurTab = posCurTab < totalQuestion - 1 ? ++posCurTab : totalQuestion - 1;
                    mTabHost.setCurrentTab(posCurTab);
                    prbStatus.setProgress(posCurTab + 1);
                    show_hide_Button();
                } catch (Exception e) {

                }
                break;

            case R.id.btnPrev:
                try {
                    markTab(posCurTab);

                    posCurTab = posCurTab > 0 ? --posCurTab : 0;
                    mTabHost.setCurrentTab(posCurTab);
                    prbStatus.setProgress(posCurTab + 1);
                    show_hide_Button();
                } catch (Exception e) {

                }
                break;

            case R.id.btnReset:
                try {

                } catch (Exception e) {

                }
                break;
        }
    }
}
