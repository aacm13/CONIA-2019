package com.martinez.conia_app

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.martinez.conia_app.Adapters.AdapterCustomPonencias
import com.martinez.conia_app.EntidadRecycler.Ponencias
import kotlinx.android.synthetic.main.fragment_ponencia.view.*


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
    lateinit var lista: RecyclerView
    lateinit var adaptador: AdapterCustomPonencias


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        //Acá hago el llenado
        val ponencias = ArrayList<Ponencias>()
        //rellenamos datos
        ponencias.add(Ponencias("Bill Gates expo", "La presente ponencia " +
                "tiene por objetivo explicar cómo me volví rico xdxdxd soi el bil gueits", 3.0, R.drawable.billgates))
        ponencias.add(Ponencias("Steve Jobs success", "Esta ponencia pretende abondar mi percepción" +
                " del éxito, y trataré de explicarte que debes hacer para alcanzarlo", 5.0, R.drawable.stevejobs))
        ponencias.add(Ponencias("Privacidad de datos", "En esta expo te daré tips para" +
                "proteger tus datos en internet y cómo evitar que te los roben, soy experto, créeme, no es que los " +
                "robe, pero a diario protejo muchos xdxdxd", 1.0, R.drawable.markzuckerberg))


        adaptador = AdapterCustomPonencias(ponencias)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_ponencia, container, false)
        bind(view)

        //Acá pongo un observador del viewModel, agregar un método update al adaptador
        return view


    }

    //Acá estoy setteando todas las vistas
    fun bind(view:View){
        this.lista=view.lista
        this.lista.adapter = adaptador
        this.lista.layoutManager = LinearLayoutManager(context)
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
        fun newInstance(): PonenciaFragment = PonenciaFragment()
    }

}
