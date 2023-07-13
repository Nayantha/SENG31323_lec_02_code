package com.nayanthayasiru.lec02.ui.github

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.nayanthayasiru.lec02.R
import com.nayanthayasiru.lec02.databinding.GithubUserViewBinding
import org.jetbrains.annotations.NotNull

class UserListAdapter internal constructor(
    context: Context,
    private val lifecycleOwner: LifecycleOwner,
    private val viewModel: GithubViewModel
) : RecyclerView.Adapter<UserListAdapter.UserViewHolder>(){
    private var users = emptyList<GithubUser>()
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    inner class UserViewHolder (
        itemView: View,
        private val binding: GithubUserViewBinding,
        private val viewModel: GithubViewModel,
        private val lifecycleOwner: LifecycleOwner
        ) : RecyclerView.ViewHolder(itemView) {
            fun bind(item: GithubUser) {
                binding.item = item
                binding.viewModel = viewModel
                binding.executePendingBindings()
                binding.lifecycleOwner = lifecycleOwner
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding: GithubUserViewBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.github_user_view,
            parent,
            false
        )
        return UserViewHolder(binding.root, binding, viewModel, lifecycleOwner)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(
        @NotNull holder: UserViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        holder.bind(users[position])
    }
    override fun onBindViewHolder(
        @NotNull holder: UserViewHolder,
        position: Int
    ) {
        holder.bind(users[position])
    }
    fun setUsers(it: List<GithubUser>){
        this.users = it
        notifyDataSetChanged()
    }

}
