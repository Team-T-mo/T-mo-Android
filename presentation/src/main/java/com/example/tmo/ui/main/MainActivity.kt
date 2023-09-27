package com.example.tmo.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.domain.entity.wikipedia.WikipediaCategoryEntity
import com.example.tmo.R
import com.example.tmo.ui.main.util.extractBiologicalClassification
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.regex.Pattern

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val test = findViewById<TextView>(R.id.test)

        var content = ""
        var category = ""

        // AI에게서 받아온 문자열
        val title = "무궁화"

        test.setOnClickListener {
            viewModel.getWikipedia(title)
            viewModel.getWikipediaCategory(title)
        }

        lifecycleScope.launch {
            viewModel.wikipedia.collectLatest { wikipediaEntity ->
                // wikipediaEntity의 content 필드를 TextView에 설정
                content = wikipediaEntity?.content ?: "null"
                if (wikipediaEntity != null) {
                    Log.d("testt", content)
                }

                test.text = category + content

            }
        }

        lifecycleScope.launch {
            viewModel.wikipediaCategory.collectLatest { wikipediaCategoryEntity ->
                category =
                    wikipediaCategoryEntity?.content?.extractBiologicalClassification() ?: "null"
                if (wikipediaCategoryEntity != null) {
                    Log.d("testt2", category)
                }

                test.text = category + content
            }
        }
    }
}