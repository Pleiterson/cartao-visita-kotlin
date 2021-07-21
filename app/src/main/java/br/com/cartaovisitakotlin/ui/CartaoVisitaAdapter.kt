package br.com.cartaovisitakotlin.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.cartaovisitakotlin.data.CartaoVisita
import br.com.cartaovisitakotlin.databinding.ItemCartaoVisitaBinding

class CartaoVisitaAdapter :
    ListAdapter<CartaoVisita, CartaoVisitaAdapter.ViewHolder>(DiffCallback()) {

    var listenerShare: (View) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCartaoVisitaBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemCartaoVisitaBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CartaoVisita) {
            binding.tvNome.text = item.nome
            binding.tvTelefone.text = item.telefone
            binding.tvEmail.text = item.email
            binding.tvNomeEmpresa.text = item.empresa
            binding.cdContent.setCardBackgroundColor(Color.parseColor(item.fundoPersonalizado))
            binding.cdContent.setOnClickListener {
                listenerShare(it)
            }
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<CartaoVisita>() {
    override fun areItemsTheSame(oldItem: CartaoVisita, newItem: CartaoVisita) = oldItem == newItem
    override fun areContentsTheSame(oldItem: CartaoVisita, newItem: CartaoVisita) =
        oldItem.id == newItem.id
}