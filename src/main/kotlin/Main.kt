import java.net.InetSocketAddress
import java.net.ServerSocket

val QuotesOfTheDay = arrayOf("Play Team Fortress 2, it's free!\r\n", "Pay Team Fortress, it's not free!\r\n")
const val IP = "0.0.0.0"
const val PORT = 17

fun server() {
    val server = ServerSocket()
    server.bind(InetSocketAddress(IP, PORT))
    println("[ServerSocket] listening on ${server.inetAddress.hostAddress}:${server.localPort}")
    while (!server.isClosed) {
        server.accept().apply {
            getOutputStream().apply {
                write(QuotesOfTheDay[QuotesOfTheDay.indices.random()].encodeToByteArray())
                println("[write] sending random quote of the day to $inetAddress")
            }
            close()
        }
    }
}

fun main() {
    server()
}