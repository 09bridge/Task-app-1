package internship.yalantis.task_app_1;

public class TaskData {
    private String mTaskCategory,
                   mTaskAddress,
                   mTaskDate,
                   mTaskDeadline,
                   mTaskDescription,
                   mLikeCount;
    private int mLogoId;

    public String getTaskCategory() {
        return mTaskCategory;
    }

    public void setTaskCategory(String mTaskCategory) {
        this.mTaskCategory = mTaskCategory;
    }

    public String getTaskAddress() {
        return mTaskAddress;
    }

    public void setTaskAddress(String mTaskAddress) {
        this.mTaskAddress = mTaskAddress;
    }

    public String getTaskDate() {
        return mTaskDate;
    }

    public void setTaskDate(String mTaskDate) {
        this.mTaskDate = mTaskDate;
    }

    public String getTaskDeadline() {
        return mTaskDeadline;
    }

    public void setTaskDeadline(String mTaskDeadline) {
        this.mTaskDeadline = mTaskDeadline;
    }

    public String getTaskDescription() {
        return mTaskDescription;
    }

    public void setTaskDescription(String mTaskDescription) {
        this.mTaskDescription = mTaskDescription;
    }

    public String getLikeCount() {
        return mLikeCount;
    }

    public void setLikeCount(String mLikeCount) {
        this.mLikeCount = mLikeCount;
    }

    public int getLogoId() {
        return mLogoId;
    }

    public void setLogoId(int mLogoId) {
        this.mLogoId = mLogoId;
    }

    public TaskData (String taskCategory, String taskAddress, String taskDate,
                            String taskDeadline, String taskDescription, String likeCount,
                            int logoId) {
        setTaskCategory(taskCategory);
        setTaskAddress(taskAddress);
        setTaskDate(taskDate);
        setTaskDeadline(taskDeadline);
        setTaskDescription(taskDescription);
        setLikeCount(likeCount);
        setLogoId(logoId);
    }
}
