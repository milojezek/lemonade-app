package eu.milo4apps.lemonadecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import eu.milo4apps.lemonadecompose.ui.theme.LemonadeComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeComposeTheme {
                LemonadeApp()
            }
        }
    }
}

@Composable
fun LemonadeImageAndText(modifier: Modifier = Modifier) {
    var currentState by remember { mutableStateOf(1) }
    val textResource = when(currentState) {
        1 -> R.string.select_lemon
        2 -> R.string.squeeze_lemon
        3 -> R.string.drink_lemonade
        else -> R.string.start_again
    }

    val imageResource = when(currentState) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    val descriptionResource = when(currentState) {
        1 -> R.string.lemon_tree
        2 -> R.string.lemon
        3 -> R.string.glass_of_lemonade
        else -> R.string.empty_glass
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(textResource),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold ,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Image(
            painter = painterResource(imageResource),
            contentDescription = stringResource(descriptionResource),
            modifier = Modifier
                .border(2.dp, Color.LightGray, RectangleShape)
                .padding(8.dp)
                .clickable {
                    if (currentState < 4) {
                        currentState++
                    } else {
                        currentState = 1
                    }
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    LemonadeImageAndText(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}