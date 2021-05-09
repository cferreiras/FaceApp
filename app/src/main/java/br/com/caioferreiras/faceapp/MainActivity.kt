package br.com.caioferreiras.faceapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*

class MainActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        imageview_login.setImageResource(R.drawable.login_image)

        login_button.setOnClickListener {
            val textoUsuario = user_input.text.toString()
            val textoSenha = password_input.text.toString()



            var intent = Intent(this, TelaInicialActivity::class.java)

            val params = Bundle()
            params.putString("usuario", textoUsuario)
            params.putInt("numero", 10)

            intent.putExtras(params)

            intent.putExtra("numero_double", 1.75)
            intent.putExtra("logico_2", false)

            if (textoUsuario == "aluno" && textoSenha == "impacta"){
                user_input.text.clear()
                password_input.text.clear()
                startActivity(intent)
            } else {
                user_input.text.clear()
                password_input.text.clear()
                Toast.makeText(this, "Usuario Ou senha Invalidos", Toast.LENGTH_SHORT).show()
                user_input.hasFocus()

            }

            }

    }
}