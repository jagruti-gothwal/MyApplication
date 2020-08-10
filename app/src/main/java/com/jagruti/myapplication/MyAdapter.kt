package com.jagruti.myapplication

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jagruti.myapplication.model.Name
import com.jagruti.myapplication.model.User

class MyAdapter(val list: List<User>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.action_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {
        val user = list[position]
        holder.userName.text =
            user.name.title.plus(" " + user.name.first).plus(" " + user.name.last)

        Log.d("MyAdapter", user.name.toString())
        Log.d("MyAdapter", user.name.title)
        Log.d("MyAdapter", user.name.first)
        Log.d("MyAdapter", user.name.last)

        Glide.with(holder.itemView).load(user.picture.thumbnail).into(holder.userImage)
        holder.userLogin.text =
        user.login.username.plus(" " + user.login.password)
        holder.userLocation.text =
            user.location.city.plus(" " + user.location.state)
                .plus(" " + user.location.country)
                .plus(" " + user.location.timezone.description)
                .plus(" " + user.location.postcode)

        holder.userEmail.text = user.email
        holder.userGender.text = user.gender
        holder.userPhone.text = user.phone


    }



    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userName: TextView = itemView.findViewById(R.id.userName)
        val userImage: ImageView = itemView.findViewById(R.id.userImage)
        val userLogin: TextView = itemView.findViewById(R.id.userLogin)
        val userLocation: TextView = itemView.findViewById(R.id.userLocation)
        val userEmail: TextView = itemView.findViewById(R.id.userEmail)
        val userGender: TextView = itemView.findViewById(R.id.userGender)
        val userPhone: TextView = itemView.findViewById(R.id.userPhone)


    }
}