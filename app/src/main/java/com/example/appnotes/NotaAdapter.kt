package com.example.appnotes
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class NotaAdapter(context: Context, notes: List<Note>) :
    ArrayAdapter<Note>(context, 0, notes) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val itemView = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_note, parent, false)

        val nota = getItem(position)

        val txtNombre = itemView.findViewById<TextView>(R.id.txtNombre)
        val txtMateria = itemView.findViewById<TextView>(R.id.txtMateria)
        val txtNotas = itemView.findViewById<TextView>(R.id.txtNotas)

        txtNombre.text = nota?.nombre
        txtMateria.text = "Materia: ${nota?.materia}"
        txtNotas.text = "Nota 1: ${nota?.nota1} | Nota 2: ${nota?.nota2} | Final: ${nota?.notaFinal}"

        return itemView
    }
}
