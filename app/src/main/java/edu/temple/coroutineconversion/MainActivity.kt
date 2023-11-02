package edu.temple.coroutineconversion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    lateinit var cakeImageView: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cakeImageView = findViewById(R.id.imageView)

        findViewById<Button>(R.id.revealButton).setOnClickListener {
            CoroutineScope(Dispatchers.Default).launch {
                repeat(100) {
                    withContext(Dispatchers.Main) {
                        cakeImageView.alpha = it / 100f
                        delay(40)
                    }
                }
            }
        }
    }
}