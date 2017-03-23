package sonnvse04038.fpt.edu.vn.mobilequiz;


import android.annotation.SuppressLint;
import android.content.ClipData;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import sonnvse04038.fpt.edu.vn.mobilequiz.Object.Matching;

/**
 * A simple {@link Fragment} subclass.
 */
public class MatchingFragment extends Fragment implements View.OnClickListener{
    private TextView option1, option2, option3, option4, choice1, choice2, choice3, choice4;
    int tId, mId, status;
    String mQues,mAnswer1,mAnswer2,mAnswer3,mAnswer4;
    String [] input1;
    String [] input2;
    String [] input3;
    String [] input4;


    public CharSequence dragData;
    Button reset;
    public MatchingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_matching, container, false);

    }
    public String[] split(String Answer)
    {
        String [] inputR;
        inputR = Answer.split("\\|");
        return inputR;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
            option1 = (TextView)getActivity().findViewById(R.id.option_1);
            option2 = (TextView)getActivity().findViewById(R.id.option_2);
            option3 = (TextView)getActivity().findViewById(R.id.option_3);
            option4 = (TextView)getActivity().findViewById(R.id.option_4);
            //views to drop onto
            choice1 = (TextView)getActivity().findViewById(R.id.choice_1);
            choice2 = (TextView)getActivity().findViewById(R.id.choice_2);
            choice3 = (TextView)getActivity().findViewById(R.id.choice_3);
            choice4 = (TextView)getActivity().findViewById(R.id.choice_4);
            //button reset
            reset = (Button)getActivity().findViewById(R.id.btnReset);
            reset.setOnClickListener(this);
        Matching matching = new Matching();
        matching.settID(1);
        matching.setmId(1);
        matching.setmQuestion("Nam Kha");
        matching.setStatus(1);
        matching.setmAnswer1("Nam Kha a | fat");
        matching.setmAnswer2("1 is | positive numbers");
        matching.setmAnswer3("Viet Nam has 63 | city");
        matching.setmAnswer4("Orange start with | O");
        mAnswer1 = matching.getmAnswer1();
        mAnswer2 = matching.getmAnswer2();
        mAnswer3 = matching.getmAnswer3();
        mAnswer4 = matching.getmAnswer4();

        //get data to textview
        input1 = split(mAnswer1);
        option1.setText(input1[0]);
        choice1.setText(input1[1]);
        input2 = split(mAnswer2);
        option2.setText(input2[0]);
        choice2.setText(input2[1]);
        input3 = split(mAnswer3);
        option3.setText(input3[0]);
        choice3.setText(input3[1]);
        input4 = split(mAnswer4);
        option4.setText(input4[0]);
        choice4.setText(input4[1]);

            //set touch listeners
            option1.setOnTouchListener(new ChoiceTouchListener());
            option2.setOnTouchListener(new ChoiceTouchListener());
            option3.setOnTouchListener(new ChoiceTouchListener());
            option4.setOnTouchListener(new ChoiceTouchListener());
            //set drag listeners
            choice1.setOnDragListener(new ChoiceDragListener());
            choice2.setOnDragListener(new ChoiceDragListener());
            choice3.setOnDragListener(new ChoiceDragListener());
            choice4.setOnDragListener(new ChoiceDragListener());
    }
    private final class ChoiceTouchListener implements OnTouchListener {
        @SuppressLint("NewApi")
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            /*
             * Drag details: we only need default behavior
             * - clip data could be set to pass data as part of drag
             * - shadow can be tailored
             */
                ClipData data = ClipData.newPlainText("","");
                DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                //start dragging the item touched
                view.startDrag(data, shadowBuilder, view, 0);
                return true;
            } else {
                return false;
            }
        }
    }

    @SuppressLint("NewApi")
    private class ChoiceDragListener implements OnDragListener {

        @Override
        public boolean onDrag(View v, DragEvent event) {
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    //no action necessary
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    //no action necessary
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    //no action necessary
                    break;
                case DragEvent.ACTION_DROP:

                    //handle the dragged view being dropped over a drop view
                    View view = (View) event.getLocalState();
                    //view dragged item is being dropped on
                    TextView dropTarget = (TextView) v;
                    //view being dragged and dropped
                    TextView dropped = (TextView) view;
                    //checking whether first character of dropTarget equals first character of dropped

                    //stop displaying the view where it was before it was dragged
                    view.setVisibility(View.INVISIBLE);
                    //update the text in the target view to reflect the data being dropped
                    dropTarget.setText(dropped.getText().toString() +"|"+ dropTarget.getText().toString());
                    //make it bold to highlight the fact that an item has been dropped
                    dropTarget.setTypeface(Typeface.DEFAULT_BOLD);
                    //if an item has already been dropped here, there will be a tag
                    Object tag = dropTarget.getTag();
                    //if there is already an item here, set it back visible in its original place
                    if(tag!=null)
                    {
                        //the tag is the view id already dropped here
                        int existingID = (Integer)tag;
                        //set the original view visible again
                        getActivity().findViewById(existingID).setVisibility(View.VISIBLE);
                        Toast.makeText(getActivity().getApplicationContext(),existingID,Toast.LENGTH_LONG).show();
                    }

                    //set the tag in the target view being dropped on - to the ID of the view being dropped
                    dropTarget.setTag(dropped.getId());
                    //remove setOnDragListener by setting OnDragListener to null, so that no further drag & dropping on this TextView can be done
                    dropTarget.setOnDragListener(null);

                    //displays message if first character of dropTarget is not equal to first character of dropped
                    //Toast.makeText(getActivity().getApplicationContext(), dropTarget.getText().toString() + "is not " + dropped.getText().toString(), Toast.LENGTH_LONG).show();
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    //no action necessary
                    break;
                default:
                    break;
            }
            return true;
        }
    }

    public void reset(View view)
    {
        option1.setVisibility(TextView.VISIBLE);
        option2.setVisibility(TextView.VISIBLE);
        option3.setVisibility(TextView.VISIBLE);
        option4.setVisibility(TextView.VISIBLE);

        choice1.setText(input1[1]);
        choice2.setText(input2[1]);
        choice3.setText(input3[1]);
        choice1.setText(input4[1]);

        choice1.setTag(null);
        choice2.setTag(null);
        choice3.setTag(null);
        choice4.setTag(null);

        choice1.setTypeface(Typeface.DEFAULT);
        choice2.setTypeface(Typeface.DEFAULT);
        choice3.setTypeface(Typeface.DEFAULT);
        choice4.setTypeface(Typeface.DEFAULT);

        choice1.setOnDragListener(new ChoiceDragListener());
        choice2.setOnDragListener(new ChoiceDragListener());
        choice3.setOnDragListener(new ChoiceDragListener());
        choice4.setOnDragListener(new ChoiceDragListener());
    }


    @Override
    public void onClick(View view) {
        reset(view);
    }
}
