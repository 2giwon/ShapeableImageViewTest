package com.egiwon.shapeableimageviewtest

import android.os.Bundle
import android.util.TypedValue
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.egiwon.shapeableimageviewtest.databinding.ActivityMainBinding
import com.google.android.material.shape.CornerFamily

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.ivCircle.loadGlideSampleImage()
        binding.ivCircleWithBorder.loadGlideSampleImage()
        binding.ivRounded.loadGlideSampleImage()
        binding.ivRoundedWithBorder.loadGlideSampleImage()

        setShapeImageModel()
    }

    private fun setShapeImageModel() {
        binding.ivTopRounded.shapeAppearanceModel = binding.ivTopRounded.shapeAppearanceModel
            .toBuilder()
            .setTopRightCorner(CornerFamily.ROUNDED, dpToPx(10f))
            .setTopLeftCorner(CornerFamily.ROUNDED, dpToPx(10f))
            .build()
        binding.ivTopRounded.loadGlideSampleImage()
    }

    private fun dpToPx(dp: Float): Float {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp,
            resources.displayMetrics
        )
    }

    private fun ImageView.loadGlideSampleImage() {
        Glide.with(this)
            .load(R.drawable.sample)
            .into(this)
    }
}
