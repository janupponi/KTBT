package com.example.basicmusicplayer

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageButton


import android.widget.SeekBar

class MainActivity : AppCompatActivity() {

    private lateinit var runnable: Runnable
    private var handler= Handler()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val musicplayer: MediaPlayer = MediaPlayer.create(this, R.raw.heat_waves)
        val seek: SeekBar = findViewById(R.id.seek)
        val previous: ImageButton = findViewById(R.id.previous_btn)
        val play: ImageButton = findViewById(R.id.play_btn)
        val next: ImageButton = findViewById(R.id.next_btn)


        seek.progress = 0
        seek.max = musicplayer.duration


        play.setOnClickListener {
            if (!musicplayer.isPlaying) {
                musicplayer.start()
                play.setImageDrawable(getDrawable(R.drawable.pause))
            } else {
                musicplayer.pause()
                play.setImageDrawable(getDrawable(R.drawable.play))
            }

            seek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(p0: SeekBar?, pos: Int, changed: Boolean) {
                    if (changed) {
                        musicplayer.seekTo(pos)
                    }
                }

                override fun onStartTrackingTouch(p0: SeekBar?) {
                }

                override fun onStopTrackingTouch(p0: SeekBar?) {
                }
            })

            runnable = Runnable {
                seek.progress = musicplayer.currentPosition
                handler.postDelayed(runnable, 1000)
            }
            handler.postDelayed(runnable, 1000)

            musicplayer.setOnCompletionListener {
                play.setImageResource(R.drawable.play)
                seek.progress = 0

            }
        }

        previous.setOnClickListener {
            musicplayer.seekTo(0)
        }

        next.setOnClickListener {
            musicplayer.seekTo(0)
        }
    }
}
