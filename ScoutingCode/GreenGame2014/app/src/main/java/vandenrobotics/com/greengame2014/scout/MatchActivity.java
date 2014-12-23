package vandenrobotics.com.greengame2014.scout;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.view.View;

import vandenrobotics.com.greengame2014.R;
import vandenrobotics.com.greengame2014.scout.dialogs.DialogListener;
import vandenrobotics.com.greengame2014.scout.tabs.*;

public class MatchActivity extends FragmentActivity implements DialogListener {

    private FragmentTabHost mTabHost;
    private InitFragment mInitFrag;
    private AutoFragment mAutoFrag;
    private TeleFragment mTeleFrag;
    private PostFragment mPostFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        mTabHost = (FragmentTabHost) findViewById(R.id.tabHost);
        mTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

        mTabHost.addTab(mTabHost.newTabSpec("tab_init")
                .setIndicator(getResources().getString(R.string.title_initTab), null),InitFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("auto_init")
                .setIndicator(getResources().getString(R.string.title_autoTab), null), AutoFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("tele_init")
                .setIndicator(getResources().getString(R.string.title_teleTab), null),TeleFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("post_init")
                .setIndicator(getResources().getString(R.string.title_postTab), null),PostFragment.class, null);
    }

    public void command_noShow(View view){
        mInitFrag = (InitFragment)getSupportFragmentManager().findFragmentByTag("tab_init");
        mInitFrag.command_noShow(view);
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        if(!dialog.equals(null)){
            if(dialog.equals(mInitFrag.noShowDF)) {
                mInitFrag.setNoShow(true);
                this.finish();
            }
        }
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        if(!dialog.equals(null)){
            if(dialog.equals(mInitFrag.noShowDF)) {
                mInitFrag.setNoShow(false);
            }
        }
    }
}
