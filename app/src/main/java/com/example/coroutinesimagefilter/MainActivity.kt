package com.example.coroutinesimagefilter

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.devtides.imageprocessingcoroutines.Filter
import com.example.coroutinesimagefilter.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.net.URL

class MainActivity : AppCompatActivity() {

    private val IMAGE_URL = "https://raw.githubusercontent.com/DevTides/JetpackDogsApp/master/app/src/main/res/drawable/dog.png"
    private val courotineScope = CoroutineScope(Dispatchers.Main)
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        courotineScope.launch {
            val originalDeferred = courotineScope.async(Dispatchers.IO){ getOriginalBitmap()}
            val originalBitmap = originalDeferred.await()
            val filteredDeferred = courotineScope.async(Dispatchers.Default) { applyFilter(originalBitmap) }
            val filteredBitmap = filteredDeferred.await()
            loadImage(filteredBitmap)
        }
    }


    private fun getOriginalBitmap(): Bitmap =
        URL(IMAGE_URL).openStream().use {
            BitmapFactory.decodeStream(it)
        }

    private fun loadImage(bitmap: Bitmap){
        binding.progressBar.visibility = View.GONE
        binding.imageView.setImageBitmap(bitmap)
        binding.imageView.visibility = View.VISIBLE
    }

    private fun applyFilter(bitmap: Bitmap) = Filter.apply(bitmap)
}
