package com.example.moscowexcursion2

import android.os.Bundle
import android.os.Parcelable
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.moscowexcursion2.databinding.ActivityExursionBinding
import com.example.moscowexcursion2.model.Routes

class ExcursionActivity: AppCompatActivity() {

        private var counter = 0
        lateinit var myRoutes: ArrayList<*>

        private val binding: ActivityExursionBinding by lazy {
            DataBindingUtil.setContentView<ActivityExursionBinding>(this, R.layout.activity_exursion).apply {
                lifecycleOwner = this@ExcursionActivity
            }
        }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
            setContentView(R.layout.activity_exursion)

        myRoutes = intent.getParcelableArrayListExtra<Parcelable>("routes") as ArrayList<*> /* = java.util.ArrayList<*> */
        binding.route = myRoutes[0] as Routes?
    }

        fun onClickClose(view: View) {
            this.finish()
        }

        fun onClickNext(view: View) {
            if (counter < myRoutes.size - 1){
                counter++
                binding.route = myRoutes[counter] as Routes?
                if (counter == myRoutes.size - 1){
                    binding.continueBtn.text = "Завершить"
                }
            }else if (counter == myRoutes.size - 1){
                this.finish()
            }
        }

    fun onClickBack(view: View) {
        if (counter == myRoutes.size - 1){
            binding.continueBtn.text = "Далее"
        }
        if (counter > 0){
            counter--
            binding.route = myRoutes[counter] as Routes?
        }
        }
}