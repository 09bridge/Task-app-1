package internship.yalantis.task_app_1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class TaskListFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAMETER_PAGE = "arg_page_num";

    private int mPageNum;
    private List <TaskData> mDataSet;

    public static TaskListFragment newInstance(int page) {
        TaskListFragment fragment = new TaskListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAMETER_PAGE, page);
        fragment.setArguments(args);
        return fragment;
    }

    public TaskListFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPageNum = getArguments().getInt(ARG_PARAMETER_PAGE);
        }

        //what is wrong???
        TaskApp app = (TaskApp) this.getActivity().getApplication();

        if (mPageNum == 0 || mPageNum == 1 || mPageNum == 2) {
            mDataSet = app.mTasksInProgress;
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task_list, container, false);





        RecyclerView taskRecycler = (RecyclerView)view.findViewById(R.id.task_recycler);
        taskRecycler.setHasFixedSize(true);

        RecyclerView.LayoutManager imageLayoutManager = new LinearLayoutManager(getActivity());
        taskRecycler.setLayoutManager(imageLayoutManager);

        RecyclerView.Adapter imageAdapter = new TaskAdapter(mDataSet);
        taskRecycler.setAdapter(imageAdapter);
        return view;
    }

}
