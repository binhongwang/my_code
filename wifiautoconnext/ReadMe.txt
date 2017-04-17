add some permission:    
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
    <uses-permission android:name="android.permission.CHANGE_WIFI_STATE" />
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />

How to use:
WifiAutoConnectManager mWifiAutoConnectManager = new WifiAutoConnectManager(context);
mWifiAutoConnectManager.connect(ssid, password,type);

Example:

Wifi Name:admin100
Wifi Security:WPA
Wifi Password:12345678
mWifiAutoConnectManager.connect("admin100", "12345678","wpa");

Wifi Name:admin100
Wifi Security:WEP
Wifi Password:12345678
mWifiAutoConnectManager.connect("admin100", "12345678","wep");

Wifi Name:admin100
Wifi Security:No password
mWifiAutoConnectManager.connect("admin100", "nopassword","nopass");

