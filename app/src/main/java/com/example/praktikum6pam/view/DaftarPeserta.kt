package com.example.praktikum6pam.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import java.lang.reflect.Modifier

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

}