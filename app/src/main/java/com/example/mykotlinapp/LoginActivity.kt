package com.example.mykotlinapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException


class LoginActivity : AppCompatActivity() {
    lateinit var btnLog: Button;
    lateinit var btnReg: Button
    lateinit var edID: EditText
    private val arList = ArrayList<String>()
    private var requestQueue: RequestQueue? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edID = findViewById(R.id.edId)
        btnReg = findViewById(R.id.btnReg)
        btnLog = findViewById(R.id.btnLog)
        btnLog.setOnClickListener(View.OnClickListener {
            val inte = Intent(this, MainActivity::class.java)
            inte.putExtra("key", edID.text.toString())
            Log.e("TAG", "onCreate: " + edID.text.toString())
            startActivity(inte)
        })
        requestQueue = Volley.newRequestQueue(this)
        /*  btnReg.setOnClickListener(View.OnClickListener {

              val inte=Intent(this,RegisterActivity::class.java)
              inte.putExtra("key",edID.text)
              startActivity(inte)
          })*/

        btnReg.setOnClickListener {
            val inte = Intent(this, RegisterActivity::class.java)
            inte.putExtra("key", edID.text.toString())
            Log.e("TAG", "onCreate: " + edID.text.toString())
            startActivity(inte)
        }
    }

    fun testVolly(view: View) {
        var edID = findViewById<TextView>(R.id.tv)
        val url = "https://reqres.in/api/login"
        val request = JsonObjectRequest(Request.Method.GET, url, null, { response ->
            try {
                edID.setText(response.toString())

                val jsonObj = response.getString("total");
                val jsonarr = response.getJSONArray("data");
                Log.e("TAG", "testVolly: " + jsonObj)
                for (i in 0 until jsonarr.length()) {
                    val onj = jsonarr.getJSONObject(i);
                    val name = onj.getString("name")
                    arList.add(name)
                    // Log.e("TAG", "testVolly: " + name)
                }
                for (i in 0 until arList.size)
                    Log.e("TAG", "testVolly: " + arList[i])
                /* val jsonArray = response.getJSONArray("employees")
                 for (i in 0 until jsonArray.length()) {
                     val employee = jsonArray.getJSONObject(i)
                     val firstName = employee.getString("firstname")
                     val age = employee.getInt("age")
                     val mail = employee.getString("mail")
                     edID.append("$firstName, $age, $mail\n\n")
                 }*/
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }, { error -> error.printStackTrace() })
        requestQueue?.add(request)
    }
}