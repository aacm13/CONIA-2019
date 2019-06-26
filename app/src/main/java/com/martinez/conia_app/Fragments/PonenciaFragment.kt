package com.martinez.conia_app.Fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.martinez.conia_app.DataBase.Entities.Ponencias
import com.martinez.conia_app.DataBase.ViewHolder.PonenciaViewHolder
import com.martinez.conia_app.R
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [PonenciaFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [PonenciaFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class PonenciaFragment : Fragment() {

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null
    //Agrego acá mis variables con lateinit
    lateinit var ponenciasList: MutableList<Ponencias>
    lateinit var ref: DatabaseReference
    private var PonRef: DatabaseReference? = null
    private var mAdapter: FirebaseRecyclerAdapter<Ponencias, PonenciaViewHolder>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_ponencia, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val database = FirebaseDatabase.getInstance()
        ref = database.getReference("gestor-de-eventos-32231")
        ref!!.keepSynced(true)

        setupFire(view)
    }

    fun setupFire(view: View) {
        val recyclerView = view.findViewById(R.id.lista) as RecyclerView
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val mQuery = ref!!.orderByKey()
        val mOptions = FirebaseRecyclerOptions.Builder<Ponencias>()
            .setQuery(mQuery, Ponencias::class.java)
            .setLifecycleOwner(this)
            .build()

        mAdapter = object : FirebaseRecyclerAdapter<Ponencias, PonenciaViewHolder>(mOptions) {

            override fun getItem(position: Int): Ponencias {
                return super.getItem(position)
            }

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PonenciaViewHolder {
                val view = LayoutInflater.from(parent!!.context)
                    .inflate(R.layout.layout_recyler, parent, false)
                return PonenciaViewHolder(view)
            }

            override fun onBindViewHolder(viewHolder: PonenciaViewHolder, position: Int, model: Ponencias) {
                viewHolder.bind(model)
            }
        }
        recyclerView.adapter = mAdapter
    }





    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        fun newInstance(): PonenciaFragment =
            PonenciaFragment()
    }

}
