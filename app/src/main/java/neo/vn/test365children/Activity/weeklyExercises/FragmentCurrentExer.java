package neo.vn.test365children.Activity.weeklyExercises;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import neo.vn.test365children.Base.BaseFragment;
import neo.vn.test365children.Fragment.FragmentCompleteBaitap;
import neo.vn.test365children.Models.CauhoiDetail;
import neo.vn.test365children.R;

/**
 * Created 11/03/2022 at 15:56
 * Company: VHM
 */
public class FragmentCurrentExer extends BaseFragment {

    public static FragmentCurrentExer newInstance() {
        FragmentCurrentExer fragment = new FragmentCurrentExer();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_demo, container, false);
        ButterKnife.bind(this, view);
        initEvent();
        return view;
    }

    private void initEvent() {

    }
}
