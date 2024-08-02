package com.example.notescraft;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
//import io.grpc.okhttp.internal.Util;



public class NoteAdapter extends FirestoreRecyclerAdapter<Note, NoteAdapter.NoteViewHolder> {
    Context context;


    //This constructor initializes a NoteAdapter with FirestoreRecyclerOptions
    // for configuring Firestore data querying and a Context object for application-specific functionality.
    public NoteAdapter(@NonNull FirestoreRecyclerOptions<Note> options, Context context) {
        super(options);
        this.context = context;
    }


    //This method binds data to a NoteViewHolder, setting the title,
    // content, and timestamp of a Note object to the corresponding TextViews in the ViewHolder.
    // Additionally, it sets an OnClickListener on the item view
    // to launch NoteDetailsActivity with information about the selected note.
    @Override
    protected void onBindViewHolder(@NonNull NoteViewHolder holder, int position, @NonNull Note note) {
        holder.titleTextView.setText(note.title);
        holder.contentTextView.setText(note.content);
        holder.timestampTextView.setText(Utility.timestampToString(note.timestamp));

        holder.itemView.setOnClickListener((v)->{
            Intent intent = new Intent(context,NoteDetailsActivity.class);
            intent.putExtra("title",note.title);
            intent.putExtra("content",note.content);
            String docId = this.getSnapshots().getSnapshot(position).getId();
            intent.putExtra("docId",docId);
            context.startActivity(intent);
        });

    }


    //This method creates and returns a NoteViewHolder by inflating a layout resource (recycler_note_item.xml)
    // in order to represent the individual items in the RecyclerView.
    // It sets up the layout for displaying a note.
    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_note_item,parent,false);
        return new NoteViewHolder(view);
    }



    //This class represents a ViewHolder for displaying individual note items in a RecyclerView.
    // It contains TextViews for displaying the title, content, and timestamp of a note,
    // and it initializes these TextViews by finding their respective views in the inflated layout for a note item.
    class NoteViewHolder extends RecyclerView.ViewHolder{
        TextView titleTextView,contentTextView,timestampTextView;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.note_title_text_view);
            contentTextView = itemView.findViewById(R.id.note_content_text_view);
            timestampTextView = itemView.findViewById(R.id.note_timestamp_text_view);
        }
    }
}