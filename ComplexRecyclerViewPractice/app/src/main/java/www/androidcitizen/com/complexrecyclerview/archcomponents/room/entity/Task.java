package www.androidcitizen.com.complexrecyclerview.archcomponents.room.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Mahi on 09/10/18.
 * www.androidcitizen.com
 */

@Entity
public class Task {

    @PrimaryKey (autoGenerate = true)
    int id;

    long dateId;

    String task;

    public Task(int id, long dateId, String task) {
        this.id = id;
        this.dateId = dateId;
        this.task = task;
    }

    @Ignore
    public Task(long dateId, String task) {
        this.dateId = dateId;
        this.task = task;
    }

    @Ignore
    public Task(String task) {
        this.task = task;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getDateId() {
        return dateId;
    }

    public void setDateId(long dateId) {
        this.dateId = dateId;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
