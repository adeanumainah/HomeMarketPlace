package com.dean.homemarketplace.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.dean.homemarketplace.R
import com.dean.homemarketplace.adapter.PropertyPopularAdapter
import com.dean.homemarketplace.model.ResponseItem
import com.dean.homemarketplace.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@Suppress("UNREACHABLE_CODE")
class HomeFragment : Fragment() {
    var rv: ListView? = null
    var apiService: ApiService? = null
    var list: List<ResponseItem> = ArrayList<ResponseItem>()

    companion object{
        fun defaultFragment(): HomeFragment{
            val home_fragment = HomeFragment()
            //ngirim ke oncreate
            val bundle = Bundle()
            //arguments default function u ngirim data
            home_fragment.arguments = bundle
            return home_fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)

        val title = requireActivity().findViewById<TextView>(R.id.tv_name_rumah)
        val add = requireActivity().findViewById<TextView>(R.id.tv_address_rumah)


        val name = requireActivity().intent.getStringExtra("name")
        val address = requireActivity().intent.getStringExtra("address")

        title.text = name
        add.text = address
        userList

    }

    private val userList: Unit
        get() {
            val call: Call<List<ResponseItem>>? = apiService?.product
            call?.enqueue(object : Callback<List<ResponseItem>> {
                override fun onResponse(call: Call<List<ResponseItem>>, response: Response<List<ResponseItem>>) {
                    if (response.isSuccessful) {
                        list = response.body()!!
                        rv!!.adapter = context?.let {
                            PropertyPopularAdapter(
                                    it,
                                    R.layout.row_listh, list

                            )
                        }
                    }
                }

                override fun onFailure(
                        call: Call<List<ResponseItem>>, t: Throwable) {
                    Log.e("ERROR: ", t.message!!)
                }
            })
        }
}


//    companion object{
//        fun defaultFragment(): HomeFragment{
//            val home_fragment = HomeFragment()
//            //ngirim ke oncreate
//            val bundle = Bundle()
//            //arguments default function u ngirim data
//            home_fragment.arguments = bundle
//            return home_fragment
//        }
//    }
//
//
//    override fun onCreateView(
//            inflater: LayoutInflater, container: ViewGroup?,
//            savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false)
//
//
//    }
//
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//
//        presenter = HomePresenter(this)
//        presenter.getData()
//    }
//
//    override fun onFailed(message: String) {
//        progressBarHolder.visibility = View.GONE
//    }
//
//    override fun showProgress() {
//        progressBarHolder.visibility = View.VISIBLE
//    }
//
//    override fun hideProgress() {
//        progressBarHolder.visibility = View.GONE
//    }
//
//    override fun showdata(dataItem: List<Home>) {
//        rv_terkini.setHasFixedSize(true)
//
//        rv_terkini.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
//        rv_terkini.adapter = NewsAdapter(this.requireContext(), dataItem)
//    }
//}







//    private lateinit var contentViewModel: ContentViewModel
//    private lateinit var popularAdapter: PropertyPopularAdapter
//
//    companion object{
//        fun defaultFragment(): HomeFragment {
//            val home_fragment = HomeFragment()
//            //ngirim dia ke onCreate
//            val bundle = Bundle()
//            //argument = default function untuk mengirim data
//            home_fragment.arguments = bundle
//            return home_fragment
//        }
//    }
//
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false)
//
//
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
////        showLoading(true)
//        attachData()
//        contentViewModel.setRumah()
//    }
//
//    @SuppressLint("FragmentLiveDataObserve")
//    private fun attachData() {
//        popularAdapter = PropertyPopularAdapter {
////            showSelected(it)
//        }
//        popularAdapter.notifyDataSetChanged()
//        rv_terkini.setHasFixedSize(true)
//        rv_terkini.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
//        rv_terkini.addItemDecoration(
//            DividerItemDecoration(
//                rv_terkini.context,
//                DividerItemDecoration.VERTICAL
//            )
//        )
//        rv_terkini.adapter = popularAdapter
//        contentViewModel = ViewModelProvider(
//            this,
//            ViewModelProvider.NewInstanceFactory()
//        ).get(ContentViewModel::class.java)
//        contentViewModel.getMovies().observe(this, androidx.lifecycle.Observer {
//            popularAdapter.setData(it as ArrayList<Home>)
////            showLoading(false)
//        })
//    }
//}

//    private val rumahList = ArrayList<Home>()
//    var list: List<ResponseItem> = ArrayList<ResponseItem>()
//    private lateinit var proyekterkiniAdapter: ProyekTerkiniAdapter
//    var propertyServices: ProductServices? = null
//    var rv: ListView? = null
//    private lateinit var propertypopularAdapter: PropertyPopularAdapter
//
//    companion object{
//        fun defaultFragment(): HomeFragment{
//            val home_fragment = HomeFragment()
//            //ngirim ke oncreate
//            val bundle = Bundle()
//            //arguments default function u ngirim data
//            home_fragment.arguments = bundle
//            return home_fragment
//        }
//    }
//
//    override fun onCreateView(
//            inflater: LayoutInflater,
//            container: ViewGroup?,
//            savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.fragment_home, container, false)
//
//        ListHome
//    }
//
//    private val ListHome: Unit
//        get() {
//            val call: Call<List<ResponseItem>>? = propertyServices?.product
//            call?.enqueue(object : Callback<List<ResponseItem>> {
//
//                override fun onResponse(call: Call<List<ResponseItem>>, response: Response<List<ResponseItem>>) {
//                    if (response.isSuccessful) {
//                        list = response.body()!!
//                        rv!!.adapter = PropertyPopularAdapter(
//                            this@HomeFragment.context,
//                            R.layout.row_listh, list                        )
//
//                    }
//                }
//
//                override fun onFailure(call: Call<List<ResponseItem>>, t: Throwable) {
//                    Log.e("ERROR: ", t.message!!)
//                }
//
//            })
//        }
//
//    val imageContentSlider = intArrayOf(
//        R.drawable.rumah1,
//        R.drawable.rumah2,
//        R.drawable.rumah3,
//        R.drawable.rumah4
//
//    )
//
//    val imageContentList: ImageListener = object : ImageListener {
//        override fun setImageForPosition(position: Int, imageView: ImageView?) {
//            imageView?.setImageResource(imageContentSlider[position])
//
//        }
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        val carouselView = is_main as CarouselView
//        //set yang sudah ditempel
//        carouselView.setImageListener(imageContentList)
//        //membaca maximum index yang dibaca
//        carouselView.setPageCount(imageContentSlider.count())
//
//        tv_see_all_terkini.setOnClickListener {
//            val intent = Intent(context, SeeAllTerkiniActivity::class.java)
//            startActivity(intent)
//        }
//
//        tv_see_all_popular.setOnClickListener {
//            val intentBest = Intent(context, SeeAllPopularActivity::class.java)
//            startActivity(intentBest)
//        }
//
//    }
//
//    private fun showSelected(it: Home) {
//        val page = Intent(context, DetailActivity::class.java)
//        page.putExtra(DetailActivity.KEY_POPULAR_HOME, it)
//        startActivity(page)
//    }
//
//
//}