package www.androidcitizen.com.complexrecyclerview.archcomponents.room.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Mahi on 09/10/18.
 * www.androidcitizen.com
 */

@Entity(indices = {@Index(value = {"date"}, unique = true)})
public class TaskDate {

    @PrimaryKey (autoGenerate = true)
    int id;

    String date;

    public TaskDate(int id, String date) {
        this.id = id;
        this.date = date;
    }

    @Ignore
    public TaskDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
