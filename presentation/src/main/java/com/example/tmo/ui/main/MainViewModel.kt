package com.example.tmo.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.detail_search.DetailSearchEntity
import com.example.domain.entity.wikipedia.WikipediaCategoryEntity
import com.example.domain.entity.wikipedia.WikipediaEntity
import com.example.domain.usecase.detail_search.DetailSearchUseCase
import com.example.domain.usecase.wikipedia.WikipediaCategoryUseCase
import com.example.domain.usecase.wikipedia.WikipediaUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val detailSearchUseCase: DetailSearchUseCase,
    private val wikipediaUseCase: WikipediaUseCase,
    private val wikipediaCategoryUseCase: WikipediaCategoryUseCase
): ViewModel() {

    private val _detailSearchList = MutableStateFlow<DetailSearchEntity?>(null)
    val detailSearchList: StateFlow<DetailSearchEntity?> = _detailSearchList

    private val _wikipedia = MutableStateFlow<WikipediaEntity?>(null)
    val wikipedia: StateFlow<WikipediaEntity?> = _wikipedia

    private val _wikipediaCategory = MutableStateFlow<WikipediaCategoryEntity?>(null)
    val wikipediaCategory: StateFlow<WikipediaCategoryEntity?> = _wikipediaCategory

    fun getSearchList(id: Int) = viewModelScope.launch {
        _detailSearchList.value = detailSearchUseCase(id).firstOrNull()
    }

    fun getWikipedia(title: String) = viewModelScope.launch{
        _wikipedia.value = wikipediaUseCase(title).firstOrNull()
    }

    fun getWikipediaCategory(title: String) = viewModelScope.launch{
        _wikipediaCategory.value = wikipediaCategoryUseCase(title).firstOrNull()
    }
}