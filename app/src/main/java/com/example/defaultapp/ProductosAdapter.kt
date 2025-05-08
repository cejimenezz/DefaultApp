package com.example.defaultapp


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.defaultapp.R
import com.example.defaultapp.Productos

class ProductosAdapter(var lista :ArrayList<Productos>, var context: Context) : RecyclerView.Adapter<ProductosAdapter.MyHolder>() {

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        // sacar cada uno de los elementos que conforman nuestra plantilla del RecyclerView
        val imagen : ImageView = itemView.findViewById(R.id.imagenProducto)
        val texto : TextView = itemView.findViewById(R.id.textNombreProducto)
        val precio : TextView = itemView.findViewById(R.id.textPrecioProducto)
        val botonAgregar : ImageButton = itemView.findViewById(R.id.buttonAgregar)
        val labelProducto : TextView = itemView.findViewById(R.id.textRecomendado)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        //asocia el XML con el Holder - "MyHolder" lo que tengo que hacer es enlazar el XML a una vista
        //INFLó EL XML, LO CONVIRTIÓ A TIPO VISTA Y SE LO PASÓ AL MyHolder

        val vista :View = LayoutInflater.from(context).inflate(R.layout.item_producto,parent,false)

        return MyHolder(vista)
    }

    override fun getItemCount(): Int {
        //Cuantas filas va a pintar?

        return lista.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        // pinta cada fila con su valor

        var producto : Productos = lista[position]
        holder.imagen.setImageResource(producto.imagenProducto)
        holder.texto.text = producto.nombreProducto.toString()
        holder.precio.text = producto.precioProducto.toString()
        if(producto.oferta){
            holder.labelProducto.text = "Oferta"
            holder.labelProducto.background = context.getDrawable(R.color.azulTextoFuerte)
        }
        else if(producto.recomendado){
            holder.labelProducto.text = "Recomendado"
            holder.labelProducto.background = context.getDrawable(R.color.naranja_card)
        }
        else{
            holder.labelProducto.visibility = View.GONE
        }
    }
}