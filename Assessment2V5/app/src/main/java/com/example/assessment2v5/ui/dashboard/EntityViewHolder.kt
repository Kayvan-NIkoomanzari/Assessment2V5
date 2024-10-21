package com.example.assessment2v5.ui.dashboard




import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assessment2v5.R
import com.example.assessment2v5.data.Entity
//EntityViewHolder for recycle View
class EntityViewHolder(view: View, private val onButtonClick: (Entity) -> Unit) : RecyclerView.ViewHolder(view) {

    private val assetTypeTextView: TextView = view.findViewById(R.id.tvAssetType)
    private val tickerTextView: TextView = view.findViewById(R.id.tvTicker)
    private val currentPriceTextView: TextView = view.findViewById(R.id.tvCurrentPrice)
    private val dividendYieldTextView: TextView = view.findViewById(R.id.tvDividendYield)
    private val showDescriptionButton: Button = view.findViewById(R.id.btnShowDescription)

    fun bind(entity: Entity) {
        assetTypeTextView.text = entity.assetType
        tickerTextView.text = entity.ticker
        currentPriceTextView.text = entity.currentPrice.toString()
        dividendYieldTextView.text = entity.dividendYield.toString()

        // Button click listener to navigate to details
        showDescriptionButton.setOnClickListener {
            onButtonClick(entity)
        }
    }
}
