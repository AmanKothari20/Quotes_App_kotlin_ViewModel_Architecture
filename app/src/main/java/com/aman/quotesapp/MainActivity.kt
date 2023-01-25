package com.aman.quotesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.aman.quotesapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  DataBindingUtil.setContentView(this,R.layout.activity_main)

        mainViewModel = ViewModelProvider(this,MainViewModelFactory(application)).get(MainViewModel::class.java)
        setQuote(mainViewModel.getQuote())

        binding.nextBtn.setOnClickListener{
            onNext()
        }
        binding.previousBtn.setOnClickListener{
            onPrevious()
        }
    }

    private fun setQuote(quote: Quote) {
        Log.d("Main", "${quote.text} ${quote.author}")
        binding.quote = quote
    }


    private fun onNext() {
        setQuote(mainViewModel.nextQuote())
    }
    private fun onPrevious() {
        setQuote(mainViewModel.prevQuote())
    }
}