package com.prasad.androiddemo.Cards;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.prasad.androiddemo.DB.DBdataSource;
import com.prasad.androiddemo.DB.Pdetails;
import com.prasad.androiddemo.R;
import com.squareup.picasso.Picasso;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Prasad on 21/04/15.
 */
public class AdapterRecycleView extends RecyclerView.Adapter<AdapterRecycleView.ViewHolder> {

    private List<Pdetails> details;
    private int rowLayout;
    private Context mContext;

    public AdapterRecycleView(List<Pdetails> details, int rowLayout, Context context) {
        this.details = details;
        this.rowLayout = rowLayout;
        this.mContext = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(rowLayout, parent, false);


        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Pdetails info = details.get(position);


        holder.txtNameCard.setText(info.getName());
        holder.txtSurnameCard.setText(info.getSurname());
        holder.imgCard.setImageResource(R.drawable.sunset);

        /*
        Picasso.with(mContext)
                .load("http://fortimages.s3-us-west-2.amazonaws.com/Ahiwantgad.jpeg")
                .into(holder.imgCard);

        */

    }

    @Override
    public int getItemCount() {
        return details == null ? 0 : details.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imgCard;
        public TextView txtNameCard;
        public TextView txtSurnameCard;



        public ViewHolder(View itemView) {
            super(itemView);

            txtNameCard = (TextView) itemView.findViewById(R.id.txtName);
            txtSurnameCard = (TextView) itemView.findViewById(R.id.txtSurnameCard);
            imgCard = (ImageView)itemView.findViewById(R.id.imageView);


        }



    }



}
