package com.android.sava.cs330_dz04;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Fragment1 extends PreferenceFragment implements DatePickerDialog.OnDateSetListener{
    String str1, str2;/*
    TimePicker timePicker;
    DatePicker datePicker;
    int hour, minute;
    int yr, month, day;
    final int TIME_DIALOG_ID = 0;
    final int DATE_DIALOG_ID = 1;*/

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        final ListPreference qPref = (ListPreference) findPreference("question");
        final EditTextPreference namePref = (EditTextPreference) findPreference("name_preference");
        final EditTextPreference addressPref = (EditTextPreference) findPreference("address_preference");

        namePref.setText(" ");
        addressPref.setText(" ");

        qPref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                questionChecker((String) newValue);
                return false;
            }
        });

        Preference load = findPreference("show");
        load.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                str1 = namePref.getText().toString();
                str2 = addressPref.getText().toString();
                Toast.makeText(getActivity(), "Faculty Name: " + str1 + "\n" + " Faculty Address: " + str2, Toast.LENGTH_LONG).show();
                return true;
            }
        });

        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        Preference df = findPreference("DateFilter");
        df.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                showDateDialog();
                return false;
            }
        });
    }
/*
    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener()
            {
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
                {
                    yr = year;
                    month = monthOfYear;
                    day = dayOfMonth;
                    Toast.makeText(getBaseContext(), "Izabrali ste : " + (month + 1) + "/" + day + "/" + year, Toast.LENGTH_SHORT).show();
                }
            };
    private TimePickerDialog.OnTimeSetListener mTimeSetListener =
            new TimePickerDialog.OnTimeSetListener()
            {
                public void onTimeSet(TimePicker view, int hourOfDay, int minuteOfHour)
                {
                    hour = hourOfDay;
                    minute = minuteOfHour;
                    SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm aa");
                    Date date = new Date(0,0,0, hour, minute);
                    String strDate = timeFormat.format(date);
                    Toast.makeText(getBaseContext(), "Izabrali ste " + strDate, Toast.LENGTH_SHORT).show();
                }
            };*/

    private void showDateDialog(){
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void questionChecker(String v) {
        if (v.equals("4")) {
            Toast.makeText(getActivity(), "That's correct!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "That's incorrect", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        Log.i("dasd", "year " + i + " month " + i2 + " day " + i3);
    }

}