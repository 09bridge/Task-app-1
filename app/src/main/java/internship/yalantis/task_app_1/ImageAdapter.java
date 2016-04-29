package internship.yalantis.task_app_1;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    private String[] mDataSet;
    private int mImageSize;

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewIcon;

        public ImageViewHolder(View itemView) {
            super(itemView);
            imageViewIcon = (ImageView) itemView.findViewById(R.id.recycler_image_item);
        }
    }

    public ImageAdapter(String[] mDataSet, int mImageSize) {
        this.mDataSet = mDataSet;
        this.mImageSize = mImageSize;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent,
                                              int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_image_item, parent, false);

        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {



        Uri imageUri = Uri.parse(mDataSet[position]);
        Context context = holder.imageViewIcon.getContext();

        Picasso.with(context)
                .load(imageUri)
                .resize(mImageSize , mImageSize)
                .centerCrop()
                .into(holder.imageViewIcon);

    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }

}
