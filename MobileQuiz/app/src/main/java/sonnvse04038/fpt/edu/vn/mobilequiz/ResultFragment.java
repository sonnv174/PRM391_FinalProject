package sonnvse04038.fpt.edu.vn.mobilequiz;

import android.view.View;
import android.widget.Toast;

/**
 * Created by admin on 3/9/2017.
 */


public class ResultFragment extends android.support.v4.app.Fragment implements android.view.View.OnClickListener{


    android.widget.Button btnDone;
    String number[]= {"1","2","3","4","5"};
    String part[]= {"Choices","Missing Word","Missing Word","Missing Word","Matching"};
    String simpleCon[]= {"1+1=","Can share info by 5 ways in Android?","Android has       version.","Google is       company","1A"};
    String status[]= {"True","False","True","True","True"};
    android.widget.TextView Question,Part, SimpleContent, Status;
    android.widget.TableLayout tbRe,tbDe;
    android.widget.TableRow tr,trDe;
    android.widget.TextView tvUser,tvTestName,tvTimeStart,tvDuration,tvTimeCom,tvMark,tvStatus;

    @Override
    public android.view.View onCreateView(android.view.LayoutInflater inflater, android.view.ViewGroup container,
                                          android.os.Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(sonnvse04038.fpt.edu.vn.mobilequiz.R.layout.fragment_result, container, false);
    }

    @Override
    public void onViewCreated(android.view.View view, @android.support.annotation.Nullable android.os.Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tbRe = (android.widget.TableLayout)view.findViewById(sonnvse04038.fpt.edu.vn.mobilequiz.R.id.tbResult);
        //tvUser = new android.widget.TextView(getContext());0
        tbDe = (android.widget.TableLayout) view.findViewById(sonnvse04038.fpt.edu.vn.mobilequiz.R.id.tbResult);
        btnDone = (android.widget.Button)view.findViewById(sonnvse04038.fpt.edu.vn.mobilequiz.R.id.btnDone);
        btnDone.setOnClickListener(this);
        addHeader();
        //addData();
        showResult();

        addDetailHearder();
        showDetailTests();
    }

    private void showDetailTests() {
        for (int i= 0; i<number.length;i++)
        {
            //Auto create row
            trDe =  new android.widget.TableRow(getContext());
            trDe.setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, android.widget.TableRow.LayoutParams.WRAP_CONTENT));
            //Creating textview to add to the row
            Question = new android.widget.TextView(getContext());
            Question.setText(number[i]);
            trDe.setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, android.widget.TableRow.LayoutParams.WRAP_CONTENT));
            trDe.addView(Question);
//
            Part = new android.widget.TextView(getContext());
            Part.setText(part[i]);
            trDe.setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, android.widget.TableRow.LayoutParams.WRAP_CONTENT));
            trDe.addView(Part);

            SimpleContent = new android.widget.TextView(getContext());
            SimpleContent.setText(simpleCon[i]);
            trDe.setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, android.widget.TableRow.LayoutParams.WRAP_CONTENT));
            trDe.addView(SimpleContent);
//
//
            Status = new android.widget.TextView(getContext());
            Status.setText(status[i]);
            trDe.setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, android.widget.TableRow.LayoutParams.WRAP_CONTENT));
            trDe.addView(Status);

            //Add Tablerow to TableLayout
            tbDe.addView(trDe, android.widget.TableRow.LayoutParams.MATCH_PARENT, android.widget.TableRow.LayoutParams.WRAP_CONTENT);

        }
    }

    private void addDetailHearder() {
        tr = new android.widget.TableRow(getContext());
        tr.setLayoutParams(new android.widget.TableRow.LayoutParams(
                android.widget.TableRow.LayoutParams.MATCH_PARENT,
                android.widget.TableRow.LayoutParams.WRAP_CONTENT));

        Question = new android.widget.TextView(getContext());
        Question.setText("Question");
        Question.setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, android.widget.TableRow.LayoutParams.WRAP_CONTENT));
        //Question.setPadding(5, 5, 5, 0);
        tr.addView(Question);  // Adding textView to tablerow.

        /** Creating another textview **/
        Part = new android.widget.TextView(getContext());
        Part.setText("Part");
        Part.setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, android.widget.TableRow.LayoutParams.WRAP_CONTENT));
        //Part.setPadding(5, 5, 5, 0);
        tr.addView(Part); // Adding textView to tablerow.

        SimpleContent = new android.widget.TextView(getContext());
        SimpleContent.setText("Simple Content");
        SimpleContent.setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, android.widget.TableRow.LayoutParams.WRAP_CONTENT));
        //SimpleContent.setPadding(5, 5, 5, 0);
        tr.addView(SimpleContent);

        Status = new android.widget.TextView(getContext());
        Status.setText("Status");
        Status.setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, android.view.ViewGroup.LayoutParams.WRAP_CONTENT));
        //Status.setPadding(5, 5, 5, 0);
        tr.addView(Status);


        // Add the TableRow to the TableLayout
        tbDe.addView(tr, new android.widget.TableLayout.LayoutParams(
                android.widget.TableRow.LayoutParams.MATCH_PARENT,
                android.widget.TableRow.LayoutParams.WRAP_CONTENT));
    }

    /** This function add the headers to the table **/
    public void addHeader()
    {
        tr = new android.widget.TableRow(getContext());
        tr.setLayoutParams(new android.widget.TableRow.LayoutParams(
                android.widget.TableRow.LayoutParams.MATCH_PARENT,
                android.widget.TableRow.LayoutParams.WRAP_CONTENT));

        tvUser = new android.widget.TextView(getContext());
        tvUser.setText("User");
        tvUser.setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, android.widget.TableRow.LayoutParams.WRAP_CONTENT));
        tvUser.setPadding(5, 5, 5, 0);
        tr.addView(tvUser);  // Adding textView to tablerow.

        /** Creating another textview **/
        tvTestName = new android.widget.TextView(getContext());
        tvTestName.setText("Test Name");
        tvTestName.setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, android.widget.TableRow.LayoutParams.WRAP_CONTENT));
        tvTestName.setPadding(5, 5, 5, 0);
        tr.addView(tvTestName); // Adding textView to tablerow.

        tvTimeStart = new android.widget.TextView(getContext());
        tvTimeStart.setText("Time Start");
        tvTimeStart.setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, android.widget.TableRow.LayoutParams.WRAP_CONTENT));
        tvTimeStart.setPadding(5, 5, 5, 0);
        tr.addView(tvTimeStart);

        tvDuration = new android.widget.TextView(getContext());
        tvDuration.setText("Duration");
        tvDuration.setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, android.widget.TableRow.LayoutParams.WRAP_CONTENT));
        tvDuration.setPadding(5, 5, 5, 0);
        tr.addView(tvDuration);

        tvTimeCom = new android.widget.TextView(getContext());
        tvTimeCom.setText("Time Completed");
        tvTimeCom.setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, android.widget.TableRow.LayoutParams.WRAP_CONTENT));
        tvTimeCom.setPadding(5, 5, 5, 0);
        tr.addView(tvTimeCom);

        tvMark = new android.widget.TextView(getContext());
        tvMark.setText("Mark");
        tvMark.setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, android.widget.TableRow.LayoutParams.WRAP_CONTENT));
        tvMark.setPadding(5, 5, 5, 0);
        tr.addView(tvMark);

        tvStatus = new android.widget.TextView(getContext());
        tvStatus.setText("Status");
        tvStatus.setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, android.widget.TableRow.LayoutParams.WRAP_CONTENT));
        tvStatus.setPadding(5, 5, 5, 0);
        tr.addView(tvStatus);
        // Add the TableRow to the TableLayout
        tbRe.addView(tr, new android.widget.TableLayout.LayoutParams(
                android.widget.TableRow.LayoutParams.MATCH_PARENT,
                android.widget.TableRow.LayoutParams.WRAP_CONTENT));
    }

    public void showResult()
    {
        tr = new android.widget.TableRow(getContext());
        tr.setLayoutParams(new android.widget.TableRow.LayoutParams(
                android.widget.TableRow.LayoutParams.MATCH_PARENT,
                android.widget.TableRow.LayoutParams.WRAP_CONTENT));

        tvUser = new android.widget.TextView(getContext());
        tvUser.setText("Nam Kha");
        tvUser.setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, android.widget.TableRow.LayoutParams.WRAP_CONTENT));
        tvUser.setPadding(5, 5, 5, 0);
        tr.addView(tvUser);  // Adding textView to tablerow.

        /** Creating another textview **/
        tvTestName = new android.widget.TextView(getContext());
        tvTestName.setText("Math");
        tvTestName.setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, android.widget.TableRow.LayoutParams.WRAP_CONTENT));
        tvTestName.setPadding(5, 5, 5, 0);
        tr.addView(tvTestName); // Adding textView to tablerow.

        tvTimeStart = new android.widget.TextView(getContext());
        tvTimeStart.setText("11:00 23/02/2011");
        tvTimeStart.setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, android.widget.TableRow.LayoutParams.WRAP_CONTENT));
        tvTimeStart.setPadding(5, 5, 5, 0);
        tr.addView(tvTimeStart);

        tvDuration = new android.widget.TextView(getContext());
        tvDuration.setText("45 minutes");
        tvDuration.setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, android.widget.TableRow.LayoutParams.WRAP_CONTENT));
        tvDuration.setPadding(5, 5, 5, 0);
        tr.addView(tvDuration);

        tvTimeCom = new android.widget.TextView(getContext());
        tvTimeCom.setText("30 minutes");
        tvTimeCom.setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, android.widget.TableRow.LayoutParams.WRAP_CONTENT));
        tvTimeCom.setPadding(5, 5, 5, 0);
        tr.addView(tvTimeCom);

        tvMark = new android.widget.TextView(getContext());
        tvMark.setText("7");
        tvMark.setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, android.widget.TableRow.LayoutParams.WRAP_CONTENT));
        tvMark.setPadding(5, 5, 5, 0);
        tr.addView(tvMark);

        tvStatus = new android.widget.TextView(getContext());
        tvStatus.setText("Passed");
        tvStatus.setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.MATCH_PARENT, android.widget.TableRow.LayoutParams.WRAP_CONTENT));
        tvStatus.setPadding(5, 5, 5, 0);
        tr.addView(tvStatus);
        // Add the TableRow to the TableLayout
        tbRe.addView(tr, new android.widget.TableLayout.LayoutParams(
                android.widget.TableRow.LayoutParams.MATCH_PARENT,
                android.widget.TableRow.LayoutParams.WRAP_CONTENT));
    }


    @Override
    public void onClick(View view) {
        int Gui_Id = view.getId();
        switch (Gui_Id) {
            case R.id.btnDone:
                getActivity().finish();
                Toast.makeText(getContext(), "Done", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
