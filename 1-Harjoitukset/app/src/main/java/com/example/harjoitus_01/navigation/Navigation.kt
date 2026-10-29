package com.example.harjoitus_01.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.harjoitus_01.ui.converter.Converter
import com.example.harjoitus_01.ui.counter.CounterViewModelScreen
import com.example.harjoitus_01.ui.event.EventDetailScreen
import com.example.harjoitus_01.ui.event.EventListScreen
import com.example.harjoitus_01.ui.event.Events
import com.example.harjoitus_01.ui.portfolio.PortfolioScreen
import com.example.harjoitus_01.ui.profile.ProfileScreen
import com.example.harjoitus_01.ui.registration.RegistrationScreen
import com.example.harjoitus_01.ui.technology.ProgrammingTechnologies
import com.example.harjoitus_01.ui.technology.TechnologyDetailScreen
import com.example.harjoitus_01.ui.technology.TechnologyListScreen
import com.example.harjoitus_01.ui.timer.TimerScreen
import com.example.harjoitus_01.ui.website.WebsiteScreen
import kotlinx.serialization.Serializable

@Serializable
data object ProfileRoute

@Serializable
data object PortfolioRoute

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
data object ConverterRoute

@Serializable
data object RegistrationRoute

@Serializable
data object WebsiteRoute

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            PortfolioBottomBar(
                navController = navController
            )
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = ProfileRoute,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable<ProfileRoute> {
                ProfileScreen()
            }

            composable<PortfolioRoute> {
                PortfolioScreen(
                    onEventsClick = {
                        navController.navigate(EventListRoute)
                    },
                    onTechnologiesClick = {
                        navController.navigate(TechnologyListRoute)
                    },
                    onCounterClick = {
                        navController.navigate(CounterViewModelRoute)
                    },
                    onTimerClick = {
                        navController.navigate(TimerRoute)
                    },
                    onConverterClick = {
                        navController.navigate(ConverterRoute)
                    },
                    onRegistrationClick = {
                        navController.navigate(RegistrationRoute)
                    },
                    onWebsiteClick = {
                        navController.navigate(WebsiteRoute)
                    }
                )
            }

            composable<EventListRoute> {
                EventListScreen(
                    onEventClick = { eventId ->
                        navController.navigate(
                            EventDetailRoute(eventId)
                        )
                    },
                    onBackClick = {
                        navController.navigateUp()
                    }
                )
            }

            composable<EventDetailRoute> { backStackEntry ->
                val route = backStackEntry.toRoute<EventDetailRoute>()

                val event = Events.find {
                    it.id == route.eventId
                }

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
                            TechnologyDetailRoute(technologyId)
                        )
                    },
                    onBackClick = {
                        navController.navigateUp()
                    }
                )
            }

            composable<TechnologyDetailRoute> { backStackEntry ->
                val route = backStackEntry.toRoute<TechnologyDetailRoute>()

                val technology = ProgrammingTechnologies.find {
                    it.id == route.technologyId
                }

                if (technology != null) {
                    TechnologyDetailScreen(
                        technology = technology,
                        onBackClick = {
                            navController.navigateUp()
                        }
                    )
                }
            }

            composable<CounterViewModelRoute> {
                CounterViewModelScreen(
                    onBackClick = {
                        navController.navigateUp()
                    }
                )
            }

            composable<TimerRoute> {
                TimerScreen(
                    onBackClick = {
                        navController.navigateUp()
                    }
                )
            }

            composable<ConverterRoute> {
                Converter(
                    onBackClick = {
                        navController.navigateUp()
                    }
                )
            }

            composable<RegistrationRoute> {
                RegistrationScreen(
                    onBackClick = {
                        navController.navigateUp()
                    }
                )
            }

            composable<WebsiteRoute> {
                WebsiteScreen(
                    onBackClick = {
                        navController.navigateUp()
                    }
                )
            }
        }
    }
}
