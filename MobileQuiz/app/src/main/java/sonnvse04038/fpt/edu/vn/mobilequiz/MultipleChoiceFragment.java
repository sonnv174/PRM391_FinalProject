package sonnvse04038.fpt.edu.vn.mobilequiz;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MultipleChoiceFragment extends Fragment implements View.OnClickListener{

    RadioButton radA, radB, radC, radD, radE;

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
        radE = (RadioButton) view.findViewById(R.id.radE);

        radA.setOnClickListener(this);
        radB.setOnClickListener(this);
        radC.setOnClickListener(this);
        radD.setOnClickListener(this);
        radE.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int GUI_id = view.getId();
        switch (GUI_id) {
            case R.id.radA:
                Toast.makeText(getContext(), "A radio button is checked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radB:
                Toast.makeText(getContext(), "B radio button is checked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radC:
                Toast.makeText(getContext(), "C radio button is checked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radD:
                Toast.makeText(getContext(), "D radio button is checked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radE:
                Toast.makeText(getContext(), "E radio button is checked!", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
