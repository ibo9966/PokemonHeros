package com.example.pokemondunyam

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dene3.Pokemon
import com.example.dene3.PokemonAdapter
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity2 : AppCompatActivity() {
    val PokemonListesi = ArrayList<Pokemon>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        PokemonListesi.add(Pokemon("bulbasaur",R.mipmap.bulbasaur))
        PokemonListesi.add(Pokemon("butterfree",R.mipmap.butterfree))
        PokemonListesi.add(Pokemon("pikachu",R.mipmap.pikachu))
        PokemonListesi.add(Pokemon("charmander",R.mipmap.charmander))
        PokemonListesi.add(Pokemon("pidgey",R.mipmap.pidgey))
        PokemonListesi.add(Pokemon("blastoise",R.mipmap.blastoise))
        PokemonListesi.add(Pokemon("caterpie",R.mipmap.caterpie))
        PokemonListesi.add(Pokemon("charizard",R.mipmap.charizard))
        PokemonListesi.add(Pokemon("ivysaur",R.mipmap.ivysaur))
        PokemonListesi.add(Pokemon("metapod",R.mipmap.metapod))
        PokemonListesi.add(Pokemon("onix",R.mipmap.onix))
        PokemonListesi.add(Pokemon("pidgeot",R.mipmap.pidgeot))
        PokemonListesi.add(Pokemon("pidgeotto",R.mipmap.pidgeotto))
        PokemonListesi.add(Pokemon("raichu",R.mipmap.raichu))
        PokemonListesi.add(Pokemon("raticate",R.mipmap.raticate))
        PokemonListesi.add(Pokemon("rattata",R.mipmap.rattata))
        PokemonListesi.add(Pokemon("squirtle",R.mipmap.squirtle))
        PokemonListesi.add(Pokemon("venusaur",R.mipmap.venusaur))
        PokemonListesi.add(Pokemon("weedle",R.mipmap.weedle))
        PokemonListesi.add(Pokemon("weepinbell",R.mipmap.weepinbell))
        PokemonListesi.add(Pokemon("wortortle",R.mipmap.wortortle))

        val adapter= PokemonAdapter(PokemonListesi)
        val intent = Intent(this,MainActivity3::class.java)
        adapter.setOnItemClickListener(object : PokemonAdapter.OnItemClickListener{
            override fun onItemClick(myObject: Pokemon?) {
                val mBundle = Bundle()
                mBundle.putString("data", myObject?.ad)
                myObject?.pokemonıd?.let { mBundle.putInt("image_id", it) }
                intent.putExtras(mBundle)
                startActivity(intent)
            }
        })
        rvPokemonlar.adapter=adapter

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation=LinearLayoutManager.VERTICAL
        layoutManager.scrollToPosition(0)
        rvPokemonlar.layoutManager = layoutManager
        rvPokemonlar.addItemDecoration(DividerItemDecoration(this,layoutManager.orientation))
    }

}