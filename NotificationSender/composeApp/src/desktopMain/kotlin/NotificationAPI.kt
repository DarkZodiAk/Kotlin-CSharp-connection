import io.ktor.network.selector.SelectorManager
import io.ktor.network.sockets.Socket
import io.ktor.network.sockets.aSocket
import io.ktor.network.sockets.openWriteChannel
import io.ktor.utils.io.ByteWriteChannel
import io.ktor.utils.io.writeStringUtf8
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class NotificationAPI {
    private var selectorManager = SelectorManager(Dispatchers.IO)
    private var socket: Socket? = null
    private var sendChannel: ByteWriteChannel? = null

    init {
        val rt = Runtime.getRuntime()
        rt.exec(arrayOf(".\\NotificationReceiver.exe"))
        CoroutineScope(Dispatchers.IO).launch {
            while(socket == null){
                delay(100L)
                try {
                    socket = aSocket(selectorManager).tcp().connect("127.0.0.1", 8080)
                    sendChannel = socket?.openWriteChannel(autoFlush = true)
                } catch (e: Exception) {
                    if(e is CancellationException) throw e
                }

            }
        }
    }

    fun sendNotification(message: String) {
        CoroutineScope(Dispatchers.IO).launch {
            sendChannel?.let {
                it.writeStringUtf8(message)
                if(message == "exit"){
                    return@launch
                }
            }
        }
    }
}