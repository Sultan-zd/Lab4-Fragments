package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonA, buttonB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonA = findViewById(R.id.btnLoadA);
        buttonB = findViewById(R.id.btnLoadB);

        // Chargement initial pour éviter la superposition lors de la rotation
        if (savedInstanceState == null) {
            switchFragment(new FragmentOne(), false);
        }

        // Gestion des clics avec la nouvelle méthode
        buttonA.setOnClickListener(view -> switchFragment(new FragmentOne(), true));
        buttonB.setOnClickListener(view -> switchFragment(new FragmentTwo(), true));
    }

    // Méthode renommée avec des variables différentes
    private void switchFragment(Fragment targetFragment, boolean saveInHistory) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragment_wrapper, targetFragment);

        if (saveInHistory) {
            transaction.addToBackStack(null);
        }

        transaction.commit();
    }
}