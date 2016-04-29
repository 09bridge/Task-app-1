package internship.yalantis.task_app_1;

import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Toast;

public class TaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        //Find a screen width for image resize
        DisplayMetrics displayMetrics = new DisplayMetrics ();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int dpWidth  = displayMetrics.widthPixels;
        int correction = Math.round(getResources().getDimension(R.dimen.padding_horizontal));
        int imageNewSize = dpWidth/2 - (3 * correction / 2);

        Resources mLinks = getResources();
        String[] mDataSet = mLinks.getStringArray(R.array.links);

        RecyclerView imageRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        imageRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager imageLayoutManager = new LinearLayoutManager(this, 0, false);
        imageRecyclerView.setLayoutManager(imageLayoutManager);

        RecyclerView.Adapter imageAdapter = new ImageAdapter(mDataSet, imageNewSize);
        imageRecyclerView.setAdapter(imageAdapter);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setTitleTextColor(Color.WHITE);
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                TaskActivity.this.finish();
            }
        });

    }

    public void onClickView(View view) {
        String viewName = view.getClass().getSimpleName();
        Toast infoToast = Toast.makeText(getApplicationContext(), viewName, Toast.LENGTH_SHORT);
        infoToast.show();
    }
}
