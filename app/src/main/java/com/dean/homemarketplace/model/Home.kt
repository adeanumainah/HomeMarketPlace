package com.dean.homemarketplace.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parceler
import kotlinx.android.parcel.Parcelize
import java.security.cert.Certificate

@Parcelize
data class Home (
        var id: String,
        var name : String,
        var address: String,
        var furnished: String,
        var developer: String,
        var price: String,
        var surface_area: String,
        var certificate: String,
        var number_of_floors: String,
        var property_facilities: String,
        var type: String,
        var desc: String

) : Parcelable