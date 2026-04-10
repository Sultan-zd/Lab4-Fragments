package com.example.lab4;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FragmentOne extends Fragment {

    private TextView displayTxt;
    private Button actionBtn;
    private final String TAG = "FirstFragmentLog"; // Tag pour les logs

    public FragmentOne() {
        super(R.layout.fragment_one);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        displayTxt = view.findViewById(R.id.tvMessage);
        actionBtn = view.findViewById(R.id.btnAction);

        actionBtn.setOnClickListener(v -> displayTxt.setText("Action réussie depuis l'écran A !"));
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "L'écran A est maintenant actif.");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "L'écran A est mis en pause.");
    }
}