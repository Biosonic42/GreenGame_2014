package vandenrobotics.com.greengame2014;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import vandenrobotics.com.greengame2014.adapter.*;

public class MatchActivity extends FragmentActivity
    implements ActionBar.TabListener {

    private TabsViewPager mViewPager;
    private TabsPagerAdapter mAdapter;
    private ActionBar mActionBar;

    private String[] tab_names = {"Team Information", "Autonomous", "Tele-Op", "Post Match"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_match);

        mAdapter = new TabsPagerAdapter(getSupportFragmentManager());
        mViewPager = (TabsViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mAdapter);

        mActionBar = getActionBar();

        mActionBar.setHomeButtonEnabled(false);
        getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        for(String tab_name : tab_names) {
            mActionBar.addTab(mActionBar.newTab()
                    .setText(tab_name)
                    .setTabListener(this));

        mActionBar.setDisplayHomeAsUpEnabled(true);
        }

        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){

            @Override
            public void onPageSelected(int position) {
                mActionBar.setSelectedNavigationItem(position);
            }
        });
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {}

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {}
}
