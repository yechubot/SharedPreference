package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;

import com.example.sharedpreference.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // sf mode
        SharedPreferences sf = getSharedPreferences("test",MODE_PRIVATE);

        String text = sf.getString("text","");
        binding.saved.setText(text);

        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //sf mode
                SharedPreferences spf = getSharedPreferences("test",MODE_PRIVATE);
                // edit to save
                SharedPreferences.Editor editor = spf.edit();
                String text = binding.input.getText().toString();
                //save in spf
                editor.putString("text",text).apply();
                //show on UI
                binding.saved.setText(text);
            }
        });
    }


}