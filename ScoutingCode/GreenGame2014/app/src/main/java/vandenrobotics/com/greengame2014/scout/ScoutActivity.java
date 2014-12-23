package vandenrobotics.com.greengame2014.scout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import vandenrobotics.com.greengame2014.R;

public class ScoutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scout);
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    public void nextMatch(View view){
        startActivity(new Intent(this, MatchActivity.class));
    }
}
