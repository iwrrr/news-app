package com.vi.schoters.newsapp.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.vi.schoters.newsapp.databinding.FragmentDetailBinding
import com.vi.schoters.newsapp.util.Extensions.toDate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setData() {
        val news = args.news
        binding.apply {
            tvTitle.text = news.title
            tvSource.text = news.source?.name
            tvDate.text = news.publishedAt?.toDate()
            tvContent.text = news.content

            Glide.with(requireContext())
                .load(news.urlToImage)
                .into(ivNews)
        }
    }
}