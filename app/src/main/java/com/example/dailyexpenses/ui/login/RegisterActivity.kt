package com.example.dailyexpenses.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.dailyexpenses.LoginModel
import com.example.dailyexpenses.common.BaseCommon
import com.example.dailyexpenses.databinding.ActivityRegisterBinding
import com.example.dailyexpenses.ui.activities.MainActivity
import com.example.dailyexpenses.vievmodel.RegisterViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {
    private val registerBinding by lazy { ActivityRegisterBinding.inflate(layoutInflater) }
    private lateinit var auth: FirebaseAuth
    private lateinit var registerVM: RegisterViewModel
    private var email = ""
    private var password = ""
    private val baseCommon = BaseCommon()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(registerBinding.root)
        registerVM = ViewModelProvider(this)[RegisterViewModel::class.java]

        auth = Firebase.auth

        observerRegister()
        clickable()
    }

    private fun clickable(){
        registerBinding.loginClickfromRegister.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        registerBinding.registerClick.setOnClickListener {
            email = registerBinding.registerEmail.text.toString()
            password = registerBinding.registerPassword.text.toString()
            registerVM.userEmailControl(email)
        }
    }
    private fun register(email:String, password:String) {
        baseCommon.showProgressBar(registerBinding.progressBar, getViewList())
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    registerSaveFirestore(auth.currentUser!!.uid)
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                    registerBinding.progressBar.visibility = View.GONE
                } else {
                    val result = task.exception?.message
                    Toast.makeText(baseContext, result, Toast.LENGTH_SHORT,).show()
                }
            }

    }
    private fun observerRegister(){
        registerVM.registerBool.observe(this, Observer{
            if(!it ){
                if(email.isNotEmpty() ||password.isNotEmpty()) {
                    register(email, password)
                }
            }else {
                Toast.makeText(this, "register hata", Toast.LENGTH_SHORT).show()
            }
        })
    }
    private fun registerSaveFirestore(userId: String){
        val currentDate = System.currentTimeMillis().toString()
        val loginData = LoginModel(email, password, currentDate, userId)
        val db = Firebase.firestore
        db.collection("users")
            .add(loginData)
            .addOnSuccessListener { documentReference ->
                Toast.makeText(this, "register başarılı", Toast.LENGTH_LONG).show()
            }
            .addOnFailureListener { e ->
                e.printStackTrace()
            }
    }
    private fun getViewList(): ArrayList<View> {
        val viewList : ArrayList<View> = arrayListOf()
        viewList.add(registerBinding.registerEmailText)
        viewList.add(registerBinding.registerPasswordText)
        viewList.add(registerBinding.registerClick)
        viewList.add(registerBinding.loginClickfromRegister)
        return viewList
    }
}

