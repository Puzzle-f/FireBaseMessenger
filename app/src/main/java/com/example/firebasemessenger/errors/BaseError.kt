package com.example.firebasemessenger.errors

import kotlinx.serialization.Serializable

interface BaseError {
    val code: Code
    val description: String?
}

@Serializable
enum class Code(vararg b: Int){
    BAD_CREDENTIALS,
    BAD_REQUEST,
    NETWORK_ERROR,
    TIMEOUT,
    CANCEL,
    OBJECT_NOT_FOUND,
    OBJECT_ALREADY_EXISTS,
    MISSING_PARAMETER,
    INVALID_PARAMETER,
    INVALID_OPERATION,
    ACCESS_DENIED,
    UNKNOWN_SERVER_ERROR,
    INTERNAL_ERROR,
    UNKNOWN_ERROR
}