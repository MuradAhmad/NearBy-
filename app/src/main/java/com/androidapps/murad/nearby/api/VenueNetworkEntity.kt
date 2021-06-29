package com.androidapps.murad.nearby.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class VenueNetworkEntity(
    @SerializedName("name")
    @Expose
    var name: String,

    @SerializedName("address")
    @Expose
    var address: String,

    @SerializedName("distance")
    @Expose
    var distance: Int
) {

}