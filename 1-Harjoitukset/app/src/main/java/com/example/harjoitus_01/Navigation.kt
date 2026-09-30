package com.example.harjoitus_01

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

@Serializable
data object EventListRoute

@Serializable
data class EventDetailRoute(
    val eventId: Int
)

@Serializable
data object TechnologyListRoute

@Serializable
data class TechnologyDetailRoute(
    val technologyId: Int
)

@Serializable
data object CounterViewModelRoute

@Serializable
data object TimerRoute
@Serializable
data object WebsiteRoute

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = EventListRoute
    ) {
        composable<EventListRoute> {
            EventListScreen(
                onEventClick = { eventId ->
                    navController.navigate(
                        EventDetailRoute(
                            eventId = eventId
                        )
                    )
                }
            )
        }

        composable<EventDetailRoute> { backStackEntry ->
            val route = backStackEntry.toRoute<EventDetailRoute>()
            val event = Events.find { it.id == route.eventId }
            if (event != null) {
                EventDetailScreen(
                    event = event,
                    onBackClick = {
                        navController.navigateUp()
                    }
                )
            }
        }

        composable<TechnologyListRoute> {
            TechnologyListScreen(
                onTechnologyClick = { technologyId ->
                    navController.navigate(
                        TechnologyDetailRoute(
                            technologyId = technologyId
                        )
                    )
                })
        }

        composable<TechnologyDetailRoute> { backStackEntry ->

            val route = backStackEntry.toRoute<TechnologyDetailRoute>()

            val technology = ProgrammingTechnologies.find {
                it.id == route.technologyId

            }

            if (technology != null) {
                TechnologyDetailScreen(
                    technology = technology, onBackClick = {
                        navController.navigateUp()
                    })
            }
        }

        composable<CounterViewModelRoute> {
            CounterViewModelScreen()
        }

        composable<TimerRoute> {
            TimerScreen()
        }
        composable<WebsiteRoute> {
            WebsiteScreen()
        }
    }
}