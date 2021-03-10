package com.dean.homemarketplace.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Home (
        var id : String,
        var name : String,
        var address : String,
        var price : String,
        var desc : String,
        var type : String,
        var developer : String,
        var property_facilties : String,
        var certificate : String,
        var furnished : String,
        var number_of_floors : String,
        var surface_area : String,
        var image : String

) : Parcelable