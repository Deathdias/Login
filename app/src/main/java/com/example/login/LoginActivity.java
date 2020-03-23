package com.example.login;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class LoginActivity extends AppCompatActivity {
    String Phone, Password;
    private Button SignIn;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(final Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SignIn = findViewById(R.id.signin_button);
        final EditText phonenum = findViewById(R.id.phone);
        final EditText pwd = findViewById(R.id.password);
        sharedPreferences = getSharedPreferences("login",MODE_PRIVATE);

        if (sharedPreferences.contains("Phone") && sharedPreferences.contains("Password")){
            openMainActivity();
        }

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Phone = phonenum.getText().toString();
                Password = pwd.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Phone",Phone);
                editor.putString("Password",Password);
                editor.apply();
                openMainActivity();
            }
        });
    }

//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState){
//        View view =  inflater.inflate(R.layout.activity_login,container,false);
//
//        Phone = view.findViewById(R.id.phone);
//        Password = view.findViewById(R.id.password);
//        SignIn = view.findViewById(R.id.signin_button);
//
//        if(sharedPreferences.contains("Phone") && sharedPreferences.contains("Password")){
//            openMainActivity();
//        }
//
//        SignIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String phone = Phone.getText().toString();
//                String password = Password.getText().toString();
//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.putString("Phone",phone);
//                editor.putString("Password",password);
//                editor.apply();
//
//                Bundle bundle = new Bundle();
//                bundle.putString("Phone",phone);
//                bundle.putString("Password",password);
//
//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//                FirstFragment firstFragment = new FirstFragment();
//                firstFragment.setArguments(bundle);
//                fragmentTransaction.replace(R.id.recyclerview, firstFragment);
//                fragmentTransaction.commit();
//
//            }
//        });
//        return view;
//    }
    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
