package com.zbobin.androiddemo.widget.dialog;

import android.app.Activity;
import android.app.Dialog;

import com.zbobin.androiddemo.R;


/**
 * 自定义加载对话框
 *
 * @author zbobin
 */
public class LoadDialog extends Dialog {

    public LoadDialog(Activity context) {
        super(context, R.style.ProgressDialog);
        this.setContentView(R.layout.progress_dialog);

        // 禁止点击activity空白处就dismiss对话框
        this.setCanceledOnTouchOutside(false);
    }
}
