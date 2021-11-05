package ir.touo.myapplication14;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.viewholder> {

    Context context;
    List<User> userList;
    QueryEvent queryEvent;

    public UserAdapter(Context context, List<User> userList, QueryEvent queryEvent) {
        this.context = context;
        this.userList = userList;
        this.queryEvent = queryEvent;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_item,parent,false);

        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, @SuppressLint("RecyclerView") int position) {
        User user = userList.get(position);
        holder.name.setText(user.getFirstName());
        holder.lastname.setText(user.getLastName());
        /**
         *  */
        //   برای حذف کردن
        holder.parent.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                userList.remove(user);
                queryEvent.onDeleteUser(user , position);
               // Toast.makeText(context,"hasan",Toast.LENGTH_SHORT).show();

                return false;
            }
        });

    }


    @Override
    public int getItemCount() { return userList.size(); }

    //   mm   برا حذف      mm
    public interface QueryEvent{ void onDeleteUser(User user , int position);}

    public class viewholder extends RecyclerView.ViewHolder {

        TextView name,lastname;
        LinearLayout parent;

        public viewholder(@NonNull View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.first_name_user_item);
            lastname = itemView.findViewById(R.id.last_name_user_item);
            parent = itemView.findViewById(R.id.parent);
        }

    }

}
