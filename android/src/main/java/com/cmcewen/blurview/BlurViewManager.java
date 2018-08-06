package com.cmcewen.blurview;

import android.view.View;
import android.widget.ProgressBar;

import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.github.mmin18.widget.RealtimeBlurView;


public class BlurViewManager extends SimpleViewManager<RealtimeBlurView> {
    public static final String REACT_CLASS = "BlurView";

    public static final int defaultRadius = 10;
    public static final int defaultSampling = 10;

    private static ThemedReactContext context;

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public RealtimeBlurView createViewInstance(ThemedReactContext ctx) {
        context = ctx;

//        BlurringView blurringView = new BlurringView(ctx);
//        blurringView.setBlurRadius(defaultRadius);
//        blurringView.setDownsampleFactor(defaultSampling);
        return new RealtimeBlurView(ctx);
    }

    @ReactProp(name = "blurRadius", defaultInt = defaultRadius)
    public void setRadius(RealtimeBlurView view, int radius) {
        view.setBlurRadius(radius);
        view.invalidate();
    }

    @ReactProp(name = "overlayColor", customType = "Color")
    public void setColor(RealtimeBlurView view, int color) {
        view.setOverlayColor(color);
        view.invalidate();
    }

    @ReactProp(name = "downsampleFactor", defaultInt = defaultSampling)
    public void setDownsampleFactor(RealtimeBlurView view, int factor) {
        view.setDownsampleFactor(factor);
    }

}
