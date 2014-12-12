package vandenrobotics.com.greengame2014.adapter;

import vandenrobotics.com.greengame2014.fragments.*;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {
	
	public TabsPagerAdapter(FragmentManager fm){
		super(fm);
	}
	
	@Override
	public Fragment getItem(int index){
		
		switch (index) {
            case 0:
                return InitFragment.newInstance();
            case 1:
                // autonomous fragment activity
                return AutoFragment.newInstance();
            case 2:
                // tele-op fragment activity
                return TeleFragment.newInstance();
            case 3:
                // post game fragment activity
                return PostFragment.newInstance();
		}
		return null;
	}

	@Override
	public int getCount(){
		// returns number of tabs
		return 4;
	}

}
