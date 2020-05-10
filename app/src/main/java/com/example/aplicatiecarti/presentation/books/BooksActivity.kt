package com.example.aplicatiecarti.presentation.books

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicatiecarti.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.include_toolbar.*

class BooksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbarMain.title=getString(R.string.books_title)
        setSupportActionBar(toolbarMain)

        with(recyclerBooks) {
            layoutManager = LinearLayoutManager(this@BooksActivity, RecyclerView.VERTICAL, false)
            setHasFixedSize(true)
            adapter = BooksAdapter(books) { book ->
                val intent = BookDetailsActivity.getStartIntent(this@BooksActivity, books.title, books.description)
                this@BooksActivity.startActivity(intent)
            }
        }
    }
})

viewModel.viewFlipperLiveData.observe(this, Observer {
    it?.let { viewFlipper ->
        viewFlipperBooks.displayedChild = viewFlipper.first

        viewFlipper.second?.let { errorMessageResId ->
            textViewError.text = getString(errorMessageResId)
        }
    }
})

viewModel.getBooks()
}
}
