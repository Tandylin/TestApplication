package com.example.lin.testapplication.base;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.example.lin.testapplication.R;
import com.example.lin.testapplication.activity.NotificationActivity;

/**
 * Created by 101912 on 2017/8/1.
 */

public class BaseLayout extends LinearLayout {

    Context context;
    public RelativeLayout rl_content;
    public RelativeLayout rl_top;

    public BaseLayout(Context context) {
        super(context);
        this.context = context;
        initView();
    }

    private void initView() {
        View view = View.inflate(context, R.layout.baselayout, null);
        rl_content = (RelativeLayout) view.findViewById(R.id.rl_content);
        rl_top = (RelativeLayout) view.findViewById(R.id.rl_top);
        super.addView(view);
    }

    public void setTopLayoutVisibility(int visibility) {
        rl_top.setVisibility(visibility);
    }

    public void addContentView(View view) {
      //  LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        if (rl_content.getChildCount() > 0) {
            rl_content.removeAllViews();
        }
        rl_content.addView(view);

    }

}
