package com.example.praktikum6pam.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.praktikum6pam.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard(
    onNavigate: () -> Unit,
    modifier: Modifier = Modifier
){
    var isloading by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 150.dp),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(text = stringResource(id = R.string.welcome),
            fontSize = 40.sp)

        Spacer(modifier = Modifier.height(10.dp))

    }
}