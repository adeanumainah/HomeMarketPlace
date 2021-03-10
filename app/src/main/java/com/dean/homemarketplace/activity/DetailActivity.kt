package com.dean.homemarketplace.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.dean.homemarketplace.R
import com.dean.homemarketplace.model.DataItem
import com.dean.homemarketplace.model.Home
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.row_listh.*
import java.lang.NullPointerException

class DetailActivity : AppCompatActivity() {

    companion object{
        const val KEY_POPULAR_HOME = "key_popular_home"
    }

    private var home: DataItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val data = intent.getStringExtra("key_popular_home").toString()

        var detail:DataItem = Gson().fromJson(data,DataItem::class.java)
        try {
            val urlImg:String = "http://192.168.80.138:8080/image/"+detail?.image

            Log.d("Cek DataDi Detail",urlImg)
            Glide.with(this).load(urlImg).into(iv_image_detail_popular)
        }catch (e:NullPointerException){
            e.printStackTrace()
        }
//            home = intent.getParcelableExtra(KEY_POPULAR_HOME)
            tv_lable_name.text = detail?.name.toString()
            tv_lable_address.text = detail?.address.toString()
            tv_lable_price.text = detail?.price.toString()
            tv_lable_desc.text = detail?.desc.toString()
            tv_lable_type.text = detail?.type.toString()
            tv_lable_developer.text = detail?.developer.toString()
            tv_lable_fproperty.text = detail?.propertyFacilities.toString()
            tv_lable_sertifikat.text = detail?.certificate.toString()
            tv_lable_furnished.text = detail?.furnished.toString()
            tv_lable_lantai.text = detail?.numberOfFloors.toString()
            tv_lable_luas.text = detail?.surfaceArea.toString()

    }

    fun panggil(view: View) {
        val nomor = "09667347"
        val panggil = Intent(Intent.ACTION_DIAL)
        panggil.data = Uri.fromParts("tel", nomor, null)
        startActivity(panggil)
    }


}


//        btn_call_us.setOnClickListener {
//            val nomor = "09667347"
//            val panggil = Intent(Intent.ACTION_DIAL)
//            panggil.data = Uri.fromParts("tel", nomor, null)
//            startActivity(panggil)
//        }

