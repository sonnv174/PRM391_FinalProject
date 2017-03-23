package sonnvse04038.fpt.edu.vn.mobilequiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sonnv174 on 3/23/2017.
 */

public class CustomGrid extends BaseAdapter {
    private Context mContext;
    private final ArrayList<String> listTestName;
    private final ArrayList<Integer> listImageId;

    public CustomGrid(Context c, ArrayList<String> listTestName, ArrayList<Integer> listImageId ) {
        mContext = c;
        this.listImageId = listImageId;
        this.listTestName = listTestName;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return listTestName.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_single, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

            textView.setText(listTestName.get(position));
            imageView.setImageResource(listImageId.get(position));
        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}
