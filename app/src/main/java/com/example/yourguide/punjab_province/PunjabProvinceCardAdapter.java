package com.example.yourguide.punjab_province;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yourguide.R;

import java.util.ArrayList;

public class PunjabProvinceCardAdapter extends RecyclerView.Adapter<PunjabProvinceCardAdapter.ViewHolder>{
    //Instance field.
    private final ArrayList<PunjabProvinceCard> punjabProvinceCardList;

    //interface variable.
    public OnItemClickListener mListener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.province_punjab_list_item, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view, mListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PunjabProvinceCard currentPunjabProvinceCard = punjabProvinceCardList.get(position);

        holder.mImageView.setImageResource(currentPunjabProvinceCard.getCardImage());
        holder.mTitle.setText(currentPunjabProvinceCard.getCardTitle());
        holder.mDescription.setText(currentPunjabProvinceCard.getCardDescription());
        holder.mRating.setText(currentPunjabProvinceCard.getCardRating());
    }

    @Override
    public int getItemCount() {
        return punjabProvinceCardList.size();
    }

    /**
     * Item click listener for the card on the RecyclerView.
     */
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        //Instance fields.
        public ImageView mImageView;
        public TextView mTitle, mDescription, mRating;


        public ViewHolder(@NonNull View itemView, OnItemClickListener mOnItemClickListener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.province_list_preview_image);
            mTitle = itemView.findViewById(R.id.province_list_item_title);
            mDescription = itemView.findViewById(R.id.province_list_item_description);
            mRating = itemView.findViewById(R.id.province_rating_numbers);

            //Listener to click the items in the recycler view.
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mOnItemClickListener != null) {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION) {
                            mOnItemClickListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public PunjabProvinceCardAdapter(ArrayList<PunjabProvinceCard> punjabProvinceCardList) {
        this.punjabProvinceCardList = punjabProvinceCardList;
    }
}