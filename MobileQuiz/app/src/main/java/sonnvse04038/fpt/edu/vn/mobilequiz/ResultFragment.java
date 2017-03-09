package sonnvse04038.fpt.edu.vn.mobilequiz;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 */
public class ResultFragment extends Fragment implements View.OnClickListener {
    Button btnDone;
    String number[] = {"1", "2", "3", "4", "5"};
    String part[] = {"Choices", "Missing Word", "Matching"};
    String simpleCon[] = {"1+1=", "Can share info by 5 ways in Android?", "Android has       version.", "Google is       company", "1A"};
    String status[] = {"True", "False"};
    TextView Question, Part, SimpleContent, Status;
    TableLayout tbRe, tbDe;
    TableRow tr;
    TextView tvUser, tvTestName, tvTimeStart, tvDuration, tvTimeCom, tvMark, tvStatus;

    public ResultFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_result, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tbRe = (TableLayout) view.findViewById(R.id.tbResult);
        //tvUser = new TextView(getActivity().getApplicationContext());0
        tbDe = (TableLayout) view.findViewById(R.id.tbDetail);
        btnDone = (Button) view.findViewById(R.id.btnDone);
        btnDone.setOnClickListener(this);
//        addHeader();
//        //addData();
//        showResult();
//
//        addDetailHearder();
//        showDetailTests();
    }

//    private void showDetailTests() {
//        for (int i = 0; i < number.length; i++) {
//            //Auto create row
//            tr = new TableRow(getActivity().getApplicationContext());
//            tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
//            //Creating textview to add to the row
//            Question = new TextView(getActivity().getApplicationContext());
//            Question.setText(number[i]);
//            Question.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
//            tr.addView(Question);
//
//            Part = new TextView(getActivity().getApplicationContext());
//            Part.setText(part[i]);
//            tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
//            tr.addView(Part);
//
//            Status = new TextView(getActivity().getApplicationContext());
//            Status.setText(status[i]);
//            tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
//            tr.addView(Status);
//
//            //Add Tablerow to TableLayout
//            tbDe.addView(tr, TableLayout.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
//        }
//    }
//
//    private void addDetailHearder() {
//        tr = new TableRow(getActivity().getApplicationContext());
//        tr.setLayoutParams(new TableRow.LayoutParams(
//                TableRow.LayoutParams.MATCH_PARENT,
//                TableRow.LayoutParams.WRAP_CONTENT));
//
//        Question = new TextView(getActivity().getApplicationContext());
//        Question.setText("Question");
//        Question.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
//        Question.setPadding(5, 5, 5, 0);
//        tr.addView(Question);  // Adding textView to tablerow.
//
//        /** Creating another textview **/
//        Part = new TextView(getActivity().getApplicationContext());
//        Part.setText("Part");
//        Part.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
//        Part.setPadding(5, 5, 5, 0);
//        tr.addView(Part); // Adding textView to tablerow.
//
//        SimpleContent = new TextView(getActivity().getApplicationContext());
//        SimpleContent.setText("Simple Content");
//        SimpleContent.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
//        SimpleContent.setPadding(5, 5, 5, 0);
//        tr.addView(SimpleContent);
//
//        // Add the TableRow to the TableLayout
//        tbDe.addView(tr, new TableLayout.LayoutParams(
//                TableRow.LayoutParams.MATCH_PARENT,
//                TableRow.LayoutParams.WRAP_CONTENT));
//    }
//
//    /**
//     * This function add the headers to the table
//     **/
//    public void addHeader() {
//        tr = new TableRow(getActivity().getApplicationContext());
//        tr.setLayoutParams(new TableRow.LayoutParams(
//                TableRow.LayoutParams.MATCH_PARENT,
//                TableRow.LayoutParams.WRAP_CONTENT));
//
//        tvUser = new TextView(getActivity().getApplicationContext());
//        tvUser.setText("User");
//        tvUser.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
//        tvUser.setPadding(5, 5, 5, 0);
//        tr.addView(tvUser);  // Adding textView to tablerow.
//
//        /** Creating another textview **/
//        tvTestName = new TextView(getActivity().getApplicationContext());
//        tvTestName.setText("Test Name");
//        tvTestName.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
//        tvTestName.setPadding(5, 5, 5, 0);
//        tr.addView(tvTestName); // Adding textView to tablerow.
//
//        tvTimeStart = new TextView(getActivity().getApplicationContext());
//        tvTimeStart.setText("Time Start");
//        tvTimeStart.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
//        tvTimeStart.setPadding(5, 5, 5, 0);
//        tr.addView(tvTimeStart);
//
//        tvDuration = new TextView(getActivity().getApplicationContext());
//        tvDuration.setText("Duration");
//        tvDuration.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
//        tvDuration.setPadding(5, 5, 5, 0);
//        tr.addView(tvDuration);
//
//        tvTimeCom = new TextView(getActivity().getApplicationContext());
//        tvTimeCom.setText("Time Completed");
//        tvTimeCom.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
//        tvTimeCom.setPadding(5, 5, 5, 0);
//        tr.addView(tvTimeCom);
//
//        tvMark = new TextView(getActivity().getApplicationContext());
//        tvMark.setText("Mark");
//        tvMark.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
//        tvMark.setPadding(5, 5, 5, 0);
//        tr.addView(tvMark);
//
//        tvStatus = new TextView(getActivity().getApplicationContext());
//        tvStatus.setText("Status");
//        tvStatus.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
//        tvStatus.setPadding(5, 5, 5, 0);
//        tr.addView(tvStatus);
//        // Add the TableRow to the TableLayout
//        tbRe.addView(tr, new TableLayout.LayoutParams(
//                TableRow.LayoutParams.MATCH_PARENT,
//                TableRow.LayoutParams.WRAP_CONTENT));
//    }
//
//    public void showResult() {
//        tr = new TableRow(getActivity().getApplicationContext());
//        tr.setLayoutParams(new TableRow.LayoutParams(
//                TableRow.LayoutParams.MATCH_PARENT,
//                TableRow.LayoutParams.WRAP_CONTENT));
//
//        tvUser = new TextView(getActivity().getApplicationContext());
//        tvUser.setText("Nam Kha");
//        tvUser.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
//        tvUser.setPadding(5, 5, 5, 0);
//        tr.addView(tvUser);  // Adding textView to tablerow.
//
//        /** Creating another textview **/
//        tvTestName = new TextView(getActivity().getApplicationContext());
//        tvTestName.setText("Math");
//        tvTestName.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
//        tvTestName.setPadding(5, 5, 5, 0);
//        tr.addView(tvTestName); // Adding textView to tablerow.
//
//        tvTimeStart = new TextView(getActivity().getApplicationContext());
//        tvTimeStart.setText("11:00 23/02/2011");
//        tvTimeStart.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
//        tvTimeStart.setPadding(5, 5, 5, 0);
//        tr.addView(tvTimeStart);
//
//        tvDuration = new TextView(getActivity().getApplicationContext());
//        tvDuration.setText("45 minutes");
//        tvDuration.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
//        tvDuration.setPadding(5, 5, 5, 0);
//        tr.addView(tvDuration);
//
//        tvTimeCom = new TextView(getActivity().getApplicationContext());
//        tvTimeCom.setText("30 minutes");
//        tvTimeCom.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
//        tvTimeCom.setPadding(5, 5, 5, 0);
//        tr.addView(tvTimeCom);
//
//        tvMark = new TextView(getActivity().getApplicationContext());
//        tvMark.setText("7");
//        tvMark.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
//        tvMark.setPadding(5, 5, 5, 0);
//        tr.addView(tvMark);
//
//        tvStatus = new TextView(getActivity().getApplicationContext());
//        tvStatus.setText("Passed");
//        tvStatus.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
//        tvStatus.setPadding(5, 5, 5, 0);
//        tr.addView(tvStatus);
//        // Add the TableRow to the TableLayout
//        tbRe.addView(tr, new TableLayout.LayoutParams(
//                TableRow.LayoutParams.MATCH_PARENT,
//                TableRow.LayoutParams.WRAP_CONTENT));
//    }


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
