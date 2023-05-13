package com.atilsamancioglu.makingregularflowstateful

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.atilsamancioglu.makingregularflowstateful.ui.theme.MakingRegularFlowStatefulTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MakingRegularFlowStatefulTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "firstScreen"){
                        composable(route = "firstScreen") {
                            val viewModel = viewModel<FirstScreenVM>()
                            val time by viewModel.counter.collectAsState()
                            FirstScreen(
                                time = time,
                            onButtonClicked = {
                                navController.navigate("secondScreen")
                            }
                                )

                            }

                        composable("secondScreen") {
                            SecondScreen()
                        }
                    }

                }
            }
        }
    }
}

