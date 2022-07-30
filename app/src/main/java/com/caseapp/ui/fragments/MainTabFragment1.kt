package com.caseapp.ui.fragments


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.caseapp.R
import com.caseapp.ui.adapters.MainTabFragment1Adapter
import com.caseapp.listeners.OnItemClickListener
import com.caseapp.models.MainTabFragment1Model
import com.caseapp.ui.activities.DetailsActivity
import kotlinx.android.synthetic.main.fragment1_main_tab.*



class MainTabFragment1 : Fragment() {


    lateinit var mainTabFragment1Adapter: MainTabFragment1Adapter  // Initialize Adapter
//    private val lLM = LinearLayoutManager.VERTICAL // Initialize layoutManager
    private val sLM = LinearLayoutManager(context) // Initialize layoutManager
    val addMainTabFragment1ModelList: MutableList<MainTabFragment1Model> = ArrayList() // Initialize listModel
    private var urlMainTabFragment1 = arrayOfNulls<String>(4) // Initialize URL Direction WebView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment1_main_tab, container, false)


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Start - Webview URL
        urlMainTabFragment1[0] = "https://eqinvi.com/wbm0101"
        urlMainTabFragment1[1] = "https://eqinvi.com/wb_moody"
        urlMainTabFragment1[2] = "https://eqinvi.com/feqinvi"
        urlMainTabFragment1[3] = "https://eqinvi.com/eqinvi"
        // End - Webview URL


        initViewMainTabFragment1() // SetUp initView listModel
        actionMainTabFragment1() // SetUp actionMainTabFragment1


    } // End - OnCreate

    // Start - intView listModel
    private fun initViewMainTabFragment1() {
        rv_mainTabFragment1.layoutManager = sLM
        mainTabFragment1Adapter = MainTabFragment1Adapter(requireActivity())
        rv_mainTabFragment1.adapter = mainTabFragment1Adapter

        addMainTabFragment1ModelList.add(
            MainTabFragment1Model(
                "https://eqinvi.com/wp-content/uploads/2022/07/cv1.png",
                "Title RVItemNo.1 MainTabFragment1",
                "Desc RVItenNo.1 MainTabFragment1",
                "https://google.com"
            )
        )
        addMainTabFragment1ModelList.add(
            MainTabFragment1Model(
                "https://eqinvi.com/wp-content/uploads/2022/07/cv2.png",
                "Title RVItemNo.2 MainTabFragment1",
                "Desc RVItenNo.2 MainTabFragment1",
                "https://youtube.com"
            )
        )
        addMainTabFragment1ModelList.add(
            MainTabFragment1Model(
                "https://eqinvi.com/wp-content/uploads/2022/07/cv3.png",
                "Title RVItemNo.3 MainTabFragment1",
                "Desc RVItenNo.3 MainTabFragment1",
                "https://gmail.com"
            )
        )
        addMainTabFragment1ModelList.add(
            MainTabFragment1Model(
                "https://eqinvi.com/wp-content/uploads/2022/07/cv4.png",
                "Title RVItemNo.4 MainTabFragment1",
                "Desc RVItenNo.4 MainTabFragment1",
                "https://blgger.com"
            )
        )

        mainTabFragment1Adapter.setMainTabFragment1(addMainTabFragment1ModelList)
    } // End - intView listModel

    // Start - putExtra to SingleProduct
    fun actionMainTabFragment1() {
        mainTabFragment1Adapter.setOnClickItemListenerMainTabFragment1(object : OnItemClickListener {
            override fun onItemClick(item: View, position: Int) {
                val i = Intent(context, DetailsActivity::class.java)
                i.putExtra(
                    "titleTextMainTabFragment1",
                    mainTabFragment1Adapter
                        .getMainTabFragment1()
                        .get(position)
                        .titleTextMainTabFragment1
                )
                i.putExtra(
                    "descTextMainTabFragment1",
                    mainTabFragment1Adapter
                        .getMainTabFragment1()
                        .get(position)
                        .descTextMainTabFragment1
                )
                i.putExtra(
                    "imgURLMainTabFragment1",
                    mainTabFragment1Adapter
                        .getMainTabFragment1()
                        .get(position)
                        .imgURLMainTabFragment1
                )
                i.putExtra(
                    "btnURLMainTabFragment1",
                    mainTabFragment1Adapter
                        .getMainTabFragment1()
                        .get(position)
                        .btnURLMainTabFragment1
                )
                startActivity(i)
            }
        })
    } // End - putExtra to SingleProduct


}


