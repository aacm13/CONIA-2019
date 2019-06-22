package com.martinez.conia_app.Fragments


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.martinez.conia_app.MainActivity
import com.martinez.conia_app.R
import kotlinx.android.synthetic.main.fragment_create_account.*
import kotlinx.android.synthetic.main.fragment_create_account.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [createAccountFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class createAccountFragment : Fragment() {

    val mAuth =FirebaseAuth.getInstance()
    lateinit var  mDatabase : DatabaseReference

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

        }

      //mDatabase = FirebaseDatabase.getInstance().getReference("Names")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_create_account, container, false)

        view.btn_create.setOnClickListener{
                view -> register()


        }


        return view
    }

    private fun register(){


        var name = ctr_name.text.toString()
        var username = ctr_user.text.toString()
        var email = ctr_email.text.toString()
        var password = ctr_pass.text.toString()
        var passwordCheck = crt_pass_repeat.text.toString()

        if(!name.isEmpty() && !username.isEmpty() && !email.isEmpty() && !password.isEmpty() && !passwordCheck.isEmpty() ){
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(Activity(), OnCompleteListener
            { task ->
                if(task.isSuccessful){

                    val user= mAuth.currentUser
                    val uid= user!!.uid
                   //mDatabase.child(uid).child("Name").setValue(name)
                    val intent = Intent(activity, MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(activity,"Ha iniciado sesión correctamente:)",Toast.LENGTH_LONG)
                        .show()

                } else{
                    Toast.makeText(activity,"Error:(",Toast.LENGTH_LONG)
                        .show()
                }
            })
        } else{
            Toast.makeText(activity,"Por favor, complete los campos faltantes:(", Toast.LENGTH_LONG)
                .show()
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment createAccountFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance():createAccountFragment = createAccountFragment()
    }
}
