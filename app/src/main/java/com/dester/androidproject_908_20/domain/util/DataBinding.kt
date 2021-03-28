package com.dester.androidproject_908_20.domain.util

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.dester.androidproject_908_20.R

@BindingAdapter("isVisible")
fun isVisible(view: View, boolean: Boolean){
    view.visibility =
        if(boolean)  View.VISIBLE
        else View.INVISIBLE
}

@BindingAdapter("isGone")
fun isGone(view: View, boolean: Boolean){
    view.visibility =
        if(boolean)  View.GONE
        else View.VISIBLE
}

@BindingAdapter("setName")
fun setName(view: TextView, name:String){
        val localization = view.context.resources.getString(R.string.name)
    view.text = "$localization$name"
}


@BindingAdapter("setStatus")
fun setStatus(view: TextView, status:String?){
    if (status.isNullOrEmpty()) return
    if(status == "Alive") view.setTextColor(Color.GREEN)
    else if (status == "Dead") view.setTextColor(Color.RED)
    else view.setTextColor(Color.YELLOW)
    val localization = view.context.resources.getString(R.string.status)
    view.text = "$localization$status"
}

@BindingAdapter("setSpecies")
fun setSpecies(view: TextView, species:String?){
    if (species.isNullOrEmpty()) return
    val localization = view.context.resources.getString(R.string.species)
    view.text = "$localization$species"
}

@BindingAdapter("setEpisode")
fun setEpisode(view: TextView, episode:String?){
    if (episode.isNullOrEmpty()) return
    val localization = view.context.resources.getString(R.string.episode)
    view.text = "$localization$episode"
}

@BindingAdapter("setAirDate")
fun setAirDate(view: TextView, airDate:String?){
    if (airDate.isNullOrEmpty()) return
    val localization = view.context.resources.getString(R.string.airDate)
    view.text = "$localization$airDate"
}

@BindingAdapter("setType")
fun setType(view: TextView, type:String?){
    if (type.isNullOrEmpty()) return
    val localization = view.context.resources.getString(R.string.type)
    view.text = "$localization$type"
}

@BindingAdapter("setDimension")
fun setDimension(view: TextView, dimension:String?){
    if (dimension.isNullOrEmpty()) return
    val localization = view.context.resources.getString(R.string.dimension)
    view.text = "$localization$dimension"
}

@BindingAdapter("setOrigin")
fun setOrigin(view: TextView, origin:String?){
    if (origin.isNullOrEmpty()) return
    val localization = view.context.resources.getString(R.string.origin)
    view.text = "$localization$origin"
}

@BindingAdapter("setLocation")
fun setLocation(view: TextView, location:String?){
    if (location.isNullOrEmpty()) return
    val localization = view.context.resources.getString(R.string.location)
    view.text = "$localization$location"
}

@BindingAdapter("setGender")
fun setGender(view: TextView, gender:String?){
    if (gender.isNullOrEmpty()) return
    val localization = view.context.resources.getString(R.string.gender)
    view.text = "$localization$gender"
}

@BindingAdapter("loadFromUrl")
fun loadFromUrl(view: ImageView, url:String?){
    if (url.isNullOrEmpty()) return

    Glide.with(view.context)
        .load(url)
        .into(view)
}


