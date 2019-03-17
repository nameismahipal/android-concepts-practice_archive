package www.androidcitizen.com.complexrecyclerview.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import www.androidcitizen.com.complexrecyclerview.archcomponents.room.entity.DateWithTasks;
import www.androidcitizen.com.complexrecyclerview.archcomponents.room.entity.Task;
import www.androidcitizen.com.complexrecyclerview.archcomponents.room.entity.User;
import www.androidcitizen.com.room.R;

/**
 * Created by Mahi on 06/10/18.
 * www.androidcitizen.com
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

//    private List<User> users = null;

    private List<DateWithTasks> dateWithTasks = null;
    private List<Task> tasks = null;

    private ItemClickListener itemClickListener;

    public UserAdapter(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClickListener(int id);
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View rootView = LayoutInflater.from(viewGroup.getContext())
                                    .inflate(R.layout.recyclerview_item,
                                            viewGroup, false);

        return new UserViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, int position) {
        userViewHolder.onBind(position);
    }

    @Override
    public int getItemCount() {
//        if (null == users)
//            return 0;
//        else
//            return users.size();

        if(null == dateWithTasks) {
            return 0;
        } else {
            return dateWithTasks.size();
        }
    }

    class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name;
        TextView date;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            date = itemView.findViewById(R.id.date);
            itemView.setOnClickListener(this);
        }

        void onBind(int iIndex) {
//            date.setText(users.get(iIndex).getDate());
//            name.setText(users.get(iIndex).getName());

            date.setText(dateWithTasks.get(iIndex).getDate());
            name.setText(dateWithTasks.get(iIndex).getTasks().get(0).getTask());
        }

        @Override
        public void onClick(View v) {
            int itemPosition = getAdapterPosition();
//            int id = users.get(itemPosition).getUid();
//            itemClickListener.onItemClickListener(id);
        }
    }

    public void loadData(List<User> users) {
//        this.users = users;
//        notifyDataSetChanged();
    }

    public void loadDatesAndTasks(List<DateWithTasks> tasks) {
        this.dateWithTasks = tasks;
        notifyDataSetChanged();
    }


}
