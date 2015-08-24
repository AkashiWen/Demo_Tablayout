package chopper.me.demo_tablayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Akashi on 8/24.
 */
public class MyFragment extends Fragment {

    public static MyFragment newInstance(int index) {
        MyFragment myFragment = new MyFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("index", index);
        myFragment.setArguments(bundle);
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = new View(getActivity());
        switch (getArguments().getInt("index")) {
            case 1:
                view.setBackgroundColor(getResources().getColor(R.color.orange));
                break;
            case 2:
                view.setBackgroundColor(getResources().getColor(R.color.green));
                break;
            case 3:
                view.setBackgroundColor(getResources().getColor(R.color.zise));
                break;
            case 4:
                view.setBackgroundColor(getResources().getColor(R.color.coffee));
                break;
        }


        return view;
    }
}
