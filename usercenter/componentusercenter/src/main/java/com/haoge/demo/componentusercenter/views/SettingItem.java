package com.haoge.demo.componentusercenter.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.haoge.demo.componentusercenter.R;

/**
 * @author haoge on 2018/1/5.
 */

public class SettingItem extends LinearLayout {

    TextView name;

    public SettingItem(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.item_setting, this, true);
        name = (TextView) findViewById(R.id.name);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.SettingItem);
        setName(ta.getString(R.styleable.SettingItem_name));
        ta.recycle();
    }

    public void setName(String name) {
        if (name == null) {
            name = "";
        }
        this.name.setText(name);
    }
}
