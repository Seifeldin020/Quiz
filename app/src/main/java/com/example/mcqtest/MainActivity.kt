package com.example.mcqtest

import android.graphics.fonts.Font
import android.graphics.fonts.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mcqtest.ui.theme.MCQTestTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MCQTestTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Quiz(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Quiz(modifier: Modifier = Modifier){
    var currentPage by remember {mutableStateOf(1)}
    var answer1 by remember {mutableStateOf("")}
    var answer2 by remember {mutableStateOf("")}
    var answer3 by remember {mutableStateOf("")}

    when (currentPage)
    {
        1 -> {
            val options = listOf("True" , "False")
            var selectedOption by remember {mutableStateOf(options[0])}
            Column(modifier = modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)) {

                Text(
                    text = "Question 1\nSeif is the coolest person in the world",
                    style = MaterialTheme.typography.titleMedium
                )

                options.forEach { optionText ->

                    Row(
                        modifier = Modifier.fillMaxWidth().selectable(
                            selected = (optionText == selectedOption),
                            onClick = { selectedOption = optionText }
                        ).padding(vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (optionText == selectedOption),
                            onClick = { selectedOption = optionText }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = optionText)
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically)
                {
                    Button(
                        onClick = { answer1 = selectedOption;
                            currentPage = 2 }) {Text("Next")}
                }


            }
        }
        2 -> {
            val options = listOf("True" , "False")
            var selectedOption by remember {mutableStateOf(options[0])}
            Column(modifier = modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)) {

                Text(
                    text = "Question 2\nSeif is the most handsome guy in gen Z",
                    style = MaterialTheme.typography.titleMedium
                )

                options.forEach { optionText ->

                    Row(
                        modifier = Modifier.fillMaxWidth().selectable(
                            selected = (optionText == selectedOption),
                            onClick = { selectedOption = optionText }
                        ).padding(vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (optionText == selectedOption),
                            onClick = { selectedOption = optionText }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = optionText)
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically)
                {
                    Button(
                        onClick = { currentPage = 1 }) {Text("Back")}

                    Button(
                        onClick = { answer2 = selectedOption;
                            currentPage = 3 }) {Text("Next")}
                }


            }
        }
        3 -> {
            val options = listOf("True" , "False")
            var selectedOption by remember {mutableStateOf(options[0])}
            Column(modifier = modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)) {

                Text(
                    text = "Question 2\nEveryone dreams of being Seif's friend",
                    style = MaterialTheme.typography.titleMedium
                )

                options.forEach { optionText ->

                    Row(
                        modifier = Modifier.fillMaxWidth().selectable(
                            selected = (optionText == selectedOption),
                            onClick = { selectedOption = optionText }
                        ).padding(vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (optionText == selectedOption),
                            onClick = { selectedOption = optionText }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = optionText)
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically)
                {
                    Button(
                        onClick = { currentPage = 2 }) {Text("Back")}

                    Button(
                        onClick = { answer3 = selectedOption;
                            currentPage = 4 }) {Text("Next")}
                }


            }
        }
        4 -> {
            var message1: String = answer1
            var message2: String = answer2
            var message3: String = answer3

            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    if (answer1 == "True") {
                        Text(
                            text = "Your answer for question 1 is: $message1",
                            fontWeight = FontWeight.Bold,
                            color = Color.Green,
                            style = MaterialTheme.typography.titleMedium
                        )
                    } else {
                        Text(
                            text = "Your answer for question 1 is: $message1",
                            fontWeight = FontWeight.Bold,
                            color = Color.Red,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                    if (answer2 == "True") {
                        Text(
                            text = "Your answer for question 2 is: $message2",
                            fontWeight = FontWeight.Bold,
                            color = Color.Green,
                            style = MaterialTheme.typography.titleMedium
                        )
                    } else {
                        Text(
                            text = "Your answer for question 2 is: $message2",
                            fontWeight = FontWeight.Bold,
                            color = Color.Red,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                    if (answer3 == "True") {
                        Text(
                            text = "Your answer for question 3 is: $message3",
                            fontWeight = FontWeight.Bold,
                            color = Color.Green,
                            style = MaterialTheme.typography.titleMedium
                        )
                    } else {
                        Text(
                            text = "Your answer for question 3 is: $message3",
                            fontWeight = FontWeight.Bold,
                            color = Color.Red,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            }

        }
    }


}
