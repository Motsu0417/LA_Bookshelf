package app.motsu.hiromoto.la_bookshelf

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookShelfAdapter(private val context: Context):RecyclerView.Adapter<BookShelfAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val bookImageView: ImageView = view.findViewById(R.id.item_BookImageView)
        val titleTextView: TextView = view.findViewById(R.id.item_BookTitle)
        val authorTextView: TextView = view.findViewById(R.id.item_Author)
        val timelogTextView:TextView = view.findViewById(R.id.item_TimeLog)
    }

    val items: MutableList<Book> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_book_shelf,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        // とりあえずリソースはノーマルな本に
        holder.bookImageView.setImageResource(R.drawable.book_nomal)
        holder.titleTextView.text = item.title
        holder.authorTextView.text = item.author
        holder.timelogTextView.text = item.time_update.toString() + "分前"
    }

    fun addAll(items: List<Book>){
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun clear(){
        this.items.clear()
        notifyDataSetChanged()
    }
}