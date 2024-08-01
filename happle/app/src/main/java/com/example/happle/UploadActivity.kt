package com.example.happle

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class UploadActivity : AppCompatActivity() {

    private val PICK_VIDEO_REQUEST = 1
    private var selectedVideoUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload)

        val imgUpload: ImageView = findViewById(R.id.img_upload)

        imgUpload.setOnClickListener {
            openGallery()
        }
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "*/*"
        startActivityForResult(intent, PICK_VIDEO_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_VIDEO_REQUEST && resultCode == RESULT_OK) {
            selectedVideoUri = data?.data
            // 선택한 영상의 URI를 활용하여 필요한 작업 수행
            // 예를 들어, 비디오를 미리보기에 보여주거나 정보를 가져오는 등의 작업
        }
    }
}
