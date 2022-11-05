package com.dagoras.osunolock

import android.R
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dagoras.osunolock.databinding.ActivitySplashBinding
import kotlin.system.exitProcess


class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private lateinit var bluetoothAdapter: BluetoothAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupBinding() {
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
        checkBluetoothNull()
        bluetoothRequest()
    }

    private fun checkBluetoothNull() {
        if (bluetoothAdapter == null) {
            AlertDialog.Builder(this)
                .setTitle("Not compatible")
                .setMessage("Your phone does not support Bluetooth")
                .setPositiveButton("Exit") { _, _ -> exitProcess(0) }
                .setIcon(R.drawable.ic_dialog_alert)
                .show()
        }
    }

    @SuppressLint("MissingPermission")
    private fun bluetoothRequest() {
        if (bluetoothAdapter.isEnabled) {
            val enableBluetooth = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            startActivityForResult(enableBluetooth, 1)
        }
    }
}