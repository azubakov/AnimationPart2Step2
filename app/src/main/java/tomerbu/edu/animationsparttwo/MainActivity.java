package tomerbu.edu.animationsparttwo;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Animator cloud1Animator;
    private Animator cloud2Animator;
    private Animator cloud3Animator;
    private Animator cloud4Animator;

    private ImageView ivCloud1;
    private ImageView ivCloud2;
    private ImageView ivCloud3;
    private ImageView ivCloud4;
    private RelativeLayout layout;

    //1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }


    private void findViews() {
        ivCloud1 = (ImageView) findViewById(R.id.ivCloud1);
        ivCloud2 = (ImageView) findViewById(R.id.ivCloud2);
        ivCloud3 = (ImageView) findViewById(R.id.ivCloud3);
        ivCloud4 = (ImageView) findViewById(R.id.ivCloud4);
        layout = (RelativeLayout) findViewById(R.id.layout);
    }

    private void animateClouds(View... cloudViews) {
        Random rand = new Random();
        for (View cloudView : cloudViews) {

            int layoutWidth = layout.getWidth();
            int cloudWidth = cloudView.getWidth();

            float startCloudPosition = 0 - cloudWidth;
            float finalCloudPosition = layoutWidth + cloudWidth;


            ObjectAnimator cloudAnimator = ObjectAnimator.ofFloat(cloudView, "X", startCloudPosition, finalCloudPosition);
            cloudAnimator.setRepeatCount(ObjectAnimator.INFINITE);
            cloudAnimator.setRepeatMode(ValueAnimator.RESTART);
            cloudAnimator.setDuration(6000 + rand.nextInt(3000));
            cloudAnimator.setStartDelay(rand.nextInt(2000));
            cloudAnimator.start();

        }
    }


    //3)
    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        ivCloud1.setX( 0 - ivCloud1.getWidth());
        ivCloud2.setX( 0 - ivCloud2.getWidth());
        ivCloud3.setX( 0 - ivCloud3.getWidth());
        ivCloud4.setX( 0 - ivCloud4.getWidth());

        animateClouds(ivCloud1, ivCloud2, ivCloud3, ivCloud4);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
