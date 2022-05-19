package org.yosef.cwt.screns

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import org.yosef.cwt.data.DataOrException
import java.lang.reflect.Modifier
import java.util.logging.Filter

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val textData = produceState<DataOrException<String, Boolean, Exception>>(
        initialValue = DataOrException(loading = true)
    ) {
        value = viewModel.getData()
    }.value

    if (textData.loading == true) {
        CircularProgressIndicator()
    } else {
        showData(navController = navController, data = textData.data)
    }
}

@Composable
fun showData(navController: NavController, data: String?) {

    Column() {
        Surface {
            Column() {

                var text by remember { mutableStateOf(data.toString()) }

                Row {
                    Button(onClick = {
                        val r = text.filter {
                            it.isDigit().not()
                        }
                        text = r.replace(".", "")

                    }) {
                        Text(text = "Filter")
                    }

                    Button(onClick = {
                        text = data.toString()
                    }) {
                        Text(text = "Refresh")
                    }
                }

                Text(

                    text = text
                )
            }

        }
    }
}


