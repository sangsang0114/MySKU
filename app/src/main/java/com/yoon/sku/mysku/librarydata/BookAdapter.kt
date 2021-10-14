package com.yoon.sku.mysku.librarydata

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yoon.sku.mysku.R

class BookAdapter : RecyclerView.Adapter<BookAdapter.ViewHolder>() {
    var items: ArrayList<Book> = ArrayList()

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(viewGroup.context)
        val itemView: View = inflater.inflate(R.layout.book_item, viewGroup, false)

        return ViewHolder(itemView)
    }

    fun add(item: Book) {
        items.add(item)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.setIsRecyclable(false);

        val item: Book = items[position]
        viewHolder.setItem(item)

    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun getItem(position: Int): Book {
        return items[position]
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setItem(book: Book) {
            val titleView: TextView = itemView.findViewById(R.id.bookTitleView)
            titleView.text = book.title
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}

