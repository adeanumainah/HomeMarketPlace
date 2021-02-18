package com.dean.homemarketplace.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.dean.homemarketplace.R
import com.dean.homemarketplace.model.Home
import com.dean.homemarketplace.model.ResponseItem
import com.dean.homemarketplace.ui.fragment.HomeFragment
import kotlinx.android.synthetic.main.row_listh.view.*
import java.lang.String

class PropertyPopularAdapter(context: Context, resource: Int, objects: List<ResponseItem>) :
    ArrayAdapter<ResponseItem?>(context!!, resource, objects) {
    private val personItem: List<ResponseItem> = objects
    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup

    ): View {
        val inflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v: View = inflater.inflate(R.layout.row_listh, parent, false)
        val txtIdRumah = v.findViewById<TextView>(R.id.tv_id_rumah)
        val txtNameRumah = v.findViewById<TextView>(R.id.tv_name_rumah)
        val txtAddressRumah = v.findViewById<TextView>(R.id.tv_address_rumah)

        txtIdRumah.text = (String.valueOf(personItem[position].id))
        txtNameRumah.text = (String.valueOf(personItem[position].name))
        txtAddressRumah.text = String.valueOf(personItem[position].address)

        v.setOnClickListener {
            val intent = Intent(context, HomeFragment::class.java)
            intent.putExtra("id", String.valueOf(personItem[position].id))
            intent.putExtra("name", personItem[position].name)
            intent.putExtra("address", personItem[position].address)
            context.startActivity(intent)
        }
        return v
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