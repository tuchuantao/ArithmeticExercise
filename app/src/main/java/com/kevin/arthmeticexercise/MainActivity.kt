package com.kevin.arthmeticexercise

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.view.ViewGroup
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        var layout = findViewById<ConstraintLayout>(R.id.content_layout)
        findViewById<Button>(R.id.btn).setOnClickListener {
            PrintViewTree().print2(layout)
        }
    }
}