package ru.pollypaps.publisheverywhere

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.pollypaps.publisheverywhere.telegram.SendMessage
import kotlinx.coroutines.*
import ru.pollypaps.publisheverywhere.telegram.bot.BotData

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.IO) {
            SendMessage(BotData.TOKEN.value,BotData.CHATID.value,"Hello World")
        }
    }

}