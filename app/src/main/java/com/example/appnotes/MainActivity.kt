package com.example.appnotes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import android.widget.ListView
import com.example.appnotes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listNotas)

        val notas = mutableListOf<Note>()
        try {
            val input = assets.open("notas.csv").bufferedReader()
            input.readLine()
            val notas = input.lineSequence().mapNotNull {
                try {
                    val campos = it.split(",")
                    Note(
                        campos[0],
                        campos[1],
                        campos[2].toInt(),
                        campos[3].toInt(),
                        campos[4].toDouble()
                    )
                } catch (e: Exception) {
                    null
                }
            }.toList()
            val adapter = NotaAdapter(this, notas)
            listView.adapter = adapter
        } catch (e: Exception) {
            e.printStackTrace() // Esto lo ves en Logcat
        }
    }
}