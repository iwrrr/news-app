package com.vi.schoters.newsapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.vi.schoters.newsapp.data.source.model.NewsArticle
import com.vi.schoters.newsapp.databinding.FragmentHomeBinding
import com.vi.schoters.newsapp.ui.adapter.NewsAdapter
import com.vi.schoters.newsapp.util.Result
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()
    private val newsAdapter: NewsAdapter by lazy { NewsAdapter(::onNewsClick) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeNews()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observeNews() {
        viewModel.getNews().observe(viewLifecycleOwner) { result ->
            when (result) {
                is Result.Loading -> {

                }
                is Result.Success -> setupRecyclerView(result.data.articles)
                is Result.Error -> {

                }
            }
        }
    }

    private fun setupRecyclerView(news: List<NewsArticle>) {
        newsAdapter.submitList(news)

        binding.rvNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun onNewsClick(news: NewsArticle) {
        val directions = HomeFragmentDirections.actionHomeFragmentToDetailFragment(news)
        findNavController().navigate(directions)
    }
}