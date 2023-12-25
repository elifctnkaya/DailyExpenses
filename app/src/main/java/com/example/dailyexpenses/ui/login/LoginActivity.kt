package com.example.dailyexpenses.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.dailyexpenses.common.BaseCommon
import com.example.dailyexpenses.databinding.ActivityLoginBinding
import com.example.dailyexpenses.ui.activities.MainActivity
import com.example.dailyexpenses.vievmodel.RegisterViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private val loginBinding by lazy { ActivityLoginBinding.inflate(layoutInflater) }
    private lateinit var auth: FirebaseAuth
    private lateinit var registerVM : RegisterViewModel
    private val baseCommon = BaseCommon()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(loginBinding.root)
        registerVM = ViewModelProvider(this)[RegisterViewModel::class.java]
        auth = Firebase.auth
        init()
        setClickListener()
    }


    private fun setClickListener(){
        loginBinding.registerClickfromLogin.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        loginBinding.loginClick.setOnClickListener{
            val email = loginBinding.loginEmail.text.toString()
            val password = loginBinding.loginPassword.text.toString()
            registerVM.userEmailControl(email)
            login(email, password)
        }
        loginBinding.forgotPassText.setOnClickListener{
        }
    }

    private fun init() {
        val currentUser = auth.currentUser
        if (currentUser != null) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
    private fun login(email:String, password:String) {
        baseCommon.showProgressBar(loginBinding.progressBar, getViewList())
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                    loginBinding.progressBar.visibility = View.GONE
                } else {
                    Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_SHORT,).show()
                }
            }
    }
    private fun getViewList():ArrayList<View> {
        val viewList : ArrayList<View> = arrayListOf()
        viewList.add(loginBinding.loginEmailText)
        viewList.add(loginBinding.loginPasswordText)
        viewList.add(loginBinding.registerClickfromLogin)
        viewList.add(loginBinding.loginClick)
        viewList.add(loginBinding.forgotPassText)
        return viewList
    }
}