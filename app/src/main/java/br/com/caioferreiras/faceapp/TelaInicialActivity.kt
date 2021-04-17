package br.com.caioferreiras.faceapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.toolbar.*

class TelaInicialActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        val args = intent.extras
        val usuario = args?.getString("usuario")
        //val numero = args?.getInt("numero")
        //val logico_2 = args?.getBoolean("logico_2")

        Toast.makeText(this, usuario, Toast.LENGTH_LONG).show()

        setSupportActionBar(toolbar)

        supportActionBar?.title = "Sua conta"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        button_pedidos.setOnClickListener {
            val intent = Intent(this, PedidosActivity::class.java)
            startActivity(intent)

        }

        button_pagamento.setOnClickListener {
            val intent = Intent(this, PagamentoActivity::class.java)
            startActivity(intent)
        }

        button_desejos.setOnClickListener {
            val intent = Intent(this, DesejosActivity::class.java)
            startActivity(intent)
        }

        }
        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.menu_main, menu)
            return true
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            val id = item.itemId

            if (id == R.id.action_buscar) {
                Toast.makeText(this, "Clicou buscar", Toast.LENGTH_SHORT).show()
            } else if (id == R.id.action_atualizar) {
                Toast.makeText(this, "Clicou atualizar", Toast.LENGTH_SHORT).show()
            } else if (id == R.id.action_config) {
                val intent = Intent(this, ConfiguracoesActivity::class.java)
                Toast.makeText(this, "Clicou configigurações", Toast.LENGTH_SHORT).show()

                startActivity(intent)

            } else if (id == R.id.action_sair) {
                val intent = Intent(this, MainActivity::class.java)
                Toast.makeText(this, "Clicou sair", Toast.LENGTH_SHORT).show()

                startActivity(intent)

            } else if (id == android.R.id.home) {
                finish()
            }

            return super.onOptionsItemSelected(item)

        }

    }