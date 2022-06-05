package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.unitconverter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    float num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (position == 0) {
                    visibilityCheckImages(binding.imageButton, true);
                    visibilityCheckImages(binding.imageButton2, true);
                    visibilityCheckImages(binding.imageButton3, true);
                    refreshFields();
                }
                if (position == 1) {
                    visibilityCheckImages(binding.imageButton, true);
                    visibilityCheckImages(binding.imageButton2, true);
                    visibilityCheckImages(binding.imageButton3, true);
                    refreshFields();
                }
                if (position == 2) {
                    visibilityCheckImages(binding.imageButton, true);
                    visibilityCheckImages(binding.imageButton2, true);
                    visibilityCheckImages(binding.imageButton3, true);
                    refreshFields();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }

        });
        binding.imageButton.setOnClickListener((View v) -> {
            num = Float.parseFloat(binding.inputNumber.getText().toString());
            binding.textView2.setText((String.format("%.2f", 100 * num)) + " Centimetre");
            binding.textView3.setText((String.format("%.2f", (float) ((3.28084) * num))) + " Foot");
            binding.textView4.setText((String.format("%.2f", (float) ((39.3701) * num))) + " Inch");
        });

        binding.imageButton2.setOnClickListener((View v) -> {
            num = Float.parseFloat(binding.inputNumber.getText().toString());
            binding.textView2.setText((String.format("%.2f", (9 * num) / 5 + 32)) + " Fahrenheit");
            binding.textView3.setText((String.format("%.2f", (float) (num + 273.151))) + " Kelvin");
            binding.textView4.setText("");
        });

        binding.imageButton3.setOnClickListener((View v) -> {
            num = Float.parseFloat(binding.inputNumber.getText().toString());
            binding.textView2.setText((String.format("%.2f", 1000 * num)) + " Grams");
            binding.textView3.setText((String.format("%.2f", (float) ((35.274) * num))) + " Ounces(Oz)");
            binding.textView4.setText((String.format("%.2f", (float) ((2.205) * num))) + " Pound(lb)");
        });
    }

    private void visibilityCheckImages(ImageButton img, boolean check) {
        if (check) {
            img.setVisibility(View.VISIBLE);
        } else {
            img.setVisibility(View.INVISIBLE);
        }
    }

    private void refreshFields() {
        binding.textView2.setText("");
        binding.textView3.setText("");
        binding.textView4.setText("");
    }
}