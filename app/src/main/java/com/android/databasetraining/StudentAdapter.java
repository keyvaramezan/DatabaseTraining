package com.android.databasetraining;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentHolder> {

    List<String> myList;
    StudentAdapter (List<String> list){
        myList = list;
    }

    @NonNull
    @Override
    public StudentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.studnet_recycler_item,parent, false);
        StudentHolder holder = new StudentHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentHolder holder, int position) {
        //در این قسمت آیتمهای درون لیست به ترتیب درون ریسایکلر قرار می گیره
        String studentName = myList.get(position);
        holder.txtStudentName.setText(studentName);
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    class StudentHolder extends RecyclerView.ViewHolder{
        TextView txtStudentName;
        public StudentHolder(@NonNull View itemView) {
            super(itemView);
            txtStudentName = itemView.findViewById(R.id.txtStudentName);
        }
    }
}
