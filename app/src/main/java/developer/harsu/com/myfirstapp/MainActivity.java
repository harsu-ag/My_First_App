package developer.harsu.com.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {




    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button start;
        start=(Button) findViewById(R.id.BStartNew);
        editText=(EditText) findViewById(R.id.editText);
        start.setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Main Activity" , "OnResume called");
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

    @Override
    public void onClick(View v) {
       if(v.getId()==R.id.BStartNew){
          String entered= editText.getText().toString();
           Intent intent=new Intent(this,SubActivity.class);
           intent.putExtra("abcd",entered);
           startActivity(intent);
       }
    }
}
