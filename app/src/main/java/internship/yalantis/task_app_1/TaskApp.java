package internship.yalantis.task_app_1;

import android.app.Application;

import java.util.List;

public class TaskApp extends Application {
    List <TaskData> mTasksInProgress,
                    mTasksCompleted,
                    mTasksStandBy;

}
