package com.example.trashhack.model

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.trashhack.R


class UsersAdapter(private val dataSet: MutableList<Users>) :
    RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val id: TextView = view.findViewById(R.id.id)
        val email: TextView = view.findViewById(R.id.email)
        val fullname: TextView = view.findViewById(R.id.fullname)
        val role: TextView = view.findViewById(R.id.role)
        val organization_id: TextView = view.findViewById(R.id.organization_id)
        val done: TextView = view.findViewById(R.id.done)
        val score: TextView = view.findViewById(R.id.score)
        val current: TextView = view.findViewById(R.id.current)
        val delete: Button = view.findViewById<Button>(R.id.delete)

        /*
        init {
            // Define click listener for the ViewHolder's View
            id = view.findViewById(R.id.id)
            email = view.findViewById(R.id.email)
            fullname = view.findViewById(R.id.fullname)
            role = view.findViewById(R.id.role)
            organization_id = view.findViewById(R.id.organization_id)
            done = view.findViewById(R.id.done)
            score = view.findViewById(R.id.score)
            current = view.findViewById(R.id.current)
        }
         */
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.full_user_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        // What a mess 😭
        // to put it simply, it just joints the "<field>: " string and it's value as a string
        viewHolder.id.text = viewHolder.id.text.toString().plus(dataSet[position].id.toString())
        viewHolder.email.text = viewHolder.email.text.toString().plus(dataSet[position].email)
        viewHolder.fullname.text = viewHolder.fullname.text.toString().plus(dataSet[position].fullname)
        viewHolder.role.text = viewHolder.role.text.toString().plus(dataSet[position].role)
        viewHolder.organization_id.text = viewHolder.organization_id.text.toString().plus(dataSet[position].organization_id.toString())
        viewHolder.done.text = viewHolder.done.text.toString().plus(dataSet[position].done.toString())
        viewHolder.score.text = viewHolder.score.text.toString().plus(dataSet[position].score.toString())
        viewHolder.current.text = viewHolder.current.text.toString().plus(dataSet[position].current)
        //viewHolder.delete = view.findViewById<Button>(R.id.delete)
        viewHolder.delete.setOnClickListener {
            //Log.i("Sent delete request", viewHolder.id.text.toString())
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return dataSet.size
    }

}
