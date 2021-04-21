package com.jccsisc.tinynetflix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jccsisc.tinynetflix.adapter.SectionAdapter
import com.jccsisc.tinynetflix.databinding.ActivityMainBinding
import com.jccsisc.tinynetflix.model.SectionModel

class MainActivity : AppCompatActivity() {

    lateinit var mBinding: ActivityMainBinding
    val sectionAdapter = SectionAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.apply {
            rvSection.adapter = sectionAdapter
            sectionAdapter.submitList(listSectionMovies())
        }
    }

    fun listSectionMovies(): List<SectionModel> {
        val section1 = SectionModel("Fantasia")
        val section2 = SectionModel("Comedia")
        val section3 = SectionModel("Terror")
        val section4 = SectionModel("Drama")
        val section5 = SectionModel("Suspenso")

        return listOf(section1, section2, section3, section4, section5)
    }
}