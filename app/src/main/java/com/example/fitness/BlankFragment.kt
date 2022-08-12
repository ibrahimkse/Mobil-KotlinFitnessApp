package com.example.fitness

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_blank.*
import java.lang.Exception


class BlankFragment : Fragment() {

    lateinit var workoutName : String
    //lateinit var but : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_blank, container, false)
        val data = arguments
        workoutName = data!!.get("name").toString()
        //but = v.findViewById(R.id.textView2)
        //but.text = workoutName
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button.setOnClickListener {
            saveButton(it)
        }


    }

    fun saveButton(view: View){
        val myDate = editTextdate.text.toString()
        val myDetails = editTextdetail.text.toString()
        val myWorkoutName = workoutName
        try {
            context?.let {
                val dataBase = it.openOrCreateDatabase("WORKOUT", Context.MODE_PRIVATE, null)
                dataBase.execSQL("CREATE TABLE IF NOT EXISTS workout (id INTEGER PRIMARY KEY, name VARCHAR, date VARCHAR, details VARCHAR)")

                val sqlString = "INSERT INTO workout (name, date, details) VALUES (?, ?, ?)"
                val statement = dataBase.compileStatement(sqlString)
                statement.bindString(1,myWorkoutName)
                statement.bindString(2,myDate)
                statement.bindString(3,myDetails)
                statement.execute()

                /*val cursor = dataBase.rawQuery("SELECT * FROM workout", null)
                val idColumnIndex = cursor.getColumnIndex("id")
                val nameColumnIndex = cursor.getColumnIndex("name")
                val dateColumnIndex = cursor.getColumnIndex("date")
                val detailsColumnIndex = cursor.getColumnIndex("details")
                while (cursor.moveToNext()){
                    println("id : ${cursor.getInt(idColumnIndex)}")
                    println("name : ${cursor.getString(nameColumnIndex)}")
                    println("date : ${cursor.getString(dateColumnIndex)}")
                    println("detail : ${cursor.getString(detailsColumnIndex)}")
                }
                cursor.close()*/
            }

        } catch (e : Exception){
            e.printStackTrace()
        }

    }

}