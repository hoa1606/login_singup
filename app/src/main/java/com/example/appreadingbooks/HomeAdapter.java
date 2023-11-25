package com.example.appreadingbooks;

import static androidx.core.content.ContentProviderCompat.requireContext;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.core.Context;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeAdapter extends FirebaseRecyclerAdapter<HomeModel,HomeAdapter.myViewHolder> {

    ClickHomeModel clickHomeModel;

    public HomeAdapter(@NonNull FirebaseRecyclerOptions<HomeModel> options,ClickHomeModel clickHomeModel) {
        super(options);
       this.clickHomeModel = clickHomeModel;
    }

    protected  void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull HomeModel model) {
        holder.title.setText(model.getTitle());
        holder.author.setText(model.getAuthor());
        holder.price.setText(String.valueOf(model.getPrice()));
        Glide.with(holder.img.getContext())
                .load(model.getCoverImage())
                .placeholder(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.img);
        holder.itemHome.setOnClickListener(v -> {

//            Bundle bundle = new Bundle();
//            bundle.putSerializable("imageModel",model);
//            Intent intent = new Intent(holder.view.getContext(),IntroductionActivity.class);
//            intent.putExtras(bundle);
            clickHomeModel.itemHome(model);
         }
        );

    }

    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_home_item,parent,false);
        return new myViewHolder(view);
    }

    public static class myViewHolder extends RecyclerView.ViewHolder {
        public View view;
        CircleImageView img;
        TextView title,author,price;
        CardView itemHome;

        public myViewHolder(@NonNull View itemView){
            super(itemView);

            img = (CircleImageView)itemView.findViewById(R.id.img1);
            title = (TextView)itemView.findViewById(R.id.nametext);
            author = (TextView)itemView.findViewById(R.id.authortext);
            price = (TextView)itemView.findViewById(R.id.pricetext);
            itemHome = (CardView) itemView.findViewById(R.id.item_home);

        }
    }


}

