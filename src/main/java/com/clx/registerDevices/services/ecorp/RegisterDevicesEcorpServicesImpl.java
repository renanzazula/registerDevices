package com.clx.registerDevices.services.ecorp;

import alahli.trustedDevices.DeviceDTO;
import com.clx.registerDevices.entity.ecorp.RegisteredDevices;
import com.clx.registerDevices.exceptions.UserNotFoundException;
import com.clx.registerDevices.repository.ecorp.RegisteredDevicesRepository;
import com.clx.registerDevices.services.RegisterDevicesServicesInterface;
import com.clx.registerDevices.services.retail.RegisterDevicesRetailServicesImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegisterDevicesEcorpServicesImpl implements RegisterDevicesServicesInterface {

    Logger logger = LoggerFactory.getLogger(RegisterDevicesRetailServicesImpl.class);
    private final RegisteredDevicesRepository registeredDevicesRepository;

    public RegisterDevicesEcorpServicesImpl(RegisteredDevicesRepository registeredDevicesRepository) {
        this.registeredDevicesRepository = registeredDevicesRepository;
    }
    @Override
    public List<DeviceDTO> getDevicesByUserId(String userName) throws UserNotFoundException {
        List<RegisteredDevices>  registeredDevices = registeredDevicesRepository.findByUserId(userName);
        if (registeredDevices != null) {
            List<DeviceDTO> dtoList = new ArrayList<>();
            for (int i = 0; i < registeredDevices.size(); i++) {
                dtoList.add(new DeviceDTO(registeredDevices.get(i).getUserId(),
                        registeredDevices.get(i).getDeviceName(),
                        registeredDevices.get(i).getDeviceId()));
            }
            return dtoList;
        } else {
            throw new UserNotFoundException("69", "User not found");
        }
    }
}
