package com.ferbajoo.testthingskotlin.core.models;


import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;

import java.io.Serializable;

/**
 * Created by
 * feuribe on 28/06/2019.
 */

public class ClassModel implements Serializable {

    private String name;

    private String description;

    private int drawable;

    public ClassModel(String name, String description, int drawable) {
        this.name = name;
        this.description = description;
        this.drawable = drawable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    @BindingAdapter({"load_image"})
    public static void loadImage(ImageView view, int drawable) {
        view.setImageDrawable(ContextCompat.getDrawable(view.getContext(), drawable));
    }

}
