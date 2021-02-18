package com.dean.homemarketplace.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

 class ResponseItem {

	 @field:SerializedName("address")
	 @Expose
	 var address: String? = null

	 @field:SerializedName("furnished")
	 @Expose
	 var furnished: String? = null

	 @field:SerializedName("price")
	 @Expose
	 var price: String? = null

	 @field:SerializedName("surface_area")
	 @Expose
	 var surfaceArea: String? = null

	 @field:SerializedName("name")
	 @Expose
	 var name: String? = null

	 @field:SerializedName("certificate")
	 @Expose
	 var certificate: String? = null

	 @field:SerializedName("developer")
	 @Expose
	 var developer: String? = null

	 @field:SerializedName("number_of_floors")
	 @Expose
	 var numberOfFloors: String? = null

	 @SerializedName("id")
	 @Expose
	 var id = 0

	 @field:SerializedName("property_facilities")
	 @Expose
	 var propertyFacilities: String? = null

	 @field:SerializedName("type")
	 @Expose
	 var type: String? = null

	 @SerializedName("desc")
	 @Expose
	 var desc: String? = null

	 constructor() {}
	 constructor(
			 id: Int,
			 name: String?,
			 price: String?,
			 desc: String?,
			 image: String?
	 ) {
		 this.id = id
		 this.name = name
		 this.address = address
		 this.furnished = furnished
		 this.developer = developer
		 this.price = price
		 this.surfaceArea = surfaceArea
		 this.certificate = certificate
		 this.numberOfFloors = numberOfFloors
		 this.propertyFacilities = propertyFacilities
		 this.type = type
		 this.desc = desc
	 }

 }
