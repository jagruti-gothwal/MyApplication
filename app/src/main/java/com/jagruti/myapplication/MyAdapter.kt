package com.jagruti.myapplication

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jagruti.myapplication.model.Name
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

        holder.userName.text= arrayOf(user.name).toString()
        /*  holder.userName.text= user.name.title
           holder.userName.text=user.name.first
           holder.userName.text=user.name.last*/
        Glide.with(holder.itemView).load(user.picture.thumbnail).into(holder.userImage)
        Log.d("MyAdapter",user.picture.thumbnail)
        holder.userLogin.text= user.login.md5
        holder.userLogin.text= user.login.password
        holder.userLogin.text= user.login.salt
        holder.userLogin.text= user.login.sha1
        holder.userLogin.text= user.login.sha256
        holder.userLogin.text= user.login.username
        holder.userLogin.text= user.login.uuid

    }
    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val userName : TextView=itemView.findViewById(R.id.userName)
        val userImage: ImageView = itemView.findViewById(R.id.userImage)
        val userLogin:  TextView =itemView.findViewById(R.id.userLogin)
    }
}