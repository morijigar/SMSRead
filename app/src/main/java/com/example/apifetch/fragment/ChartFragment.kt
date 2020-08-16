package com.example.apifetch.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.apifetch.BR
import com.example.apifetch.R
import com.example.apifetch.adapter.PostAdapter
import com.example.apifetch.base.BaseFragment
import com.example.apifetch.databinding.FragmentChartBinding
import com.example.apifetch.util.SingletoneData
import com.example.apifetch.viewmodel.ChartFragmentViewModel
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChartFragment : BaseFragment<FragmentChartBinding, ChartFragmentViewModel>() {


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
            ChartFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.fragment_chart
    override val viewModel: ChartFragmentViewModel
        get() = ViewModelProvider(this).get(ChartFragmentViewModel::class.java)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initData()
    }

    fun initData() {


        val xvalues  = ArrayList<PieEntry>()

        xvalues.add(PieEntry(SingletoneData.totalIncome.toFloat(),"Income"))
        xvalues.add(PieEntry(SingletoneData.totalExpanse.toFloat(),"Expanse"))
        val dataSet = PieDataSet(xvalues, "Income vs expanse")



        val dataTag = ArrayList<Any>()

        dataTag.add("Income")
        dataTag.add("Expanse")

        val data = PieData(dataSet)
        viewDataBinding!!.pieChart.setData(data)
        dataSet.setColors(*ColorTemplate.COLORFUL_COLORS)
        viewDataBinding!!.pieChart.animateXY(1000, 1000)


    }
}