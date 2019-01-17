package mvvmdemo.dankim.com.mvvmdemo.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import mvvmdemo.dankim.com.mvvmdemo.R;

public class DetailedActivity extends AppCompatActivity {

    public static final String EXTRA_IMAGE_URL = "EXTRA_IMAGE_URL";
    public static final String EXTRA_IMAGE_NAME = "EXTRA_IMAGE_NAME";

    private ImageView ivImageView;
    private TextView tvImageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_actvity);
        ivImageView = findViewById(R.id.iv_image);
        tvImageName = findViewById(R.id.tv_image_name);

        if (getIntent() != null && getIntent().hasExtra(EXTRA_IMAGE_NAME) && getIntent().hasExtra(EXTRA_IMAGE_URL)){

            String imageUrl = getIntent().getStringExtra(EXTRA_IMAGE_URL);
            String imageName = getIntent().getStringExtra(EXTRA_IMAGE_NAME);

            Glide.with(this)
                    .asBitmap()
                    .load(imageUrl)
                    .into(ivImageView);

            tvImageName.setText(imageName);
        }
    }
}
