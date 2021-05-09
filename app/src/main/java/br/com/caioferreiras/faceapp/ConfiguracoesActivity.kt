package br.com.caioferreiras.faceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ConfiguracoesActivity : NavigationDrawerActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configurations)
        ConfiguraMenuLateral()
    }
}