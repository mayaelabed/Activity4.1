package com.example.act41;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String TAG ="MainActivity";

       private SharedPreferences myPreferences;
       private SharedPreferences.Editor editor;
       private EditText name , pwd;
       private Button button;
       private CheckBox boxcheck;
    private Object PreferenceManager;

    private void checkSharedPrefence(){
        String checkbox =myPreferences.getString(getString(R.string.notify_me),"false");
        String namet =myPreferences.getString(getString(R.string.enter_name),"");
        String pwdt =myPreferences.getString(getString(R.string.enter_pwd),"");
        name.setText(namet);
        pwd.setText(pwdt);
        if (checkbox.equals("true")){
            boxcheck.setChecked(true);
        }else {
            boxcheck.setChecked(false);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText) findViewById(R.id.enter_name);
        pwd=(EditText) findViewById(R.id.enter_pwd);
        button=(Button) findViewById(R.id.next_button);
        boxcheck=(CheckBox) findViewById(R.id.notify_me_checkbox);
        editor=myPreferences.edit();
        myPreferences = getSharedPreferences("Myapp", getApplicationContext().MODE_PRIVATE);
        /* editor.putString("key","maya");
         editor.commit();
         String name =myPreferences.getString("key","value");
        Log.d(TAG,"onCreate: name:"+ name);*/
         checkSharedPrefence();
         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if (boxcheck.isChecked()){
                     editor.putString(getString(R.string.notify_me),"true");
                     editor.commit();

                     String nom =name.getText().toString();
                     editor.putString(getString(R.string.enter_name),nom);
                     editor.commit();

                     String password =pwd.getText().toString();
                     editor.putString(getString(R.string.enter_pwd),password);
                     editor.commit();
                 }else {
                     editor.putString(getString(R.string.notify_me),"false");
                     editor.commit();

                     editor.putString(getString(R.string.enter_name),"");
                     editor.commit();

                     editor.putString(getString(R.string.enter_pwd),"");
                     editor.commit();

                 }
             }

         });

}
}