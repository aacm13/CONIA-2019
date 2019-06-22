package com.martinez.conia_app.Fragments


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.martinez.conia_app.CreateAccount
import com.martinez.conia_app.MainActivity

import com.martinez.conia_app.R
import kotlinx.android.synthetic.main.fragment_login.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [loginFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class loginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        // Inflate the layout for this fragment
        val view:View= inflater.inflate(R.layout.fragment_login, container, false)



        view.btn_login.setOnClickListener{
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        }

        view.crear_cuenta_text_view.setOnClickListener {
            val create = createAccountFragment.newInstance()
            val manager = activity?.supportFragmentManager
            val transaction = manager?.beginTransaction()
            transaction?.replace(R.id.fragment_container,create)
            transaction?.addToBackStack(null)
            transaction?.commit()
        }

        return view
    }


    companion object {
        fun newInstance(): loginFragment = loginFragment()
    }
}
