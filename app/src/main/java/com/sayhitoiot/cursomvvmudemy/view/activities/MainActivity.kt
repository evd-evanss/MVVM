package com.sayhitoiot.cursomvvmudemy.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AlertDialogLayout
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.sayhitoiot.cursomvvmudemy.view.adapters.NotasAdapter
import com.sayhitoiot.cursomvvmudemy.R
import com.sayhitoiot.cursomvvmudemy.model.Nota
import com.sayhitoiot.cursomvvmudemy.viewmodels.NotasViewMode
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_insert.view.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val notasViewModel: NotasViewMode by viewModel()

    val notasAdapter: NotasAdapter by lazy {
        NotasAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        my_recyclerview.adapter = notasAdapter
        my_recyclerview.layoutManager = LinearLayoutManager(this)

        notasViewModel.getNotas().observe(this, Observer { data ->
            data?.let {
                notasAdapter.addAll(it)
            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_add -> {
                Log.i("menu", "item add clicado")
                //TODO: Chamar tela de adcionar nota
                dialogAddNota()
            }
            R.id.action_edit -> Log.i("menu", "item edit clicado")
            R.id.action_delete -> Log.i("menu", "item delete clicado")
        }
        return super.onOptionsItemSelected(item)
    }

    private fun dialogAddNota() {
        val layout = LayoutInflater.from(this).inflate(R.layout.dialog_insert, null, false)
        val inputNota = layout.edt_insert
        val dialog = AlertDialog.Builder(this).setView(layout)
        dialog.setNegativeButton("Cancelar", null)
        dialog.setPositiveButton("Salvar") { d, i ->
        val nota = Nota(0, inputNota?.text.toString())
            notasViewModel.insertNota(nota)
        }
        dialog.create().show()
    }
}

