package vandenrobotics.com.greengame2014.scout;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
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
                .setIndicator(getResources().getString(R.string.title_initTab), null), InitFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("tab_auto")
                .setIndicator(getResources().getString(R.string.title_autoTab), null), AutoFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("tab_tele")
                .setIndicator(getResources().getString(R.string.title_teleTab), null), TeleFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("tab_post")
                .setIndicator(getResources().getString(R.string.title_postTab), null), PostFragment.class, null);
    }

    private void set_fragments(){
        mInitFrag = (InitFragment)getSupportFragmentManager().findFragmentByTag("tab_init");
        mAutoFrag = (AutoFragment)getSupportFragmentManager().findFragmentByTag("tab_auto");
        mTeleFrag = (TeleFragment)getSupportFragmentManager().findFragmentByTag("tab_tele");
        mPostFrag = (PostFragment)getSupportFragmentManager().findFragmentByTag("tab_post");
    }

    public void dialog_noShow(View view){
        if(mInitFrag==null) mInitFrag = (InitFragment)getSupportFragmentManager().findFragmentByTag("tab_init");
        mInitFrag.command_noShow(view);
    }

    public void dialog_autoAction(View view){
        if(mAutoFrag==null) mAutoFrag = (AutoFragment)getSupportFragmentManager().findFragmentByTag("tab_auto");
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
