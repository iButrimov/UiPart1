package com.example.activityuipart1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.activityuipart1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TEXT_VIEW_TEXT_KEY = "TEXT_VIEW_TEXT_KEY"
    }

    private val binding: ActivityMainBinding by lazy {
        val tmpBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(tmpBinding.root)
        tmpBinding
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.enterButton.setOnClickListener {
            binding.textView2.text = binding.editText.text
        }

        binding.deleteButton.setOnClickListener {
            binding.textView2.text = null
            binding.editText.text = null
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(TEXT_VIEW_TEXT_KEY, binding.textView2.text.toString())
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        savedInstanceState.getString(TEXT_VIEW_TEXT_KEY)?.let {
            binding.textView2.text = it
        }
        super.onRestoreInstanceState(savedInstanceState)
    }
}