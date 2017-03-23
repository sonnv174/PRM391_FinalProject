package sonnvse04038.fpt.edu.vn.mobilequiz;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TableRow.LayoutParams;

import sonnvse04038.fpt.edu.vn.mobilequiz.Object.Result;


/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFlagment extends android.support.v4.app.Fragment {

    String user[] = {"NamKha","Son","Dung","Duong","Minh","Chi","Anh","Trung","Quang"};
    String test[] = {"Math","Geography","Physical","Accouting","Managing","Constructing","Programming","Art","History"};
    String time[] = {"11:00 23/02/2011","08:00 08/02/2011","18:10 02/02/2011","12:27 22/02/2011","11:15 14/02/2011","15:00 10/11/2011","10:00 15/03/2011","16:00 19/02/2011","12:00 24/02/2011"};
    String duration[]= {"45 minute","15 minute","30 minute","30 minute","30 minute","30 minute","30 minute","30 minute","30 minute"};
    //String comple[]= {"30 minute","10 minute","30 minute","27 minute","22 minute","15 minute","6 minute", "29 minute", "21 minute"};
    String mark[]= {"7","6","2","3","5","10","8","9","1"};
    //String status[]= {"Pass","Pass","Failed","Failed","Pass","Pass","Pass","Pass","Failed"};
    Result result = new Result(1,1,1,1,7.5);
    android.widget.TableLayout tl;
    android.widget.TableRow tr;
    android.widget.TextView tvUser,tvTestName,tvTimeStart,tvDuration,tvTimeCom,tvMark,tvStatus;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(sonnvse04038.fpt.edu.vn.mobilequiz.R.layout.fragment_history, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tl = (android.widget.TableLayout)view.findViewById(sonnvse04038.fpt.edu.vn.mobilequiz.R.id.tableLay);
        //tvUser = new android.widget.TextView(getContext());
        addHeader();
        addData();
    }

    /** This function add the headers to the table **/
    public void addHeader()
    {
        tr = new TableRow(getContext());
        tr.setLayoutParams(new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));

        tvUser = new TextView(getContext());
        tvUser.setText("User");
        tvUser.setLayoutParams(new LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        tvUser.setPadding(5, 5, 5, 0);
        tr.addView(tvUser);  // Adding textView to tablerow.

        /** Creating another textview **/
        tvTestName = new TextView(getContext());
        tvTestName.setText("Test Name");
        tvTestName.setLayoutParams(new LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        tvTestName.setPadding(5, 5, 5, 0);
        tr.addView(tvTestName); // Adding textView to tablerow.

        tvTimeStart = new TextView(getContext());
        tvTimeStart.setText("Time Start");
        tvTimeStart.setLayoutParams(new LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        tvTimeStart.setPadding(5, 5, 5, 0);
        tr.addView(tvTimeStart);

        tvDuration = new TextView(getContext());
        tvDuration.setText("Duration");
        tvDuration.setLayoutParams(new LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        tvDuration.setPadding(5, 5, 5, 0);
        tr.addView(tvDuration);


        tvMark = new TextView(getContext());
        tvMark.setText("Mark");
        tvMark.setLayoutParams(new LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        tvMark.setPadding(5, 5, 5, 0);
        tr.addView(tvMark);


        // Add the TableRow to the TableLayout
        tl.addView(tr, new TableLayout.LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT));
    }

    public void addData()
    {
        for (int i= 0; i<user.length;i++)
        {
            //android.widget.Toast.makeText(getContext(),""+user[i]+"", android.widget.Toast.LENGTH_LONG).show();
            //Auto create row
            tr =  new android.widget.TableRow(getContext());
            tr.setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, android.widget.TableRow.LayoutParams.WRAP_CONTENT));
            //Creating textview to add to the row
            tvUser = new android.widget.TextView(getContext());
            tvUser.setText(user[i]);
            tvUser.setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, android.widget.TableRow.LayoutParams.WRAP_CONTENT));
            tr.addView(tvUser);

            tvTestName = new android.widget.TextView(getContext());
            tvTestName.setText(test[i]);
            tr.setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, android.widget.TableRow.LayoutParams.WRAP_CONTENT));
            tr.addView(tvTestName);

            tvTimeStart = new android.widget.TextView(getContext());
            tvTimeStart.setText(time[i]);
            tr.setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, android.widget.TableRow.LayoutParams.WRAP_CONTENT));
            tr.addView(tvTimeStart);

            tvDuration = new android.widget.TextView(getContext());
            tvDuration.setText(duration[i]);
            tr.setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, android.widget.TableRow.LayoutParams.WRAP_CONTENT));
            tr.addView(tvDuration);

            tvMark = new android.widget.TextView(getContext());
            tvMark.setText(mark[i]);
            tr.setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, android.widget.TableRow.LayoutParams.WRAP_CONTENT));
            tr.addView(tvMark);


            //Add Tablerow to TableLayout
            tl.addView(tr, android.widget.TableLayout.LayoutParams.MATCH_PARENT, android.widget.TableRow.LayoutParams.WRAP_CONTENT);
        }
    }
    public HistoryFlagment() {
        // Required empty public constructor
    }



}
