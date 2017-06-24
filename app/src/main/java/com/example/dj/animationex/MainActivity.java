package com.example.dj.animationex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private String [] mAnimationName = {"None","Bounce","Clockwise","Fade","Move","Slide","ZoomIn","Blink"};
    private Spinner mSpinner;
    private ImageView mImageView;
    private HashMap<String, Integer> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSpinner();

        setImage();

        createHashmap();
    }

    private void createHashmap() {
        map = new HashMap<>();
        map.put(mAnimationName[0],R.anim.none);
        map.put(mAnimationName[1],R.anim.bounce);
        map.put(mAnimationName[2],R.anim.clockwise);
        map.put(mAnimationName[3],R.anim.fade);
        map.put(mAnimationName[4],R.anim.move);
        map.put(mAnimationName[5],R.anim.slide);
        map.put(mAnimationName[6],R.anim.zoomin);
        map.put(mAnimationName[7],R.anim.blink);
    }

    private void setImage() {
        mImageView = (ImageView) findViewById(R.id.imageView);
    }

    private void setSpinner() {
        mSpinner = (Spinner) findViewById(R.id.spinner);

        mSpinner.setOnItemSelectedListener(this);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item, mAnimationName);

        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        mSpinner.setAdapter(aa);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Log.d("item number",i+"");
        Animation animation = AnimationUtils.loadAnimation(this,map.get(mAnimationName[i]));
        mImageView.startAnimation(animation);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
