package developer.harsu.com.myfirstapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText email, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences pref=getPreferences(MODE_PRIVATE);
        boolean signedIn=pref.getBoolean("SignedIn",false);
        if(signedIn){
            startSubActivity();
        }
        login = (Button) findViewById(R.id.btnLogin);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailEntered = email.getText().toString();
                String passwordEntered = password.getText().toString();
                if (emailEntered.equals("harsu@1234") && passwordEntered.equals("12345678")) {
                    Toast.makeText(MainActivity.this, "Successfully logged in", Toast.LENGTH_SHORT).show();

                    SharedPreferences.Editor editor= getPreferences(MODE_PRIVATE).edit();
                    editor.putBoolean("SignedIn", true);
                    editor.apply();
                    startSubActivity();

                } else {
                    Toast.makeText(MainActivity.this, "username or password entered is wrong!!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private void startSubActivity() {
        startActivity(new Intent(MainActivity.this, SubActivity.class));
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Main Activity", "OnResume called");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Main Activity", "onPause called");
    }


}
