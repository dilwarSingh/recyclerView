package com.example.vibrant.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by vibrant on 11/14/2017.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.viewHolder> {
    ArrayList<Movie> movies;
    Context context;
    ArrayList<Boolean> checkList;

    public MoviesAdapter(ArrayList<Movie> movies, ArrayList<Boolean> checkList, Context context) {
        this.movies = movies;
        this.checkList = checkList;
        this.context = context;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        return new viewHolder(v);

    }

    public ArrayList<Movie> getCheckedMovies() {
        ArrayList<Movie> dataList = new ArrayList<>();
        for (int i = 0; i < checkList.size(); i++) {

            if (checkList.get(i))
                dataList.add(movies.get(i));
        }
        return dataList;


    }

    @Override
    public void onBindViewHolder(final viewHolder holder, final int position) {
        final Movie movieItem = movies.get(position);
        Boolean bool = checkList.get(position);

        holder.name.setText(movieItem.getTitle());
        holder.check.setChecked(bool);


        holder.check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                checkList.set(position, isChecked);
                Toast.makeText(context, movieItem.getTitle() + "\n" + isChecked, Toast.LENGTH_SHORT).show();
            }
        });

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "";

                for (int i = 0; i < checkList.size(); i++) {

                    if (checkList.get(i)) {
                        s += movies.get(i).getTitle() + " \n";
                    }
                }

                Toast.makeText(context, s, Toast.LENGTH_SHORT).show();


            }
        });

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView name;
        CheckBox check;

        public viewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.textView);
            check = itemView.findViewById(R.id.checkBox);


        }
    }
}
