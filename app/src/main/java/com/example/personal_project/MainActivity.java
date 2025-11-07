package com.example.personal_project;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Tag cho Logcat
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        // BÀI 2: CHẴN / LẺ
        EditText etNumber = findViewById(R.id.etNumber);
        Button btnCheck = findViewById(R.id.btnCheck);
        TextView tvResult = findViewById(R.id.tvResult);

        btnCheck.setOnClickListener(v -> {
            String input = etNumber.getText().toString().trim();

            if (input.isEmpty()) {
                Log.d("CHECK", "Vui lòng nhập dãy số!");
                return;
            }

            // Tách các số bằng dấu phẩy
            String[] parts = input.split(",");
            ArrayList<Integer> even = new ArrayList<>();
            ArrayList<Integer> odd = new ArrayList<>();

            for (String s : parts) {
                try {
                    int num = Integer.parseInt(s.trim());
                    if (num % 2 == 0) even.add(num);
                    else odd.add(num);
                } catch (NumberFormatException e) {
                    Log.d("CHECK", "Bỏ qua giá trị không hợp lệ: " + s);
                }
            }

            Log.d("CHECK", "Số chẵn: " + even);
            Log.d("CHECK", "Số lẻ: " + odd);
        });

        // BÀI 3: ĐẢO CHUỖI
        EditText etString = findViewById(R.id.etString);
        Button btnReverse = findViewById(R.id.btnReverse);
        TextView tvReversed = findViewById(R.id.tvReversed);

        btnReverse.setOnClickListener(v -> {
            String input = etString.getText().toString().trim();

            if (input.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập chuỗi!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Tách chuỗi theo khoảng trắng
            String[] words = input.split(" ");
            StringBuilder reversed = new StringBuilder();

            // Đảo ngược thứ tự từ
            for (int i = words.length - 1; i >= 0; i--) {
                reversed.append(words[i].toUpperCase());
                if (i > 0) reversed.append(" ");
            }

            String result = reversed.toString();
            tvReversed.setText(result);

            // Hiển thị Toast
            Toast.makeText(this, "Chuỗi đảo ngược: " + result, Toast.LENGTH_LONG).show();

        });
    }
}
