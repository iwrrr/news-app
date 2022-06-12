package com.vi.schoters.newsapp.util

import android.icu.text.SimpleDateFormat
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import java.util.*

object Extensions {

    fun ShapeableImageView.loadImage(image: String?) {
        Glide.with(this.context)
            .load(image)
            .into(this)
    }

    fun String.toDate(): String? {
        val inputPattern = "yyyy-MM-dd'T'HH:mm:ss'Z'"
        val outputPattern = "d MMMM yyyy"

        val inputFormat = SimpleDateFormat(inputPattern, Locale.getDefault())
        val outputFormat = SimpleDateFormat(outputPattern, Locale.getDefault())

        val inputDate = inputFormat.parse(this)

        return inputDate?.let { outputFormat.format(it) }
    }
}