package com.uam.agenda.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
       modifier = Modifier.fillMaxSize(),
       elevation = CardDefaults.cardElevation(8.dp)
   ) {
       Text(
           text="Nombre Cliente: + ${item.nombreCliente}",
           modifier = Modifier.align(Alignment.Start)
       )
   }
}
