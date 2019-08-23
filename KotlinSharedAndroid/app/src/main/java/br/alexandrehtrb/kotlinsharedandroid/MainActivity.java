package br.alexandrehtrb.kotlinsharedandroid;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.alexandrehtrb.kotlinsharedlibrary.Person;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_MAIN_ACTIVITY_PERSON = "KEY_MAIN_ACTIVITY_PERSON";

    private Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ignore red warning in Android Studio! Just click in Run!
        if (savedInstanceState != null) {
            this.person = (Person) savedInstanceState.getSerializable(KEY_MAIN_ACTIVITY_PERSON);
            Log.d("MainActivity", "Loading Person object from savedInstanceState.");
        } else {
            this.person = new Person("John", 20);
            Log.d("MainActivity", "Creating new Person object.");
        }

        TextView centerText = findViewById(R.id.activity_main_center_text);
        centerText.setText(person.createApplicationScreenMessage());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //Ignore red warning in Android Studio! Just click in Run!
        outState.putSerializable(KEY_MAIN_ACTIVITY_PERSON, this.person);
        super.onSaveInstanceState(outState);
    }
}