package cn.autotextview.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.TextView;

/**
 * Created by cloudist on 2017/6/19.
 */

public class AutoFitTextView extends TextView {

    OnFitSizeListener onFitSizeListener;

    public AutoFitTextView(Context context) {
        super(context);
        setMaxLines(1);
        getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public AutoFitTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setMaxLines(1);
        getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public AutoFitTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setMaxLines(1);
        getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
    }


    ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
        @Override
        public void onGlobalLayout() {
            //测量字符串的长度
            String measureText = String.valueOf(getText());
            float measureWidth = getPaint().measureText(measureText);
            //得到TextView 的宽度
            int width = getWidth() - getPaddingLeft() - getPaddingRight();
            //当前size大小
            float textSize = getTextSize();
            int length = String.valueOf(getText()).length();
            if (width < measureWidth) {
                textSize = (width / measureWidth) * textSize;
                length = (int) ((width / measureWidth) * length);
                measureText = measureText.substring(0, length);
            }
            if (onFitSizeListener != null) {
                onFitSizeListener.setTextSize(AutoFitTextView.this, textSize, measureText);
            }
            //注意，使用像素大小设置
            //setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
        }
    };

    public interface OnFitSizeListener {
        void setTextSize(AutoFitTextView autoFitTextView, float fitSize, String fitText);
    }

    public void setOnFitSizeListener(OnFitSizeListener onFitSizeListener) {
        this.onFitSizeListener = onFitSizeListener;
    }
}
