package neo.vn.test365children.Activity.game.game_kow;

import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import neo.vn.test365children.Adapter.AdapterTopicKoW;
import neo.vn.test365children.Base.BaseActivity;
import neo.vn.test365children.Config.Constants;
import neo.vn.test365children.Listener.ItemClickListener;
import neo.vn.test365children.Models.ErrorApi;
import neo.vn.test365children.Models.ResponDetailKow;
import neo.vn.test365children.Models.ResponGetTopicKow;
import neo.vn.test365children.Models.TopicKoW;
import neo.vn.test365children.Presenter.ImlGameKoW;
import neo.vn.test365children.Presenter.PresenterGameKoW;
import neo.vn.test365children.R;
import neo.vn.test365children.Untils.KeyboardUtil;
import neo.vn.test365children.Untils.SharedPrefs;

public class ActivityKoWMenuGame extends BaseActivity
        implements View.OnClickListener, ImlGameKoW.View {
    @BindView(R.id.img_back)
    ImageView img_back;
    @BindView(R.id.img_background)
    ImageView img_background;
    private String sUserMother;
    private String sUserKiD;
    private PresenterGameKoW mPresenter;
    @BindView(R.id.list_topic_left)
    RecyclerView list_topic_left;
    @BindView(R.id.list_topic_right)
    RecyclerView list_topic_right;
    AdapterTopicKoW adapter_left;
    AdapterTopicKoW adapter_right;
    RecyclerView.LayoutManager mLayoutManager_left;
    RecyclerView.LayoutManager mLayoutManager_right;
    List<TopicKoW> mLisLeft, mLisRight;

    @Override
    public int setContentViewId() {
        return R.layout.activity_game_kow_menu_level;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new PresenterGameKoW(this);
        Glide.with(this).load(R.drawable.bg_kow_menu).into(img_background);
        initLis();
        initData();
        initEvent();
        /*btn_start_kow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               *//* KeyboardUtil.animation_click_button(ActivityKoWMenuGame.this, btn_start_kow);
                startActivity(new Intent(ActivityKoWMenuGame.this, ActivityKoWPlayGame.class));*//*
            }
        });*/
        // group_gameover.setVisibility(View.GONE);
    }

    private void initLis() {
        mLisLeft = new ArrayList<>();
        mLisRight = new ArrayList<>();
        adapter_left = new AdapterTopicKoW(mLisLeft, this);
        adapter_right = new AdapterTopicKoW(mLisRight, this);
        mLayoutManager_left = new GridLayoutManager(this, 1,
                GridLayoutManager.VERTICAL, false);
        mLayoutManager_right = new GridLayoutManager(this, 1,
                GridLayoutManager.VERTICAL, false);
        list_topic_left.setLayoutManager(mLayoutManager_left);
        list_topic_left.setAdapter(adapter_left);
        list_topic_right.setLayoutManager(mLayoutManager_right);
        list_topic_right.setAdapter(adapter_right);
    }

    private void initData() {
        sUserMother = SharedPrefs.getInstance().get(Constants.KEY_USER_ME, String.class);
        sUserKiD = SharedPrefs.getInstance().get(Constants.KEY_USER_CON, String.class);
        if (sUserKiD != null && sUserMother != null) {
            showDialogLoading();
            mPresenter.api_get_list_topic_kow(sUserMother, sUserKiD);
        }
    }

    private void initEvent() {
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtil.play_click_button(ActivityKoWMenuGame.this);
                finish();
            }
        });
        adapter_left.setOnIListener(new ItemClickListener() {
            @Override
            public void onClickItem(int position, Object item) {
                KeyboardUtil.play_click_button(ActivityKoWMenuGame.this);
                Intent intent = new Intent(ActivityKoWMenuGame.this, ActivityKoWMenuLevel.class);
                intent.putExtra(Constants.KEY_SEND_LEVEL_KOW, mLisLeft.get(position));
                startActivity(intent);
            }
        });
        adapter_right.setOnIListener(new ItemClickListener() {
            @Override
            public void onClickItem(int position, Object item) {
                KeyboardUtil.play_click_button(ActivityKoWMenuGame.this);
                Intent intent = new Intent(ActivityKoWMenuGame.this, ActivityKoWMenuLevel.class);
                intent.putExtra(Constants.KEY_SEND_LEVEL_KOW, mLisRight.get(position));
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {

      /*  switch (v.getId()) {
            case R.id.btn_level_one:
                KeyboardUtil.animation_click_button(ActivityKoWMenuGame.this, btn_level_one);
                intent.putExtra(Constants.KEY_SEND_LEVEL_KOW, "1");
                startActivity(intent);
                break;
            case R.id.btn_level_two:
                KeyboardUtil.animation_click_button(ActivityKoWMenuGame.this, btn_level_two);
                intent.putExtra(Constants.KEY_SEND_LEVEL_KOW, "2");
                startActivity(intent);
                break;
            case R.id.btn_level_three:
                *//*KeyboardUtil.animation_click_button(ActivityKoWMenuGame.this, btn_level_three);
                intent.putExtra(Constants.KEY_SEND_LEVEL_KOW, "3");
                startActivity(intent);*//*
                break;
        }*/
    }

    @Override
    public void show_error_api(ErrorApi objError) {

    }

    @Override
    public void show_list_topic(ResponGetTopicKow objRes) {
        hideDialogLoading();
        if (objRes.getsERROR().equals("0000")) {
            if (objRes.getLisInfo() != null && objRes.getLisInfo().size() > 0) {
                if (objRes.getLisInfo().size() > 1) {
                    for (int i = 0; i < objRes.getLisInfo().size(); i++) {
                        if (i < (objRes.getLisInfo().size() / 2)) {
                            mLisLeft.add(objRes.getLisInfo().get(i));
                        } else {
                            mLisRight.add(objRes.getLisInfo().get(i));
                        }
                    }
                } else {
                    mLisLeft.addAll(objRes.getLisInfo());
                }
                adapter_right.notifyDataSetChanged();
                adapter_left.notifyDataSetChanged();
            }
        } else showAlertDialog(objRes.getsMESSAGE(), objRes.getsRESULT());
    }

    @Override
    public void show_list_detail_kow(ResponDetailKow objRes) {

    }
}
