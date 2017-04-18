package com.android.settings.scanner;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

public class BluetoothAutoConnectService extends Service {

    private final static String TAG = "BluetoothAutoConnectService";
    private BluetoothAdapter mBluetoothAdapter;
    private Set<BluetoothDevice> mBondedDevices;
    private String mTargetDeviceName;

    private static int MSG_CONNECT_DEVICE = 1;

    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            switch (msg.what) {
            case 1:// MSG_CONNECT_DEVICE
                connectTargetDevice();
                break;
            default:
                break;
            }
            super.handleMessage(msg);
        }

    };

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        init();
    }

    private void init() {
        // TODO Auto-generated method stub

        IntentFilter filter = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
        filter.addAction(BluetoothDevice.ACTION_FOUND);
        filter.addAction(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
        this.registerReceiver(receiver, filter);

        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO Auto-generated method stub
        if (intent != null) {
            String scanResult = intent.getStringExtra("scan_result");
            HashMap<String, String> scanResultHashMap = ScanResultTransform.strToHashMap(scanResult);
            if ("bluetooth".equals(scanResultHashMap.get("way")) && scanResultHashMap.get("target") != null) {
                mTargetDeviceName = scanResultHashMap.get("target");
                Log.v(TAG, "mTargetDeviceName--->" + mTargetDeviceName);
                // open bluetooth
                if (!mBluetoothAdapter.isEnabled()) {
                    mBluetoothAdapter.enable();
                    mHandler.sendEmptyMessageDelayed(MSG_CONNECT_DEVICE, 2000);
                } else {
                    mHandler.sendEmptyMessage(MSG_CONNECT_DEVICE);
                }
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

    private void connectTargetDevice() {
        // find device and connect;
        if (checkBoundedDevices()) {
            // connect boundedDevices
        } else {
            checkFoundDevices();
        }
    }

    private boolean checkBoundedDevices() {
        // TODO Auto-generated method stub
        mBondedDevices = mBluetoothAdapter.getBondedDevices();
        if (mBondedDevices != null) {
            for (BluetoothDevice device : mBondedDevices) {
                if (mTargetDeviceName.equals(device.getName())) {
                    Log.v(TAG, "device--->" + device.getName() + "address--->" + device.getAddress());
                    bondTargetDevice(device);
                    return true;
                }
            }
        }
        return false;
    }

    private void checkFoundDevices() {
        // TODO Auto-generated method stub
        if (mBluetoothAdapter.isDiscovering()) {
            mBluetoothAdapter.cancelDiscovery();
        } else {
            mBluetoothAdapter.startDiscovery();
        }
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
    }

    private final BroadcastReceiver receiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            // TODO Auto-generated method stub
            if (BluetoothAdapter.ACTION_DISCOVERY_STARTED.equals(intent.getAction())) {
                Log.v(TAG, "ACTION_DISCOVERY_STARTED");
            } else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(intent.getAction())) {
                Log.v(TAG, "ACTION_DISCOVERY_FINISHED");
            } else if (BluetoothDevice.ACTION_FOUND.equals(intent.getAction())) {
                Log.v(TAG, "ACTION_FOUND");
                BluetoothDevice device = (BluetoothDevice) intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                if (device.getBondState() != BluetoothDevice.BOND_BONDED) {
                    if (mTargetDeviceName.equals(device.getName())) {
                        Log.v(TAG, "device--->" + device.getName() + "address--->" + device.getAddress());
                        bondTargetDevice(device);
                        mBluetoothAdapter.cancelDiscovery();
                    }
                }
            } else if (BluetoothDevice.ACTION_BOND_STATE_CHANGED.equals(intent.getAction())) {
                Log.v(TAG, "ACTION_BOND_STATE_CHANGED");
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                if (device.getName().equalsIgnoreCase(mTargetDeviceName)) {
                    int connectState = device.getBondState();
                    switch (connectState) {
                    case BluetoothDevice.BOND_NONE:
                        break;
                    case BluetoothDevice.BOND_BONDING:
                        break;
                    case BluetoothDevice.BOND_BONDED:
                        try {
                            connect(device);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                }
            }
        }

    };

    private void bondTargetDevice(BluetoothDevice targetDevice) {
        int connectState = targetDevice.getBondState();
        switch (connectState) {
        case BluetoothDevice.BOND_NONE:
            try {
                Method createBondMethod = BluetoothDevice.class.getMethod("createBond");
                createBondMethod.invoke(targetDevice);
            } catch (Exception e) {
                e.printStackTrace();
            }
            break;
        case BluetoothDevice.BOND_BONDED:
            try {
                connect(targetDevice);
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        }
    }

    private void connect(BluetoothDevice device) throws IOException {
        /*
         * final String SPP_UUID = "00001101-0000-1000-8000-00805F9B34FB"; UUID
         * uuid = UUID.fromString(SPP_UUID); BluetoothSocket socket =
         * device.createRfcommSocketToServiceRecord(uuid); socket.connect();
         */
    }

}
