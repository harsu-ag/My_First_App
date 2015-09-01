package developer.harsu.com.myfirstapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int sum;
    TextView tvSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sum = 0;
        Button bAdd, bSub;

        bAdd = (Button) findViewById(R.id.Badd);
        bSub = (Button) findViewById(R.id.Bsub);
        tvSum = (TextView) findViewById(R.id.tvSum);

        bAdd.setOnClickListener(this);
        bSub.setOnClickListener(this);

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
    public void onClick(View v) {
        if (v.getId() == R.id.Badd) {
            Toast.makeText(this, "BAdd clicked", Toast.LENGTH_SHORT).show();

            sum++;
            tvSum.setText("Sum is " + sum);


        } else if (v.getId() == R.id.Bsub) {
            Toast.makeText(this, "BSub clicked", Toast.LENGTH_SHORT).show();
            sum--;
            tvSum.setText("Sum is " + sum);
        }
    }
}
