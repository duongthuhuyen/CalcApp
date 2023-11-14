package jp.techacademy.huyen.duong.calcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import jp.techacademy.huyen.duong.calcapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.button1.setOnClickListener(this)
        binding.button2.setOnClickListener(this)
        binding.button3.setOnClickListener(this)
        binding.button4.setOnClickListener(this)
    }

    //足し算の関数
    private fun add(a: Double?, b: Double?): Double {
        return a!! + b!!
    }

    //引き算の関数
    private fun sub(a: Double?, b: Double?): Double {
        return a!! - b!!
    }

    //掛け算の関数
    private fun multi(a: Double?, b: Double?): Double {
        return a!! * b!!
    }

    // 割り算の関数
    private fun divid(a: Double?, b: Double?): Double {
        var result: Double = 0.0
//        try {
        result = a!! / b!!
//        } catch (e: Exception) {
//            Log.d(MY_TAG, "エラーが出た")
//        }
        return result
    }

    //画面遷移の関数
    private fun switchScreen(result: Double) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("value", result)
        startActivity(intent)
    }

    override fun onClick(p0: View?) {
        var a: Double? = binding.edittext1.text.toString().toDoubleOrNull()
        var b: Double? = binding.edittext2.text.toString().toDoubleOrNull()
        //nullをチェックする
        if (a != null && b != null) {
            when (p0?.id) {
                R.id.button1 -> switchScreen(add(a, b))
                R.id.button2 -> switchScreen(sub(a, b))
                R.id.button3 -> switchScreen(multi(a, b))
                R.id.button4 -> switchScreen(divid(a, b))
            }
        }
    }
}

const val MY_TAG: String = "UI"