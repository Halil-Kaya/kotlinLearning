package com.halilkaya.todoapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import com.halilkaya.todoapp.R
import com.halilkaya.todoapp.model.BaslikVeNot
import org.greenrobot.eventbus.EventBus

class FragmentAddTodo : Fragment() , View.OnClickListener{

    lateinit var btnEkle:Button
    lateinit var etBaslik:TextInputEditText
    lateinit var etNot:TextInputEditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.fragment_add_todo,container,false)

        btnEkle = view.findViewById(R.id.btnEkle)
        etBaslik = view.findViewById(R.id.etBaslik)
        etNot = view.findViewById(R.id.etNot)


        btnEkle.setOnClickListener(this)





        return view
    }

    override fun onClick(v: View?) {

        if(etBaslik.text!!.isNotEmpty() && etNot.text!!.isNotEmpty()){

            EventBus.getDefault().post(BaslikVeNot(etBaslik.text.toString(),etNot.text.toString()))

            etBaslik.setText("")
            etNot.setText("")

        }else{

            var myDialog = MyDialogFragment()
            myDialog.show(fragmentManager!!,"frag")


        }


    }


}