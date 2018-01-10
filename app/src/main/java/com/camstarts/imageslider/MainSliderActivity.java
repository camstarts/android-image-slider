package com.camstarts.imageslider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.camstarts.imageslider.library.animations.DescriptionAnimation;
import com.camstarts.imageslider.library.slidertypes.BaseSliderView;
import com.camstarts.imageslider.library.slidertypes.TextSliderView;
import com.camstarts.imageslider.library.tricks.ViewPagerEx;
import java.util.HashMap;

public class MainSliderActivity extends AppCompatActivity implements BaseSliderView.OnImageSliderClickListener,  ViewPagerEx.OnPageChangeListener {

    private ImageSliderLayout mDemoSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_slider);

        mDemoSlider = (ImageSliderLayout)findViewById(R.id.slider);

        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("Hannibal", "https://1.bp.blogspot.com/-FtQvUub1U7w/WVXojLlop0I/AAAAAAAALi0/4nWLINs3trojXaodYb5w0ZvJstTCnbzEwCLcBGAs/s1600/56.jpg");
        url_maps.put("Big Bang Theory", "https://3.bp.blogspot.com/-I52wbFiH8tI/WVXojBvzDjI/AAAAAAAALi8/FV4MYnSCSAIIDfz74TkOvgKKm7Mq9fdjACLcBGAs/s1600/57.jpg");
        url_maps.put("House of Cards", "https://2.bp.blogspot.com/-BVKuou9a_ro/WVXojPKdASI/AAAAAAAALi4/8rg0fc71iYogsNJhXAR9SmaijKdQX1mLQCLcBGAs/s1600/58.jpg");
        url_maps.put("Game of Thrones", "https://3.bp.blogspot.com/-sNI_geeaxiQ/WVXojyXtY2I/AAAAAAAALjA/kauYvxoNI7EdBamHxc6O8_tF3yYlbeP4wCLcBGAs/s1600/59.jpg");


        for(String name : url_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnImageSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(ImageSliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(ImageSliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);


    }



    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this,slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
