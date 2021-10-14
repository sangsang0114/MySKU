package com.yoon.sku.mysku

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yoon.sku.mysku.databinding.FragmentLibrarySearchBinding
import com.yoon.sku.mysku.librarydata.Book
import com.yoon.sku.mysku.librarydata.BookAdapter
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class LibrarySearchFragment : Fragment() {
    private lateinit var binding: FragmentLibrarySearchBinding
    private lateinit var bookAdapter: BookAdapter
    private lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLibrarySearchBinding.inflate(inflater, container, false)
        recyclerView = binding.resultList

        binding.searchBtn.setOnClickListener {
            val searchKeyword = binding.searchInput.text.toString()
            val url = "https://library.skuniv.ac.kr/search/Search.Result.ax?q=${searchKeyword}"
            bookAdapter = BookAdapter()
            scrapSearchResult(url)
        }
        return binding.root
    }

    private fun scrapSearchResult(url: String) = runBlocking {
        val job = GlobalScope.launch {
            Test()
            val document: Document = Jsoup.connect(url).get()
            val elements: Elements = document.select(".body > a:first-child")

            for (e in elements) {
                val title = e.text().toString()
                bookAdapter.add(Book(title, "sample", "sample", "sample", "sample"))
            }
        }
        job.join()
        applyDataToView()
    }

    private fun applyDataToView() {
        recyclerView.adapter = bookAdapter
        recyclerView.layoutManager = LinearLayoutManager(activity)
    }
}