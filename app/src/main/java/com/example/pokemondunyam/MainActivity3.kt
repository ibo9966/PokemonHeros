package com.example.pokemondunyam

import android.content.Context
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main3.*


class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
                textViewDetay.text=intent.getStringExtra("data")
                imageView3.setImageResource(intent.getIntExtra("image_id",0))
        val sharedPref = getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
        val rating = sharedPref.getInt(intent.getStringExtra("data"),0)
        if (rating!=null && rating!=0){
            ratingBar.rating=rating.toFloat()
        }
        ratingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            if (rating.toInt()!=null){
                sharedPref.edit().putInt(intent.getStringExtra("data"), rating.toInt()).apply()
            }
        }
    }
}