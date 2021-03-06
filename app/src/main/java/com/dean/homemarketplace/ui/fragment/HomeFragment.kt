package com.dean.homemarketplace.ui.fragment

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dean.homemarketplace.R
import com.dean.homemarketplace.activity.DetailActivity
import com.dean.homemarketplace.activity.SeeAllTerkiniActivity
import com.dean.homemarketplace.adapter.ProyekTerkiniAdapter
import com.dean.homemarketplace.model.ResponseModel
import com.dean.homemarketplace.network.AppiService
import com.google.gson.Gson
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {
    private lateinit var terkiniAdapter: ProyekTerkiniAdapter
    private lateinit var rv_terkini: RecyclerView


    companion object {
        fun defaultFragment(): HomeFragment {
            val home_fragment = HomeFragment()
            //ngirim ke oncreate
            val bundle = Bundle()
            //arguments default function u ngirim data
            home_fragment.arguments = bundle
            return home_fragment
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        var v : View = inflater.inflate(R.layout.fragment_home, container, false)

        rv_terkini = v.findViewById(R.id.rv_terkini)
                // Inflate the layout for this fragment
        return v
    }

    val imageContentSlider = intArrayOf(
            R.drawable.rumah1,
            R.drawable.rumah2,
            R.drawable.rumah3,
            R.drawable.rumah4

    )

    val imageContentListener: ImageListener = object : ImageListener {
        override fun setImageForPosition(position: Int, imageView: ImageView?) {
            imageView?.setImageResource(imageContentSlider[position])
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val carouselView = is_main as CarouselView
        carouselView.setImageListener(imageContentListener)
        carouselView.pageCount = imageContentSlider.count()


        GetDatas()


        tv_see_all_terkini.setOnClickListener {
            val intent = Intent(context, SeeAllTerkiniActivity::class.java)
            startActivity(intent)
        }

        terkiniAdapter = context?.let { ProyekTerkiniAdapter(it) }!!
        rv_terkini.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = terkiniAdapter
        }
    }

    private fun GetDatas() {
        var loading = ProgressDialog.show(context, "Request Data", "Loading..")
        AppiService.endpoint.getData().enqueue(
                object : Callback<ResponseModel> {
                    override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
//                        Log.d("Response", "Success" + response.body()?.data)

                        loading.dismiss()
                        Log.d("DATA", "hide loading")
                        if (response.isSuccessful) {
                            val data = response.body()
                            Log.d("DATA", "success")
                            if(data?.status == 200) {
                                Log.d("DATA", "200")
                                if(!data.data.isNullOrEmpty()){
                                    Log.d("DATA", "ADA")
                                    Log.d("DATA", Gson().toJson(data.data))
                                    terkiniAdapter.setData(data.data!!)
                                }

                            }
                        }
                    }

                    override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                        Log.d("Response", "Failed : " + t.localizedMessage)
                        loading.dismiss()
                    }
                }


        )

    }
    private fun Intent.putExtra(keyPopularHome: String) {
        val page = Intent(context, DetailActivity::class.java)
        page.putExtra(DetailActivity.KEY_POPULAR_HOME)
        startActivity(page)
    }
}


//        apiService = ApiConfig.apiService
//
//        val title = requireActivity().findViewById<TextView>(R.id.tv_name_rumah)
//        val add = requireActivity().findViewById<TextView>(R.id.tv_address_rumah)
//
//
//        val name = requireActivity().intent.getStringExtra("name")
//        val address = requireActivity().intent.getStringExtra("address")
//
//        title.text = name
//        add.text = address
//        userList

    

//    private val userList: Unit
//        get() {
//            val call: Call<List<ResponseItem>>? = apiService?.product
//            call?.enqueue(object : Callback<List<ResponseItem>> {
//                override fun onResponse(call: Call<List<ResponseItem>>, response: Response<List<ResponseItem>>) {
//                    if (response.isSuccessful) {
//                        list = response.body()!!
//                        rv!!.adapter = context?.let {
//                            PropertyPopularAdapter(
//                                    it,
//                                    R.layout.row_listh, list
//
//                            )
//                        }
//                    }
//                }
//
//                override fun onFailure(
//                        call: Call<List<ResponseItem>>, t: Throwable) {
//                    Log.e("ERROR: ", t.message!!)
//                }
//            })
//        }
//}


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