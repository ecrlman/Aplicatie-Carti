package com.example.aplicatiecarti.data.repository

import com.example.aplicatiecarti.data.BooksResult

interface BooksRepository {

    fun getBooks(booksResultCallback: (result: BooksResult) -> Unit)
}