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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TabHost;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class TestFragment extends Fragment implements View.OnClickListener {

    Button btnFinishNow, btnPrev, btnNext;
    ProgressBar prbStatus;
    private FragmentTabHost mTabHost;
    int percent = 100/6;

    public TestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

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

        mTabHost.addTab(
                mTabHost.newTabSpec("tab1").setIndicator("Q 1", null),
                FillBlankFragment.class, null);
        mTabHost.addTab(
                mTabHost.newTabSpec("tab2").setIndicator("Q 2", null),
                FillBlankFragment.class, null);
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
                //Finish and go to Result fragment
                ResultFragment fragment = new ResultFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.test_fragment_container, fragment);
                fragmentTransaction.commit();
                break;

            case R.id.btnNext:
                percent += 100/6;
                percent = percent >= 100 ? 100 : percent;
                prbStatus.setProgress(percent);
                mTabHost.setCurrentTab(percent*6/100);
                break;

            case R.id.btnPrev:
                percent -= 100/6;
                percent = percent <= 0 ? 0 : percent;
                prbStatus.setProgress(percent);
                mTabHost.setCurrentTab(percent*6/100);
                break;
        }
    }
}
