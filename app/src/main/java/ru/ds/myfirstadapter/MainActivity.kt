package ru.ds.myfirstadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import ru.ds.myfirstadapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var bind: ActivityMainBinding

    //создаем экземпляр класса адаптер
    private var adapter = PlantAdapter()
    //создаем список картинок
    private val imageIDList = listOf(
            R.drawable.edelveis,
            R.drawable.el,
            R.drawable.flore_1,
            R.drawable.flore_2,
            R.drawable.flore_3,)
    //создаем переменную для перебора картинок (для того, что бы их перебтрать)
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
                //запускаем функцию init()
        init()
    }

                //создаем функцию для инициализации
    private fun init() {
        bind.apply {

                //при такой настроке картинки будут списком
                // rcView.layoutManager = LinearLayoutManager(this@MainActivity)
                // при такой настроки картинки будут списком
            rcView.layoutManager = GridLayoutManager(this@MainActivity, 3)
                //добавляем адаптер в rcView
            rcView.adapter = adapter
            //при нажатии добавлем растение
            buttonAdd.setOnClickListener {
                //так как у нас всего 5 картинок то мы будем обнулять индикс когда он будет доходить до крайней картинки
                if (index > 4) index = 0
                //создаем экземпляр класса Plant
                var plant = Plant(imageIDList[index],"Plant $index")
                //передем наше растение в адаптер
                adapter.addPlant(plant)
                index++
            }
        }
    }
}