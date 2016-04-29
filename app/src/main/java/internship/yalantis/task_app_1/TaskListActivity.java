package internship.yalantis.task_app_1;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;

public class TaskListActivity extends AppCompatActivity {

    static final int PAGE_COUNT = 3;

    ViewPager mPager;
    PagerAdapter mPagerAdapter;

    TaskApp app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setTitleTextColor(Color.WHITE);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new TaskFragmentPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(mPager);

        initDataInProgress();

        Log.d("mDataSet_1: ", app.mTasksInProgress.toString());

    }

    private void initDataInProgress() {
        app = (TaskApp) getApplication();
        app.mTasksInProgress = new ArrayList<>();
        app.mTasksInProgress.add(new TaskData(getString(R.string.task_category_0),
                        getString(R.string.task_address),
                        getString(R.string.task_date_0),
                        getString(R.string.task_deadline_0),
                        getString(R.string.task_description),
                        getString(R.string.like_count),
                        R.drawable.ic_file_document_grey600_24dp));
        app.mTasksInProgress.add(new TaskData(getString(R.string.task_category_1),
                getString(R.string.task_address),
                getString(R.string.task_date_0),
                getString(R.string.task_deadline_0),
                getString(R.string.task_description),
                getString(R.string.like_count),
                R.drawable.ic_money_off_black_24dp));
        app.mTasksInProgress.add(new TaskData(getString(R.string.task_category_2),
                getString(R.string.task_address),
                getString(R.string.task_date_0),
                getString(R.string.task_deadline_0),
                getString(R.string.task_description),
                getString(R.string.like_count),
                R.drawable.ic_money_off_black_24dp));
        app.mTasksInProgress.add(new TaskData(getString(R.string.task_category_3),
                getString(R.string.task_address),
                getString(R.string.task_date_0),
                getString(R.string.task_deadline_0),
                getString(R.string.task_description),
                getString(R.string.like_count),
                R.drawable.ic_trash));
    }

    private class TaskFragmentPagerAdapter extends FragmentPagerAdapter {

        public TaskFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return TaskListFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return "Title " + position;
        }

    }

}
