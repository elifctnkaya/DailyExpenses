package com.example.dailyexpenses.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class RegisterViewModel : ViewModel(){
    var registerBool = MutableLiveData(false)
    fun userEmailControl(email: String) {
        val db = Firebase.firestore
        val doc = db.collection("users")
        doc.get().addOnSuccessListener { result ->
            val found = result.find { it.data["email"] == email}
            registerBool.value = found != null
        }.addOnFailureListener { exception ->
                println("fail")
        }
    }
}