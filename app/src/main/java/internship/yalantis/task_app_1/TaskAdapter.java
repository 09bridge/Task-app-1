package internship.yalantis.task_app_1;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private List<TaskData> mDataSet;

    public class TaskViewHolder extends RecyclerView.ViewHolder {
        CardView mTaskCard;
        TextView mTaskCategory,
                 mTaskAddress,
                 mTaskDate,
                 mTaskDeadline,
                 mLikeCount;
        ImageView mCategoryIcon;

        public TaskViewHolder(View itemView) {
            super(itemView);
            mTaskCard = (CardView) itemView.findViewById(R.id.card_view);
            mTaskCategory = (TextView) itemView.findViewById(R.id.taskCategory);
            mTaskAddress = (TextView) itemView.findViewById(R.id.taskAddress);
            mTaskDate = (TextView) itemView.findViewById(R.id.taskDate);
            mTaskDeadline = (TextView) itemView.findViewById(R.id.taskDeadline);
            mLikeCount = (TextView) itemView.findViewById(R.id.likeCount);
            mCategoryIcon = (ImageView) itemView.findViewById(R.id.categoryIcon);
        }
    }

    public TaskAdapter(List<TaskData> mDataSet) {
        this.mDataSet = mDataSet;
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent,
                                              int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_card_layout, parent, false);

        return new TaskViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        //set text and icon
        Log.d("mDataSet_2: ", mDataSet.get(position).getTaskCategory()
                + mDataSet.get(position).getTaskAddress() + mDataSet.get(position).getTaskDate());
        holder.mTaskCategory.setText(mDataSet.get(position).getTaskCategory());
        holder.mTaskAddress.setText(mDataSet.get(position).getTaskAddress());
        holder.mTaskDate.setText(mDataSet.get(position).getTaskDate());
        holder.mTaskDeadline.setText(mDataSet.get(position).getTaskDeadline());
        holder.mLikeCount.setText(mDataSet.get(position).getLikeCount());
        holder.mCategoryIcon.setImageResource(mDataSet.get(position).getLogoId());

    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
