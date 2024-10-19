package com.example.edittextdialogbox

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        showEditTextDialog()
    }
    private fun showEditTextDialog(){
        var tv_textView=findViewById<TextView>(R.id.tv_textView)
        tv_textView.setOnClickListener(){
            val builder=AlertDialog.Builder(this)
            val inflater: LayoutInflater= layoutInflater
            val dialogLayout=inflater.inflate(R.layout.edit_text_layout,null)
            val editText:EditText=dialogLayout.findViewById<EditText>(R.id.edit_text_id)

            with(builder){
                setTitle("Enter some text!")
                setPositiveButton("Ok"){dialog,which->
                   tv_textView.text=editText.text.toString()
                }
                setNegativeButton("cancel"){dialog, which->
                    Log.d("Main","Negative Button clicked")
                }
                setView(dialogLayout)
                show()

            }
        }
    }
}