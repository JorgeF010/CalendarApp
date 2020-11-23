package com.example.calendarapp.ui.notes;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.calendarapp.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;

public class NotesFragment extends Fragment {

    private NotesViewModel notesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notesViewModel =
                new ViewModelProvider(this).get(NotesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notes, container, false);
//        final TextView textView = root.findViewById(R.id.text_notifications);
        final EditText notes = root.findViewById(R.id.enterNotes);
        final Button save = root.findViewById(R.id.buttonSave);
        notesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                notes.setText(getNotes(getContext()));
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String notesStr = notes.getText().toString();
                setNotes(v.getContext(), notesStr);

            }
        });
        return root;
    }

    public static void setNotes(Context context, String notes) {
        SharedPreferences preferences = context.getSharedPreferences("myAppPackage2", 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("notes", notes);
        editor.commit();
    }

    public static String getNotes(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("myAppPackage2", 0);
        return preferences.getString("notes", "");
    }

}