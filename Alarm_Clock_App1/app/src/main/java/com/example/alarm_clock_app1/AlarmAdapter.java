package com.example.alarm_clock_app1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AlarmAdapter extends RecyclerView.Adapter<AlarmAdapter.ViewHolder> {

    private List<String> alarmList;

    public AlarmAdapter(List<String> alarmList) {
        this.alarmList = alarmList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.alarm_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtAlarmItem.setText(alarmList.get(position));
    }

    @Override
    public int getItemCount() {
        return alarmList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtAlarmItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtAlarmItem = itemView.findViewById(R.id.txtAlarmItem);
        }
    }
}