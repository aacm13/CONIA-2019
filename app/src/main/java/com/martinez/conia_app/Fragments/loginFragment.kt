package com.martinez.conia_app.Fragments


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.martinez.conia_app.MainActivity

import com.martinez.conia_app.R
import kotlinx.android.synthetic.main.fragment_login.*
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
    val mAuth = FirebaseAuth.getInstance()
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      /*  btn_login.setOnClickListener(View.OnClickListener {
                view -> login()
        })*/

        /*crear_cuenta_text_view.setOnClickListener(View.OnClickListener {
                view -> register()
        })*/


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View= inflater.inflate(R.layout.fragment_login, container, false)



       view.btn_login.setOnClickListener{
               //view -> login()
           activity?.let{
               val intent = Intent (it, MainActivity::class.java)
               it.startActivity(intent)
           }
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


    //funcion que permite el login, revisa si existe el email y password
    private fun login(){


        var email = et_user.text.toString()
        var password = et_pass.text.toString()

        if(!email.isEmpty() && !password.isEmpty()){
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(Activity(), OnCompleteListener { task ->
                if(task.isSuccessful){
                    startActivity(Intent(activity,MainActivity::class.java))
                    Toast.makeText(activity,"Ha iniciado sesión correctamente:)", Toast.LENGTH_LONG).show()
                } else{
                    Toast.makeText(activity,"Error :(", Toast.LENGTH_LONG).show()

                }
            })
        }else{
            Toast.makeText(activity,"Complete los campos faltantes:(", Toast.LENGTH_LONG).show()
        }
    }
    //funcion que nos transporta al registro
    private fun register (){
        val create = createAccountFragment.newInstance()
        val manager = activity?.supportFragmentManager
        val transaction = manager?.beginTransaction()
        transaction?.replace(R.id.fragment_container,create)
        transaction?.addToBackStack(null)
        transaction?.commit()

    }
}

