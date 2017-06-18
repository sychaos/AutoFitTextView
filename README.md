# AutoFitTextView
可以自适应宽度的单行的textView
## 1.代码参考
    final AutoFitTextView fitTextView = (AutoFitTextView) findViewById(R.id.autofittextview);
    fitTextView.setOnFitSizeListener(new AutoFitTextView.OnFitSizeListener() {
        @Override
        public void setTextSize(AutoFitTextView autoFitTextView, float fitSize, String fitText) {
            //fitText返回的是当前textsize下正好的为一行的text
            //autoFitTextView.setText(fitText);

            //fitSize是当前text下正好为一行的textSize
            //autoFitTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, fitSize);
        }
    });
