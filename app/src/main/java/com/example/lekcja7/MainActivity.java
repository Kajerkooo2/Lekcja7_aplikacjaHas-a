package com.example.lekcja7;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText emailEdit = findViewById(R.id.emailText);
        EditText passwordEdit = findViewById(R.id.hasloPodajText);
        EditText repeatPasswordEdit = findViewById(R.id.halsoPowtorzText);
        Button confirmButton = findViewById(R.id.buttonConfirm);
        TextView welcomeText = findViewById(R.id.tvWelcome);
        Button checkPassword = findViewById(R.id.buttonCheckPassword);

        confirmButton.setOnClickListener(v -> {
            String email = emailEdit.getText().toString();
            String password = passwordEdit.getText().toString();
            String repeatPassword = repeatPasswordEdit.getText().toString();
            String message;

            if (!email.contains("@")) {
                message = "email musi zawierac @";
            } else if (!password.equals(repeatPassword)) {
                message = "Hasla sie roznia";
            } else {
                message = "Witaj: " + email;
            }

            welcomeText.setText(message);
        });

        checkPassword.setOnClickListener(v ->{
            String password = passwordEdit.getText().toString();

            if(!password.contains("QWERTYUIOPASDFGHJKLZXCVBNM")){

            }
        });
    }
}
