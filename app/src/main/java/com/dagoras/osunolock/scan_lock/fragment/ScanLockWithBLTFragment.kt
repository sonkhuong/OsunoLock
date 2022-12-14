package com.dagoras.osunolock.scan_lock.fragment

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity.RESULT_OK
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dagoras.osunolock.adapter.DeviceScanAdapter
import com.dagoras.osunolock.databinding.FragmentScanLockWithBltBinding
import com.dagoras.osunolock.model.DeviceInfo

class ScanLockWithBLTFragment : Fragment() {
    private val TAG = "ScanLockWithBLTFragment"
    private lateinit var binding: FragmentScanLockWithBltBinding
    private var bluetoothAdapter: BluetoothAdapter? = null
    private val availableDevices: MutableList<DeviceInfo> = mutableListOf()
    private val pairedDevices: ArrayList<DeviceInfo> = arrayListOf()
    private lateinit var availableAdapter: DeviceScanAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScanLockWithBltBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBinding()
    }

    private fun setupBinding() {
        val bluetoothManager = activity?.getSystemService(BluetoothManager::class.java)
        bluetoothAdapter = bluetoothManager?.adapter
        Log.d(
            TAG,
            "setupBinding: BT adapter = $bluetoothAdapter, enale = ${bluetoothAdapter?.isEnabled}"
        )
        if (bluetoothAdapter?.isEnabled == false) {
            requestTurnOnBT()
        }
        with(binding) {
            viewToolbar.buttonScan.setOnClickListener {
                Log.d(TAG, "setupBinding: BT adapter = $bluetoothAdapter")
                val filter = IntentFilter(BluetoothDevice.ACTION_FOUND)
                requireActivity().registerReceiver(findDeviceReceiver, filter)
                scanDevices()
            }
            availableAdapter = DeviceScanAdapter(availableDevices)
            rvAvailableDevices.adapter = availableAdapter
        }
    }

    private fun requestTurnOnBT() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val bluetoothConnect = ContextCompat.checkSelfPermission(
                requireActivity(),
                Manifest.permission.BLUETOOTH_CONNECT
            ) == PackageManager.PERMISSION_GRANTED
            Log.d(TAG, "requestTurnOnBT: SDK > S bluetoothConnect = $bluetoothConnect")
            if (bluetoothConnect) {
                turnOnBT()
            } else {
                requestBtConnectPermission.launch(Manifest.permission.BLUETOOTH_CONNECT)
            }
        } else {
            //API level 30 and below
            val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            requestBluetooth.launch(enableBtIntent)
        }
    }

    private val requestBtConnectPermission =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                turnOnBT()
            }
        }

    private fun turnOnBT() {
        val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
        requestBluetooth.launch(enableBtIntent)
    }

    private fun scanDevices() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            checkBtScanPermission()
        } else {
            val location = ContextCompat.checkSelfPermission(
                requireActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
            if (location) {
                bluetoothAdapter?.startDiscovery()
            } else {
                requestBluetoothPermissions.launch(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION))
            }
        }
    }

    private fun checkBtScanPermission() {
        activity?.let {
            val bluetoothScan =
                ContextCompat.checkSelfPermission(
                    requireActivity(),
                    Manifest.permission.BLUETOOTH_SCAN
                ) == PackageManager.PERMISSION_GRANTED
            if (bluetoothScan) {
                Log.d(TAG, "checkAndRequestPermission:  adapter = $bluetoothAdapter")
                bluetoothAdapter?.startDiscovery()
            }
            val listPermissionNeeded = arrayListOf<String>()
            if (!bluetoothScan) {
                listPermissionNeeded.add(Manifest.permission.BLUETOOTH_SCAN)
            }
            if (listPermissionNeeded.isNotEmpty()) {
                requestBluetoothPermissions.launch(
                    arrayOf(
                        Manifest.permission.BLUETOOTH_SCAN
                    )
                )
            }
        }
    }

    @SuppressLint("MissingPermission")
    private val requestBluetoothPermissions =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            permissions.entries.forEach {
                Log.d(TAG, "${it.key} = ${it.value}")
            }
            val data = permissions.containsValue(false)
            Log.d(TAG, "data:$data ")
            if (!permissions.containsValue(false)) {
                Log.d(TAG, "bluetoothAdapter: $bluetoothAdapter -- startDiscovery ")
                bluetoothAdapter?.startDiscovery()
            }
        }

//    private fun navigateToManagerLock() {
//        val action =
//            ScanLockWithBLTFragmentDirections.actionFragmentScanLockWithBLTToManagerLockFragment()
//        findNavController().navigate(action)
//    }

    @SuppressLint("MissingPermission")
    private var requestBluetooth =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                Log.d(TAG, "resultCode OK")
            } else {
                //deny
                Toast.makeText(
                    activity,
                    "Cannot find device because bluetooth is denied",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

    private val findDeviceReceiver = object : BroadcastReceiver() {
        @SuppressLint("MissingPermission")
        override fun onReceive(context: Context?, intent: Intent?) {
            Log.d(TAG, "onReceive: Intent action = ${intent?.action}")
            when (intent?.action) {
                BluetoothDevice.ACTION_FOUND -> {
                    val device: BluetoothDevice? =
                        intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE)
                    if (device?.name != null) {
                        val deviceInfo = DeviceInfo(device.name, device.type, device.address)
                        if (!availableDevices.contains(deviceInfo)) {
                            availableDevices.add(deviceInfo)
                            availableAdapter.notifyItemInserted(availableDevices.size - 1)
                            Log.d(TAG, "onReceive: $availableDevices")
                        }
                    }
                }
            }
        }
    }
}