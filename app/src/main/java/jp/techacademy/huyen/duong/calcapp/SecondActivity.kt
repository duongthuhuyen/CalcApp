package jp.techacademy.huyen.duong.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import jp.techacademy.huyen.duong.calcapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val result = intent.getDoubleExtra("value", 0.0)
        if (result.isInfinite()) {
            binding.textview.setText("計算中に、エラーが出たので入力したのをチェックお願いします。")
        } else {
            binding.textview.setText(result.toString())
        }
    }
}