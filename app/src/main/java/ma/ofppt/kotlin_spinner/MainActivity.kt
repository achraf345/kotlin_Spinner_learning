package ma.ofppt.kotlin_spinner

import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var spinner:Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        spinner = findViewById(R.id.Spinner)
        var listItem = listOf("russie","france","albanie","morocco","italy","spain")

        var arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, listItem)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = arrayAdapter
        
        
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent:AdapterView<*>, view:View?, position:Int, id:Long){
                val selectedItem = parent.getItemAtPosition(position).toString()
                Toast.makeText(this@MainActivity,"you alredy clicked on it: $selectedItem", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }
}