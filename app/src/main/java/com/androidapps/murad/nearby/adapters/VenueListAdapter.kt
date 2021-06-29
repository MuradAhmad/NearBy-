/*

package com.androidapps.murad.nearby.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androidapps.murad.nearby.R
import com.androidapps.murad.nearby.models.VenueData
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.card_layout.view.*

@AndroidEntryPoint
class VenueListAdapter: RecyclerView.Adapter<VenueListAdapter.VenueViewHolder>() {

    private var _venueList = emptyList<VenueData>()

    class VenueViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VenueListAdapter.VenueViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent,false)
        return VenueViewHolder(v)
    }

    override fun onBindViewHolder(holder: VenueListAdapter.VenueViewHolder, position: Int) {
        val currentItem = _venueList[position]
        holder.itemView.tvname.text = currentItem.placeName
        holder.itemView.tvaddress.text = currentItem.placeAddress
        holder.itemView.tvaddress.text = currentItem.placeAddress
    }

    override fun getItemCount(): Int {
        return _venueList.size
    }

    fun setData(venue: List<VenueData>){
        this._venueList = venue
    }

}

*/
