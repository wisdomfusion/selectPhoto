package com.common.select_pictures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.common.photo.EasyPhotos
import com.common.photo.callback.SelectCallback
import com.common.photo.models.album.entity.Photo
import com.common.photo.ui.EasyPhotosActivity
import com.common.photo.utils.bitmap.BitmapUtils
import com.common.select_pictures.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnPhoto.setOnClickListener {
            Toast.makeText(this, "点击了～", Toast.LENGTH_SHORT).show()
            selectPicture()
        }
        binding.btnTakePhoto.setOnClickListener {
            Toast.makeText(this, "点击了～", Toast.LENGTH_SHORT).show()
            takePhoto()
        }
    }

    private fun takePhoto() {
        EasyPhotos.createCamera(this, false).setFileProviderAuthority("$packageName.fileprovider")
            .start(object : SelectCallback() {
                override fun onResult(
                    photos: ArrayList<Photo>, isOriginal: Boolean
                ) {
                    if (photos.isNotEmpty()) {
                        val photo = photos[0]
                        Toast.makeText(this@MainActivity, photo.path, Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onCancel() {

                }
            })
    }

    private fun selectPicture() {
        EasyPhotos.createAlbum(
            this, false, false, GlideEngine.getInstance()
        ).setFileProviderAuthority("$packageName.fileprovider").start(object : SelectCallback() {
                override fun onResult(
                    photos: ArrayList<Photo>, isOriginal: Boolean
                ) {
                    if (photos.isNotEmpty()) {
                        val photo = photos[0]
                        Toast.makeText(this@MainActivity, photo.path, Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onCancel() {

                }
            })
    }
}