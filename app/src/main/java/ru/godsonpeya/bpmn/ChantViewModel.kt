package ru.godsonpeya.bpmn

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ChantViewModel : ViewModel() {
    // StateFlow pour la liste des chants
    private val _chants = MutableStateFlow<List<String>>(listOf())
    val chants: StateFlow<List<String>> = _chants

    private val _currentChantIndex = MutableStateFlow(0)
    val currentChantIndex: StateFlow<Int> = _currentChantIndex

    init {
        // Simule le chargement des données (cela peut provenir d'une base de données ou d'une API)
        _chants.value = (1..100).map { "Chant $it" }
    }

    fun updateCurrentChantIndex(index: Int) {
        _currentChantIndex.value = index
    }

}
