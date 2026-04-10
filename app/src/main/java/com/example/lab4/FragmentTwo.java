package com.example.lab4;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class FragmentTwo extends Fragment {

    private TextView levelText;
    private SeekBar levelSlider;
    private int currentLevel = 0;

    // Clé renommée pour la sauvegarde
    private static final String SAVED_SLIDER_VAL = "slider_value";

    public FragmentTwo() {
        super(R.layout.fragment_two);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        levelText = view.findViewById(R.id.tvLevel);
        levelSlider = view.findViewById(R.id.sliderLevel);

        // Restauration de l'état
        if (savedInstanceState != null) {
            currentLevel = savedInstanceState.getInt(SAVED_SLIDER_VAL, 0);
            levelSlider.setProgress(currentLevel);
            levelText.setText("Niveau : " + currentLevel);
        }

        // Écouteur de la SeekBar
        levelSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentLevel = progress;
                levelText.setText("Niveau : " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Pas utilisé ici
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Pas utilisé ici
            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SAVED_SLIDER_VAL, currentLevel);
    }
}