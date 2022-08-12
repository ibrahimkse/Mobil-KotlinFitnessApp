package com.example.fitness

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_history.*

class HistoryFragment : Fragment() {
    private lateinit var listAdapter: ListeRecyclerAdapter

    lateinit var workoutName : String

    var dateList = ArrayList<String>()
    var idList = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_history, container, false)
        val data = arguments
        workoutName = data!!.get("name").toString()

        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listAdapter = ListeRecyclerAdapter(dateList, idList)
        recyclerView2.layoutManager = LinearLayoutManager(context)
        recyclerView2.adapter = listAdapter

        getData()
    }

    fun getData(){
        try {
            activity?.let {
                val dataBase = it.openOrCreateDatabase( "WORKOUT", Context.MODE_PRIVATE, null)

                val cursor = dataBase.rawQuery("SELECT * FROM workout WHERE name = '$workoutName'", null)
                val idColumnIndex = cursor.getColumnIndex("id")
                val nameColumnIndex = cursor.getColumnIndex("name")
                val dateColumnIndex = cursor.getColumnIndex("date")
                val detailsColumnIndex = cursor.getColumnIndex("details")

                dateList.clear()
                idList.clear()

                while (cursor.moveToNext()){
                    dateList.add(cursor.getString(dateColumnIndex))
                    idList.add(cursor.getInt(idColumnIndex))
                }
                listAdapter.notifyDataSetChanged()
                cursor.close()
            }


        } catch (e : Exception){

        }
    }
}