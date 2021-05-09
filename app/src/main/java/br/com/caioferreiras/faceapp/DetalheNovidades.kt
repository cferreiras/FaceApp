package br.com.caioferreiras.faceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detalhe_novidades.*

class DetalheNovidades : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_novidades)

        var novidade = intent.getSerializableExtra("novidades") as Novidade

        novidade_nome.text = novidade.nome

        Picasso.with(this).load(novidade.foto).fit().into(imageView_novidade)




    }
}