package com.example.ucp1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HeaderSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                contentAlignment = Alignment.BottomEnd,
                modifier = Modifier.size(72.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .padding(4.dp),
                    tint = Color.White
                )
            }
            Column(
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Text(text = "Webesite Pemesanan Tiket")
                Text(text = "Kereta Api")

            }
        }
    }
}

@Composable
fun TampilanPesanan(param: String, argu: String) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = param,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = ":",
                modifier = Modifier.weight(0.1f)
            )
        }
    }

}


@Preview(showBackground = true)
@Composable
fun PemesananKAI(modifier: Modifier = Modifier
) {
    HeaderSection()




    var keberangkatan by remember { mutableStateOf("") }
    var tujuan by remember { mutableStateOf("") }
    var tanggal by remember { mutableStateOf("") }
    var kelas by remember { mutableStateOf("") }

    var dataKelas = listOf("Ekonomi", "Eksekutif")
    var confKeberangkatan by remember { mutableStateOf("") }
    var confTujuan by remember { mutableStateOf("") }
    var confTanggal by remember { mutableStateOf("") }
    var confKelas by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = keberangkatan,
            onValueChange = { keberangkatan = it },
            label = {
                Text(text = "Nama")
            },
            placeholder = {
                Text(text = "Isi nama anda")
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        TextField(
            value = tujuan,
            onValueChange = { tujuan = it },
            label = {
                Text(text = "Tujuan")
            },
            placeholder = {
                Text(text = "Isi tujuan anda")
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            dataKelas.forEach { selectedKelas ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = kelas == selectedKelas,
                        onClick = { kelas = selectedKelas }
                    )
                    Text(text = selectedKelas)
                }
            }
        }
        Button(onClick = {
            confKeberangkatan = keberangkatan
            confTujuan = tujuan
            confKelas = kelas
        }) {
            Text(text = "Submit")
        }


        TampilanPesanan(
            param = "Keberangkatan",
            argu = confKeberangkatan
        )
        TampilanPesanan(
            param = "Tujuan",
            argu = confTujuan
        )
        TampilanPesanan(
            param = "Kelas",
            argu = confKelas
        )

    }
}
