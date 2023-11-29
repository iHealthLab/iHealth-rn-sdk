import { BP5SModule } from '@ihealth/ihealthlibrary-react-native';

export default {
  apis: {
    getAllConnectedDevices: () => BP5SModule.getAllConnectedDevices(),
    setUnit:             (mac) => BP5SModule.setUnit(mac),
    deleteData:          (mac) => BP5SModule.deleteData(mac),
    getOffLineData:      (mac) => BP5SModule.getOffLineData(mac),
    getOfflineNum: (mac) => BP5SModule.getOffLineNum(mac),
    startMeasure:        (mac) => BP5SModule.startMeasure(mac),
    stopMeasure:         (mac) => BP5SModule.stopMeasure(mac),
    enableOfflineBattery: (mac) => BP5SModule.enbleOffline(mac, mode),
    getBattery: (mac) => BP5SModule.getBattery(mac),
    setUnit: (mac) => BP5SModule.setUnit(mac, 0),
    getFunctionInfo: (mac) => BP5SModule.getFunctionInfo(mac),
    disconnect:          (mac) => BP5SModule.disconnect(mac)
  }
}
