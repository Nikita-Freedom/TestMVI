package com.example.testmvi


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testmvi.adapter.MainAdapter
import com.example.testmvi.data.api.ApiHelperImpl
import com.example.testmvi.data.api.RetrofitBuilder
import com.example.testmvi.intent.MainIntent
import com.example.testmvi.data.model.User
import com.example.testmvi.viewmodel.util.ViewModelFactory
import com.example.testmvi.viewmodel.MainViewModel
import com.example.testmvi.viewstate.MainState
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class MainActivity : AppCompatActivity(), UserView {
    private lateinit var mainViewModel: MainViewModel
    private var adapter = MainAdapter(arrayListOf())
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUI()
        setupViewModel()
        observeViewModel()
        setupClicks()
    }
    private fun setupClicks()
    {
        buttonFetchUser.setOnClickListener {
            lifecycleScope.launch {
                mainViewModel.userIntent.send(MainIntent.FetchUser) // Отправляем нажатие пользователя через intetn нашему MainViewModel
            }

        }

    }
    private fun setupUI()
    {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.run {
            addItemDecoration(DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as
                        LinearLayoutManager).orientation))
        }
        recyclerView.adapter = adapter
    }


    private fun setupViewModel()
    {
        mainViewModel = ViewModelProviders.of(this, ViewModelFactory(ApiHelperImpl(RetrofitBuilder.apiService))).get(MainViewModel::class.java)
    }
    private fun observeViewModel()
    {
        lifecycleScope.launch {
            mainViewModel.state.collect {
                when (it) {
                    is MainState.Idle -> {
                    }
                    is MainState.Loading -> {
                        buttonFetchUser.visibility = View.GONE
                        progressBar.visibility = View.VISIBLE
                    }
                    is MainState.Users ->
                    {
                        progressBar.visibility = View.GONE
                        buttonFetchUser.visibility = View.GONE
                        renderList(it.user)
                    }
                    is MainState.Error ->
                    {
                        progressBar.visibility = View.GONE
                        buttonFetchUser.visibility = View.VISIBLE
                        Toast.makeText(this@MainActivity, it.error,
                            Toast.LENGTH_LONG).show()
                    }
                }
            }
        }

    }
    private fun renderList(users: List<User>)
    {
        recyclerView.visibility = View.GONE
        users.let {
                listOfUsers -> listOfUsers.let {
            adapter.addData(it)
                }
        }
        adapter.notifyDataSetChanged()
    }
}