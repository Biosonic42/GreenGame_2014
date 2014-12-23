package vandenrobotics.com.greengame2014.scout.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vandenrobotics.com.greengame2014.R;

/**
 * Created by Programming701-A on 12/11/2014.
 */
public class TeleFragment extends Fragment {

    public static TeleFragment newInstance(){
        TeleFragment teleFrag = new TeleFragment();

        return teleFrag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_tele, container, false);

        return rootView;
    }
}
