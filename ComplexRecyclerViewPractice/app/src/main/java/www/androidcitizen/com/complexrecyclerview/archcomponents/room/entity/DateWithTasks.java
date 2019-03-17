package www.androidcitizen.com.complexrecyclerview.archcomponents.room.entity;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

/**
 * Created by Mahi on 09/10/18.
 * www.androidcitizen.com
 */

public class DateWithTasks {

    @Embedded
    public TaskDate taskDate;

    @Relation(parentColumn = "id", entityColumn = "dateId", entity = Task.class)
    public List<Task> tasks;

    public List<Task> getTasks() {
        return tasks;
    }

    public String getDate() {
        return taskDate.getDate();
    }

    public int getTasksCount() {
        return tasks == null ? 0 : tasks.size();
    }
}
