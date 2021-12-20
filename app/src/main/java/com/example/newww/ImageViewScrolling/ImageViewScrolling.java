package com.example.newww.ImageViewScrolling;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.newww.JackPot;
import com.example.newww.R;

public class ImageViewScrolling extends FrameLayout {

    private static int ANIMATION_DUR = 150;
    ImageView current_image , next_image;

    int last_result = 0 , old_value = 0;

    IEventEnd eventEnd ;
    public void setEventEnd(IEventEnd eventEnd) {
        this.eventEnd = eventEnd;
    }


    public ImageViewScrolling( Context context) {
        super(context);
        init(context);

    }

    public ImageViewScrolling(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.image_view_scrolling,this );
        current_image = (ImageView)getRootView().findViewById(R.id.current_image);
        next_image = (ImageView)getRootView().findViewById(R.id.next_image);
        next_image.setTranslationY(getHeight());



    }


    public void setValueRandom(int image, int rorate_count){
        current_image.animate().translationY(-getHeight()).setDuration(ANIMATION_DUR).start();
        next_image.setTranslationY(next_image.getHeight());
        next_image.animate().translationY(0).setDuration(ANIMATION_DUR).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                setImage(current_image,old_value%6);//bởi vì có 6 tắm , vì vậy chúng ta mod 6
                current_image.setTranslationY(0);
                if (old_value != rorate_count){
                    //neu gia tri cu van ko bang voi rotate count , van se roll
                    setValueRandom(image,rorate_count);
                    old_value++;
                }else {
                    last_result = 0;
                    old_value = 0;
                    setImage(next_image,image);
                    eventEnd.eventEnd(image%6,rorate_count);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }

    private void setImage(ImageView image_view, int value) {
        if (value == Util.BAR){
            image_view.setImageResource(R.drawable.bar_done);

        }else if (value == Util.SEVEN){
            image_view.setImageResource(R.drawable.sevent_done);

        } else if (value == Util.LEMON){
            image_view.setImageResource(R.drawable.lemon_done);

        }else if (value == Util.ORAGEN){
            image_view.setImageResource(R.drawable.bar_done);

        } else if (value == Util.TRIPLE){
            image_view.setImageResource(R.drawable.bar_done);

        } else {
            image_view.setImageResource(R.drawable.waternelon_done);

        }


        image_view.setTag(value);
        last_result = value;

    }
    public int getValue(){

        return Integer.parseInt(next_image.getTag().toString());
    }

}
