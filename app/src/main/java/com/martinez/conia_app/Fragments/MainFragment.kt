package com.martinez.conia_app.Fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.martinez.conia_app.Adapters.ViewPageAdapter
import com.martinez.conia_app.R
import kotlinx.android.synthetic.main.fragment_main.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class MainFragment : Fragment() {

    private var listener: OnFragmentInteractionListener? = null

    //La variable del viewPager xdxd y su adaptador
    lateinit var viewPager: ViewPager
    lateinit var adaptador: ViewPageAdapter

    companion object {
        fun newInstance(): MainFragment =
            MainFragment()
    }
/*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            //param1 = it.getString(ARG_PARAM1)
            //param2 = it.getString(ARG_PARAM2)
        }
        adaptador = ViewPageAdapter(view.context)
    }*/

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_main, container, false)

        bind(view)

        return view
    }

    //Hago la función bind
    fun bind(view:View){
        this.viewPager = view.view_pager_conia //ACÁ VA EL THIS.VIEWPAGER = view. id de mi lista del view image conia
        this.viewPager.adapter = activity?.applicationContext?.let { ViewPageAdapter(it) }
        //this.lista.adapter = adaptador
        //this.lista.layoutManager = LinearLayoutManager(context)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction()
    }
}
