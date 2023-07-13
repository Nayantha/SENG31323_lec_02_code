package com.nayanthayasiru.lec02.ui.github

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.nayanthayasiru.lec02.R
import com.nayanthayasiru.lec02.databinding.FragmentGithubBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GithubFragment : Fragment() {

    companion object {
        fun newInstance() = GithubFragment()
    }

    private lateinit var viewModel: GithubViewModel
    private lateinit var binding: FragmentGithubBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(GithubViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_github, container, false)
        val recycleView = binding.usersRecyclerview
        val adapter = UserListAdapter(binding.root.context, this, viewModel)
        recycleView.adapter = adapter
        recycleView.layoutManager = LinearLayoutManager(binding.root.context)
        viewModel.users.observe(viewLifecycleOwner) {
            adapter.setUsers(it)
        }
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }
}