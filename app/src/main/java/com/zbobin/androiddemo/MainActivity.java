package com.zbobin.androiddemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.zbobin.androiddemo.entity.StaticData;
import com.zbobin.androiddemo.entity.UrlData;
import com.zbobin.androiddemo.utils.CommonLogUtil;
import com.zbobin.androiddemo.utils.HttpUtil;
import com.zbobin.androiddemo.utils.NetworkUtil;
import com.zbobin.androiddemo.utils.ToastUtil;
import com.zbobin.androiddemo.widget.dialog.LoadDialog;

/**
 * 主界面
 *
 * @author zbobin
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView textViewResult;
    private LoadDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog = new LoadDialog(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textViewResult = (TextView) findViewById(R.id.textView_result);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        //1网络请求
        if (id == R.id.nav_android_async_http) {
            if(NetworkUtil.isNetworkAvailable(this) || NetworkUtil.isWiFiActive(this)){
                requestData();
            }else{
                ToastUtil.showMessage(this, R.string.network_is_disabled, Toast.LENGTH_LONG);
            }
        } else if (id == R.id.nav_httpmime) {
            if(NetworkUtil.isNetworkAvailable(this) || NetworkUtil.isWiFiActive(this)){
                requestData();
            }else{
                ToastUtil.showMessage(this, R.string.network_is_disabled, Toast.LENGTH_LONG);
            }
        } else if (id == R.id.nav_okHttp) {
            ToastUtil.showMessage(this, R.string.nav_okHttp);
        } else if (id == R.id.nav_retrofit2) {
            ToastUtil.showMessage(this, R.string.nav_retrofit2);
        //2下拉刷新、加载更多
        } else if (id == R.id.nav_PullToRefresh) {
            ToastUtil.showMessage(this, R.string.nav_PullToRefresh);
        } else if (id == R.id.nav_Ultra_Pull_To_Refresh) {
            ToastUtil.showMessage(this, R.string.nav_Ultra_Pull_To_Refresh);
        //3注解
        } else if (id == R.id.nav_Butterknife) {
            ToastUtil.showMessage(this, R.string.nav_Butterknife);
        } else if (id == R.id.nav_dagger2) {
            ToastUtil.showMessage(this, R.string.nav_dagger2);
        //4json解析
        } else if (id == R.id.nav_Json) {
            ToastUtil.showMessage(this, R.string.nav_Json);
        } else if (id == R.id.nav_Gson) {
            ToastUtil.showMessage(this, R.string.nav_Gson);
        } else if (id == R.id.nav_FastJson) {
            ToastUtil.showMessage(this, R.string.nav_FastJson);
        } else if (id == R.id.nav_converter_gson) {
            ToastUtil.showMessage(this, R.string.nav_converter_gson);
        //5图片加速
        } else if (id == R.id.nav_maa) {
            ToastUtil.showMessage(this, R.string.nav_maa);
        //6图片加载
        } else if (id == R.id.nav_Universalimageloader) {
            ToastUtil.showMessage(this, R.string.nav_Universalimageloader);
        } else if (id == R.id.nav_Photoview) {
            ToastUtil.showMessage(this, R.string.nav_Photoview);
        //7字母导航栏
        } else if (id == R.id.nav_pinyin4j) {
            ToastUtil.showMessage(this, R.string.nav_pinyin4j);
        //8com.android.support组件
        } else if (id == R.id.nav_Design) {
            ToastUtil.showMessage(this, R.string.nav_Design);
        } else if (id == R.id.nav_appcompat_v7) {
            ToastUtil.showMessage(this, R.string.nav_appcompat_v7);
        } else if (id == R.id.nav_recyclerview_v7) {
            ToastUtil.showMessage(this, R.string.nav_recyclerview_v7);
        } else if (id == R.id.nav_cardview_v7) {
            ToastUtil.showMessage(this, R.string.nav_cardview_v7);
        //9时间
        } else if (id == R.id.nav_TimePickerDialog) {
            ToastUtil.showMessage(this, R.string.nav_TimePickerDialog);
        } else if (id == R.id.nav_android_times_square) {
            ToastUtil.showMessage(this, R.string.nav_android_times_square);
        //10拖动选取
        } else if (id == R.id.nav_discrete_seekbar) {
            ToastUtil.showMessage(this, R.string.nav_discrete_seekbar);
        //11dex分包
        } else if (id == R.id.nav_Multidex) {
            ToastUtil.showMessage(this, R.string.nav_Multidex);
        //12多渠道打包
        } else if (id == R.id.nav_channel) {
            ToastUtil.showMessage(this, R.string.nav_channel);
        } else if (id == R.id.nav_walle_plugin) {
            ToastUtil.showMessage(this, R.string.nav_walle_plugin);
        //13二维码扫码
        } else if (id == R.id.nav_Zxing) {
            ToastUtil.showMessage(this, R.string.nav_Zxing);
        //14响应式编程框架
        } else if (id == R.id.nav_Rxjava) {
            ToastUtil.showMessage(this, R.string.nav_Rxjava);
        } else if (id == R.id.nav_RxAndroid) {
            ToastUtil.showMessage(this, R.string.nav_RxAndroid);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void requestData() {
        RequestParams params = HttpUtil.getRequestParams(this);
        params.put(StaticData.PAGE, "1");

        HttpUtil.post(this, UrlData.APP_KIND, params, new AsyncHttpResponseHandler() {

            @Override
            public void onStart() {
                super.onStart();
                if (dialog != null && !isFinishing()) {
                     dialog.show();
                }
            }

            @Override
            public void onSuccess(String s) {
                super.onSuccess(s);
                try {
                    CommonLogUtil.e(TAG, s);
                    textViewResult.setText(s);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Throwable throwable, String s) {
                super.onFailure(throwable, s);
                if (dialog != null) {
                    dialog.dismiss();
                }
            }

            @Override
            public void onFinish() {
                super.onFinish();
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });

    }
}
