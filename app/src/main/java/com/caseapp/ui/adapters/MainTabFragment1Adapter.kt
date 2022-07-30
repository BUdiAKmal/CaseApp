
package com.caseapp.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import com.caseapp.R
import com.caseapp.listeners.OnItemClickListener
import com.caseapp.models.MainTabFragment1Model
import com.google.android.material.card.MaterialCardView


class MainTabFragment1Adapter(private val context: Context) :
    RecyclerView.Adapter<MainTabFragment1Adapter.MainTabFragment1ViewHolder>() {

    private val MainTabFragment1Model: MutableList<MainTabFragment1Model> = mutableListOf()  // Initialize listModel
    private lateinit var onSelectedListenerMainTabFragment1: OnItemClickListener // Initialize onItemListener


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainTabFragment1ViewHolder {
        return MainTabFragment1ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_maintab_fragment1_layout, parent, false)
        )
    } // End - onCreateViewHolder

    override fun getItemCount(): Int {
        return MainTabFragment1Model.size
    }  // End - getItem

    override fun onBindViewHolder(holder: MainTabFragment1ViewHolder, position: Int) {
        holder.maintabfragment1BindView(MainTabFragment1Model[position])
    } // End - onBindViewHolder

    // Start - setMainTabFragment1
    fun setMainTabFragment1(data: List<MainTabFragment1Model>) {
        MainTabFragment1Model.clear()
        MainTabFragment1Model.addAll(data)
        notifyDataSetChanged()
    } // End - setMainTabFragment1

    // Start - getMainTabFragment1
    fun getMainTabFragment1(): MutableList<MainTabFragment1Model> {
        return MainTabFragment1Model
    } // End - getMainTabFragment1

    // Start - MainTabFragment1ViewHolder
    inner class MainTabFragment1ViewHolder(maintabfragment1view: View) : RecyclerView.ViewHolder(maintabfragment1view) {
        val ivMainTabFragment1 = maintabfragment1view.findViewById<ImageView>(R.id.iv_RVItem_MainTabFragment1)
        val tvTitleMainTabFragment1 = maintabfragment1view.findViewById<TextView>(R.id.tv_titleText_MainTabFragment1)
        val cvMainTabFragment1: MaterialCardView = maintabfragment1view.findViewById(R.id.cv_RVItem_MainTabFragment1)

        fun maintabfragment1BindView(MainTabFragment1Model: MainTabFragment1Model) {
            MainTabFragment1Model.apply {
                val image = MainTabFragment1Model.imgURLMainTabFragment1
                image.let {
                    Glide.with(itemView.context)
                        .load(it)
                        .into(ivMainTabFragment1)

                    Glide.with(itemView.context)
                        .load(it)
                        .centerCrop()
                        .fitCenter()
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .skipMemoryCache(true)
                }
            }
            tvTitleMainTabFragment1.text = MainTabFragment1Model.titleTextMainTabFragment1
        }

        init {
            cvMainTabFragment1.setOnClickListener { onSelectedListenerMainTabFragment1.onItemClick(it, layoutPosition) }
        }

    } // End - MainTabFragment1BindViewHolder

    // Start - OnItemListener
    fun setOnClickItemListenerMainTabFragment1(onItemClickListener: OnItemClickListener) {
        this.onSelectedListenerMainTabFragment1 = onItemClickListener
    } // End - OnItemListener

} // End - Class