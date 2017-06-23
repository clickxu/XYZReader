package com.example.xyzreader.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.example.xyzreader.R;

/**
 * Created by t-xu on 2017/06/23.
 */

public class DynamicHeightImageView extends AppCompatImageView {

    private float mRadio = 0;

    public DynamicHeightImageView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public DynamicHeightImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public DynamicHeightImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        final TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.DynamicHeightImageView, defStyle, 0);
        assert a != null;
        mRadio = a.getFloat(R.styleable.DynamicHeightImageView_aspectRatio, 0);
        a.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int newHeightMeasureSpec = heightMeasureSpec;
        if (mRadio > 0) {
            int newHeight = Math.round(MeasureSpec.getSize(widthMeasureSpec) / mRadio);
            newHeightMeasureSpec = MeasureSpec.makeMeasureSpec(newHeight, MeasureSpec.EXACTLY);
        }
        super.onMeasure(widthMeasureSpec, newHeightMeasureSpec);
    }
}
