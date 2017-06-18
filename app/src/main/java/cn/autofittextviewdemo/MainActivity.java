package cn.autofittextviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.widget.EditText;

import cn.autotextview.view.AutoFitTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText text = (EditText) findViewById(R.id.edit_query);
        final AutoFitTextView fitTextView = (AutoFitTextView) findViewById(R.id.autofittextview);
        fitTextView.setOnFitSizeListener(new AutoFitTextView.OnFitSizeListener() {
            @Override
            public void setTextSize(AutoFitTextView autoFitTextView, float fitSize, String fitText) {
                //autoFitTextView.setText(fitText);
                autoFitTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, fitSize);
            }
        });

        text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                fitTextView.setText(text.getText().toString());
            }
        });
    }
}
