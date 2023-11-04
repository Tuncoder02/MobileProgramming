package com.example.simplestore

import android.os.Bundle
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appList = findViewById<LinearLayout>(R.id.appList)

        for (i in 1..50) {
            val horizontalScrollView = HorizontalScrollView(this)
            val horizontalLayout = LinearLayout(this)
            horizontalLayout.orientation = LinearLayout.HORIZONTAL

            for (j in 1..10) {
                val appItem = createAppItem("Facebook $j", R.drawable.app)
                horizontalLayout.addView(appItem)
            }

            horizontalScrollView.addView(horizontalLayout)
            appList.addView(horizontalScrollView)

            // Bật cuộn ngang trong danh sách con
            ViewCompat.setNestedScrollingEnabled(horizontalScrollView, true)
        }
    }

    private fun createAppItem(appName: String, appIconRes: Int): LinearLayout {
        val appItemLayout = layoutInflater.inflate(R.layout.app_item, null) as LinearLayout
        val appIcon = appItemLayout.findViewById<ImageView>(R.id.appIcon)
        val appNameTextView = appItemLayout.findViewById<TextView>(R.id.appName)

        appIcon.setImageResource(appIconRes)
        appNameTextView.text = appName

        val params = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        params.setMargins(16, 0, 16, 0)
        appItemLayout.layoutParams = params

        return appItemLayout
    }
}
