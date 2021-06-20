package com.konstantin_romashenko.fisherhandbook;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.content.Intent;
import android.graphics.Typeface;
import android.widget.TextView;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Text_Content_Activity extends AppCompatActivity
{
    private TextView text_content;
    private Typeface face1;
    private ImageView image_content;
    private int category;
    private int position;
    private int[] array_fish = {R.string.content_fish_1,
                                R.string.content_fish_2,
                                R.string.content_fish_3,
                                R.string.content_fish_4,
                                R.string.content_fish_5};
    private int[] array_bait = {R.string.content_bait_1,
                                R.string.content_bait_2,
                                R.string.content_bait_3,
                                R.string.content_bait_4};
    private int[] array_tackle = {R.string.content_tackle_1,
                                  R.string.content_tackle_2,
                                  R.string.content_tackle_3,
                                  R.string.content_tackle_4};
    private int[] array_lure = {R.string.content_lure_1,
                                R.string.content_lure_2,
                                R.string.content_lure_3};
    private int[] array_stories = {R.string.content_stories_1,
                                   R.string.content_stories_2,
                                   R.string.content_stories_3};
    private int[] array_advices = {R.string.content_advices_1,
                                   R.string.content_advices_2,
                                   R.string.content_advices_3};

    private int[] array_image_fish = {R.drawable.fish_karp,
                                    R.drawable.fish_shuka,
                                    R.drawable.fish_som,
                                    R.drawable.fish_osetr,
                                    R.drawable.fish_nalim};
    private int[] array_image_bait = {R.drawable.bait_worm,
                                    R.drawable.bait_bread,
                                    R.drawable.bait_corn,
                                    R.drawable.bait_rice};
    private int[] array_image_tackle = {R.drawable.tackle_gruzilo,
                                        R.drawable.tackle_kruchok,
                                        R.drawable.tackle_leska,
                                        R.drawable.tackle_blesna};
    private int[] array_image_lure = {R.drawable.lure_bread,
                                    R.drawable.lure_corn,
                                    R.drawable.lure_rice};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);
        init();
        recieveIntent();

    }

    private void recieveIntent()
    {
        Intent i = getIntent();
        if(i != null)
        {
            category = i.getIntExtra("category", 0);
            position = i.getIntExtra("position", 0);
        }
        switch(category)
        {
            case 0:
                text_content.setText(array_fish[position]);
                image_content.setImageResource(array_image_fish[position]);
                break;
            case 1:
                text_content.setText(array_bait[position]);
                image_content.setImageResource(array_image_bait[position]);
                break;
            case 2:
                text_content.setText(array_tackle[position]);
                image_content.setImageResource(array_image_tackle[position]);
                break;
            case 3:
                text_content.setText(array_lure[position]);
                image_content.setImageResource(array_image_lure[position]);
                break;
            case 4:
                text_content.setText(array_stories[position]);
                break;
            case 5:
                text_content.setText(array_advices[position]);
                break;
        }
    }

    private void init()
    {
        text_content = findViewById(R.id.textView);
        image_content = findViewById(R.id.image_content);
        face1 = Typeface.createFromAsset(this.getAssets(), "Fonts/FiraSansExtraCondensed-Regular.ttf");
        text_content.setTypeface(face1);
    }
}
