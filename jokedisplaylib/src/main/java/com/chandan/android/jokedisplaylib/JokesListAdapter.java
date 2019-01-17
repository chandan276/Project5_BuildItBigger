package com.chandan.android.jokedisplaylib;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class JokesListAdapter extends RecyclerView.Adapter<JokesListAdapter.JokesViewHolder> {

    private String jokesStr;

    JokesListAdapter(String joke) {
        this.jokesStr = joke;
    }

    @Override
    public JokesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.jokes_cell;

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, parent, false);

        return new JokesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(JokesViewHolder holder, int position) {
        holder.jokeTextView.setText(jokesStr);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class JokesViewHolder extends RecyclerView.ViewHolder {

        TextView jokeTextView;

        JokesViewHolder(View itemView) {
            super(itemView);
            jokeTextView = (TextView) itemView.findViewById(R.id.joke_textview);
        }
    }
}
