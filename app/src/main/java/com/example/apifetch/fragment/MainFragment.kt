package com.example.apifetch.fragment

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.SearchView
import androidx.core.view.MenuItemCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apifetch.BR
import com.example.apifetch.R
import com.example.apifetch.adapter.PostAdapter
import com.example.apifetch.base.BaseFragment
import com.example.apifetch.databinding.FragmentMainBinding
import com.example.apifetch.viewmodel.MainFragmentViewModel


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : BaseFragment<FragmentMainBinding, MainFragmentViewModel>() {

    var adapter: PostAdapter? = null
    //var loadmore = true
    //var offset = 0

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var page: Int = 1
    var loadmore = true
    var q = "vanilla"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onPrepareOptionsMenu(menu)
        inflater.inflate(R.menu.menu_action_search, menu)
        val item: MenuItem = menu.findItem(R.id.action_search)
        var searchView: SearchView = MenuItemCompat.getActionView(item) as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.clearFocus()
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                //Toast.makeText(baseActivity,newText,Toast.LENGTH_LONG).show()
                q = newText!!
                viewModel.callApi(page.toString(), q)
                return true
            }

            /*  fun onQueryTextSubmit(s: String?): Boolean {
                  searchView.clearFocus()
                  return false
              }

              fun onQueryTextChange(s: String): Boolean {
                  val filteredList: List<MyModel> =
                      filter(mArrayList, s.toLowerCase())
                  mAdapter.setFilter(filteredList)
                  return true
              }*/
        })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.fragment_main
    override val viewModel: MainFragmentViewModel
        get() = ViewModelProvider(this).get(MainFragmentViewModel::class.java)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initData()
    }

    fun initData() {
        viewModel.callApi(page.toString(), q)
       // showData()

        viewDataBinding.swipeRefresh.setOnRefreshListener {
            viewModel.callApi(page.toString(), q)
        }

        val layoutManager = GridLayoutManager(baseActivity, 3)
        viewDataBinding.recycler.layoutManager = layoutManager


        //For lOAD MORE
        viewDataBinding?.recycler?.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(
                recyclerView: RecyclerView,
                dx: Int,
                dy: Int
            ) { // super.onScrolled(recyclerView, dx, dy);
                val lastVisiblePosition: Int = layoutManager.findLastVisibleItemPosition()
                if (lastVisiblePosition == recyclerView.childCount) {
                    if (loadmore) {
                        page++
                        viewModel.callApi(page.toString(), q)
                    }
                }
            }
        })
    }

    /*private fun showData() {

        viewModel.listData.observe(viewLifecycleOwner, Observer {
            viewDataBinding.swipeRefresh.isRefreshing = false
            if (it.success) {
                if (null == adapter) {
                    adapter = PostAdapter(baseActivity!!, it.data)
                    viewDataBinding.recycler.adapter = adapter
                } else {
                    //adapter?.updateList(it)
                    adapter?.notifyDataSetChanged()
                }
            } else {
                loadmore = false
            }

        })


    }*/
}