package com.example.mykotlinapp;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NonNls;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.FruitHolder>{

    Context context;
    List<MOdell> list = new ArrayList<>();

    public Adapter(Context context, List<MOdell> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public FruitHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view  = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);

        return new FruitHolder(view);
    }

    @Override
    public void onBindViewHolder(final FruitHolder holder, final int position) {

        final MOdell fruits = list.get(position);

        holder.tv_name.setText(fruits.getName());
        holder.tv_price.setText(fruits.getPrice());

        holder.checkBox.setChecked(fruits.isSelected());
        holder.checkBox.setTag(list.get(position));

        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = "";
                MOdell fruits1 = (MOdell)holder.checkBox.getTag();

                fruits1.setSelected(holder.checkBox.isChecked());

                list.get(position).setSelected(holder.checkBox.isChecked());

                for (int j=0; j<list.size();j++){

                    if (list.get(j).isSelected())
                        data = data + "\n" + list.get(j).getName().toString() + "   " + list.get(j).getPrice().toString();
                }

                Toast.makeText(context, "Selected Fruits : \n " + data, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class FruitHolder extends RecyclerView.ViewHolder{

        TextView tv_name,tv_price;
        CheckBox checkBox;

        public FruitHolder(View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_fruit_name);
            tv_price = itemView.findViewById(R.id.tv_fruit_price);
            checkBox = itemView.findViewById(R.id.checkBox_select);
        }
    }

    public List<MOdell> getFruitsList(){
        return list;
    }
}
