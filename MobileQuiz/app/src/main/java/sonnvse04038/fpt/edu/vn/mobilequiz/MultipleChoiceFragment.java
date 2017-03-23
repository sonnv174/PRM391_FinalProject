package sonnvse04038.fpt.edu.vn.mobilequiz;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import sonnvse04038.fpt.edu.vn.mobilequiz.Object.MultipleChoice;


/**
 * A simple {@link Fragment} subclass.
 */
public class MultipleChoiceFragment extends Fragment implements View.OnClickListener{

    RadioButton radA, radB, radC, radD;
    TextView tvQuestion;
    String righAnswer = "Question A";
    String answer = "";
    boolean result = false;
    MultipleChoice mc = new MultipleChoice(0, 0, null, null, null, null, null, null, null);

    public MultipleChoiceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_multiple_choice, container, false);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        radA = (RadioButton) view.findViewById(R.id.radA);
        radB = (RadioButton) view.findViewById(R.id.radB);
        radC = (RadioButton) view.findViewById(R.id.radC);
        radD = (RadioButton) view.findViewById(R.id.radD);

        tvQuestion = (TextView) view.findViewById(R.id.tvMulQuestion);

        radA.setOnClickListener(this);
        radB.setOnClickListener(this);
        radC.setOnClickListener(this);
        radD.setOnClickListener(this);

        mc.setMulQuestion("Question");
        mc.setMulAnswer1("Answer A");
        mc.setMulAnswer2("Answer B");
        mc.setMulAnswer3("Answer C");
        mc.setMulAnswer4("Answer D");
        mc.setMulRighAnswer(righAnswer);

        tvQuestion.setText(mc.getMulQuestion());
        radA.setText(mc.getMulAnswer1());
        radB.setText(mc.getMulAnswer2());
        radC.setText(mc.getMulAnswer3());
        radD.setText(mc.getMulAnswer4());
    }

    @Override
    public void onClick(View view) {
        int GUI_id = view.getId();
        switch (GUI_id) {
            case R.id.radA:
                Toast.makeText(getContext(), radA.getText().toString()+" button is checked!", Toast.LENGTH_SHORT).show();
                answer = radA.getText().toString();
                break;
            case R.id.radB:
                Toast.makeText(getContext(), radB.getText().toString()+" button is checked!", Toast.LENGTH_SHORT).show();
                answer = radB.getText().toString();
                break;
            case R.id.radC:
                Toast.makeText(getContext(), radC.getText().toString()+" button is checked!", Toast.LENGTH_SHORT).show();
                answer = radC.getText().toString();
                break;
            case R.id.radD:
                Toast.makeText(getContext(), radD.getText().toString()+" button is checked!", Toast.LENGTH_SHORT).show();
                answer = radD.getText().toString();
                break;
        }
        if(answer == mc.getMulRighAnswer()){
            result = true;
        }
    }
}
