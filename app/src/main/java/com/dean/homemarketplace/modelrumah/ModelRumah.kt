package com.dean.homemarketplace.modelrumah

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class ModelRumah(

        @field:SerializedName("person")
        val person: List<RumahItem?>? = null,

        @field:SerializedName("error")
        val error: String? = null,

        @field:SerializedName("status")
        val status: String? = null

) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.createTypedArrayList(RumahItem),
            parcel.readString()
            ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(person)
        parcel.writeValue(error)
        parcel.writeString(status)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ModelRumah> {
        override fun createFromParcel(parcel: Parcel): ModelRumah {
            return ModelRumah(parcel)
        }

        override fun newArray(size: Int): Array<ModelRumah?> {
            return arrayOfNulls(size)
        }
    }
}
