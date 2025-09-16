package com.example.assignmenttwo_q3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.assignmenttwo_q3.ui.theme.AssignmentTwo_Q3Theme
//New Imports!
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.HorizontalDivider


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AssignmentTwo_Q3Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    KotlinPracticeScreen()
                }
            }
        }
    }
}

@Composable
fun KotlinPracticeScreen() {
    var selectedAnimal by rememberSaveable { mutableStateOf("") }
    var nullableString by rememberSaveable { mutableStateOf<String?>(null) }
    var counter by rememberSaveable { mutableStateOf(0) }

    // When expression for animal sounds
    val animalResult = when (selectedAnimal) {
        "cat" -> "Meow! Cats are independent and curious."
        "dog" -> "Woof! Dogs are loyal and friendly."
        "fish" -> "Blub! Fish are quiet and peaceful."
        "bird" -> "Tweet! Birds can fly and sing beautifully."
        "elephant" -> "Trumpet! Elephants are wise and gentle giants."
        "" -> "Select an animal to see what they say!"
        else -> "Hmm, I don't know what a $selectedAnimal says..."
    }

    // Nullable string with ?.let demonstration
    val nullableResult = nullableString?.let { text ->
        "Message received: \"$text\" (Length: ${text.length} characters)"
    } ?: "No message available (string is null)"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            text = "Kotlin Practice Screen",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center
        )

        HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)

        // SECTION 1: When Expression Demo
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "When Expression Demo",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    text = animalResult,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                // Animal selection buttons
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    listOf("cat", "dog", "fish").forEach { animal ->
                        Button(
                            onClick = { selectedAnimal = animal },
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (selectedAnimal == animal)
                                    MaterialTheme.colorScheme.secondary
                                else MaterialTheme.colorScheme.primary
                            )
                        ) {
                            Text(animal, fontSize = 12.sp)
                        }
                    }
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = { selectedAnimal = "bird" },
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (selectedAnimal == "bird")
                                MaterialTheme.colorScheme.secondary
                            else MaterialTheme.colorScheme.primary
                        )
                    ) {
                        Text("bird", fontSize = 12.sp)
                    }
                    Button(
                        onClick = { selectedAnimal = "elephant" },
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (selectedAnimal == "elephant")
                                MaterialTheme.colorScheme.secondary
                            else MaterialTheme.colorScheme.primary
                        )
                    ) {
                        Text("elephant", fontSize = 12.sp)
                    }
                }
            }
        }

        // SECTION 2: Nullable String with ?.let Demo
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "Nullable String (?.let) Demo",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    text = nullableResult,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = { nullableString = "Hello Kotlin!" },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Set Message", fontSize = 12.sp)
                    }
                    Button(
                        onClick = { nullableString = "Compose is awesome!" },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Set Another", fontSize = 12.sp)
                    }
                    Button(
                        onClick = { nullableString = null },
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.error
                        )
                    ) {
                        Text("Set Null", fontSize = 12.sp)
                    }
                }
            }
        }

        // SECTION 3: Conditional Counter Demo
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "Conditional Counter Demo",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    text = "Counter: $counter",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (counter >= 5) Color.Red else MaterialTheme.colorScheme.primary
                )

                Text(
                    text = if (counter >= 5) "Maximum reached!" else "Can still increment",
                    fontSize = 14.sp,
                    color = if (counter >= 5) Color.Red else Color.Green
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Button(
                        onClick = {
                            // Only increment if below 5
                            if (counter < 5) {
                                counter++
                            }
                        },
                        enabled = counter < 5
                    ) {
                        Text("Increment")
                    }

                    Button(
                        onClick = { counter = 0 },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.secondary
                        )
                    ) {
                        Text("Reset")
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
    }
}


@Preview(showBackground = true)
@Composable
fun KotlinPracticeScreenPreview() {
    AssignmentTwo_Q3Theme {
        KotlinPracticeScreen()
    }
}

//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
