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

/**
 * A simple {@link Fragment} subclass.
 */
public class MatchingFragment extends Fragment implements View.OnClickListener{
    private TextView option1, option2, option3, option4, choice1, choice2, choice3, choice4;
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

        choice1.setText("A for ");
        choice2.setText("O for ");
        choice3.setText("B for ");

        choice1.setTag(null);
        choice2.setTag(null);
        choice3.setTag(null);

        choice1.setTypeface(Typeface.DEFAULT);
        choice2.setTypeface(Typeface.DEFAULT);
        choice3.setTypeface(Typeface.DEFAULT);

        choice1.setOnDragListener(new ChoiceDragListener());
        choice2.setOnDragListener(new ChoiceDragListener());
        choice3.setOnDragListener(new ChoiceDragListener());
    }


    @Override
    public void onClick(View view) {
        reset(view);
    }
}
