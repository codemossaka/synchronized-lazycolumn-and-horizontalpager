package ru.godsonpeya.bpmn

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun ChantApp(viewModel: ChantViewModel = viewModel(), modifier: Modifier) {
    val chants = viewModel.chants.collectAsState().value
    val currentChantIndex = viewModel.currentChantIndex.collectAsState().value
    val navController = rememberNavController()
    NavHost(modifier = modifier, navController = navController, startDestination = "chantList") {
        composable("chantList") {
            ChantListScreen(
                chants = chants,
                currentChantIndex = currentChantIndex
            ) { selectedChantIndex ->
                navController.navigate("chantDetail/$selectedChantIndex")
            }
        }
        composable("chantDetail/{chantIndex}") { backStackEntry ->
            val chantIndex = backStackEntry.arguments?.getString("chantIndex")?.toInt() ?: 0
            ChantDetailScreen(
                viewModel = viewModel,
                chants = chants,
                initialChantIndex = chantIndex
            )
        }
    }
}
