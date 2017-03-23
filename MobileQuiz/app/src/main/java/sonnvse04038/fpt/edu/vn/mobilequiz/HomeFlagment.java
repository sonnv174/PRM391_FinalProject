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

import java.util.ArrayList;

import sonnvse04038.fpt.edu.vn.mobilequiz.Object.Test;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFlagment extends Fragment implements View.OnClickListener {
    FloatingActionButton fab;

    ArrayList<Test> listTest;
    DBHelper myDB;

    public HomeFlagment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        listTest = new ArrayList<>();
        myDB = new DBHelper(getContext(), DBHelper.DB_NAME, null, DBHelper.DB_VERSION);

        listTest = myDB.getAllTest();
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //get component by id here
        fab = (FloatingActionButton) view.findViewById(R.id.fabAdd);

        //set listener here
        fab.setOnClickListener(this);

        for (int i = 0; i< listTest.size(); i++) {
            listTestName.add(listTest.get(i).gettName());
            if(i%6 == 0) {
                listImageId.add(R.drawable.hm_twitter);
            }
            if(i%6 == 1) {
                listImageId.add(R.drawable.hm_instagram);
            }
            if(i%6 == 2) {
                listImageId.add(R.drawable.hm_linkedin);
            }
            if(i%6 == 3) {
                listImageId.add(R.drawable.hm_plus);
            }
            if(i%6 == 4) {
                listImageId.add(R.drawable.hm_facebook);
            }
            if(i%6 == 5) {
                listImageId.add(R.drawable.hm_youtube);
            }
        }
        CustomGrid adapter = new CustomGrid(getContext(), listTestName, listImageId);
        grid = (GridView) view.findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent testIntent = new Intent(getContext(), TestActivity.class);
                testIntent.putExtra("testID", position + 1);
                startActivity(testIntent);
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

        }
    }

    GridView grid;
    ArrayList<String> listTestName = new ArrayList<>();
    ArrayList<Integer> listImageId = new ArrayList<>();
}