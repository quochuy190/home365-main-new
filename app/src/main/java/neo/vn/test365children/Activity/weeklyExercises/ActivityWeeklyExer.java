package neo.vn.test365children.Activity.weeklyExercises;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import neo.vn.test365children.Activity.CustomViewPager;
import neo.vn.test365children.Adapter.AdapterViewpager;
import neo.vn.test365children.Base.BaseActivity;
import neo.vn.test365children.FragmentDemo;
import neo.vn.test365children.R;

/**
 * Created 11/03/2022 at 15:49
 * Company: VHM
 */
public class ActivityWeeklyExer extends BaseActivity {
    @BindView(R.id.vpWeeklyExer)
    CustomViewPager vpWeeklyExer;
    @BindView(R.id.mTabExer)
    TabLayout mTabExer;
    AdapterViewpager adapterViewpager;

    @Override
    public int setContentViewId() {
        return R.layout.activity_weekly_exer;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewPage();
    }

    private void initViewPage() {
        adapterViewpager = new AdapterViewpager(getSupportFragmentManager());
        adapterViewpager.addFragment(FragmentLastExer.newInstance(), "Bài tập tuần trước");
        adapterViewpager.addFragment(FragmentCurrentExer.newInstance(), "Bài tập tuần này");
        vpWeeklyExer.setPagingEnabled(true);
        vpWeeklyExer.setAdapter(adapterViewpager);
        mTabExer.setupWithViewPager(vpWeeklyExer);
    }
}
