package com.example.firebasemessenger.errors

data class AppError(
    val uid: String? = null,
    override val code: Code = Code.UNKNOWN_ERROR,
    override val description: String? = null,
) : BaseError, Error()