package www.androidcitizen.com.complexrecyclerview.archcomponents.room.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;
import android.arch.persistence.room.Update;

import java.util.List;

import www.androidcitizen.com.complexrecyclerview.archcomponents.room.entity.DateWithTasks;
import www.androidcitizen.com.complexrecyclerview.archcomponents.room.entity.Task;
import www.androidcitizen.com.complexrecyclerview.archcomponents.room.entity.TaskDate;
import www.androidcitizen.com.complexrecyclerview.archcomponents.room.entity.User;

/**
 * Created by Mahi on 06/10/18.
 * www.androidcitizen.com
 */

@Dao
public abstract class UserDao {

    static long lastRowId = -2;

    @Insert
    public abstract void insertUser(User user);

    @Insert
    public abstract void insertUsers(List<User> users);

    @Delete
    public abstract void deleteUser(User user);

    @Query("DELETE FROM user_table")
    public abstract void deleteAll();

    @Query("SELECT * FROM user_table WHERE uid=:id")
    public abstract LiveData<User> getUserById(int id);

    @Query("SELECT * FROM user_table ORDER BY uid DESC")
    public abstract LiveData<List<User>> getAllUsers();

    @Update(onConflict = OnConflictStrategy.REPLACE)
    public abstract void updateUser(User user);

    // ************ Room - Relation ***************

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract long insertTaskDate(TaskDate date);
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract void insertTask(Task task);

    @Query("SELECT id FROM TaskDate WHERE date=:date")
    abstract long getIdBasedOnDate(String date);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract void updateTaskDate(TaskDate taskDate);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract void updateTask(Task task);

    @Transaction
    @Query("SELECT * FROM TaskDate WHERE date =:selectedDate")
    public abstract LiveData<DateWithTasks> getAllTasksforSpecificDate(String selectedDate);

    @Transaction
    @Query("SELECT * FROM TaskDate")
    public abstract LiveData<List<DateWithTasks>> getAllTasksForAllDates();

    @Query("SELECT * FROM Task")
    public abstract List<Task> getAllTasks();
    @Query("SELECT * FROM TaskDate")
    public abstract List<TaskDate> getAllTaskDates();

    @Transaction
    public void insertTaskswithDate(TaskDate date, Task task){
        long rowId = insertTaskDate(date);

        if(rowId >= 1) {
            lastRowId = rowId;
        } else {
            lastRowId = getIdBasedOnDate(date.getDate());
        }

        task.setDateId(lastRowId);
        insertTask(task);
    }

    @Transaction
    public void updateTaskswithDate(TaskDate date, Task task){
        task.setDateId(date.getId());
        updateTaskDate(date);
        updateTask(task);
    }

}
