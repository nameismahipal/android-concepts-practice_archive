package www.androidcitizen.com.complexrecyclerview.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import www.androidcitizen.com.complexrecyclerview.archcomponents.room.entity.DateWithTasks;
import www.androidcitizen.com.complexrecyclerview.archcomponents.room.entity.Task;
import www.androidcitizen.com.complexrecyclerview.archcomponents.room.entity.TaskDate;
import www.androidcitizen.com.complexrecyclerview.archcomponents.room.entity.User;
import www.androidcitizen.com.complexrecyclerview.archcomponents.viewmodel.MainViewModel;
import www.androidcitizen.com.room.R;
import www.androidcitizen.com.complexrecyclerview.adapter.UserAdapter;
import www.androidcitizen.com.complexrecyclerview.repository.AppRepository;

public class MainActivity extends AppCompatActivity
        implements UserAdapter.ItemClickListener {

    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    public static final int UPDATE_WORD_ACTIVITY_REQUEST_CODE = 2;

    // Constant for date format
    private static final String DATE_FORMAT = "dd MMM, yyy";
    // TaskDate formatter
    private SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());


    AppRepository appRepository;
    UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        appRepository = new AppRepository(this);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        adapter = new UserAdapter(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddUserActivity.class);
                startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
            }
        });


        loadUI();

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Date date = new Date();
        String dateMY = dateFormat.format(date);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {

//            User user = new User(dateMY,
//                                 data.getStringExtra(AddUserActivity.EXTRA_REPLY_FIRSTNAME),
//                                 data.getStringExtra(AddUserActivity.EXTRA_REPLY_LASTNAME));

//            appRepository.insertUser(user);

            TaskDate date1 = new TaskDate(dateMY);
            Task task = new Task(data.getStringExtra(AddUserActivity.EXTRA_REPLY_FIRSTNAME) +
                                " " +
                               data.getStringExtra(AddUserActivity.EXTRA_REPLY_LASTNAME));
            appRepository.insertDateWithTasks(date1, task);

        }

        if (requestCode == UPDATE_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {

            String id = data.getStringExtra(AddUserActivity.EXTRA_UPDATE_ITEM_ID);

            User user = new User(
                    Integer.parseInt(id),
                    dateMY,
                    data.getStringExtra(AddUserActivity.EXTRA_REPLY_FIRSTNAME),
                    data.getStringExtra(AddUserActivity.EXTRA_REPLY_LASTNAME));

            appRepository.updateUser(user);
        }
    }

    void loadUI() {
        MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

//        viewModel.getUsers().observe(this, new Observer<List<User>>() {
//            @Override
//            public void onChanged(@Nullable List<User> users) {
//                adapter.loadData(users);
//            }
//        });

        viewModel.getDatesWithTasks().observe(this, new Observer<List<DateWithTasks>>() {
            @Override
            public void onChanged(@Nullable List<DateWithTasks> dateWithTasks) {
                adapter.loadDatesAndTasks(dateWithTasks);
            }
        });

    }

    @Override
    public void onItemClickListener(int id) {
        Intent intent = new Intent(MainActivity.this, AddUserActivity.class);
        intent.putExtra(AddUserActivity.EXTRA_UPDATE_ITEM_ID, id);
        startActivityForResult(intent, UPDATE_WORD_ACTIVITY_REQUEST_CODE);
    }
}
