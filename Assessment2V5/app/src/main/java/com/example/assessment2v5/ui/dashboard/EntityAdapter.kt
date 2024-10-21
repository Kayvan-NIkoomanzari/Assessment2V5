package com.example.assessment2v5.ui.dashboard



import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assessment2v5.R
import com.example.assessment2v5.data.Entity
//EntityAdapter for recycle View
class EntityAdapter(private val entities: MutableList<Entity> = mutableListOf(), private val onButtonClick: (Entity) -> Unit) :
    RecyclerView.Adapter<EntityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_entity, parent, false)
        return EntityViewHolder(view, onButtonClick)
    }

    override fun onBindViewHolder(holder: EntityViewHolder, position: Int) {
        holder.bind(entities[position])
    }

    override fun getItemCount() = entities.size

    fun setData(newEntities: List<Entity>) {
        entities.clear()
        entities.addAll(newEntities)
        notifyDataSetChanged()
    }
}
