package br.com.caioferreiras.faceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PedidosActivity : NavigationDrawerActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedidos)
        ConfiguraMenuLateral()
    }
}