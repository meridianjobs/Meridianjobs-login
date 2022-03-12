package com.example.meridianjobs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;

public class employer extends AppCompatActivity {
    Button sign;
    EditText name,email,adrs,pass,cont;

    FirebaseAuth mAuth;
    FirebaseUser mUser;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer);

        sign = findViewById(R.id.button);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();

        name =findViewById(R.id.e_name);
        email =findViewById(R.id.e_email);
        adrs =findViewById(R.id.e_adrs);
        pass =findViewById(R.id.e_pass);
        cont =findViewById(R.id.e_cont);



        String email1 = email.getText().toString().trim();

        String pass1 = pass.getText().toString().trim();


        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Auth();


            }
        });


    }

    private void Auth() {

        String email1 = email.getText().toString().trim();

        String pass1 = pass.getText().toString().trim();

        mAuth.createUserWithEmailAndPassword(email1, pass1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    //  Data();
                    //progressDialog.dismiss();
                    Toast.makeText(employer.this, "Account created", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(employer.this, Login.class));
                } else {
                    //progressDialog.dismiss();
                    Toast.makeText(employer.this, "Error occurred", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void Data() {
        mDatabase = FirebaseDatabase.getInstance().getReference("data").child(FirebaseAuth.getInstance().getCurrentUser().getUid());

        String name1 = name.getText().toString();
        String email1 = email.getText().toString();
        String adrs1 = adrs.getText().toString();
        String pass1 = pass.getText().toString();
        String cont1 = cont.getText().toString();

        model m = new model();
        m.setE_name(name1);
        m.setE_email(email1);
        m.setE_adrs(adrs1);
        m.setE_cont(cont1);
        m.setE_pass(pass1);

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {

                mDatabase.setValue(m);
                Toast.makeText(employer.this, "Data added", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(employer.this, "Error to add", Toast.LENGTH_SHORT).show();

            }
        });

    }
}