// src/main/java/com/example/managerially/MainActivity.kt
package com.example.dailytaskmanager

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.dailytaskmanager.fragments.AddTaskFragment
import com.example.dailytaskmanager.fragments.TaskListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnAddTask).setOnClickListener {
            val dialog = AddTaskFragment()
            dialog.show(supportFragmentManager, "AddTaskFragment")
        }

        findViewById<Button>(R.id.btnViewTasks).setOnClickListener {
            replaceFragment(TaskListFragment())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_add_task -> {
                val dialog = AddTaskFragment()
                dialog.show(supportFragmentManager, "AddTaskFragment")
                true
            }
            R.id.menu_view_tasks -> {
                replaceFragment(TaskListFragment())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
