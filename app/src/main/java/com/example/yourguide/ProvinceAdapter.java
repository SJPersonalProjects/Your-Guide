package com.example.yourguide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProvinceAdapter extends RecyclerView.Adapter<ProvinceAdapter.ViewHolder>{
    //Instance field.
    private final ArrayList<Province> punjabProvinceCardList;

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
        Province currentPunjabProvinceCard = punjabProvinceCardList.get(position);

        holder.mImageView.setImageResource(currentPunjabProvinceCard.getCardImage());
        holder.mTitle.setText(currentPunjabProvinceCard.getCardTitle());
        holder.mDescription.setText(currentPunjabProvinceCard.getCardDescription());
        holder.mRating.setText(currentPunjabProvinceCard.getCardRating());
        holder.mReview.setText(currentPunjabProvinceCard.getCardReview());
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
        public TextView mTitle, mDescription, mRating, mReview;


        public ViewHolder(@NonNull View itemView, OnItemClickListener mOnItemClickListener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.province_list_preview_image);
            mTitle = itemView.findViewById(R.id.province_list_item_title);
            mDescription = itemView.findViewById(R.id.province_list_item_description);
            mRating = itemView.findViewById(R.id.rating);
            mReview = itemView.findViewById(R.id.review);


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

    public ProvinceAdapter(ArrayList<Province> punjabProvinceCardList) {
        this.punjabProvinceCardList = punjabProvinceCardList;
    }

    /**
     * Adds two parentheses around the reviews.
     * @param reviews are the amount of comments on a single card.
     * @return the formatted reviews.
     */
    private String reviewsFormatter(int reviews) {
        return "(" + reviews + ")";
    }
}
