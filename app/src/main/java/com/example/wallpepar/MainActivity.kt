package com.example.wallpepar
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wallpepar.Adapter.WallpaperAdapter
import com.example.wallpepar.Model.PhotosItem
import com.example.wallpepar.Model.wallpeparModel
import com.example.wallpepar.api.ApiInterface
import com.example.wallpepar.api.apiclient
import com.example.wallpepar.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: WallpaperAdapter
    var auth = "tJCyTiaz7mjtevZkfdemL7rGVEkUnNpcumf60Stl3KTX4gL32sW6r77G"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = WallpaperAdapter()
        binding.imgsearch.setOnClickListener {
            callAPI()
        }
    }

    private fun callAPI() {
//        var auth = "tJCyTiaz7mjtevZkfdemL7rGVEkUnNpcumf60Stl3KTX4gL32sW6r77G"
        var text = binding.edtsearch.text.toString()

        var api: ApiInterface = apiclient.getclient().create(ApiInterface::class.java)
        api?.getPhotos(auth, text)?.enqueue(object : Callback<wallpeparModel> {
            override fun onResponse(call: Call<wallpeparModel>, response: Response<wallpeparModel>) {
                if (response.isSuccessful) {
                    var wallpaper = response.body()?.photos
                    adapter.setwallpepar(wallpaper as List<PhotosItem>?)
                    binding.rcv.layoutManager = GridLayoutManager(this@MainActivity, 2)
                    binding.rcv.adapter = adapter

                    Toast.makeText(this@MainActivity, "sssssss", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<wallpeparModel>, t: Throwable) {
            }
        })
    }
}