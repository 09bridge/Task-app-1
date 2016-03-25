package internship.yalantis.task_app_1;

import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    String [] dataSet;
    ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataSet = new String[]{
                "http://i.dailymail.co.uk/i/pix/2014/04/11/article-2602528-1D06B2D200000578-424_634x471.jpg",
                "http://memesvault.com/wp-content/uploads/Sad-Cat-Meme-04.jpg",
                "https://s-media-cache-ak0.pinimg.com/736x/bf/fd/0e/bffd0e24f35c7e61f0b8bc022b94a213.jpg",
                "http://raisinghappykittens.com/wp-content/uploads/2015/04/sad_cat.jpg",
                "http://www.she-kicks-she-throws.com/wp-content/uploads/sad-cat-fi-720x340.jpg",
                "http://vignette1.wikia.nocookie.net/steven-universe/images/8/8a/Sad-cat.jpg/revision/latest?cb=20150827161123"
        };

        backButton = (ImageButton) findViewById(R.id.backButton);

        RecyclerView imageRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        imageRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, 0, false);
        imageRecyclerView.setLayoutManager(mLayoutManager);

        RecyclerView.Adapter mAdapter = new MyAdapter(dataSet);
        imageRecyclerView.setAdapter(mAdapter);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

    }

    public void closeApp(View v) {
        this.finish();
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
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ImageViewHolder> {
        private String [] mDataSet;
        public class ImageViewHolder extends RecyclerView.ViewHolder {
            ImageView imageViewIcon;
            public ImageViewHolder(View itemView) {
                super(itemView);
                imageViewIcon = (ImageView) itemView.findViewById(R.id.recycler_image_item);
            }
        }
        public MyAdapter(String [] mDataSet) {
            this.mDataSet = mDataSet;
        }

        @Override
        public ImageViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recycler_image_item, parent, false);
            // set the view's size, margins, paddings and layout parameters

            ImageViewHolder vh = new ImageViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(ImageViewHolder holder, int position) {

            Uri imageUri = Uri.parse(mDataSet[position]);
            Context context = holder.imageViewIcon.getContext();

            Picasso.with(context).load(imageUri).into(holder.imageViewIcon);



        }

        @Override
        public int getItemCount() {
            return mDataSet.length;
        }

    }
}
