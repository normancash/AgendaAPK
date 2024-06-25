package com.uam.agenda.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.uam.agenda.model.AgendaItem
import com.uam.agenda.viewmodel.AgendaViewModel


@Composable
fun AgendaApp(padding: Modifier) {

    val agendaModel : AgendaViewModel = viewModel()
    val collectState by agendaModel._mstate.collectAsState()

    if (collectState.loading) {
        Box(modifier = Modifier.fillMaxSize()
            ,contentAlignment = Alignment.Center)
        {
            CircularProgressIndicator()
        }
    }

    LazyColumn(verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally) {
       itemsIndexed(items = collectState.listData) {index,item ->
           CardAgenda(item)
       }
    }
}

@Composable
fun CardAgenda(item: AgendaItem) {
   Card(
       modifier = Modifier
           .fillMaxSize()
           .padding(10.dp),
       elevation = CardDefaults.cardElevation(8.dp)
   ) {
       Column(
           horizontalAlignment = Alignment.CenterHorizontally,
           verticalArrangement = Arrangement.Center
       ) {
           Text(
               text = "Nombre Cliente:${item.nombreCliente}",
               modifier = Modifier.align(Alignment.Start)
           )
           Text(
               text = "Motivo:  ${item.motivo}",
               modifier = Modifier.align(Alignment.Start)
           )
           Text(
               text = "Fecha:  ${item.fecha}",
               modifier = Modifier.align(Alignment.Start)
           )
       }
       Spacer(modifier=Modifier.height(20.dp))
   }
}
