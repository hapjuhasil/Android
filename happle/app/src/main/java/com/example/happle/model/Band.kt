package com.example.happle.model

data class Band(
    val id: Int,
    val name: String,
    val description: String,
    val imageResId: Int, // 이미지 리소스 ID를 저장
    val rating: Double,
    val location: String
)
