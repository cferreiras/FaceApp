package br.com.caioferreiras.faceapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class NovidadeAdapter(val novidade: List<Novidade>,
                       val onClick: (Novidade) -> Unit
                    ):RecyclerView.Adapter<NovidadeAdapter.NovidadeViewHolder>() {

    class NovidadeViewHolder(view: View): RecyclerView.ViewHolder(view){
        val cardNome: TextView
        val cardImg: ImageView
        val cardProgress: ProgressBar
        val cardView: CardView

        init {
            cardNome = view.findViewById(R.id.card_nome)
            cardImg = view.findViewById(R.id.card_img)
            cardProgress = view.findViewById(R.id.card_progress)
            cardView = view.findViewById(R.id.card_novidades)
        }
    }

    override fun getItemCount() = this.novidade.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NovidadeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_novidade,parent, false)
        val holder = NovidadeViewHolder(view)

        return holder
    }

    override fun onBindViewHolder(holder: NovidadeViewHolder, position: Int) {
        val novidades = this.novidade[position]

        holder.cardNome.text = novidades.nome
        holder.cardProgress.visibility = View.VISIBLE

        val contexto = holder.itemView.context

        Picasso.with(contexto).load(novidades.foto).fit().into(holder.cardImg,
        object: com.squareup.picasso.Callback{
            override fun onSuccess() {
                holder.cardProgress.visibility = View.GONE
            }

            override fun onError() {
                holder.cardImg.setImageResource(R.drawable.login_image)
            }


        }

        )


        holder.itemView.setOnClickListener{onClick(novidades)}


    }


}

