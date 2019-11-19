package com.example.antino_labs.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.antino_labs.R;
import com.squareup.picasso.Picasso;

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    Context context;
    Contact[] contacts;

    public ContactAdapter(Contact[] contacts,Context context ) {
        this.context = context;
        this.contacts = contacts;
    }
    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View contactsView = inflater.inflate(R.layout.contact_card,parent,false);
        ContactViewHolder contactViewHolder=new ContactViewHolder(contactsView,this.context);
        return contactViewHolder;
    }


    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        holder.contact_name.setText(contacts[position].getName());
        // new ImageLoadTask(songs[position].getCover_image(),holder.song_image).execute();
        Picasso.get().load(contacts[position].getUrl()).into(holder.contact_image);
        holder.contact_location.setText(contacts[position].getLocation());
        holder.contact_age.setText(contacts[position].getAge());
        holder.image=contacts[position].getUrl();


    }
    @Override
    public int getItemCount() {
        return  contacts.length;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
