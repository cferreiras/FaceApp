package br.com.caioferreiras.faceapp

object NovidadeService {
    fun getNovidade(): List<Novidade>{
        val novidades = mutableListOf<Novidade>()

        for (i in 1..10){
            val n = Novidade()
            n.nome = "Processo $i"
            n.conteudo = "Conteudo $i"
            n.foto = "Imagem $i"
            n.linksite = "Site $i"

            novidades.add(n)
        }

        return novidades
    }


}