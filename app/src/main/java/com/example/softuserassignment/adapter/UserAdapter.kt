package com.example.softuserassignment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.softuserassignment.R
import com.example.softuserassignment.model.User

class UserAdapter(val User: ArrayList<User>,
                  val context: Context
                  ): RecyclerView.Adapter<UserAdapter.UserViewHolder>()
{
    class UserViewHolder(view: View):RecyclerView.ViewHolder(view){
        val imgProfile: ImageView
        val tvName: TextView
        val tvAge: TextView
        val tvAddress: TextView
        val tvGender: TextView
        val imgDelete: ImageView
        init {
            imgProfile = view.findViewById(R.id.imgProfile)
            tvName = view.findViewById(R.id.tvName)
            tvAge = view.findViewById(R.id.tvAge)
            tvAddress = view.findViewById(R.id.tvAddress)
            tvGender = view.findViewById(R.id.tvGender)
            imgDelete = view.findViewById(R.id.imgDelete)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.user_layout, parent, false)
        return  UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = User[position]
        holder.tvName.text = user.name
        holder.tvAge.text = user.age.toString()
        holder.tvAddress.text = user.address
        holder.tvGender.text = user.gender
        if(user.gender == "Male"){
            holder.imgProfile.setImageResource(R.drawable.male)
        }
        else if(user.gender == "Female"){
            holder.imgProfile.setImageResource(R.drawable.female)
        }
        holder.imgProfile.setOnClickListener {
            val context = context
            val stringBuilder = StringBuilder()
            stringBuilder.append("Hello this is: ")
            stringBuilder.append(user.name)
            Toast.makeText(context, stringBuilder.toString(), Toast.LENGTH_SHORT).show()
        }
        holder.imgDelete.setOnClickListener {
            User.removeAt(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return User.size
    }
}