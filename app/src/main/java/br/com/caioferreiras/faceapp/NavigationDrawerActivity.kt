package br.com.caioferreiras.faceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.toolbar.*
import java.text.MessageFormat

open class NavigationDrawerActivity :  DebugActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

        protected fun ConfiguraMenuLateral(){

            setSupportActionBar(toolbar)

            supportActionBar?.title = "Conta"
            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            var toogle = ActionBarDrawerToggle(
                this,
                layoutMenuLateral,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close
            )

            layoutMenuLateral.addDrawerListener(toogle)
            toogle.syncState()

            menu_lateral.setNavigationItemSelectedListener(this)

        }

        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            when(item.itemId){

                R.id.nav_home->{
                    //Toast.makeText(this,    "Clicou na Home", Toast.LENGTH_SHORT).show()

                    var intent= Intent(this, TelaInicialActivity::class.java)
                    startActivity(intent)

                }

                R.id.nav_perfil->{
                    Toast.makeText(this,    "Clicou no Perfil", Toast.LENGTH_SHORT).show()

                }

                R.id.nav_meusPedidos -> {
                    Toast.makeText(this,    "Clicou no eus Pedidos", Toast.LENGTH_SHORT).show()
                    //var intent= Intent(this, MeusPedidosActivity::class.java)
                    //startActivity(intent)

                }

                R.id.nav_dadosPagamento->{
                    Toast.makeText(this,    "Clicou no Dados de Pagamento", Toast.LENGTH_SHORT).show()
                    var intent= Intent(this,MeusPagamentosActivity::class.java)
                    startActivity(intent)

                }

                R.id.nav_mensagens->{
                    Toast.makeText(this,    "Clicou na Mensagens", Toast.LENGTH_SHORT).show()
                    //var intent= Intent(this, MensagemActivity::class.java)
                    //startActivity(intent)

                }

                R.id.nav_listaDesejos->{
                    Toast.makeText(this,    "Clicou na Lista de Desejos", Toast.LENGTH_SHORT).show()
                    //var intent= Intent(this, TelaInicialActivity::class.java)
                    //startActivity(intent)

                }

                R.id.nav_localizacao->{
                    Toast.makeText(this,    "Clicou na Localização", Toast.LENGTH_SHORT).show()

                }

                R.id.nav_config -> {
                    Toast.makeText(this,    "Clicou na Configuração", Toast.LENGTH_SHORT).show()
                    var intent= Intent(this, ConfiguracoesActivity::class.java)
                    startActivity(intent)

                }

                R.id.nav_sair -> {
                    var intent= Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }

            }

            layoutMenuLateral.closeDrawer(GravityCompat.START)
            return true
        }

    }
