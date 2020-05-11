package com.example.rootservice.models

class UserRequestResponse{
    var username: String = ""
    var booksRead : MutableList<BookInfoResponse> = mutableListOf<BookInfoResponse>()
    var booksToRead : MutableList<BookInfoResponse> = mutableListOf<BookInfoResponse>()
}