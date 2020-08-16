package com.example.apifetch.databse

import android.os.Parcelable
import android.text.TextUtils
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class FactRes(
    @ColumnInfo(name = "title")
    @SerializedName("title")
    @Expose
    var title: String = "",

    var rows: MutableList<Rows> = mutableListOf()
) : Parcelable

@Parcelize
@Entity(
    tableName = "tbl_post",
    indices = [Index(value = arrayOf("AID"), unique = true)]
)
data class Rows(
    /*@ColumnInfo(name = "ID")
    @PrimaryKey(autoGenerate = true)
    var ID: Long = 0,*/

    @ColumnInfo(name = "ID")
    @PrimaryKey(autoGenerate = true)
    var ID: Long = 0,

    @ColumnInfo(name = "AID")
    var AID: String = "",

    @ColumnInfo(name = "title")
    @SerializedName("title")
    @Expose
    var title: String? = null,

    @ColumnInfo(name = "comment")
    @SerializedName("comment")
    @Expose
    var comment: String? = null,

    @ColumnInfo(name = "imageHref")
    @SerializedName("imageHref")
    @Expose
    var imageHref: String? = null
) : Parcelable {

    fun getTitleStr(): String {

        return if (TextUtils.isEmpty(title)) {
            ""
        } else {
            title!!
        }

    }

    fun getDescriptionStr(): String {
        return if (TextUtils.isEmpty(comment)) {
            ""
        } else {
            comment!!
        }
    }

    fun getImageHrefStr(): String {
        return if (TextUtils.isEmpty(imageHref)) {
            ""
        } else {
            imageHref!!
        }
    }
}

/*@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, imageUrl: String?) {
    Log.e("Image",imageUrl+"")
    Glide.with(view.getContext())
        .load(imageUrl)*//*.apply(RequestOptions().circleCrop())*//*
        .override(200,200)
        .into(view)
}*/

