package com.example.fitness

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_row.view.*

class RecyclerAdapter(val workoutList: ArrayList<String>, val drawableList: ArrayList<Int>) : RecyclerView.Adapter<RecyclerAdapter.WorkoutVH>() {
    class WorkoutVH(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutVH {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row,parent,false)
        return WorkoutVH(itemView)

    }

    override fun onBindViewHolder(holder: WorkoutVH, position: Int) {
        holder.itemView.recyclerViewTextView.text = workoutList.get(position)
        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context,MainActivity2::class.java)
            intent.putExtra("workoutName",workoutList.get(position))
            intent.putExtra("workoutImage",drawableList.get(position))
            holder.itemView.context.startActivity(intent)
        }
    }


    override fun getItemCount(): Int {
        return workoutList.size
    }

}