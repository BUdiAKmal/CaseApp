package com.caseapp.ui.activities

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.caseapp.R
import com.caseapp.ui.fragments.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_details.*


class DetailsActivity : AppCompatActivity() {

    var prodBundle: Bundle? = null // Initialize getString (bundle) from MainActivity
    private var urls = arrayOfNulls<String>(10) // Initialize URL Direction


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)


        // Start - full screen
        val window = window
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        ) // End - full screen


        initView() // Setup getString from RecyclerView Main Activity

    } // End - OnCreate


    // Start - getString from RecyclerView Main Activity
    fun initView() {
        prodBundle = intent.extras

        tv_titleText.text = prodBundle?.getString("titleTextMainTabFragment1")
        tv_descText.text = prodBundle?.getString("descTextMainTabFragment1")

//        btn_keranjang.text = prodBundle?.getString("urlKeranjang")
        prodBundle?.getString("imgURLMainTabFragment1").let {
            Glide.with(this).asBitmap()
                .load(it)
                .into(iv_imgURL)

            Glide.with(this).asBitmap()
                .load(it)
                .centerCrop()
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
        }
    } //  End  - getString from RecyclerView Main Activity


} // End - Class


