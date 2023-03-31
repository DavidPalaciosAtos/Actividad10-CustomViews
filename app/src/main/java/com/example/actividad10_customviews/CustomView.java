package com.example.actividad10_customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.example.actividad10_customviews.databinding.CustomViewBinding;

public class CustomView extends LinearLayout {

    private CustomViewBinding binding;

    public CustomView(Context context) {
        super(context);
        init(context, null);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, @Nullable AttributeSet attrs){

        binding = CustomViewBinding.inflate(LayoutInflater.from(context), this, true);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomView);

        try {
            binding.editText.setHint(typedArray.getString(R.styleable.CustomView_hint));

            binding.editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    if (binding.editText.getText().length() > 9){
                        binding.text.setText("No puede tener mas de 9 caracteres");
                        binding.text.setVisibility(VISIBLE);
                    }
                    else{
                        binding.text.setVisibility(GONE);
                    }
                }
            });

        }
        finally {
            typedArray.recycle();
        }
    }

    public void setHint(String text) {
        binding.text.setText(text);
    }

    public void setError(String error) {
        if (error != null && !error.isEmpty()) {
            binding.text.setText(error);
            binding.text.setVisibility(VISIBLE);
        } else {
            binding.text.setVisibility(GONE);
        }
    }

}
