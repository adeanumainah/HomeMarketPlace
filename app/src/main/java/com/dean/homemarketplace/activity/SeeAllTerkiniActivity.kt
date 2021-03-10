package com.dean.homemarketplace.activity

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.dean.homemarketplace.R
import com.dean.homemarketplace.adapter.ProyekTerkiniAdapter
import com.dean.homemarketplace.model.Home
import com.dean.homemarketplace.model.ResponseModel
import com.dean.homemarketplace.network.AppiService
import com.dean.homemarketplace.ui.fragment.HomeFragment
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_see_all_terkini.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SeeAllTerkiniActivity : AppCompatActivity() {
    private lateinit var terkiniAdapter: ProyekTerkiniAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_see_all_terkini)
        supportActionBar?.hide()
        showRecyclerGrid()
        getHome()
        getRecyclerList()

    }

    private fun getRecyclerList() {
        //mengikat si recyclernya ke dalam list
        val layoutManagerStaggered = StaggeredGridLayoutManager(2, GridLayoutManager.VERTICAL)
        rv_all_terkini.layoutManager = layoutManagerStaggered

        //ngeset data diadapter dan diset adapternya disini
        terkiniAdapter = ProyekTerkiniAdapter(this)

        rv_all_terkini.adapter = terkiniAdapter

    }

    private fun getHome() {
        imgHome.setOnClickListener {
            val intent = Intent (this, HomeFragment::class.java)
            startActivity(intent)
        }
    }


    private fun showRecyclerGrid() {
        var loading = ProgressDialog.show(this, "Request Data", "Loading..")
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
}

