package com.example.alarm_clock_app1;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Switch;
import android.widget.CompoundButton;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.Intent;
import android.media.RingtoneManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView txtTime, txtDate, txtAlarm;
    Button btnSetAlarm, btnTone, btnSnooze, btnDismiss;
    ListView listAlarms;
    Switch switchAlarm;

    ArrayList<String> alarmList;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTime = findViewById(R.id.txtTime);
        txtDate = findViewById(R.id.txtDate);
        txtAlarm = findViewById(R.id.txtAlarm);
        btnSetAlarm = findViewById(R.id.btnSetAlarm);
        btnTone = findViewById(R.id.btnTone);
        listAlarms = findViewById(R.id.listAlarms);
        btnSnooze = findViewById(R.id.btnSnooze);
        btnDismiss = findViewById(R.id.btnDismiss);

        alarmList = new ArrayList<>();
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                alarmList
        );

        listAlarms.setAdapter(adapter);
        switchAlarm = findViewById(R.id.switchAlarm);




        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a", Locale.getDefault());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());

        txtTime.setText("Current Time: " + timeFormat.format(calendar.getTime()));
        txtDate.setText("Current Date: " + dateFormat.format(calendar.getTime()));

        btnSetAlarm.setOnClickListener(v -> {

            TimePickerDialog timePickerDialog = new TimePickerDialog(
                    MainActivity.this,
                    (view, hourOfDay, minute) -> {

                        Calendar alarmCalendar = Calendar.getInstance();
                        alarmCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        alarmCalendar.set(Calendar.MINUTE, minute);

                        String alarmTime = new SimpleDateFormat(
                                "hh:mm a",
                                Locale.getDefault()
                        ).format(alarmCalendar.getTime());

                        txtAlarm.setText("Alarm: " + alarmTime);
                        alarmList.add(alarmTime);
                        adapter.notifyDataSetChanged();

                        Toast.makeText(
                                MainActivity.this,
                                "Alarm Set for " + alarmTime,
                                Toast.LENGTH_SHORT
                        ).show();
                    },
                    calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE),
                    false
            );

            timePickerDialog.show();
        });
        btnTone.setOnClickListener(v -> {
            Intent intent = new Intent(RingtoneManager.ACTION_RINGTONE_PICKER);
            startActivity(intent);
        });

        switchAlarm.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(this, "Alarm Enabled", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Alarm Disabled", Toast.LENGTH_SHORT).show();
            }
        });
        btnSnooze.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this,
                    "Alarm Snoozed for 5 minutes",
                    Toast.LENGTH_SHORT).show();
        });
        btnDismiss.setOnClickListener(v -> {
            txtAlarm.setText("No Alarm Set");

            if (!alarmList.isEmpty()) {
                alarmList.remove(alarmList.size() - 1);
                adapter.notifyDataSetChanged();
            }

            Toast.makeText(MainActivity.this,
                    "Alarm Dismissed",
                    Toast.LENGTH_SHORT).show();
        });
    }
}