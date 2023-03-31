package com.example.gpt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MessgaeRVAdapter(private val messageList : ArrayList<MessageRVModal>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class UserMessageViewHolder(ItemView : View) : RecyclerView.ViewHolder(ItemView){
        val usermsgTV: TextView =itemView.findViewById(R.id.idTVUser)
    }
    class BotMessageViewHolder(ItemView : View) : RecyclerView.ViewHolder(ItemView){
        val botmsgTV: TextView =itemView.findViewById(R.id.idTVBot)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view:View
        return if(viewType==0){
            view=LayoutInflater.from(parent.context).inflate(R.layout.user_message_rv_item,parent,false)
            UserMessageViewHolder(view)
        }
        else{
            view=LayoutInflater.from(parent.context).inflate(R.layout.bot_message_rv_item,parent,false)
            BotMessageViewHolder(view)
        }
    }

    override fun getItemCount(): Int {
        return messageList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val Sender = messageList.get(position).Sender
        when(Sender){
            "user"->(holder as UserMessageViewHolder).usermsgTV.setText(messageList.get(position).message)
            "bot"->(holder as BotMessageViewHolder).botmsgTV.setText(messageList.get(position).message)

        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(messageList.get(position).Sender){
            "user"->0
            "bot"->1
            else->1
        }
    }
}