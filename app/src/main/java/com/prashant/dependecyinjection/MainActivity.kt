package com.prashant.dependecyinjection

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.prashant.dependecyinjection.roomdb.Note
import com.prashant.dependecyinjection.ui.theme.DependencyInjectionTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DependencyInjectionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }

    @Composable
    fun Greeting(vm: MainActivityViewModel = hiltViewModel()) {
        val breedItems by vm.getAllNotes.observeAsState()


        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = "ID:123\nName: Prashant Singh")
            Button(onClick = {
                vm.add(
                    Note(
                        title = "Prashant Singh",
                    )
                )
            }) {
                Text(text = "Add Data")
            }

            Button(onClick = {
                Log.e("TAG", "Greeting: $breedItems")
//                mainActivityVM.deleteAllNotes()
            }) {
                Text(text = "Retrieve")
            }
            Button(onClick = {
                vm.note = vm.getById(4)
            }) {
                Text(text = "Retrieve id 4")
            }

            /*if(vm.note.isIn){
                Text(text = vm.note.title)
            }*/

        }

    }


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        DependencyInjectionTheme {
            Greeting()
        }
    }
}

