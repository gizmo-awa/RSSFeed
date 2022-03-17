package com.example.rssfeed

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class ApplicationsAdapter(context: Context, feedEntries: ArrayList<FeedEntry>):
    RecyclerView.Adapter<ApplicationsAdapter.ViewHolder> () {
    private var localContext: Context? = null
    private var localFeedEntries: ArrayList<FeedEntry>? = null
    init {
        localContext = context
        localFeedEntries = feedEntries
    }

    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int): ApplicationsAdapter.ViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(localContext) //referencia a main activity
        val view: View = layoutInflater.inflate(R.layout.feed_artistas, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ApplicationsAdapter.ViewHolder, position: Int) {
        val currentFeedEntry: FeedEntry = localFeedEntries!![position]
        holder.textArtist.text = currentFeedEntry.artist
        holder.textDescription.text = currentFeedEntry.summary.take(250).plus("...")
        holder.textName.text = currentFeedEntry.name
    }

    override fun getItemCount(): Int {
        return localFeedEntries?.size ?: 0 //si es vacío, regresa cero
    }

    /* estamos declarando esta clase, en la que recibimos una vista. extendemos la clase con viewholder.
    Que recibe como parámetro la vista que declaranmos. Recycler view nos permite crear un adaptador
     */
    class ViewHolder(v: View): RecyclerView.ViewHolder(v) {

        /*
        var textName: TextView? = null
        init {
            textName = v.findViewById(R.id.textViewName)
        }*/
        val textName: TextView = v.findViewById(R.id.textViewName)
        val textArtist: TextView = v.findViewById(R.id.textViewArtist)
        val textDescription: TextView = v.findViewById(R.id.textViewDescription)
    }
}