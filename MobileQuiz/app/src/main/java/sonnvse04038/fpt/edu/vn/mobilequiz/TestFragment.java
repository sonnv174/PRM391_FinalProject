package sonnvse04038.fpt.edu.vn.mobilequiz;


import android.app.TabActivity;
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
import android.widget.ProgressBar;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import sonnvse04038.fpt.edu.vn.mobilequiz.Object.FillBlank;
import sonnvse04038.fpt.edu.vn.mobilequiz.Object.Matching;
import sonnvse04038.fpt.edu.vn.mobilequiz.Object.MultipleChoice;


/**
 * A simple {@link Fragment} subclass.
 */
public class TestFragment extends Fragment implements View.OnClickListener {

    Button btnFinishNow, btnPrev, btnNext;
    ProgressBar prbStatus;
    private FragmentTabHost mTabHost;
    int percent = 100 / 6;
    int testID;

    DBHelper myDB;

    ArrayList<FillBlank> listFilling;
    ArrayList<Matching> listMatching;
    ArrayList<MultipleChoice> listMultiple;

    public TestFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        testID = getArguments().getInt("testID");//get test ID
        myDB = new DBHelper(getContext(), DBHelper.DB_NAME, null, DBHelper.DB_VERSION);

        listFilling = myDB.getAllFillBlankByTestID(testID); // get all fill blank question

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

        prbStatus = (ProgressBar) view.findViewById(R.id.prbStatus);
        prbStatus.setMax(100);
        prbStatus.getProgressDrawable().setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);

        mTabHost = (FragmentTabHost) getActivity().findViewById(android.R.id.tabhost);
        mTabHost.setup(getContext(), getActivity().getSupportFragmentManager(), android.R.id.tabcontent);
        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {

                Toast.makeText(getContext(), "Start!" + mTabHost.getCurrentTab() + " == " + mTabHost.getCurrentTabTag(), Toast.LENGTH_SHORT).show();
            }
        });

        int i = 0;

        //add all tab what is filling blank question
        for (FillBlank f : listFilling) {
            i++;
            Bundle bundle = new Bundle();
            bundle.putSerializable("fQuestion", f);
            mTabHost.addTab(mTabHost.newTabSpec("tab" + i).setIndicator("Q" + i, null), FillBlankFragment.class, bundle);
        }

        mTabHost.addTab(
                mTabHost.newTabSpec("tab3").setIndicator("Q 3", null),
                MultipleChoiceFragment.class, null);
        mTabHost.addTab(
                mTabHost.newTabSpec("tab4").setIndicator("Q 4", null),
                MultipleChoiceFragment.class, null);
        mTabHost.addTab(
                mTabHost.newTabSpec("tab5").setIndicator("Q 5", null),
                MatchingFragment.class, null);
        mTabHost.addTab(
                mTabHost.newTabSpec("tab6").setIndicator("Q 6", null),
                MatchingFragment.class, null);
        mTabHost.setCurrentTab(0);
    }


    @Override
    public void onClick(View view) {
        int GUI_id = view.getId();
        switch (GUI_id) {
            case R.id.btnFinishNow:

                View v = mTabHost.getChildAt(0);
                TextView tv = (TextView) v.findViewById(R.id.tvFQuestion);
                Toast.makeText(getContext(), "Start!" +tv.getText(), Toast.LENGTH_SHORT).show();
//                //Finish and go to Result fragment
//                ResultFragment fragment = new ResultFragment();
//                android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
//                fragmentTransaction.replace(R.id.test_fragment_container, fragment);
//                fragmentTransaction.commit();
                break;

            case R.id.btnNext:
                percent += 100 / 6;
                percent = percent >= 100 ? 100 : percent;
                prbStatus.setProgress(percent);
                mTabHost.setCurrentTab(percent * 6 / 100);
                break;

            case R.id.btnPrev:
                percent -= 100 / 6;
                percent = percent <= 0 ? 0 : percent;
                prbStatus.setProgress(percent);
                mTabHost.setCurrentTab(percent * 6 / 100);
                break;
        }
    }
}
