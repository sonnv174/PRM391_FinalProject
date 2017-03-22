package sonnvse04038.fpt.edu.vn.mobilequiz;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import sonnvse04038.fpt.edu.vn.mobilequiz.Object.FillBlank;


/**
 * A simple {@link Fragment} subclass.
 */
public class FillBlankFragment extends Fragment {

    EditText edtAnswer1, edtAnswer2, edtAnswer3, edtAnswer4, edtAnswer5;
    TextView tvQuestion;
    FillBlank fb;

    public void setQuestion(String question) {
        this.question = question;
    }

    String question;

    public FillBlankFragment() {
        // Required empty public constructor
    }

    public FillBlankFragment(FillBlank fb) {
        this.fb = fb;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_fill_blank, container, false);
        View v = inflater.inflate(R.layout.fragment_fill_blank, container, false);
        edtAnswer1 = (EditText) v.findViewById(R.id.edtAnswer1);
        edtAnswer2 = (EditText) v.findViewById(R.id.edtAnswer2);
        edtAnswer3 = (EditText) v.findViewById(R.id.edtAnswer3);
        edtAnswer4 = (EditText) v.findViewById(R.id.edtAnswer4);
        edtAnswer5 = (EditText) v.findViewById(R.id.edtAnswer5);

        tvQuestion = (TextView) v.findViewById(R.id.tvFQuestion);

        //get object was sent from TestFragment
        Bundle bd = getArguments();
        fb = (FillBlank) bd.getSerializable("fQuestion");
        tvQuestion.setText(fb.getfQuestion());
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    public boolean getResult() {

        return false;
    }
}
