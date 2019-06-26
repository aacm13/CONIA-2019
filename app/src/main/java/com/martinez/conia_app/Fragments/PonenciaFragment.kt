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
import com.firebase.ui.database.ChangeEventListener
import com.google.firebase.database.*
import com.martinez.conia_app.Adapters.AdapterCustomPonencias
import com.martinez.conia_app.DataBase.Entities.Ponencias
import com.martinez.conia_app.DataBase.ViewHolder.PonenciaViewHolder
import com.martinez.conia_app.R
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import kotlinx.android.synthetic.main.fragment_ponencia.*
import kotlinx.android.synthetic.main.fragment_ponencia.view.*
import kotlinx.android.synthetic.main.fragment_ponencia.view.lista


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

    override fun onActivityCreated(savedInstanceState: Bundle?) {



        val layoutManager = LinearLayoutManager(context)
        layoutManager.reverseLayout = false
        lista.setHasFixedSize(true)
        lista.layoutManager = layoutManager
        super.onActivityCreated(savedInstanceState)
        var query = FirebaseDatabase.getInstance()
            .reference
            .child("").child("gestor-de-eventos-32231")
            .limitToLast(50)

        val options = FirebaseRecyclerOptions.Builder<Ponencias>()
            .setQuery(query, Ponencias::class.java)
            .setLifecycleOwner(this)
            .build()

        mAdapter = object : FirebaseRecyclerAdapter<Ponencias, PonenciaViewHolder>(options) {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PonenciaViewHolder {
                return PonenciaViewHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.template_ponencias, parent, false))
            }

            protected override fun onBindViewHolder(holder: PonenciaViewHolder, position: Int, model: Ponencias) {
                holder.bind(model)
            }

            override fun onDataChanged() {
                // Called each time there is a new data snapshot. You may want to use this method
                // to hide a loading spinner or check for the "no documents" state and update your UI.
                // ...
            }
        }
        lista.adapter = mAdapter


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
