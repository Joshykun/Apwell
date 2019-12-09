package adu.capstone.apwell.splash

import adu.capstone.apwell.R
import adu.capstone.apwell.terms.TermsActivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import gr.net.maroulis.library.EasySplashScreen

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val splashView = EasySplashScreen(this)
            .withTargetActivity(TermsActivity::class.java)
            .withSplashTimeOut(4000)
            .withBackgroundResource(R.drawable.apwellsplashscreen)
            .create()

        setContentView(splashView)
    }
}
