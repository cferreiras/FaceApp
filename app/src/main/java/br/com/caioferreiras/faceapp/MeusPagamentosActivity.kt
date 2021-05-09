package br.com.caioferreiras.faceapp

import android.os.Bundle

class MeusPagamentosActivity: NavigationDrawerActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagamento)
        ConfiguraMenuLateral()
    }
}