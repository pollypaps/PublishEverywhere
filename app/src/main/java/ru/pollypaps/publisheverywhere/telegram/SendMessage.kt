package ru.pollypaps.publisheverywhere.telegram

import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.URL
import java.net.URLConnection

class SendMessage(token:String,chatID:String,msg:String){

    init {
        var urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s"
        urlString = String.format(urlString, token, chatID, msg);
        val url: URL? = URL(urlString)
        val conn: URLConnection = url!!.openConnection()
        val sb = StringBuilder()
        val inputStream: InputStream = BufferedInputStream(conn.getInputStream())
        val br = BufferedReader(InputStreamReader(inputStream))
        var inputLine: String? = ""
        while (br.readLine().also { inputLine = it } != null) {
            sb.append(inputLine)
        }
        val response = sb.toString()
    }
}