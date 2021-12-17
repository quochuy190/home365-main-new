package neo.vn.test365children.MenuSearch;

import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import neo.vn.test365children.Adapter.AdapterListSchools;
import neo.vn.test365children.App;
import neo.vn.test365children.Base.BaseActivity;
import neo.vn.test365children.Config.Constants;
import neo.vn.test365children.Listener.ItemClickListener;
import neo.vn.test365children.Models.City;
import neo.vn.test365children.Models.District;
import neo.vn.test365children.Models.ErrorApi;
import neo.vn.test365children.Models.Schools;
import neo.vn.test365children.Models.respon_api.ResponGetDistrict;
import neo.vn.test365children.Models.respon_api.ResponGetProvince;
import neo.vn.test365children.Models.respon_api.ResponGetSchool;
import neo.vn.test365children.R;
import neo.vn.test365children.Untils.KeyboardUtil;
import neo.vn.test365children.Untils.SharedPrefs;


/**
 * Created by QQ on 10/16/2017.
 */

public class ActivityListSchools extends BaseActivity implements ImlMenuSearch.View, ImlMenuSearchRest.View {

    private List<Schools> mLisAirport;
    private AdapterListSchools adapterService;
    @BindView(R.id.recycle_list_service)
    RecyclerView recycle_service;
    RecyclerView.LayoutManager mLayoutManager;
    @BindView(R.id.edt_search_service)
    EditText edt_search_service;
    List<Schools> temp;
    String sUserId;
    PresenterMenuSearch mPresenter;
    PresenterRestMenuSearch mPresenterRest;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //   setContentView(R.layout.fragment_service);
        ButterKnife.bind(this);
        KeyboardUtil.hideSoftKeyboard(this);
        //  initData();
        App.mSchools = null;
        mPresenter = new PresenterMenuSearch(this);
        mPresenterRest = new PresenterRestMenuSearch(this);
        edt_search_service.setVisibility(View.VISIBLE);
        initAppbar();
        init();
        initData();
        initEvent();
    }

    TextView txt_title;

    public void initAppbar() {
        ImageView img_back = findViewById(R.id.img_back);
        txt_title = findViewById(R.id.txt_title_main);
        txt_title.setVisibility(View.GONE);
        img_back.setVisibility(View.VISIBLE);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public int setContentViewId() {
        return R.layout.activity_recycleview;
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    /*  @Nullable
          @Override
          public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
              View view= inflater.inflate(R.layout.fragment_service, container, false);


              view.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {

                  }
              });
              return view;
          }
      */
    private void initEvent() {
        edt_search_service.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {

                // filter your list from your input
                filter(s.toString());
                //you can use runnable postDelayed like 500 ms to delay search text
            }
        });


    }

    void filter(String text) {
        temp.clear();
        for (Schools d : mLisAirport) {
            if (d.getsSCHOOL_NAME().toLowerCase().contains(text.toLowerCase())) {
                //adding the element to filtered list
                temp.add(d);
            }
            //or use .equal(text) with you want equal match
            //use .toLowerCase() for better matches
            if (d.getsSCHOOL_NAME().contains(text)) {

            }
        }
        //update recyclerview
        adapterService.updateList(temp);
       /* adapterService.setOnIListener(new ItemClickListener() {
            @Override
            public void OnItemClickListener(int position) {
                App.mDistrict = temp.get(position);
                finish();
            }

            @Override
            public void OnLongItemClickListener(int position) {

            }
        });*/
        adapterService.setOnIListener(new ItemClickListener() {
            @Override
            public void onClickItem(int position, Object item) {
                setResult(RESULT_OK, new Intent());
                App.mSchools = (Schools) item;
                finish();
            }
        });

    }

    private void init() {
        mLisAirport = new ArrayList<>();
        temp = new ArrayList<>();
        adapterService = new AdapterListSchools(temp, this);
        mLayoutManager = new GridLayoutManager(this, 1);
        recycle_service.setNestedScrollingEnabled(false);
        recycle_service.setHasFixedSize(true);
        recycle_service.setLayoutManager(mLayoutManager);
        recycle_service.setItemAnimator(new DefaultItemAnimator());
        recycle_service.setAdapter(adapterService);
        adapterService.updateList(temp);
        /*adapterService.setOnIListener(new setOnItemClickListener() {
            @Override
            public void OnItemClickListener(int position) {
                App.mDistrict = mLisAirport.get(position);
                finish();

            }

            @Override
            public void OnLongItemClickListener(int position) {

            }
        });*/
        adapterService.setOnIListener(new ItemClickListener() {
            @Override
            public void onClickItem(int position, Object item) {
                setResult(RESULT_OK, new Intent());
                App.mSchools = (Schools) item;
                finish();
            }
        });

    }

    private void initData() {
        String sDistrictId = getIntent().getStringExtra(Constants.KEY_SEND_DISTRICT_ID);
        sUserId = SharedPrefs.getInstance().get(Constants.KEY_USER_ME, String.class);
        String sUserChild = SharedPrefs.getInstance().get(Constants.KEY_USER_CON, String.class);
        showDialogLoading();
        //mPresenter.api_get_list_schools(sUserId, sDistrictId);
        mPresenterRest.apirest_get_school(sUserId, sUserChild, sDistrictId);
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }


    @Override
    public void show_get_api_error() {
        hideDialogLoading();
    }

    @Override
    public void show_get_list_district(List<District> mList) {
        hideDialogLoading();

    }

    @Override
    public void show_get_list_citys(List<City> mList) {
        hideDialogLoading();

    }

    @Override
    public void show_get_list_schools(List<Schools> mList) {
        hideDialogLoading();
        if (mList != null) {
            mLisAirport.addAll(mList);
            temp.addAll(mLisAirport);
            adapterService.notifyDataSetChanged();
        }
    }

    @Override
    public void show_error_api(ErrorApi obj) {
        hideDialogLoading();
    }

    @Override
    public void show_get_list_district(ResponGetDistrict objRespon) {
        hideDialogLoading();
    }

    @Override
    public void show_get_list_province(ResponGetProvince objRespon) {
        hideDialogLoading();
    }

    @Override
    public void show_get_list_schools(ResponGetSchool objRespon) {
        hideDialogLoading();
        if (objRespon.getsERROR().equals("0000")) {
            if (objRespon.getLisSchool() != null) {
                mLisAirport.addAll(objRespon.getLisSchool());
                temp.addAll(mLisAirport);
                adapterService.notifyDataSetChanged();
            }
        }

    }
}
