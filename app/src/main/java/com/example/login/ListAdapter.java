package com.example.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListAdapter extends RecyclerView.Adapter {
    Context mContext;
    SharedPreferences sharedPreferences;

    public ListAdapter(Context context){
        mContext = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_contact,parent,false);
        return new RecycleViewHolder(view, mContext);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position){
        ( (RecycleViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return ContactList.name.length;
    }
    class RecycleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView name;
        private TextView phonenum;
        CircleImageView image;
        int position;

        public RecycleViewHolder(View cView, Context context){
            super(cView);
            name = cView.findViewById(R.id.name);
            phonenum = cView.findViewById(R.id.phone_num);
            image = cView.findViewById(R.id.image);

            cView.setOnClickListener((View.OnClickListener) this);
        }

        public void bindView(int position){
            this.position = position;
            name.setText(ContactList.name[position]);
            phonenum.setText(ContactList.phonenum[position]);
            image.setImageResource(ContactList.img[position]);
        }
        @Override
        public void onClick(View v) {
            String Name = name.getText().toString();
            String PhoneNum = phonenum.getText().toString();
            int Image = ContactList.img[position];

            sharedPreferences =mContext.getSharedPreferences("Data",mContext.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("Name",Name);
            editor.putString("Phone",PhoneNum);
            editor.putInt("Image",Image);
            editor.apply();
        }
    }
}
