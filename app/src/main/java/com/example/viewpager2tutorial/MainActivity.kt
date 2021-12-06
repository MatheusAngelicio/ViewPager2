package com.example.viewpager2tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpager2tutorial.databinding.ActivityMainBinding
import me.relex.circleindicator.CircleIndicator3

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var titleList = mutableListOf<String>()
    private var descList = mutableListOf<String>()
    private var imagesList = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        postToList()

        with(binding) {
            viewPager2.adapter = ViewPagerAdapter(titleList, descList, imagesList)
            viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

            val indicator = findViewById<CircleIndicator3>(R.id.indicator)
            indicator.setViewPager(viewPager2)

            with(binding) {
                btnFakeSwipe.setOnClickListener {
                    viewPager2.apply {
                        beginFakeDrag()
                        fakeDragBy(-10f)
                        endFakeDrag()
                    }
                }
            }
        }
    }

    private fun addToList(title: String, description: String, image: Int) {
        titleList.add(title)
        descList.add(description)
        imagesList.add(image)
    }

    private fun postToList() {
        /*for (i in 1..5) {
            addToList("Tile $i", "Description $i", R.mipmap.ic_launcher_round)
        }*/
        addToList("Spider-man", "no way home", R.drawable.spider)
        addToList("Resident evil", "welcome to raccoon city", R.drawable.resident_evil)
        addToList("Venom", "let There Be Carnage", R.drawable.venom)
        addToList("Ghostbusters", "afterlife", R.drawable.ghost)

    }
}