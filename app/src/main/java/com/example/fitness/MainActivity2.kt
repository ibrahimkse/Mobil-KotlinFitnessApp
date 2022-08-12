package com.example.fitness

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    lateinit var currentWorkoutName : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val intent = intent
        currentWorkoutName = intent.getStringExtra("workoutName").toString()
        val currentWorkoutImage = intent.getIntExtra("workoutImage",0)
        val bitmap = BitmapFactory.decodeResource(applicationContext.resources,currentWorkoutImage)
        imageView2.setImageBitmap(bitmap)
        textView.text = currentWorkoutName


    }

    fun newEntry(view:View){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val entryFragment = BlankFragment()

        val bundle = Bundle()
        bundle.putString("name", currentWorkoutName)
        entryFragment.arguments = bundle


        fragmentTransaction.replace(R.id.frameLayout, entryFragment).commit()
    }

    fun showData(view: View){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val historyFragment = HistoryFragment()

        val bundle = Bundle()
        bundle.putString("name", currentWorkoutName)
        historyFragment.arguments = bundle

        fragmentTransaction.replace(R.id.frameLayout, historyFragment).commit()
    }

}