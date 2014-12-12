package vandenrobotics.com.greengame2014;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class ScoutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scout);

        startActivity(new Intent(this, MatchActivity.class));
    }

}
