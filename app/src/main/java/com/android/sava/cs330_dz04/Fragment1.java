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
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Fragment1 extends PreferenceFragment{
    String str1, str2;

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
    }

    public void questionChecker(String v) {
        if (v.equals("4")) {
            Toast.makeText(getActivity(), "That's correct!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "That's incorrect", Toast.LENGTH_SHORT).show();
        }
    }

}