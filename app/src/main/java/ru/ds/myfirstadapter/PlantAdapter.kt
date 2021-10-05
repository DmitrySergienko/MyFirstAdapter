package ru.ds.myfirstadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.ds.myfirstadapter.databinding.PlantItemBinding

//1. наследуемся от RecyclerView
class PlantAdapter:RecyclerView.Adapter<PlantAdapter.PlantHolder>() {
//создаем список наших элементов
        val plantList = ArrayList<Plant>()

//2. создаем класс который хранит ссылки на наши элементы списка и имплементируем 3 метода
    class PlantHolder(item: View):RecyclerView.ViewHolder(item) {
        val binding = PlantItemBinding.bind(item)
        fun bind(plant: Plant) = with(binding){
            im.setImageResource(plant.imageId)
            tvTitle.text = plant.title

        }

    }
//3 метода имплементируются вместе с классом PlantAdapter
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantHolder {
//создаем элемент view
        val view = LayoutInflater.from(parent.context).inflate(R.layout.plant_item, parent,false)
    return PlantHolder(view)
    }
//заполняется элемент
    override fun onBindViewHolder(holder: PlantHolder, position: Int) {
        holder.bind(plantList[position])
    }
//передаем размер массива
    override fun getItemCount(): Int {
        return plantList.size
    }
//создаем новый элемент
    fun addPlant(plant: Plant){
        plantList.add(plant)
//система проверяет изменение данных
        notifyDataSetChanged()
    }

    //если у нас есть готовый список, который мы хотим добавить в адптер
   // fun addAll(list: List<Plant>){
   //     plantList.clear() // стираем старый список если требуется
   //     plantList.addAll(list) // передаем новый список
   //     notifyDataSetChanged() //система проверяет изменение данных
   // }

}