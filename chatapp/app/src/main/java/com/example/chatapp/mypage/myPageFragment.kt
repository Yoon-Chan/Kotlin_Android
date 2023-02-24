package com.example.chatapp.mypage

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.chatapp.Key
import com.example.chatapp.LoginActivity
import com.example.chatapp.R
import com.example.chatapp.databinding.FragmentMypageBinding
import com.example.chatapp.userlist.UserItem
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class myPageFragment : Fragment(R.layout.fragment_mypage) {

    private lateinit var binding : FragmentMypageBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMypageBinding.bind(view)


        val currentUserId = Firebase.auth.currentUser?.uid ?: ""
        val currentUserDB = Firebase.database.reference.child(Key.DB_USERS).child(currentUserId)

        currentUserDB.get().addOnSuccessListener {
            val currentUserItem = it.getValue(UserItem::class.java) ?: return@addOnSuccessListener

            binding.usernameEditText.setText(currentUserItem.username)
            binding.descriptionEditText.setText(currentUserItem.description)

        }

        binding.applyButton.setOnClickListener {
            val username = binding.usernameEditText.text.toString()
            val description = binding.descriptionEditText.text.toString()

            if(username.isEmpty()){
                Toast.makeText(context, "유저이름은 빈 값으로 두실 수 없습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            val user = mutableMapOf<String, Any>()
            user["username"] = username
            user["description"] = description
            currentUserDB.updateChildren(user)
            //todo 파이어베이스 realtime database update

        }


        binding.signOutButton.setOnClickListener {
            Firebase.auth.signOut()
            startActivity(Intent(context, LoginActivity::class.java))
            activity?.finish()
        }


    }

}