package com.dean.homemarketplace

import androidx.lifecycle.ViewModel

class ContentViewModel : ViewModel() {

//    private val listRumah = MutableLiveData<ArrayList<Home>>()
//
//    internal fun setRumah(category: String = "rumah") {
//        val client = AsyncHttpClient()
//        val listItems = ArrayList<Home>()
//        val BASE_URL =
//                "http://192.168.42.11/houseapp/index.php/person/get"
//
//        client.get(BASE_URL, object : AsyncHttpResponseHandler() {
//            override fun onSuccess(
//                    statusCode: Int,
//                    headers: Array<out cz.msebera.android.httpclient.Header>?,
//                    responseBody: ByteArray?
//            ) {
//
//                try {
//                    val  result = responseBody?.let { String(it) }
//                    val responseBody = JSONObject(result)
//                    val list = responseBody.getJSONArray("results")
//
//                    for (i in 0 until list.length()) {
//                        val rumah = list.getJSONObject(i)
//                        val rumahItem = Home()
//                        rumahItem.id = rumah.getInt("id")
//                        if (rumah.has("name")){
//                            rumahItem.name = rumah.getString("name")
//                        } else {
//                            rumahItem.name = rumah.getString("name")
//                        }
//
//                        rumahItem.address = rumah.getString("description")
//                        if (rumah.has("description")){
//
//                        }
//                    }
//                    listRumah.postValue(listItems)
//                } catch (e: Exception) {
//                    print(msg = e.message.toString())
//
//                }
//            }
//            override fun onFailure(
//                    statusCode: Int,
//                    headers: Array<out cz.msebera.android.httpclient.Header>?,
//                    responseBody: ByteArray?,
//                    error: Throwable?
//            ) {
//
//                if (error != null) {
//                    print(msg = error.message.toString())
//                }
//            }
//
//        })
//    }
//
//    internal fun getMovies(): LiveData<ArrayList<Home>> {
//        return listRumah
//    }
//    private fun print(msg: String, tag: String? = "tagMovieCatalogue") {
//        Log.e(tag, msg)
//    }
}