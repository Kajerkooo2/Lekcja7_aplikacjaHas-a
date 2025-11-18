package com.example.lekcja7;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

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
        TextView passwordTextUpperCase = findViewById(R.id.tvPasswordCheckUpperCase);
        TextView passwordTextLowerCase = findViewById(R.id.tvPasswordCheckLowerCase);
        TextView passwordTextSpecialCase = findViewById(R.id.tvPasswordCheckSpecialCase);
        String specialCases = "!@#$%^&*()-_+={}][;:<>,.?/~`";
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

        checkPassword.setOnClickListener(v -> {
            String password = passwordEdit.getText().toString();
            boolean hasUpper = false;
            for (int i = 0; i < password.length(); i++) {
                char c = password.charAt(i);
                if (Character.isUpperCase(c)) {
                    hasUpper = true;
                    break;
                }
            }
            if (!hasUpper) {
                passwordTextUpperCase.setTextColor(Color.rgb(255, 0, 0));
            } else {

                passwordTextUpperCase.setTextColor(Color.rgb(0, 225, 0));
            }

            boolean hasLower = false;
            for(int i = 0; i < password.length(); i++){
                char c = password.charAt(i);
                if(Character.isLowerCase(c)){
                    hasLower = true;
                    break;
                }
            }
            if(!hasLower){
                passwordTextLowerCase.setTextColor(Color.rgb(255,0,0));
            }
            else{
                passwordTextLowerCase.setTextColor(Color.rgb(0,255,0));
            }

            boolean hasSpecialCase = false;
            for (int i = 0; i < password.length(); i++) {
                char c = password.charAt(i);
                if (specialCases.indexOf(c) != -1) {
                    hasSpecialCase = true;
                    break;
                }
            }
            if (!hasSpecialCase) {
                passwordTextSpecialCase.setTextColor(Color.rgb(255,0,0));
            } else {
                passwordTextSpecialCase.setTextColor(Color.rgb(0,255,0));
            }
        });
    }
}
