package com.example.fitness

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var allWorkouts = ArrayList<String>()
        allWorkouts.add("BENCH PRESS")
        allWorkouts.add("INCLINE DB PRESS")
        allWorkouts.add("INCLINE DB FLY")
        allWorkouts.add("PUSH UPS")
        allWorkouts.add("CABLE FLY")
        allWorkouts.add("DIPS")
        allWorkouts.add("SEATED DB PRESS")
        allWorkouts.add("BARBELL OVERHEAD PRESS")
        allWorkouts.add("ARNOLD PRESS")
        allWorkouts.add("LATERAL RAISE")
        allWorkouts.add("FRONT RAISE")
        allWorkouts.add("UPRIGHT ROW")
        allWorkouts.add("REVERSE FLY")
        allWorkouts.add("DB KICKBACKS")
        allWorkouts.add("CABLE PUSH-DOWN")
        allWorkouts.add("ROPE PUSH-DOWN")
        allWorkouts.add("ONE ARM REVERSE PUSH-DOWN")
        allWorkouts.add("SKULL CRUSHERS")
        allWorkouts.add("PULL UPS")
        allWorkouts.add("CHIN UPS")
        allWorkouts.add("LAT PULL-DOWN")
        allWorkouts.add("SEATED ROW")
        allWorkouts.add("CLOSE GRIP ROW")
        allWorkouts.add("DB ROW")
        allWorkouts.add("DEADLIFT")
        allWorkouts.add("SHRUGS")
        allWorkouts.add("Z BAR CURL")
        allWorkouts.add("DB CURL")
        allWorkouts.add("INCLINE DB CURL")
        allWorkouts.add("HAMMER CURL")
        allWorkouts.add("REVERSE BARBELL CURL")
        allWorkouts.add("PREACHER CURL")
        allWorkouts.add("SQUATS")
        allWorkouts.add("LEG PRESS")
        allWorkouts.add("LUNGE")
        allWorkouts.add("LEG EXTENSIONS")
        allWorkouts.add("LEG CURLS")
        allWorkouts.add("HIP THRUSTS")
        allWorkouts.add("CALF RAISES")
        allWorkouts.add("SEATED CALF RAISES")

        val drawableList = ArrayList<Int>()
        val benchDrawableId = R.drawable.bench
        val inclineDbPressDrawableId = R.drawable.inclinedbpress
        val inclineDbFlyDrawableId = R.drawable.inclinedbfly
        val pushUpDrawableId = R.drawable.pushup
        val cableFlyDrawableId = R.drawable.cablefly
        val dipsDrawableId = R.drawable.dips
        val seatedDbPressDrawableId = R.drawable.seateddbpress
        val barbellOverHeadPressDrawableId = R.drawable.barbelloverheadpress
        val arnoldPressDrawableId = R.drawable.arnoldpress
        val lateralRaiseDrawableId = R.drawable.lateralraise
        val frontRaiseDrawableId = R.drawable.frontraise
        val uprightRowDrawableId = R.drawable.uprightrow
        val reverseFlyDrawableId = R.drawable.reversefly
        val dbKickbackDrawableId = R.drawable.dbkickback
        val cablePushDownDrawableId = R.drawable.cablepushdown
        val ropePushDownDrawableId = R.drawable.ropepushdown
        val oneArmReverseDrawableId = R.drawable.onearmreversepushdown
        val skullCrushersDrawableId = R.drawable.skullcrushers
        val pullUpDrawableId = R.drawable.pullup
        val chinUpDrawableId = R.drawable.chinup
        val latPullDownDrawableId = R.drawable.latpulldown
        val seatedRowDrawableId = R.drawable.seatedrow
        val closeGripRowDrawableId = R.drawable.closegriprow
        val dbRowDrawableId = R.drawable.dbrow
        val deadLiftDrawableId = R.drawable.deadlift
        val shrugsDrawableId = R.drawable.shrugs
        val zBarCurlDrawableId = R.drawable.zbarcurl
        val dbCurlDrawableId = R.drawable.dbcurl
        val inclineDbCurlDrawableId = R.drawable.inclinedbcurl
        val hammerDrawableId = R.drawable.hammercurl
        val reverseBarbellCurlDrawableId = R.drawable.reversebarbellcurl
        val preacherCurlDrawableId = R.drawable.preachercurl
        val squatDrawableId = R.drawable.squat
        val legPressDrawableId = R.drawable.legpress
        val lungeDrawableId = R.drawable.lunge
        val legExtensionsDrawableId = R.drawable.legextensions
        val legCurlsDrawableId = R.drawable.legcurls
        val hipThrustDrawableId = R.drawable.hipthrust
        val calfRaisesDrawableId = R.drawable.calfraises
        val seatedCalfRaisesDrawableId = R.drawable.seatedcalfraises

        drawableList.add(benchDrawableId)
        drawableList.add(inclineDbPressDrawableId)
        drawableList.add(inclineDbFlyDrawableId)
        drawableList.add(pushUpDrawableId)
        drawableList.add(cableFlyDrawableId)
        drawableList.add(dipsDrawableId)
        drawableList.add(seatedDbPressDrawableId)
        drawableList.add(barbellOverHeadPressDrawableId)
        drawableList.add(arnoldPressDrawableId)
        drawableList.add(lateralRaiseDrawableId)
        drawableList.add(frontRaiseDrawableId)
        drawableList.add(uprightRowDrawableId)
        drawableList.add(reverseFlyDrawableId)
        drawableList.add(dbKickbackDrawableId)
        drawableList.add(cablePushDownDrawableId)
        drawableList.add(ropePushDownDrawableId)
        drawableList.add(oneArmReverseDrawableId)
        drawableList.add(skullCrushersDrawableId)
        drawableList.add(pullUpDrawableId)
        drawableList.add(chinUpDrawableId)
        drawableList.add(latPullDownDrawableId)
        drawableList.add(seatedRowDrawableId)
        drawableList.add(closeGripRowDrawableId)
        drawableList.add(dbRowDrawableId)
        drawableList.add(deadLiftDrawableId)
        drawableList.add(shrugsDrawableId)
        drawableList.add(zBarCurlDrawableId)
        drawableList.add(dbCurlDrawableId)
        drawableList.add(inclineDbCurlDrawableId)
        drawableList.add(hammerDrawableId)
        drawableList.add(reverseBarbellCurlDrawableId)
        drawableList.add(preacherCurlDrawableId)
        drawableList.add(squatDrawableId)
        drawableList.add(legPressDrawableId)
        drawableList.add(lungeDrawableId)
        drawableList.add(legExtensionsDrawableId)
        drawableList.add(legCurlsDrawableId)
        drawableList.add(hipThrustDrawableId)
        drawableList.add(calfRaisesDrawableId)
        drawableList.add(seatedCalfRaisesDrawableId)





        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val adapter = RecyclerAdapter(allWorkouts, drawableList)
        recyclerView.adapter = adapter
    }

}