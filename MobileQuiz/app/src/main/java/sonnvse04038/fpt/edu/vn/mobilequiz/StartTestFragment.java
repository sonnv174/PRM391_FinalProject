package sonnvse04038.fpt.edu.vn.mobilequiz;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class StartTestFragment extends Fragment implements View.OnClickListener{


    Button btnStart, btnCancel;

    public StartTestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start_test, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnStart = (Button) view.findViewById(R.id.btnStart);
        btnCancel = (Button) view.findViewById(R.id.btnCancel);

        btnStart.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int GUI_id = view.getId();
        switch (GUI_id) {
            case R.id.btnStart:
                Toast.makeText(getContext(), "Start!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnCancel:
                //return result intent is cancel to go to home screen
                //else result intent is finish, it will be gone to Resuklt screen
                Toast.makeText(getContext(), "Cancel!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(), HomeActivity.class));
                break;

        }
    }
}
