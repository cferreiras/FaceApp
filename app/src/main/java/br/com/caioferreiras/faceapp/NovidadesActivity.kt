package br.com.caioferreiras.faceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.arch.core.executor.DefaultTaskExecutor
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_novidades.*
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.activity_tela_inicial.layoutMenuLateral
import kotlinx.android.synthetic.main.activity_tela_inicial.menu_lateral
import kotlinx.android.synthetic.main.toolbar.*

class NovidadesActivity : NavigationDrawerActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novidades)

        ConfiguraMenuLateral()
        recyclerNovidades?.layoutManager = LinearLayoutManager(this)
        recyclerNovidades?.itemAnimator = DefaultItemAnimator()
        recyclerNovidades?.setHasFixedSize(true)

    }

    override fun onResume() {
        super.onResume()
        taskNovidades()
    }
    private var novidades = listOf<Novidade>()

    private fun taskNovidades(){
        this.novidades = NovidadeService.getNovidade()
        recyclerNovidades?.adapter = NovidadeAdapter(novidades){onClickNovidades(it)}

    }

    fun onClickNovidades(novidades: Novidade){
        Toast.makeText(this,    "Clicou Na Novidade: ${novidades.nome}", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, DetalheNovidades::class.java)
        intent.putExtra("novidades",novidades)
        startActivity(intent)

    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_buscar) {
            Toast.makeText(this, "Clicou Buscar", Toast.LENGTH_SHORT).show()
        } else if (id == R.id.action_atualizar) {
            Toast.makeText(this, "Clicou Atualizar", Toast.LENGTH_SHORT).show()
        } else if (id == R.id.action_config) {
            val intent = Intent(this, ConfiguracoesActivity::class.java)
            Toast.makeText(this, "Clicou Configurações", Toast.LENGTH_SHORT).show()

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