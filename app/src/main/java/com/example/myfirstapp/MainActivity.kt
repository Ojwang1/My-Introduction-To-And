package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    var edit_name:EditText ? =null
    var edit_mail:EditText ? =null
    var edit_phone:EditText ? =null
    var edit_pass:EditText ? =null
    var btn_red:Button ? = null
    var btn_login:Button ? =null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edit_name=findViewById(R.id.edit_name)
        edit_mail=findViewById(R.id.edit_mail)
        edit_phone=findViewById(R.id.edit_phone)
        edit_pass=findViewById(R.id.edit_pass)
        btn_red=findViewById(R.id.btn_red)
        btn_login=findViewById(R.id.btn_login)

        btn_red!!.setOnClickListener {
            var name=edit_name!!.text.toString().trim()
            var mail=edit_mail!!.text.toString().trim()
            var phone=edit_phone!!.text.toString().trim()
            var pass=edit_pass!!.text.toString().trim()
            if (name.isEmpty()){
                edit_name!!.setError("Please fill this input")
                edit_name!!.requestFocus()
            }else if (mail.isEmpty()){
                edit_mail!!.setError("pleae fill this input")
                edit_mail!!.requestFocus()
            }else if (phone.isEmpty()){
                edit_phone!!.setError("Please fill this input")
                edit_phone!!.requestFocus()

            }else if (mail.isEmpty()){
                edit_pass!!.setError("pleae fill this input")
                edit_pass!!.requestFocus()
            } else{
                var time=System.currentTimeMillis().toString()
                var userData= User(name,mail,phone, pass)
                var ref = FirebaseDatabase.getInstance().getReference().child("User/$time")
                ref.setValue(userData).addOnCompleteListener {
                        task->
                    if(task.isSuccessful){
                        Toast.makeText(applicationContext,"User save successfully",
                            Toast.LENGTH_LONG).show()
                    }else{ Toast.makeText(applicationContext,"Saving user failed",
                        Toast.LENGTH_LONG).show()
                    }
                }

            }
        }

//        btn_login!!.setOnClickListener {
//            startActivity(Intent( this,UsersActivity::class.java))
        }



    }
