package com.example.listycitylab3;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.fragment.app.DialogFragment;

public class Editing extends DialogFragment {
    private City cityToEdit;

    public Editing() {
    }
    public Editing(City city) {
        this.cityToEdit = city;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) { // GOT SOME HELP FROM AI to get linear layout and to understand how builder works and how to get main updated
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LinearLayout layout = new LinearLayout(getActivity());
        EditText nameInput = new EditText(getActivity());
        EditText provinceInput = new EditText(getActivity());
        layout.addView(nameInput);
        layout.addView(provinceInput);
        builder.setTitle("Edit City and Province")
                .setView(layout)
                .setPositiveButton("Save", (dialog, id) -> {
                    cityToEdit.setName(nameInput.getText().toString());
                    cityToEdit.setProvince(provinceInput.getText().toString());

                    ((MainActivity) getActivity()).updateList();
                });
        return builder.create();
    }
}
