package com.pakt_games.kotlinretrofitadvanceexample.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pakt_games.kotlinretrofitadvanceexample.R
import com.pakt_games.kotlinretrofitadvanceexample.data.api.ApiHelper
import com.pakt_games.kotlinretrofitadvanceexample.data.api.RetrofitBuilder
import com.pakt_games.kotlinretrofitadvanceexample.data.model.User
import com.pakt_games.kotlinretrofitadvanceexample.ui.adapter.RetrofitCalismaRecyclerAdapter
import com.pakt_games.kotlinretrofitadvanceexample.ui.base.ViewModelFactory
import com.pakt_games.kotlinretrofitadvanceexample.ui.viewmodel.RetrofitCalismaViewModel
import com.pakt_games.kotlinretrofitadvanceexample.utils.Status
import kotlinx.android.synthetic.main.fragment_retrofit_calisma.*


class RetrofitCalisma : Fragment() {

    private lateinit var viewModel: RetrofitCalismaViewModel
    private lateinit var adapter: RetrofitCalismaRecyclerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_retrofit_calisma, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        setupUI()
        setupObservers()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(RetrofitCalismaViewModel::class.java)
    }

    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = RetrofitCalismaRecyclerAdapter(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.getUsers().observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        resource.data?.let { users -> retrieveList(users) }
                    }
                    Status.ERROR -> {
                        recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                        recyclerView.visibility = View.GONE
                    }
                }
            }
        })
    }

    private fun retrieveList(users: List<User>) {
        adapter.apply {
            addUsers(users)
            notifyDataSetChanged()
        }
    }

}