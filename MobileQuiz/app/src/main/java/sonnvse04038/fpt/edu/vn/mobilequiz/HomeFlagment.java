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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import sonnvse04038.fpt.edu.vn.mobilequiz.Object.FillBlank;
import sonnvse04038.fpt.edu.vn.mobilequiz.Object.Matching;
import sonnvse04038.fpt.edu.vn.mobilequiz.Object.MultipleChoice;
import sonnvse04038.fpt.edu.vn.mobilequiz.Object.Test;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFlagment extends Fragment implements View.OnClickListener {
    private static final int REQUEST_FILE_CODE = 6969;
    FloatingActionButton fab;
    File file;
    String jsonString;

    JSONObject jsonRoot;
    JSONObject jsonTest;
    JSONArray jsonMultipleArray, jsonFillingArray, jsonMatchingArray;

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

        for (int i = 0; i < listTest.size(); i++) {
            listTestName.add(listTest.get(i).gettName());
            if (i % 6 == 0) {
                listImageId.add(R.drawable.hm_twitter);
            }
            if (i % 6 == 1) {
                listImageId.add(R.drawable.hm_instagram);
            }
            if (i % 6 == 2) {
                listImageId.add(R.drawable.hm_linkedin);
            }
            if (i % 6 == 3) {
                listImageId.add(R.drawable.hm_plus);
            }
            if (i % 6 == 4) {
                listImageId.add(R.drawable.hm_facebook);
            }
            if (i % 6 == 5) {
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
                try {
                    Intent fileIntent = new Intent(Intent.ACTION_GET_CONTENT);
                    fileIntent.setType("file/*"); // intent type to filter application based on your requirement
                    startActivityForResult(fileIntent, REQUEST_FILE_CODE);
//                Toast.makeText(getContext(), "Add button is clicked!", Toast.LENGTH_SHORT).show();
                }catch(Exception e) {

                }
                break;

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_FILE_CODE) {
            try {
                String FilePath = data.getData().getPath();
                if(FilePath == null) throw new Exception();
                file = new File(FilePath);
                FileInputStream fis = new FileInputStream(file);
                InputStream is = new BufferedInputStream(fis);
                jsonString = convertStreamToString(is);

                addDataByJSON();

                HomeFlagment fragment = new HomeFlagment();
                android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            //    Toast.makeText(getContext(), jsonString, Toast.LENGTH_SHORT).show();
        }
    }
    public void addDataByJSON() {
        try {
            jsonRoot = new JSONObject(jsonString);
            jsonTest = jsonRoot.getJSONObject("test");
            jsonFillingArray = jsonRoot.getJSONArray("filling");
            jsonMultipleArray = jsonRoot.getJSONArray("multiple");
            jsonMatchingArray = jsonRoot.getJSONArray("matching");

            Test t = new Test();
            t.settStatus(jsonTest.getInt("tStatus"));
            t.settName(jsonTest.getString("tName"));
            t.setTime(jsonTest.getInt("time"));
            t.setInfo(jsonTest.getString("info"));
            myDB.insertTest(t);
            int newTestID = myDB.getNewTestID();
            for (int i = 0; i < jsonFillingArray.length(); i++) {
                JSONObject jo = (JSONObject) jsonFillingArray.get(i);
                FillBlank q = new FillBlank();
                q.settID(newTestID);
                q.setfQuestion(jo.getString("fQuestion"));
                q.setfStatus(jo.getInt("fStatus"));
                q.setfAnswer1(jo.getString("fAnswer1"));
                q.setfAnswer2(jo.getString("fAnswer2"));
                q.setfAnswer3(jo.getString("fAnswer3"));
                q.setfAnswer4(jo.getString("fAnswer4"));
                q.setfAnswer5(jo.getString("fAnswer5"));
                myDB.insertFilling(q);
            }

            for (int i = 0; i < jsonMatchingArray.length(); i++) {
                JSONObject jo = (JSONObject) jsonMatchingArray.get(i);
                Matching q = new Matching();
                q.settID(newTestID);
                q.setmQuestion(jo.getString("matQuestion"));
                q.setStatus(jo.getInt("matStatus"));
                q.setmAnswer1(jo.getString("matAnswer1"));
                q.setmAnswer2(jo.getString("matAnswer2"));
                q.setmAnswer3(jo.getString("matAnswer3"));
                q.setmAnswer4(jo.getString("matAnswer4"));
                myDB.insertMatching(q);
            }


            for (int i = 0; i < jsonMultipleArray.length(); i++) {
                JSONObject jo = (JSONObject) jsonMultipleArray.get(i);
                MultipleChoice q = new MultipleChoice();
                q.settID(newTestID);
                q.setMulQuestion(jo.getString("mulQuestion"));
                q.setMulStatus(jo.getInt("mulStatus"));
                q.setMulRighAnswer(jo.getString("mulRighAnswer"));
                q.setMulAnswer1(jo.getString("mulAnswer1"));
                q.setMulAnswer2(jo.getString("mulAnswer2"));
                q.setMulAnswer3(jo.getString("mulAnswer3"));
                q.setMulAnswer4(jo.getString("mulAnswer4"));
                myDB.insertMultiple(q);
            }

            Toast.makeText(getContext(), "The " + t.gettName() + " is added!", Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }

    GridView grid;
    ArrayList<String> listTestName = new ArrayList<>();
    ArrayList<Integer> listImageId = new ArrayList<>();
}