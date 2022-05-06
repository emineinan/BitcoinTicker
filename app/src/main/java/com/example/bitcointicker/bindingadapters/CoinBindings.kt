package com.example.bitcointicker.bindingadapters

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.bitcointicker.R
import com.example.bitcointicker.utils.loadImage
import kotlin.math.abs
import kotlin.math.roundToInt

class CoinBindings {

    companion object {
        @BindingAdapter("load_image")
        @JvmStatic
        fun loadImage(imageView: ImageView, coinImage: String?) {
            imageView.loadImage(coinImage)
        }

        @BindingAdapter("show_percentage")
        @JvmStatic
        fun showPercentage(imageView: ImageView, priceChange: Double) {
            if (priceChange > 0) {
                imageView.setImageResource(R.drawable.ic_up)
            } else {
                imageView.setImageResource(R.drawable.ic_down)
            }
        }

        @BindingAdapter("make_abs")
        @JvmStatic
        fun makeAbs(textView: TextView, priceChange: Double) {
            textView.text = abs((priceChange * 100.0).roundToInt() / 100.00).toString()
        }
    }
}