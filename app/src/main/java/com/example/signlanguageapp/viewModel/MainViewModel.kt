package com.example.signlanguageapp.viewModel

import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.StorageReference
import kotlinx.coroutines.tasks.await

class MainViewModel: ViewModel() {

    private val db = Firebase.firestore

    fun getResult(): CollectionReference {
        return db.collection("sign-language")
    }

    suspend fun addImage(reference: StorageReference, uri: Uri){
        try {
            reference.putFile(uri).await()
        } catch (e: Exception){
            e.message?.let { Log.d("Add Image Failed", it) }
        }
    }
}