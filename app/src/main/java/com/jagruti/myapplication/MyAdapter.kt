package com.jagruti.myapplication

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jagruti.myapplication.model.Picture
import com.jagruti.myapplication.model.User

class MyAdapter(val list: List<User>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.action_layout,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {
       val user = list[position]
        holder.userName.text= user.name.toString()
        Glide.with(holder.itemView).load(user.picture).into(holder.userImage)
        Log.d("MyAdapter",user.picture.toString())
        holder.userDetails.text= user.login.toString()
    }
    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val userName : TextView=itemView.findViewById(R.id.userName)
        val userImage: ImageView = itemView.findViewById(R.id.userImage)
        val userDetails:  TextView =itemView.findViewById(R.id.userLogin)
    }
}