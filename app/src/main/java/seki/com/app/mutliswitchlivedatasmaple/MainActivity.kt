package seki.com.app.mutliswitchlivedatasmaple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel: SampleViewModel by lazy {
        ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(SampleViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
            viewModel.onResultChange1(button1.isChecked)
        }

        button2.setOnClickListener {
            viewModel.onResultChange2(button2.isChecked)
        }

        viewModel.completed.observe(this, Observer { completed ->
            result.text = if (completed) "Completed" else "Computing"
        })
    }
}
