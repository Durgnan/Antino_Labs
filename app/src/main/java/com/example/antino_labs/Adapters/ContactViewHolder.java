package com.example.antino_labs.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.antino_labs.ContactDetails;
import com.example.antino_labs.R;


public class ContactViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
    Context context;
    ImageView contact_image;
    TextView contact_name,contact_age,contact_location;
    String image;


    public ContactViewHolder(@NonNull View itemView, Context context) {
        super(itemView);
        contact_image = itemView.findViewById(R.id.image);
        contact_name=itemView.findViewById(R.id.name);
        contact_age=itemView.findViewById(R.id.age);
        contact_location=itemView.findViewById(R.id.location);
        this.context = context;

    }
    @Override
    public void onClick(View v) {
        Intent i = new Intent(v.getContext(), ContactDetails.class).putExtra("sname",contact_name.getText()).putExtra("age",contact_age.getText()).putExtra("image",image).putExtra("location",contact_location.getText());
        v.getContext().startActivity(i);
    }
}
