package www.androidcitizen.com.complexrecyclerview.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.support.design.widget.FloatingActionButton;

import www.androidcitizen.com.complexrecyclerview.archcomponents.room.entity.User;
import www.androidcitizen.com.room.R;
import www.androidcitizen.com.complexrecyclerview.archcomponents.viewmodel.AddUserViewModel;
import www.androidcitizen.com.complexrecyclerview.archcomponents.viewmodel.AddUserViewModelFactory;
import www.androidcitizen.com.complexrecyclerview.repository.AppRepository;

public class AddUserActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY_FIRSTNAME = "com.androidcitizen.www.userlistsql.REPLY.FIRST";
    public static final String EXTRA_REPLY_LASTNAME = "com.androidcitizen.www.userlistsql.REPLY.LAST";
    public static final String EXTRA_UPDATE_ITEM_ID = "extraUpdateItemId";

    private static final int DEFAULT_USER_ID = -1;
    private int mUserId = DEFAULT_USER_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_user);

        AppRepository appRepository = new AppRepository(this);

        final TextInputEditText firstName = findViewById(R.id.firstName);
        final TextInputEditText lastName  = findViewById(R.id.lastName);

        final FloatingActionButton button = findViewById(R.id.saveButton);

        Intent intent = getIntent();
        if(null !=intent && intent.hasExtra(EXTRA_UPDATE_ITEM_ID)) {

            if(mUserId == DEFAULT_USER_ID) {
                mUserId = intent.getIntExtra(EXTRA_UPDATE_ITEM_ID, DEFAULT_USER_ID);

                AddUserViewModelFactory factory = new AddUserViewModelFactory(appRepository, mUserId);
                final AddUserViewModel viewModel = ViewModelProviders.of(this, factory).get(AddUserViewModel.class);

                viewModel.getUser().observe(this, new Observer<User>() {
                    @Override
                    public void onChanged(@Nullable User userEntry) {
                        viewModel.getUser().removeObserver(this);

                        firstName.setText(userEntry.getName());
                        lastName.setText(userEntry.getLast_name());
                    }
                });
            }
        }

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();

                if(mUserId == DEFAULT_USER_ID) {
                    if (TextUtils.isEmpty(firstName.getText().toString())) {
                        setResult(RESULT_CANCELED, replyIntent);
                    } else {
                        String zfirstName = firstName.getText().toString();
                        String zlastName = lastName.getText().toString();

                        replyIntent.putExtra(EXTRA_REPLY_FIRSTNAME, zfirstName);
                        replyIntent.putExtra(EXTRA_REPLY_LASTNAME, zlastName);

                        setResult(RESULT_OK, replyIntent);
                    }
                } else {
                    String zfirstName = firstName.getText().toString();
                    String zlastName = lastName.getText().toString();

                    replyIntent.putExtra(EXTRA_UPDATE_ITEM_ID, Integer.toString(mUserId));
                    replyIntent.putExtra(EXTRA_REPLY_FIRSTNAME, zfirstName);
                    replyIntent.putExtra(EXTRA_REPLY_LASTNAME, zlastName);

                    setResult(RESULT_OK, replyIntent);
                }

                finish();
            }
        });
    }
}
