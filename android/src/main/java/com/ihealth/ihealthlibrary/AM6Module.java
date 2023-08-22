package com.ihealth.ihealthlibrary;

import android.text.TextUtils;
import android.util.Log;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.ihealth.communication.control.Am6Control;
import com.ihealth.communication.manager.iHealthDevicesManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ReactModule(name = "AM6Module")
public class AM6Module extends iHealthBaseModule {
    
    private static final String modelName = "AM6Module";
    private static final String TAG = AM6Module.modelName;
    private static final String EVENT_NOTIFY = "event_notify_am6";

    public AM6Module(ReactApplicationContext reactContext) {
        super(TAG, reactContext);
    }

    @Override
    public String getName() {
        return modelName;
    }

    @Override
    public Map<String, Object> getConstants() {
        Map<String, Object> map = new HashMap<>();
        map.put("Event_Notify", EVENT_NOTIFY);
        return map;
    }

    @Override
    public void handleNotify(String mac, String deviceType, String action, String message) {
        WritableMap params = Arguments.createMap();
        params.putString("action", action);
        params.putString("mac", mac);
        params.putString("type", deviceType);
        if (!TextUtils.isEmpty(message)) {
            Utils.jsonToMap(message, params);
        }
        sendEvent(EVENT_NOTIFY, params);
    }

    private static Am6Control getControl(String mac) {
        return iHealthDevicesManager.getInstance().getAm6Control(mac);
    }

    @ReactMethod
    public void getAllConnectedDevices() {
        List<String> devices = iHealthDevicesManager.getInstance().getAm6Devices();
        WritableMap params = Arguments.createMap();
        if (devices.size() > 0) {
            WritableArray array = Arguments.createArray();
            for (String device : devices) {
                array.pushString(device);
            }
            params.putArray("devices", array);
            params.putString("action", ACTION_GET_ALL_CONNECTED_DEVICES);
        }
        sendEvent(EVENT_NOTIFY, params);
    }

    @ReactMethod
    public void getDeviceInfoAndSyncTime(String mac, boolean is24Hour) {
        Am6Control control = getControl(mac);
        if (control != null) {
            control.getDeviceInfoAndSyncTime(is24Hour);
        } else {
            Log.e(TAG, "Can not find AM6 Control mac:" + mac);
        }
    }

    @ReactMethod
    public void setUserInfo(String mac, byte[] userIds, int gender, int age, int height, float weight) {
        Am6Control control = getControl(mac);
        if (control != null) {
            control.setUserInfo(userIds, gender, age, height, weight);
        } else {
            Log.e(TAG, "Can not find AM6 Control mac:" + mac);
        }
    }

    @ReactMethod
    public void setPhonePlatform(String mac) {
        Am6Control control = getControl(mac);
        if (control != null) {
            control.setPhonePlatform();
        } else {
            Log.e(TAG, "Can not find AM6 Control mac:" + mac);
        }
    }

    @ReactMethod
    public void notifyMessage(String mac, long date, int status, int type, byte[] title, byte[] content) {
        Am6Control control = getControl(mac);
        if (control != null) {
            control.notifyMessage(date, status, type, title, content);
        } else {
            Log.e(TAG, "Can not find AM6 Control mac:" + mac);
        }
    }

    @ReactMethod
    public void findDevice(String mac, int start) {
        Am6Control control = getControl(mac);
        if (control != null) {
            control.findDevice(start);
        } else {
            Log.e(TAG, "Can not find AM6 Control mac:" + mac);
        }
    }

    @ReactMethod
    public void rebootDevice(String mac) {
        Am6Control control = getControl(mac);
        if (control != null) {
            control.rebootDevice();
        } else {
            Log.e(TAG, "Can not find AM6 Control mac:" + mac);
        }
    }

    @ReactMethod
    public void getTime(String mac) {
        Am6Control control = getControl(mac);
        if (control != null) {
            control.getTime();
        } else {
            Log.e(TAG, "Can not find AM6 Control mac:" + mac);
        }
    }

    @ReactMethod
    public void setTargetRemind(String mac, boolean isEnable, int calorie, int step) {
        Am6Control control = getControl(mac);
        if (control != null) {
            control.setTargetRemind(isEnable, calorie, step);
        } else {
            Log.e(TAG, "Can not find AM6 Control mac:" + mac);
        }
    }

    @ReactMethod
    public void getTargetRemind(String mac) {
        Am6Control control = getControl(mac);
        if (control != null) {
            control.getTargetRemind();
        } else {
            Log.e(TAG, "Can not find AM6 Control mac:" + mac);
        }
    }

    @ReactMethod
    public void setSedentaryRemind(String mac, int enable, int start, int end) {
        Am6Control control = getControl(mac);
        if (control != null) {
            control.setSedentaryRemind(enable, start, end);
        } else {
            Log.e(TAG, "Can not find AM6 Control mac:" + mac);
        }
    }

    @ReactMethod
    public void getSedentaryRemind(String mac) {
        Am6Control control = getControl(mac);
        if (control != null) {
            control.getSedentaryRemind();
        } else {
            Log.e(TAG, "Can not find AM6 Control mac:" + mac);
        }
    }

    @ReactMethod
    public void setRaiseToLightRemind(String mac, int enable, int start, int end) {
        Am6Control control = getControl(mac);
        if (control != null) {
            control.setRaiseToLightRemind(enable, start, end);
        } else {
            Log.e(TAG, "Can not find AM6 Control mac:" + mac);
        }
    }

    @ReactMethod
    public void getRaiseToLightRemind(String mac) {
        Am6Control control = getControl(mac);
        if (control != null) {
            control.getRaiseToLightRemind();
        } else {
            Log.e(TAG, "Can not find AM6 Control mac:" + mac);
        }
    }

    @ReactMethod
    public void setDoNotDisturbMode(String mac, int enable, int start, int end) {
        Am6Control control = getControl(mac);
        if (control != null) {
            control.setDoNotDisturbMode(enable, start, end);
        } else {
            Log.e(TAG, "Can not find AM6 Control mac:" + mac);
        }
    }

    @ReactMethod
    public void getDoNotDisturbMode(String mac) {
        Am6Control control = getControl(mac);
        if (control != null) {
            control.getDoNotDisturbMode();
        } else {
            Log.e(TAG, "Can not find AM6 Control mac:" + mac);
        }
    }

    @ReactMethod
    public void setWearHand(String mac, int type) {
        Am6Control control = getControl(mac);
        if (control != null) {
            control.setWearHand(type);
        } else {
            Log.e(TAG, "Can not find AM6 Control mac:" + mac);
        }
    }

    @ReactMethod
    public void getWearHand(String mac) {
        Am6Control control = getControl(mac);
        if (control != null) {
            control.getWearHand();
        } else {
            Log.e(TAG, "Can not find AM6 Control mac:" + mac);
        }
    }

    @ReactMethod
    public void setAlarmClockList(String mac, int type) {
        Am6Control control = getControl(mac);
        if (control != null) {
            // control.setAlarmClockList(type);
        } else {
            Log.e(TAG, "Can not find AM6 Control mac:" + mac);
        }
    }

    @ReactMethod
    public void getAlarmClockList(String mac) {
        Am6Control control = getControl(mac);
        if (control != null) {
            control.getAlarmClockList();
        } else {
            Log.e(TAG, "Can not find AM6 Control mac:" + mac);
        }
    }

    @ReactMethod
    public void startBind(String mac) {
        Am6Control control = getControl(mac);
        if (control != null) {
            control.startBind();
        } else {
            Log.e(TAG, "Can not find AM6 Control mac:" + mac);
        }
    }

    @ReactMethod
    public void bindUserSuccess(String mac, byte[] userIds) {
        Am6Control control = getControl(mac);
        if (control != null) {
            control.bindUserSuccess(userIds);
        } else {
            Log.e(TAG, "Can not find AM6 Control mac:" + mac);
        }
    }

    @ReactMethod
    public void bindUserFail(String mac) {
        Am6Control control = getControl(mac);
        if (control != null) {
            control.bindUserFail();
        } else {
            Log.e(TAG, "Can not find AM6 Control mac:" + mac);
        }
    }

    @ReactMethod
    public void unBindUser(String mac, byte[] userIds) {
        Am6Control control = getControl(mac);
        if (control != null) {
            control.unBindUser(userIds);
        } else {
            Log.e(TAG, "Can not find AM6 Control mac:" + mac);
        }
    }

    @ReactMethod
    public void readySyncData(String mac) {
        Am6Control control = getControl(mac);
        if (control != null) {
            control.readySyncData();
        } else {
            Log.e(TAG, "Can not find AM6 Control mac:" + mac);
        }
    }

    @ReactMethod
    public void getDailyData(String mac) {
        Am6Control control = getControl(mac);
        if (control != null) {
            control.getDailyData();
        } else {
            Log.e(TAG, "Can not find AM6 Control mac:" + mac);
        }
    }

    @ReactMethod
    public void getStepData(String mac) {
        Am6Control control = getControl(mac);
        if (control != null) {
            control.getStepData();
        } else {
            Log.e(TAG, "Can not find AM6 Control mac:" + mac);
        }
    }

    @ReactMethod
    public void getSleepData(String mac) {
        Am6Control control = getControl(mac);
        if (control != null) {
            control.getSleepData();
        } else {
            Log.e(TAG, "Can not find AM6 Control mac:" + mac);
        }
    }

    @ReactMethod
    public void getHeartRateData(String mac) {
        Am6Control control = getControl(mac);
        if (control != null) {
            control.getHeartRateData();
        } else {
            Log.e(TAG, "Can not find AM6 Control mac:" + mac);
        }
    }

    @ReactMethod
    public void getBloodOxygenData(String mac) {
        Am6Control control = getControl(mac);
        if (control != null) {
            control.getBloodOxygenData();
        } else {
            Log.e(TAG, "Can not find AM6 Control mac:" + mac);
        }
    }

    @ReactMethod
    public void getActivityData(String mac) {
        Am6Control control = getControl(mac);
        if (control != null) {
            control.getActivityData();
        } else {
            Log.e(TAG, "Can not find AM6 Control mac:" + mac);
        }
    }

    @ReactMethod
    public void deleteData(String mac, int num) {
        Am6Control control = getControl(mac);
        if (control != null) {
            control.deleteData(num);
        } else {
            Log.e(TAG, "Can not find AM6 Control mac:" + mac);
        }
    }

    @ReactMethod
    public void disconnect(String mac) {
        Am6Control control = getControl(mac);
        if (control != null) {
            control.disconnect();
        } else {
            Log.e(TAG, "Can not find AM6 Control mac:" + mac);
        }
    }
}