package com.clx.registerDevices.services;

import alahli.trustedDevices.DeviceDTO;
import com.clx.registerDevices.exceptions.UserNotFoundException;

import java.util.List;

public interface RegisterDevicesServicesInterface {

    List<DeviceDTO> getDevicesByUserId(String userName)  throws UserNotFoundException;

}
