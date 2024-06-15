package com.example.foodu_deliveryapp.OnboardingScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.foodu_deliveryapp.Main_Screen1;
import com.example.foodu_deliveryapp.R;
import com.example.foodu_deliveryapp.ViewpagerAdapter;

public class OnB_Layout extends AppCompatActivity {
    ViewPager mSlideViewPager;
    LinearLayout mDotLayout;

    Button backbtn, nextbtn, skipbtn;

    TextView[] dots;
    ViewpagerAdapter vViewpageradapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_blayout);
        backbtn = findViewById(R.id.backbutton);
        nextbtn = findViewById(R.id.nextbutton);
        skipbtn = findViewById(R.id.skipbutton);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getitem(0)>0){
                    mSlideViewPager.setCurrentItem(getitem(-1),true);
                }

            }
        });

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(getitem(0)<3){
                    mSlideViewPager.setCurrentItem(getitem(1),true);
                }else {
                    Intent i = new Intent(OnB_Layout.this, Main_Screen1.class);
                    startActivity(i);
                    finish();
                }
            }
        });

        skipbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(OnB_Layout.this,Main_Screen1.class);
                startActivity(i);
                finish();
            }
        });

        mSlideViewPager = (ViewPager) findViewById(R.id.viewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.indicator_layout);

        vViewpageradapter = new ViewpagerAdapter(this);
        mSlideViewPager.setAdapter(vViewpageradapter);
        Setupindicator(0);
        mSlideViewPager.addOnPageChangeListener(viewlistner);
    }

    public void Setupindicator(int position) {
        dots = new TextView[3];
        mDotLayout.removeAllViews();


        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.lightfaded, getApplicationContext().getTheme()));
            mDotLayout.addView(dots[i]);
        }
        dots[position].setTextColor(getResources().getColor(R.color.green, getApplicationContext().getTheme()));
    }

    ViewPager.OnPageChangeListener viewlistner = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            Setupindicator(position);
            if (position > 0) {
                backbtn.setVisibility(View.VISIBLE);
            } else {
                backbtn.setVisibility(View.INVISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged ( int state){

        }
    };

    public int getitem(int i) {

        return mSlideViewPager.getCurrentItem() + i;
    }
}
