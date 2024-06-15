import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

fun main() = application {
    val notificationAPI = remember { NotificationAPI() }
    var message by remember { mutableStateOf("") }

    Window(
        onCloseRequest = {
            notificationAPI.sendNotification("exit")
            exitApplication()
        },
        title = "NotificationSender",
        state = WindowState(width = 300.dp, height = 300.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            BasicTextField(
                value = message,
                onValueChange = {
                    message = it
                },
                modifier = Modifier
                    .border(2.dp, Color.Black)
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    notificationAPI.sendNotification(message)
                    if(message == "exit") exitApplication()
                    message = ""
                }
            ) {
                Text("Send notification")
            }
        }
    }
}