package com.ikarimeister.marvelapp.domain.model

data class Hero(
    val id: String,
    val name: String,
    val photo: String?,
    val isAvenger: Boolean,
    val description: String
)
