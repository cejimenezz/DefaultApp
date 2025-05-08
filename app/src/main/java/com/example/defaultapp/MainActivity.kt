package com.example.defaultapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.defaultapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //crear un objeto del tipo de mi adaptador
    private lateinit var adapter: ProductosAdapter
    //crear un arrayList
    private lateinit var listaproductos: ArrayList <Productos>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //instancio el arrayList y le meto sus datos
        listaproductos = arrayListOf(
            Productos("Pizza Margarita","17.50€", R.drawable.pizza,true,false),
            Productos("Pizza Peperoni","15.0€", R.drawable.pizza,false,false),
            Productos("Pizza Diabola","19.25€", R.drawable.pizza,false,false),
            Productos("Pizza Campesina","10.0€", R.drawable.pizza,false,true),
            Productos("Pizza Pork","13.50€", R.drawable.pizza,false,false),
            Productos("Pizza Especial","15.50€", R.drawable.pizza,true,false),
            Productos("Pizza York","15.50€", R.drawable.pizza,false,false),
            Productos("Pizza Bacon","12.00€", R.drawable.pizza,false,true),
            Productos("Pizza Vegetal","11.50€", R.drawable.pizza,false,false),
            Productos("Pizza Bao","17.50€", R.drawable.pizza,true,false),
            Productos("Pizza 4 Quesos","15€", R.drawable.pizza,true,false),
            Productos("Pizza Chili","13.50€", R.drawable.pizza,false,true)
        )
        //inicializar el objeto de mi adaptador ---SIEMPRE "this"
        adapter = ProductosAdapter(listaproductos,this)

        // enlazo o asocio el adaptador del RecyclerView en el XML al adaptador que he creado yo
        binding.recyclerProductos.adapter = adapter

        // le especifico el tipo de layout que se va a usar en el RecyclerView
        binding.recyclerProductos.layoutManager = GridLayoutManager(this,4)

    }
}