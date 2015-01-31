package vandenrobotics.com.greengame2014.scout.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import vandenrobotics.com.greengame2014.R;
import vandenrobotics.com.greengame2014.scout.dialogs.NoShowDialogFragment;

/**
 * Created by Programming701-A on 12/11/2014.
 */
public class InitFragment extends Fragment {

    private CheckBox noShow;
    private ImageView robotPic;
    public NoShowDialogFragment noShowDF;


    private boolean viewsAssigned = false;

    public static InitFragment newInstance(){
        InitFragment initFrag = new InitFragment();

        return initFrag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_init, container, false);

        noShowDF = new NoShowDialogFragment();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        assignViews(view);

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser){
        super.setUserVisibleHint(isVisibleToUser);
        if(!viewsAssigned);
        else if(isVisibleToUser);
            //loadData();
        else if(!isVisibleToUser);
            //saveData();

    }

    @Override
    public void onPause(){
        super.onPause();
        //saveData();
        viewsAssigned=false;
    }

    @Override
    public void onResume(){
        super.onResume();
        //loadData();
        assignViews(getView());
    }

    private void assignViews(View view){
        try{
            noShow = (CheckBox) view.findViewById(R.id.cb_noShow);
            robotPic = (ImageView) view.findViewById(R.id.img_teamPic);
            String url = "https://lh5.googleusercontent.com/-Wnd2tLc6DKI/VJFD50_M3oI/AAAAAAAAiNQ/9syW2hURsC0/s426/IMG_5391.JPG";
            Picasso.with(getActivity()).load(url).into(robotPic);


            viewsAssigned = true;
        } catch (Exception e){
            e.printStackTrace();
            viewsAssigned = false;
        }
    }

    public void command_noShow(View view) {
        if (noShow.isChecked()) {
            noShowDF.show(getFragmentManager(), "NoShowDialogFragment");
        }
    }

    public void setNoShow(boolean b){
        noShow.setChecked(b);
    }

    public boolean getNoShow(){
        return noShow.isChecked();
    }
}
