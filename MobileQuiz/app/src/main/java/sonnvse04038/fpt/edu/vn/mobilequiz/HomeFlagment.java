package sonnvse04038.fpt.edu.vn.mobilequiz;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFlagment extends Fragment implements View.OnClickListener {
    FloatingActionButton fab;
    Button btnDemoTest;


    public HomeFlagment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //get component by id here
        fab = (FloatingActionButton) view.findViewById(R.id.fabAdd);
        btnDemoTest = (Button) view.findViewById(R.id.btnDemoTest);

        //set listener here
        fab.setOnClickListener(this);
        btnDemoTest.setOnClickListener(this);

        GridView gridview = (GridView) view.findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(getContext()));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
//                Toast.makeText(HelloGridView.this, "" + position,
//                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        int GUI_id = view.getId();
        switch (GUI_id) {
            case R.id.fabAdd:
                Toast.makeText(getContext(), "Add button is clicked!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnDemoTest:
                Intent testIntent = new Intent(getContext(), TestActivity.class);
                testIntent.putExtra("testID", 333);
                startActivity(testIntent);
                break;

        }
    }
}