package com.example.gymlog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListAdapter extends ArrayAdapter<String> {
    private List<String> dataList;
    private LayoutInflater inflater;

    public ListAdapter(@NonNull Context context, List<String> dataList) {
        super(context, 0, dataList);
        this.dataList = dataList;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.history_workouts, parent, false);
            holder = new ViewHolder();
            holder.textView = convertView.findViewById(R.id.txtWorkout);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String data = dataList.get(position);
        holder.textView.setText(data);

        return convertView;
    }

    private static class ViewHolder {
        TextView textView;
    }
}

