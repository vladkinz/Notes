package com.example.a3hm_3.ui.main.data.models.local

import android.content.Context

class Pref(context: Context) {

    val pref = context.getSharedPreferences("key_on_board", Context.MODE_PRIVATE)

    fun setIntroShown(){
        pref.edit().putBoolean("isIntroShown", true).apply()
    }

    fun isIntroShown(): Boolean = pref.getBoolean("isIntroShown", false)
}