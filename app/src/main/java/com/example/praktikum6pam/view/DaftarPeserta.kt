package com.example.praktikum6pam.view


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
// import androidx.compose.foundation.layout.Box // Tidak terpakai
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.praktikum6pam.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DaftarPeserta(
    onBeranda: () -> Unit,
    onForm: () -> Unit,
    modifier: Modifier = Modifier
){
    val allBiodata = listOf(
        listOf(
            "NAMA LENGKAP" to "Refky Muhammad Syahrin",
            "JENIS KELAMIN" to "Laki-laki",
            "STATUS PERKAWINAN" to "Belum Menikah",
            "ALAMAT" to "Texas, JABAR"
        ),
        listOf(
            "NAMA LENGKAP" to "Rafina Raihani",
            "JENIS KELAMIN" to "Perempuan",
            "STATUS PERKAWINAN" to "Belum Menikah",
            "ALAMAT" to "Yokohama, JAPAN"
        ),
        listOf(
            "NAMA LENGKAP" to "Rina Marlina",
            "JENIS KELAMIN" to "Perempuan",
            "STATUS PERKAWINAN" to "Menikah",
            "ALAMAT" to "Ikikwiradikarta, JABAR"
        ),
        listOf(
            "NAMA LENGKAP" to "Pinaky",
            "JENIS KELAMIN" to "Laki-laki",
            "STATUS PERKAWINAN" to "Belum Menikah",
            "ALAMAT" to "Los Angeles, JABAR"
        ),
        listOf(
            "NAMA LENGKAP" to "PapaBurjo",
            "JENIS KELAMIN" to "Laki-laki",
            "STATUS PERKAWINAN" to "Madep",
            "ALAMAT" to "Texasmalaya, JABAR"
        )
    )

    // Column Utama
    Column (modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp, bottom = 16.dp)
                .size(size = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text = stringResource(id = R.string.list), fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Color.Black)
        }


        // LazyColumn (List yang bisa di-scroll)
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp)
        ) {
            itemsIndexed(allBiodata) {index, biodata ->
                //untuk biodata
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .background(color = Color.LightGray)
                        .padding(20.dp)
                ){
                    biodata.chunked(2).forEach { rowItems ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ){
                            rowItems.forEach { (label, value) ->
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = label,
                                        style = MaterialTheme.typography.labelMedium.copy(
                                            fontWeight = FontWeight.Bold,
                                            color = Color.Black
                                        )
                                    )
                                    Text(
                                        text = value,
                                        style = MaterialTheme.typography.bodyMedium.copy(
                                            color = Color.Blue
                                        )
                                    )
                                }
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Button(
                onClick = onBeranda,
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                border = BorderStroke(1.dp, Color.DarkGray)
            ) { Text("Beranda", color = Color.Black) }

            Button(
                onClick = onForm,
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                border = BorderStroke(1.dp, Color.DarkGray)
            ) { Text("Formulir", color = Color.Black) }
        }

    }
}