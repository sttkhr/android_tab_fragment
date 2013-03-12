package localhost.test_tab_fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Tab1Fragment extends Fragment {
    @Override
    public View onCreateView(
    		LayoutInflater inflater,
    		ViewGroup container,
    		Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab1_fragment, container, false);
        return v;
    }
}
