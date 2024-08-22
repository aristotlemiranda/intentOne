package com.segar.segarone;

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        const val REQUEST_CODE_SAY_HELLO = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sayHelloButton: Button = findViewById(R.id.greetBtn)
        sayHelloButton.setOnClickListener {
            val intent = Intent().apply {
                action = "com.segar.segartwo.ACTION_SAY_HELLO"
                putExtra("EXTRA_MESSAGE", "Say Hello")
            }

            /*if (intent.resolveActivity(packageManager) != null) {
                startActivityForResult(intent, REQUEST_CODE_SAY_HELLO)
            } else {
                Toast.makeText(this, "No app found to handle this action", Toast.LENGTH_SHORT).show()
            }*/

            getResult.launch(intent)
        }
    }

    private val getResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            val reply = data?.getStringExtra("EXTRA_REPLY")
            Toast.makeText(this, reply, Toast.LENGTH_SHORT).show()
        }
    }

   /* override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_SAY_HELLO && resultCode == Activity.RESULT_OK) {
            val reply = data?.getStringExtra("EXTRA_REPLY")
            Toast.makeText(this, reply, Toast.LENGTH_SHORT).show()
        }
    }*/
}