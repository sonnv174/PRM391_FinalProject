package sonnvse04038.fpt.edu.vn.mobilequiz;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TableRow.LayoutParams;
import android.widget.Toast;

import java.util.ArrayList;

import sonnvse04038.fpt.edu.vn.mobilequiz.Object.History;
import sonnvse04038.fpt.edu.vn.mobilequiz.Object.Result;


/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFlagment extends android.support.v4.app.Fragment implements View.OnClickListener {

    ArrayList<History> listHistory;
    DBHelper myDB;
    Button btnDelete;

    ArrayList<String> userName = new ArrayList<>();
    ArrayList<String> testName = new ArrayList<>();
    ArrayList<String> testDuration = new ArrayList<>();
    ArrayList<String> timeStart = new ArrayList<>();
    ArrayList<String> timeComplete = new ArrayList<>();
    String duration[] = {"45 minute", "15 minute", "30 minute", "30 minute", "30 minute", "30 minute", "30 minute", "30 minute", "30 minute"};
    //String comple[]= {"30 minute","10 minute","30 minute","27 minute","22 minute","15 minute","6 minute", "29 minute", "21 minute"};
    String mark[] = {"7", "6", "2", "3", "5", "10", "8", "9", "1"};
    //String status[]= {"Pass","Pass","Failed","Failed","Pass","Pass","Pass","Pass","Failed"};
    Result result = new Result(1, 1, 1, 7.5, "12-12-2012 12:12", "10 mins");
    android.widget.TableLayout tl;
    android.widget.TableRow tr;
    android.widget.TextView tvUser, tvTestName, tvTimeStart, tvTimeComplete, tvMark, tvTestDuration;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        myDB = new DBHelper(getContext(), DBHelper.DB_NAME, null, DBHelper.DB_VERSION);
        listHistory = myDB.getAllHistory();

        return inflater.inflate(sonnvse04038.fpt.edu.vn.mobilequiz.R.layout.fragment_history, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tl = (android.widget.TableLayout) view.findViewById(sonnvse04038.fpt.edu.vn.mobilequiz.R.id.tableLay);

        btnDelete = (Button) view.findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(this);
        //tvUser = new android.widget.TextView(getContext());
        addHeader();
        addData();
    }

    /**
     * This function add the headers to the table
     **/
    public void addHeader() {
        tr = new TableRow(getContext());
        tr.setLayoutParams(new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT));

        tvUser = new TextView(getContext());
        tvUser.setText("User Name");
        tvUser.setLayoutParams(new LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        tvUser.setPadding(20, 20, 20, 20);
        tr.addView(tvUser);  // Adding textView to tablerow.

        /** Creating another textview **/
        tvTestName = new TextView(getContext());
        tvTestName.setText("Test Name");
        tvTestName.setLayoutParams(new LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        tvTestName.setPadding(20, 20, 20, 20);
        tr.addView(tvTestName); // Adding textView to tablerow.

        tvTestDuration = new TextView(getContext());
        tvTestDuration.setText("Test Duration");
        tvTestDuration.setLayoutParams(new LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        tvTestDuration.setPadding(20, 20, 20, 20);
        tr.addView(tvTestDuration);

        tvTimeStart = new TextView(getContext());
        tvTimeStart.setText("Time Start");
        tvTimeStart.setLayoutParams(new LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        tvTimeStart.setPadding(20, 20, 20, 20);
        tr.addView(tvTimeStart);

        tvTimeComplete = new TextView(getContext());
        tvTimeComplete.setText("Time Complete");
        tvTimeComplete.setLayoutParams(new LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        tvTimeComplete.setPadding(20, 20, 20, 20);
        tr.addView(tvTimeComplete);


        tvMark = new TextView(getContext());
        tvMark.setText("Mark");
        tvMark.setLayoutParams(new LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        tvMark.setPadding(20, 20, 20, 20);
        tr.addView(tvMark);


        // Add the TableRow to the TableLayout
        tl.addView(tr, new TableLayout.LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.MATCH_PARENT));
    }

    public void addData() {
        for (int i = 0; i < listHistory.size(); i++) {
            //android.widget.Toast.makeText(getContext(),""+user[i]+"", android.widget.Toast.LENGTH_LONG).show();
            //Auto create row
            tr = new android.widget.TableRow(getContext());
            tr.setPadding(10, 10, 10, 10);
            tr.setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, android.widget.TableRow.LayoutParams.MATCH_PARENT));
            //Creating textview to add to the row
            tvUser = new android.widget.TextView(getContext());
            tvUser.setText(listHistory.get(i).getUserName());
            tvUser.setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, android.widget.TableRow.LayoutParams.MATCH_PARENT));
            tr.addView(tvUser);

            tvTestName = new android.widget.TextView(getContext());
            tvTestName.setText(listHistory.get(i).getTestName());
            tr.setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, android.widget.TableRow.LayoutParams.MATCH_PARENT));
            tr.addView(tvTestName);


            int sec = (int) (listHistory.get(i).getDuration() % 60);
            int min = (int) ((listHistory.get(i).getDuration() / 60) % 60);
            tvTestDuration = new android.widget.TextView(getContext());
            tvTestDuration.setText(min + " mins " + sec + " seconds");
            tr.setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, android.widget.TableRow.LayoutParams.MATCH_PARENT));
            tr.addView(tvTestDuration);

            tvTimeStart = new android.widget.TextView(getContext());
            tvTimeStart.setText(listHistory.get(i).getTimeStart());
            tr.setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, android.widget.TableRow.LayoutParams.MATCH_PARENT));
            tr.addView(tvTimeStart);

            tvTimeComplete = new android.widget.TextView(getContext());
            tvTimeComplete.setText(listHistory.get(i).getTimeComplete());
            tr.setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, android.widget.TableRow.LayoutParams.MATCH_PARENT));
            tr.addView(tvTimeComplete);

            tvMark = new android.widget.TextView(getContext());
            tvMark.setText(String.format("%.1f", listHistory.get(i).getMark()));
            tr.setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, android.widget.TableRow.LayoutParams.MATCH_PARENT));
            tr.addView(tvMark);


            //Add Tablerow to TableLayout
            tl.addView(tr, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        }
    }

    public HistoryFlagment() {
        // Required empty public constructor
    }


    @Override
    public void onClick(View view) {
        int Gui_Id = view.getId();
        switch (Gui_Id) {
            case R.id.btnDelete:
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

                builder.setTitle("Delete History");
                builder.setMessage("Do you want to delete all of history?");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // Do do my action here
                        myDB.deleteAllHistory();
                        HistoryFlagment fragment = new HistoryFlagment();
                        android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container, fragment);
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
                break;
        }
    }
}
