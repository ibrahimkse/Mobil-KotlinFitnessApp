package com.example.fitness

import android.content.Context
import android.text.Layout
import android.text.method.ScrollingMovementMethod
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_blank.*
import kotlinx.android.synthetic.main.recycler_row1.view.*

class ListeRecyclerAdapter(val dateList: ArrayList<String>, val idList: ArrayList<Int>) : RecyclerView.Adapter<ListeRecyclerAdapter.WorkoutHolder>(){
    class WorkoutHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recycler_row1,parent, false)
        return WorkoutHolder(view)
    }

    override fun onBindViewHolder(holder: WorkoutHolder, position: Int) {
        holder.itemView.recyclerViewTextView1.text = dateList[position]
        holder.itemView.setOnClickListener{
            val comingId = idList[position]
            try {
                holder.itemView.context?.let {
                    val db = it.openOrCreateDatabase("WORKOUT", Context.MODE_PRIVATE, null)
                    val cursor1 = db.rawQuery("SELECT * FROM workout WHERE id = ?", arrayOf(comingId.toString()))
                    val idColumnIndex = cursor1.getColumnIndex("id")
                    val nameColumnIndex = cursor1.getColumnIndex("name")
                    val dateColumnIndex = cursor1.getColumnIndex("date")
                    val detailsColumnIndex = cursor1.getColumnIndex("details")
                    while (cursor1.moveToNext()){
                        holder.itemView.recyclerViewTextView1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16.toFloat())
                        holder.itemView.recyclerViewTextView1.movementMethod = ScrollingMovementMethod()
                        holder.itemView.recyclerViewTextView1.text = cursor1.getString(dateColumnIndex) +": "+  cursor1.getString(detailsColumnIndex)
                    }
                }
            } catch (e:Exception){
                e.printStackTrace()
            }

        }
    }

    override fun getItemCount(): Int {
        return dateList.size
    }
}