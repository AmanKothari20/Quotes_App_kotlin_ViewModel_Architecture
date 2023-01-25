package com.aman.quotesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel:MainViewModel
    private val quoteBody : TextView
    get() = findViewById(R.id.quoteBody)
    private val quoteAuthor : TextView
    get()= findViewById(R.id.quoteAuthor)
    private val nextBtn : TextView
    get() = findViewById(R.id.nextBtn)
    private val prevBtn : TextView
    get() = findViewById(R.id.previousBtn)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this,MainViewModelFactory(application)).get(MainViewModel::class.java)
        setQuote(mainViewModel.getQuote())

        nextBtn.setOnClickListener{
            onNext()
        }
        prevBtn.setOnClickListener{
            onPrevious()
        }
    }

    private fun setQuote(quote: Quote) {
        Log.d("Main","${quote.text} ${quote.author}")
        quoteBody.text = quote.text
        quoteAuthor.text = quote.author
    }


    private fun onNext() {
        setQuote(mainViewModel.nextQuote())
    }
    private fun onPrevious() {
        setQuote(mainViewModel.prevQuote())
    }
}