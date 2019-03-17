package www.androidcitizen.com.complexrecyclerview.archcomponents.room.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by Mahi on 06/10/18.
 * www.androidcitizen.com
 */

@Entity (tableName = "user_table")
public class User {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    private String date;

    @ColumnInfo(name = "first_name")
    @NonNull
    private String name;

    private String last_name;

    @Ignore
    private String unused_variable;

    // Only 1 Constructor, Setters/Getters are required for Room.

    public User(int uid, String date, String name, String last_name) {
        this.uid = uid;
        this.date = date;
        this.name = name;
        this.last_name = last_name;
    }

    @Ignore
    public User(String date, String name, String last_name) {
        this.date = date;
        this.name = name;
        this.last_name = last_name;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
