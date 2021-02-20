package jp.techacademy.masahito.chikami.taskapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class TaskAdapter(context: Context): BaseAdapter() {
    private val mLayoutInflater: LayoutInflater    //xmlのリソースを取り扱うための仕組みのLayoutInflaterをプロパティとして定義

    var mTaskList= mutableListOf<Task>()

    init {
        this.mLayoutInflater = LayoutInflater.from(context)
    }

    override fun getCount(): Int {  //アイテム（データ）の数を返す
        return mTaskList.size
    }

    override fun getItem(position: Int): Any {  //アイテム（データ）を返す
        return mTaskList[position]
    }

    override fun getItemId(position: Int): Long {  //アイテム（データ）のIDを返す
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {  //Viewを返す
        val view: View = convertView ?: mLayoutInflater.inflate(android.R.layout.simple_list_item_2, null)

        val textView1 = view.findViewById<TextView>(android.R.id.text1)
        val textView2 = view.findViewById<TextView>(android.R.id.text2)

        textView1.text = mTaskList[position].title

        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.JAPANESE)
        val date = mTaskList[position].date
        textView2.text = simpleDateFormat.format(date)

        return view
    }
}