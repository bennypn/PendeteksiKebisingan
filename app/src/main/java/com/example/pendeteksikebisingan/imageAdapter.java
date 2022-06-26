package com.example.pendeteksikebisingan;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.type.DateTime;

// FirebaseRecyclerAdapter is a class provided by
// FirebaseUI. it provides functions to bind, adapt and show
// database contents in a Recycler View
public class imageAdapter extends FirebaseRecyclerAdapter<Image,imageAdapter.ImagesViewholder> {

    Long epochh;
    protected static String date, Imagetv;
    public imageAdapter(
            @NonNull FirebaseRecyclerOptions<Image> options)
    {
        super(options);
    }

    // Function to bind the view in Card view(here
    // "Image.xml") iwth data in
    // model class(here "Image.class")
    @Override
    protected void
    onBindViewHolder(@NonNull ImagesViewholder holder,
                     int position, @NonNull Image model)
    {
        epochh = model.getEpoch();
        date = new java.text.SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date (epochh*1000));
        // epochtv = Long.toString(model.getEpoch());
        Imagetv = model.getLink();

        // Add firstname from model class (here
        // "Image.class")to appropriate view in Card
        // view (here "Image.xml")
        holder.epoch.setText(date);

        // Add lastname from model class (here
        // "Image.class")to appropriate view in Card
        // view (here "Image.xml")
        holder.Image.setText(Imagetv);

    }

    // Function to tell the class about the Card view (here
    // "Image.xml")in
    // which the data will be shown
    @NonNull
    @Override
    public ImagesViewholder
    onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType)
    {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new imageAdapter.ImagesViewholder(view);
    }

    // Sub Class to create references of the views in Crad
    // view (here "Image.xml")
    class ImagesViewholder
            extends RecyclerView.ViewHolder {
        TextView epoch, Image;
        public ImagesViewholder(@NonNull View itemView)
        {
            super(itemView);

            epoch = itemView.findViewById(R.id.epoch_tv);
            Image = itemView.findViewById(R.id.link_iv);
        }
    }


}
