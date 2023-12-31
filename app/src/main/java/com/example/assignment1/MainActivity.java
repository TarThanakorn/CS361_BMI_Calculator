package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DecimalFormat formatter = new DecimalFormat("#,###.##");
        EditText edit_text1 = findViewById(R.id.editText1);
        EditText edit_text2 = findViewById(R.id.editText2);
        TextView show_bmi = findViewById(R.id.show_bmi);
        TextView show_status = findViewById(R.id.show_status);
        ImageView image = findViewById(R.id.imageView);

        image.setImageResource(R.drawable.ws0);
        edit_text1.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(6, 2)});
        edit_text2.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(6, 2)});

        final Button calculate = findViewById(R.id.button);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!edit_text1.getText().toString().isEmpty() && !edit_text2.getText().toString().isEmpty() && Double.parseDouble(edit_text2.getText().toString()) > 0){
                    hideKeyboard();
                    Double bmiCal = Double.parseDouble(edit_text1.getText().toString())/(Double.parseDouble(edit_text2.getText().toString())/100 * Double.parseDouble(edit_text2.getText().toString())/100);
                    String bmiFormat = formatter.format(bmiCal);
                    String statusCal;
                    show_status.setTextColor(getResources().getColor(R.color.black));
                    if(bmiCal < 18.5){
                        statusCal = getString(R.string.ws1);
                        show_status.setBackgroundColor(getResources().getColor(R.color.ws1));
                        image.setImageResource(R.drawable.ws1);
                    }else if(bmiCal < 23) {
                        statusCal = getString(R.string.ws2);
                        show_status.setBackgroundColor(getResources().getColor(R.color.ws2));
                        image.setImageResource(R.drawable.ws2);
                    }else if(bmiCal < 25) {
                        statusCal = getString(R.string.ws3);
                        show_status.setBackgroundColor(getResources().getColor(R.color.ws3));
                        image.setImageResource(R.drawable.ws3);
                    }else if(bmiCal < 30) {
                        statusCal = getString(R.string.ws4);
                        show_status.setBackgroundColor(getResources().getColor(R.color.ws4));
                        image.setImageResource(R.drawable.ws4);
                    }else if(bmiCal >= 30) {
                        statusCal = getString(R.string.ws5);
                        show_status.setBackgroundColor(getResources().getColor(R.color.ws5));
                        image.setImageResource(R.drawable.ws5);
                    }else{
                        statusCal = getString(R.string.error);
                    }
                    show_bmi.setText(bmiFormat);
                    show_status.setText(statusCal);
                }
            }
        });

        edit_text1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getAction()==KeyEvent.ACTION_DOWN) {
                    if (i == KeyEvent.KEYCODE_ENTER) {
                        if (!edit_text1.getText().toString().isEmpty() && !edit_text2.getText().toString().isEmpty() && Double.parseDouble(edit_text2.getText().toString()) > 0) {
                            hideKeyboard();
                            Double bmiCal = Double.parseDouble(edit_text1.getText().toString()) / (Double.parseDouble(edit_text2.getText().toString()) / 100 * Double.parseDouble(edit_text2.getText().toString()) / 100);
                            String bmiFormat = formatter.format(bmiCal);
                            String statusCal;
                            show_status.setTextColor(getResources().getColor(R.color.black));
                            if (bmiCal < 18.5) {
                                statusCal = getString(R.string.ws1);
                                show_status.setBackgroundColor(getResources().getColor(R.color.ws1));
                                image.setImageResource(R.drawable.ws1);
                            } else if (bmiCal < 23) {
                                statusCal = getString(R.string.ws2);
                                show_status.setBackgroundColor(getResources().getColor(R.color.ws2));
                                image.setImageResource(R.drawable.ws2);
                            } else if (bmiCal < 25) {
                                statusCal = getString(R.string.ws3);
                                show_status.setBackgroundColor(getResources().getColor(R.color.ws3));
                                image.setImageResource(R.drawable.ws3);
                            } else if (bmiCal < 30) {
                                statusCal = getString(R.string.ws4);
                                show_status.setBackgroundColor(getResources().getColor(R.color.ws4));
                                image.setImageResource(R.drawable.ws4);
                            } else if (bmiCal >= 30) {
                                statusCal = getString(R.string.ws5);
                                show_status.setBackgroundColor(getResources().getColor(R.color.ws5));
                                image.setImageResource(R.drawable.ws5);
                            } else {
                                statusCal = getString(R.string.error);
                            }
                            show_bmi.setText(bmiFormat);
                            show_status.setText(statusCal);
                        }
                    }
                }
                return false;
            }
        });

        edit_text2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getAction()==KeyEvent.ACTION_DOWN) {
                    if (i == KeyEvent.KEYCODE_ENTER) {
                        if (!edit_text1.getText().toString().isEmpty() && !edit_text2.getText().toString().isEmpty() && Double.parseDouble(edit_text2.getText().toString()) > 0) {
                            hideKeyboard();
                            Double bmiCal = Double.parseDouble(edit_text1.getText().toString()) / (Double.parseDouble(edit_text2.getText().toString()) / 100 * Double.parseDouble(edit_text2.getText().toString()) / 100);
                            String bmiFormat = formatter.format(bmiCal);
                            String statusCal;
                            show_status.setTextColor(getResources().getColor(R.color.black));
                            if (bmiCal < 18.5) {
                                statusCal = getString(R.string.ws1);
                                show_status.setBackgroundColor(getResources().getColor(R.color.ws1));
                                image.setImageResource(R.drawable.ws1);
                            } else if (bmiCal < 23) {
                                statusCal = getString(R.string.ws2);
                                show_status.setBackgroundColor(getResources().getColor(R.color.ws2));
                                image.setImageResource(R.drawable.ws2);
                            } else if (bmiCal < 25) {
                                statusCal = getString(R.string.ws3);
                                show_status.setBackgroundColor(getResources().getColor(R.color.ws3));
                                image.setImageResource(R.drawable.ws3);
                            } else if (bmiCal < 30) {
                                statusCal = getString(R.string.ws4);
                                show_status.setBackgroundColor(getResources().getColor(R.color.ws4));
                                image.setImageResource(R.drawable.ws4);
                            } else if (bmiCal >= 30) {
                                statusCal = getString(R.string.ws5);
                                show_status.setBackgroundColor(getResources().getColor(R.color.ws5));
                                image.setImageResource(R.drawable.ws5);
                            } else {
                                statusCal = getString(R.string.error);
                            }
                            show_bmi.setText(bmiFormat);
                            show_status.setText(statusCal);
                        }
                    }
                }
                return false;
            }
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        final TextView title = findViewById(R.id.title);
        final TextView title2 = findViewById(R.id.title2);
        final TextView weight = findViewById(R.id.weight);
        final TextView height = findViewById(R.id.height);
        final TextView bmi = findViewById(R.id.bmi);
        final TextView status = findViewById(R.id.status);
        final EditText edit_text1 = findViewById(R.id.editText1);
        final EditText edit_text2 = findViewById(R.id.editText2);
        final TextView show_bmi = findViewById(R.id.show_bmi);
        final TextView show_status = findViewById(R.id.show_status);
        final Button button = findViewById(R.id.button);

        title.setTextSize(newConfig.fontScale*16);
        title2.setTextSize(newConfig.fontScale*16);
        weight.setTextSize(newConfig.fontScale*12);
        height.setTextSize(newConfig.fontScale*12);
        bmi.setTextSize(newConfig.fontScale*12);
        status.setTextSize(newConfig.fontScale*12);
        edit_text1.setTextSize(newConfig.fontScale*12);
        edit_text2.setTextSize(newConfig.fontScale*12);
        show_bmi.setTextSize(newConfig.fontScale*12);
        show_status.setTextSize(newConfig.fontScale*12);
        button.setTextSize(newConfig.fontScale*12);
    }

    private void hideKeyboard(){
        View view = getCurrentFocus(); // returns the view that has focus or null
        if (view != null) {
            InputMethodManager manager = (InputMethodManager) getSystemService( Context.INPUT_METHOD_SERVICE);
            manager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}

class DecimalDigitsInputFilter implements InputFilter {
    private final Pattern mPattern;
    DecimalDigitsInputFilter(int digits, int digitsAfterZero) {
        mPattern = Pattern.compile("[0-9]{0," + (digits - 1) + "}+((\\.[0-9]{0," + (digitsAfterZero - 1) +
                "})?)||(\\.)?");
    }
    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        Matcher matcher = mPattern.matcher(dest);
        if (!matcher.matches())
            return "";
        return null;
    }
}