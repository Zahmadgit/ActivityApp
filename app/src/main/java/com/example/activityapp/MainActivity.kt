package com.example.activityapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.action_take_picture -> Toast.makeText(this, "Taking picture", Toast.LENGTH_SHORT).show()
            R.id.action_help -> startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.temple.edu")))
            R.id.action_delete_picture -> {
                AlertDialog.Builder(this)
                    .setTitle("Confirmation")
                    .setMessage("You're about to delete bruh")
                    .setPositiveButton("Yes"){_,_ -> Toast.makeText(this, "Deleting picture", Toast.LENGTH_SHORT).show()}
                    .setNegativeButton("Never mind") {dialog,_ -> dialog.cancel()}
                    .setCancelable(false)
                    .create()
                    .show()
            }
            else -> return false
        }
        return true
    }
}