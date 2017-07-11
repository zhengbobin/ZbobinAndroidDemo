package com.zbobin.androiddemo.app.base;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.zbobin.androiddemo.R;
import com.zbobin.androiddemo.entity.StaticData;

/**
 * 自定义的内部浏览器
 *
 * @author zbobin
 *         2017/7/11.
 */

public class CommonWebViewActivity extends BaseActity {

    Toolbar toolbar;
    private WebView webView;
    private String title = "";
    private String url = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_webview);
        initView();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        webView = (WebView) findViewById(R.id.webView);

        if (getIntent().hasExtra(StaticData.TITLE))
            title = getIntent().getStringExtra(StaticData.TITLE);
        if (getIntent().hasExtra(StaticData.URL))
            url = getIntent().getStringExtra(StaticData.URL);
        toolbar.setTitle(title);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                toolbar.setTitle(title);
            }

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);

            }
        });

        webView.loadUrl(url);

    }

}
