package com.example.mitu.dynamicbuttonselectdeselect;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mitu on 4/5/16.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {// Recyclerview will extend to
    // recyclerview adapter
    private ArrayList<Data_Model> arrayList;
    private Context context;
    public ArrayList<Integer> selectedIds = new ArrayList<Integer>();

    public class RecyclerViewHolder extends RecyclerView.ViewHolder  {
        // View holder for gridview recycler view as we used in listview
        public Button button;

        public RecyclerViewHolder(View view) {
            super(view);
            // Find all views ids

            this.button = (Button) view
                    .findViewById(R.id.button);



        }



    }

    public void toggleSelected(Integer position)
    {
        if(selectedIds.contains(position))
        {
            selectedIds.remove(position);


        }
        else
        {
            try{
                selectedIds.remove(0);
            }catch (Exception e){

            }
            selectedIds.add(position);
        }
    }

    public RecyclerViewAdapter(Context context,ArrayList<Data_Model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;

    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);

    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        final Data_Model model = arrayList.get(position);

        final RecyclerViewHolder mainHolder = (RecyclerViewHolder) holder;// holder



        // setting title
        if (selectedIds.contains(position)) {
            mainHolder.button.setTextColor(Color.RED);
        }
        else
        {
            mainHolder.button.setTextColor(Color.BLUE);
        }
        mainHolder.button.setText(model.getTitle());


        mainHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleSelected(new Integer(position));
                notifyDataSetChanged();

            }
        });



    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        // This method will inflate the custom layout and return as viewholder
        LayoutInflater mInflater = LayoutInflater.from(viewGroup.getContext());

        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(
                R.layout.button_layout, viewGroup, false);
        RecyclerViewHolder listHolder = new RecyclerViewHolder(mainGroup);
        return listHolder;

    }
}
