package com.epam.androidlab.task3;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ButtonsFragment extends android.support.v4.app.Fragment implements View.OnClickListener {

    @BindView(R.id.btn_1) Button btn1;
    @BindView(R.id.btn_2) Button btn2;
    @BindView(R.id.btn_3) Button btn3;

    private int btnColor1;
    private int btnColor2;
    private int btnColor3;
    private static final String BTN1_COLOR_VALUE = "BTN1_COLOR_VALUE";
    private static final String BTN2_COLOR_VALUE = "BTN2_COLOR_VALUE";
    private static final String BTN3_COLOR_VALUE = "BTN3_COLOR_VALUE";
    private Random random;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.buttons_fragment, container, false);


        ButterKnife.bind(this, view);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);


        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null) {


            if (savedInstanceState.getInt(BTN1_COLOR_VALUE) != 0) {
                btnColor1 = savedInstanceState.getInt(BTN1_COLOR_VALUE);
                btn1.setBackgroundColor(btnColor1);
            } else btn1.setBackgroundColor(ContextCompat.getColor( getContext()  , R.color.colorDefault));


            if (savedInstanceState.getInt(BTN2_COLOR_VALUE) != 0) {
                btnColor2 = savedInstanceState.getInt(BTN2_COLOR_VALUE);
                btn2.setBackgroundColor(btnColor2);
            } else btn2.setBackgroundColor(ContextCompat.getColor( getContext()  , R.color.colorDefault));


            if (savedInstanceState.getInt(BTN3_COLOR_VALUE) != 0) {
                btnColor3 = savedInstanceState.getInt(BTN3_COLOR_VALUE);
                btn3.setBackgroundColor(btnColor3);
            } else btn3.setBackgroundColor(ContextCompat.getColor( getContext()  , R.color.colorDefault));

        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(BTN1_COLOR_VALUE, btnColor1);
        outState.putInt(BTN2_COLOR_VALUE, btnColor2);
        outState.putInt(BTN3_COLOR_VALUE, btnColor3);
    }


    public int getRandomColor() {

        random = new Random();
        int colorValue;
        int randValue = (random.nextInt(10)) + 1;

        switch (randValue) {

            case 1:
                colorValue = R.color.colorAmethyst;
                break;
            case 2:
                colorValue = R.color.colorAmazonite;
                break;
            case 3:
                colorValue = R.color.colorAqua;
                break;
            case 4:
                colorValue = R.color.colorAzure;
                break;
            case 5:
                colorValue = R.color.colorLime;
                break;
            case 6:
                colorValue = R.color.colorBrightGreen;
                break;
            case 7:
                colorValue = R.color.colorClaret;
                break;
            case 8:
                colorValue = R.color.colorCorn;
                break;
            case 9:
                colorValue = R.color.colorDesert;
                break;
            case 10:
                colorValue = R.color.colorDrab;
                break;

            default:
                colorValue = 1;
        }
        return colorValue;
    }

    public void setRandomColor(View view) {

        view.setBackgroundColor(getResources().getColor(getRandomColor()));
        int viewId = view.getId();
        switch (viewId) {
            case R.id.btn_1:
                btnColor1 = ((ColorDrawable) btn1.getBackground()).getColor();
                break;
            case R.id.btn_2:
                btnColor2 = ((ColorDrawable) btn2.getBackground()).getColor();
                break;
            case R.id.btn_3:
                btnColor3 = ((ColorDrawable) btn3.getBackground()).getColor();
                break;
        }

    }


    @OnClick
    public void onClick(View view) {
        setRandomColor(view);

    }
}
