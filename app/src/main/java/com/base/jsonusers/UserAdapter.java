package com.base.jsonusers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<UserEntity> userEntityList;
    public void setUsers(List<UserEntity> users) {
        this.userEntityList = users;
        notifyDataSetChanged();
    }
    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_users, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        if (userEntityList != null) {
            UserEntity currentUser = userEntityList.get(position);
            holder.name.setText(currentUser.getName());
            holder.city.setText(currentUser.getCity());
            holder.latitude.setText(currentUser.getLatitude());
            holder.longitude.setText(currentUser.getLongitude());
            holder.companyName.setText(currentUser.getCompanyName());
        }
    }

    @Override
    public int getItemCount() {
        return userEntityList != null ?
                userEntityList.size()
                :
                0;
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        private TextView name, city, latitude, longitude, companyName;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            city = itemView.findViewById(R.id.tv_city);
            latitude = itemView.findViewById(R.id.tv_latitude);
            longitude = itemView.findViewById(R.id.tv_longitude);
            companyName = itemView.findViewById(R.id.tv_companyname);
        }
    }
}
