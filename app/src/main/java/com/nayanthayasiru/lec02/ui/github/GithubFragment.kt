package com.nayanthayasiru.lec02.ui.github

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.nayanthayasiru.lec02.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GithubFragment : Fragment() {

    companion object {
        fun newInstance() = GithubFragment()
    }

    private lateinit var viewModel: GithubViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_github, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GithubViewModel::class.java)
        // TODO: Use the ViewModel
    }

}