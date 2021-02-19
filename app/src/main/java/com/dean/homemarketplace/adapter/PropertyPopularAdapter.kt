package com.dean.homemarketplace.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.dean.homemarketplace.R
import com.dean.homemarketplace.activity.DetailActivity
import com.dean.homemarketplace.helper.BaseActivity.Companion.KEYRUMAH
import com.dean.homemarketplace.modelrumah.RumahItem
import com.dean.homemarketplace.ui.fragment.HomeFragment
import kotlinx.android.synthetic.main.row_listh.view.*
import java.lang.String

class PropertyPopularAdapter(
        var rumahActivity: FragmentActivity?,
        var dataPerson: List<RumahItem?>?
): RecyclerView.Adapter<PropertyPopularAdapter.MyViewHolder>() {


    //unutk mengatur layout yang akan ditampilkan
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PropertyPopularAdapter.MyViewHolder {
        var view = LayoutInflater.from(rumahActivity).inflate(R.layout.row_listh, parent, false)
        return MyViewHolder(view)
    }

    //deklarasi dan inisialisasi
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    //untuk memnghitung total data yang akan di load/tampil
    override fun getItemCount(): Int = dataPerson?.size!!

    //untuk mengeset data
    override fun onBindViewHolder(holder: PropertyPopularAdapter.MyViewHolder, position: Int) {
        holder.itemView.tv_name_rumah.text = dataPerson?.get(position)?.name
        holder.itemView.tv_address_rumah.text = dataPerson?.get(position)?.address
        //aksi klik
        holder.itemView.setOnClickListener {
            var intent = Intent(rumahActivity, DetailActivity::class.java)
            intent.putExtra(KEYRUMAH,dataPerson?.get(position))

            rumahActivity?.startActivity(intent)
        }
    }
}


//    var dataItem: List<Home>? = data
//    var mContext: Context? = c
//
//    override fun getItemCount(): Int {
//        return dataItem?.size!!
//    }
//
//    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
//        val inflater = LayoutInflater.from(mContext).inflate(R.layout.row_listh, p0, false)
//        return ViewHolder(inflater)
//    }
//
//    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
//
//        p0.judul?.text = dataItem?.get(p1)?.name
//        p0.address?.text = dataItem?.get(p1)?.address
////        Picasso.get().load(dataItem?.get(p1)?.urlToImage).into(p0.image)
//
//        p0.itemView.setOnClickListener {
//            val bundle = bundleOf(
//                    "name" to dataItem?.get(p1)?.name,
//                    "address" to dataItem?.get(p1)?.address,
////                    "image" to dataItem?.get(p1)?.urlToImage,
////                    "author" to dataItem?.get(p1)?.author,
////                    "date" to dataItem?.get(p1)?.publishedAt
//            )
//        }
//    }
//
//    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
//        var judul = itemView?.findViewById<TextView>(R.id.tv_name_rumah)
//        var address = itemView?.findViewById<TextView>(R.id.tv_address_rumah)
////        var image = itemView?.findViewById<ImageView>(R.id.imageNewsItemView)
//
//
//
//    }
//
//}