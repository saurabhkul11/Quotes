package com.example.android.quotes.models

data class User(
    val id: Int? = null,
    val name: String? = null,
    val userName: String? = null,
    val email: String? = null,
    val address : Address? = null,
    val phone: String? = null,
    val website: String? = null
)
data class Address(
    val street: String? = null,
    val suite: String? = null,
    val city: String? = null,
    val zipCode: String? = null
)