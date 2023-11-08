package com.example.retrofitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import retrofit2.Response
import com.example.retrofitdemo.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var retService: AlbumService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retService = RetrofitInstance
            .getRetrofitInstance()
            .create(AlbumService::class.java)
        getRequestWithQueryParameters()
        //getRequestWithPathParameters()

    }

    private fun getRequestWithQueryParameters() {
        val responseLiveData: LiveData<Response<Albums>> = liveData {
            val response = retService.getSortedAlbums(3)
            emit(response)
        }
        responseLiveData.observe(this, Observer {
            val albumsList = it.body()?.listIterator()
            if (albumsList != null) {
                while (albumsList.hasNext()) {
                    val albumsItem = albumsList.next()
                    val result = " " + "Album Title : ${albumsItem.title}" + "\n" +
                            " " + "Album id : ${albumsItem.id}" + "\n" +
                            " " + "User id : ${albumsItem.userId}" + "\n\n\n"
                    binding.textView.append(result)
                }
            }
        })
    }

    private fun getRequestWithPathParameters() {
        val pathResponse: LiveData<Response<AlbumsItem>> = liveData {
            val response = retService.getAlbum(3)
            emit(response)
        }

        pathResponse.observe(this, Observer {
            val title = it.body()?.title
            Toast.makeText(applicationContext, title, Toast.LENGTH_LONG).show()
        })
    }

}