package com.example.apifetch.fragment

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apifetch.databinding.FragmentImportBinding
import com.example.apifetch.util.SingletoneData
import com.example.apifetch.viewmodel.IncomeFragmentViewModel

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
class IncomeFragment : BaseFragment<FragmentImportBinding, IncomeFragmentViewModel>() {

    var adapter: PostAdapter? = null
    //var loadmore = true
    //var offset = 0

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    /* private var page: Int = 1
     var loadmore = true
     var q = "vanilla"*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
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
            IncomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.fragment_import
    override val viewModel: IncomeFragmentViewModel
        get() = ViewModelProvider(this).get(IncomeFragmentViewModel::class.java)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initData()
    }

    fun initData() {


        val layoutManager = LinearLayoutManager(baseActivity)
        viewDataBinding.recycler.layoutManager = layoutManager

        adapter = PostAdapter(baseActivity!!, SingletoneData.incomeArr)
        viewDataBinding.recycler.adapter = adapter


        //For lOAD MORE
        /*viewDataBinding?.recycler?.addOnScrollListener(object : RecyclerView.OnScrollListener() {
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
        })*/
    }

    private fun showData() {

        /*viewModel.listData.observe(viewLifecycleOwner, Observer {
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

        })*/


    }
}