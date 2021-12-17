package neo.vn.test365children.Activity.untility_menu;

import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import neo.vn.test365children.Adapter.AdapterMenuUntility;
import neo.vn.test365children.Base.BaseActivity;
import neo.vn.test365children.Config.Constants;
import neo.vn.test365children.Listener.ItemClickListener;
import neo.vn.test365children.Models.ErrorApi;
import neo.vn.test365children.Models.ObjUntility;
import neo.vn.test365children.Models.respon_api.ResponGetUntilities;
import neo.vn.test365children.R;
import neo.vn.test365children.Untils.KeyboardUtil;
import neo.vn.test365children.Untils.SharedPrefs;

public class Activity_Menu_Untility extends BaseActivity implements Iml_Untilities.View {
    @BindView(R.id.list_menu_untility)
    RecyclerView list_menu_untility;
    @BindView(R.id.img_background)
    ImageView img_background;
    @BindView(R.id.btn_back)
    ImageView btn_back;
    @BindView(R.id.btn_mute)
    ImageView btn_mute;
    RecyclerView.LayoutManager mLayoutManager;
    List<ObjUntility> lisMenuUntility;
    AdapterMenuUntility adapter;
    PresenterUntilities mPresenter;
    String sUserMother, sUserChild;

    @Override
    public int setContentViewId() {
        return R.layout.activity_untility;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Glide.with(this).load(R.drawable.bg_untility)
                .into(img_background);
        mPresenter = new PresenterUntilities(this);
        init();
        initData();
        initEvent();
    }

    private void initData() {
        sUserMother = SharedPrefs.getInstance().get(Constants.KEY_USER_ME, String.class);
        sUserChild = SharedPrefs.getInstance().get(Constants.KEY_USER_CON, String.class);
        showDialogLoading();
        mPresenter.api_get_untilities(sUserMother, sUserChild);
    }

    private void initEvent() {
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtil.play_click_button(Activity_Menu_Untility.this);
                finish();
            }
        });
        btn_mute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtil.play_click_button(Activity_Menu_Untility.this);
                finish();
            }
        });
    }

    private void init() {
        lisMenuUntility = new ArrayList<>();
        adapter = new AdapterMenuUntility(lisMenuUntility, this);
        mLayoutManager = new GridLayoutManager(this,
                7, GridLayoutManager.VERTICAL, false);
        //    recycleBaitap.setNestedScrollingEnabled(false);
        list_menu_untility.setHasFixedSize(true);
        list_menu_untility.setLayoutManager(mLayoutManager);
        list_menu_untility.setItemAnimator(new DefaultItemAnimator());
        list_menu_untility.setAdapter(adapter);
        adapter.setOnIListener(new ItemClickListener() {
            @Override
            public void onClickItem(int position, Object item) {
                KeyboardUtil.play_click_button(Activity_Menu_Untility.this);
                ObjUntility obj = (ObjUntility) item;
                Intent intent = new Intent(Activity_Menu_Untility.this, ActivityUntitiliesDetail.class);
                intent.putExtra(Constants.KEY_SEND_DETAIL_UNTILITIES, obj);
                startActivity(intent);
            }
        });
    }

    @Override
    public void show_error_api(ErrorApi mLis) {
        hideDialogLoading();
        showAlertErrorNetwork();
    }

    @Override
    public void show_get_untilities(ResponGetUntilities mLis) {
        hideDialogLoading();
        lisMenuUntility.clear();
        if (mLis.getsERROR().equals("0000")) {
            if (mLis.getLisUntilities() != null) {
                lisMenuUntility.addAll(mLis.getLisUntilities());

            }
        } else {
            showDialogNotify("Lỗi", mLis.getsRESULT());
        }
        adapter.notifyDataSetChanged();
    }
}
