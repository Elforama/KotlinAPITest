package com.example.lawrencemuller.kotlinapitest.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

import com.example.lawrencemuller.kotlinapitest.R;

/**
 * Created by Jonathan Muller on 9/22/16.
 */

public class ReversibleAnimatedVector extends ImageView {

    private static final String TAG = "ReversibleAnimatedVector";

    AnimatedVectorDrawable firstAnimatedImage;
    AnimatedVectorDrawable secondAnimatedImage;

    boolean isFirstState = true;

    public ReversibleAnimatedVector(Context context) {
        super(context);
    }

    public ReversibleAnimatedVector(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ReversibleAnimatedVector(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.ReversibleAnimatedVector, 0, 0);

        try {
            int firstImageId = typedArray.getResourceId(R.styleable.ReversibleAnimatedVector_firstStateAnimatedVector, 0);
            int secondImageId = typedArray.getResourceId(R.styleable.ReversibleAnimatedVector_secondStateAnimatedVector, 0);

            if (firstImageId == 0|| secondImageId == 0)
                return;
            else {
                firstAnimatedImage = (AnimatedVectorDrawable) context.getDrawable(firstImageId);
                secondAnimatedImage = (AnimatedVectorDrawable) context.getDrawable(secondImageId);

                setImageDrawable(firstAnimatedImage);
            }

        } finally {
            Log.d(TAG, "First or second vector resource is invalid");
        }
    }

    public void animateToSecondState() {
        Log.d(TAG, "animateToSecondState: ");
        setImageDrawable(firstAnimatedImage);
        firstAnimatedImage.start();

        isFirstState = false;
    }

    public void animateToFirstState() {
        Log.d(TAG, "animateToFirstState: ");
        setImageDrawable(secondAnimatedImage);
        secondAnimatedImage.start();

        isFirstState = true;
    }

    public void animateToNextState() {
//        firstAnimatedImage.stop();
//        firstAnimatedImage.reset();
//
//        secondAnimatedImage.stop();
//        secondAnimatedImage.reset();

        if (isFirstState)
            animateToSecondState();
        else
            animateToFirstState();
    }

    public void setFirstStateImage(AnimatedVectorDrawable firstAnimatedImage) {
        this.firstAnimatedImage = firstAnimatedImage;
    }

    public void setSecondStateImage(AnimatedVectorDrawable secondAnimatedImage) {
        this.secondAnimatedImage = secondAnimatedImage;
    }
}
