package com.example.praktikum6pam.view


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.praktikum6pam.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Pendaftaran(
    onBeranda: () -> Unit,
    modifier: Modifier = Modifier
){



    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }
    var textKWN by remember { mutableStateOf("") }

    val gender: List<String> = listOf("Laki-laki", "Perempuan")
    val kawin: List<String> = listOf("Menikah", "Belum Menikah", "Malas Menikah")

    var Nama by remember { mutableStateOf("") }
    var Alamat by remember { mutableStateOf("") }
    var JK by remember { mutableStateOf("") }
    var KWN by remember { mutableStateOf("") }

//    untuk dropdown
    var expanded by remember { mutableStateOf(false) }

//    DIAGLO
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = R.string.judul_formulir))
    }

    Column (modifier = Modifier
        .fillMaxWidth()
        .padding(top = 180.dp, start = 30.dp, end = 30.dp)
    ){

        Text(
            text = stringResource(id = R.string.nama_lengkap),
            fontSize = 15.sp,
            color = Color.Black

        )


        OutlinedTextField(
            value = textNama,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .width(350.dp),
            label = { Text(text = "Nama Lengkap") },
            onValueChange = { textNama = it }
        )

        Spacer(modifier = Modifier.height(30.dp))

        Column {
            Text(
                text = stringResource(id = R.string.jenis_kelamin),
                fontSize = 15.sp,
                color = Color.Black
            )
            Row {
                gender.forEach { item ->
                    Row(
                        modifier = Modifier.selectable(
                            selected = textJK == item,
                            onClick = { textJK = item }
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(selected = textJK == item, onClick = { textJK = item })
                        Text(item)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Column {
            Text(
                text = stringResource(id = R.string.status_kawin),
                fontSize = 15.sp,
                color = Color.Black
            )
//        ini buat dropdown
            Box(

            ) {
                OutlinedTextField(
                    value = textKWN,
                    onValueChange = { textKWN = it },
                    label = { Text("Pilih Status Kawin") },
                    singleLine = true,
                    shape = MaterialTheme.shapes.large,
                    readOnly = true,
                    modifier = Modifier
                        .width(350.dp)
                        .clickable() { expanded = true },
                    trailingIcon = {
                        IconButton(onClick = { expanded = !expanded }) {
                            Icon(
                                imageVector = if (expanded)
                                    Icons.Default.ArrowDropDown
                                else
                                    Icons.Default.ArrowDropDown,
                                contentDescription = "Dropdown icon"
                            )
                        }
                    }
                )

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier.width(350.dp)
                ) {
                    kawin.forEach { status ->
                        DropdownMenuItem(
                            text = { Text(status) },
                            onClick = {
                                textKWN = status
                                expanded = false
                            }
                        )
                    }
                }
            }


//        nih baru alamat
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = stringResource(id = R.string.alamat),
                fontSize = 15.sp,
                color = Color.Black
            )
            OutlinedTextField(
                value = textAlamat,
                singleLine = true,
                shape = MaterialTheme.shapes.large,
                modifier = Modifier
                    .width(350.dp)
                ,
                label = { Text(text = "Alamat") },
                onValueChange = { textAlamat = it }
            )
        }
    }



    Box(Modifier.fillMaxSize()){
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .background(Color.White)
                .padding(vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,

            ) {
            Button(
                onClick = onBeranda,
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                border = BorderStroke(1.dp, Color.LightGray)
            ) { Text("Beranda", color = Color.Black) }

            Button(


                onClick = {
                    Nama = textNama
                    Alamat = textAlamat
                    JK = textJK
                    KWN= textKWN
                    showDialog = true
                }
            ) {
                Text(text = stringResource(id = R.string.submit))
            }

            if (showDialog) {
                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    title = {
                        Text(
                            text = "Data Registrasi",
                            fontSize = 22.sp,
                            color = Color(0xFF3F51B5)
                        )
                    },
                    text = {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp)
                        ) {
                            Text(
                                text = "Nama Lengkap:",
                                fontSize = 14.sp,
                                color = Color.Gray
                            )
                            Text(
                                text = Nama,
                                fontSize = 16.sp,
                                modifier = Modifier.padding(bottom = 12.dp)
                            )

                            Text(
                                text = "Alamat:",
                                fontSize = 14.sp,
                                color = Color.Gray
                            )
                            Text(
                                text = Alamat,
                                fontSize = 16.sp,
                                modifier = Modifier.padding(bottom = 12.dp)
                            )

                            Text(
                                text = "Jenis Kelamin:",
                                fontSize = 14.sp,
                                color = Color.Gray
                            )
                            Text(
                                text = JK,
                                fontSize = 16.sp,
                                modifier = Modifier.padding(bottom = 12.dp)
                            )

                            Text(
                                text = "Status Kawin:",
                                fontSize = 14.sp,
                                color = Color.Gray
                            )
                            Text(
                                text = KWN,
                                fontSize = 16.sp,
                                modifier = Modifier.padding(bottom = 12.dp)
                            )
                        }
                    },
                    confirmButton = {
                        Button(
                            onClick = onBeranda,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Blue
                            )
                        ) {
                            Text("OK")
                        }
                    }

                )
            }
        }
    }

}