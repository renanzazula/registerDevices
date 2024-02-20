package com.clx.registerDevices.services;

import alahli.trustedDevices.DeviceDTO;
import com.clx.registerDevices.entity.retail.User;
import com.clx.registerDevices.exceptions.UserNotFoundException;
import com.clx.registerDevices.repository.retail.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RegisterDevicesServices {

    Logger logger = LoggerFactory.getLogger(RegisterDevicesServices.class);
    private final UserRepository userRepository;

    public RegisterDevicesServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<DeviceDTO> getDevicesByUserId(String userName) throws UserNotFoundException {
        User user = userRepository.findByUsername(userName);
        if (user != null) {
            if (user.getUuidTrusted() != null) {
                HashMap<String, DeviceDTO> map = getHmFromJson(user.getUuidTrusted());
                List<DeviceDTO> dtoList = new ArrayList<>();
                for(Map.Entry<String, DeviceDTO> entry : map.entrySet()) {
                    String key = entry.getKey();
                    DeviceDTO value = entry.getValue();
                    value.setUuid(key);
                    value.setUserName(userName);
                    dtoList.add(value);
                }
                return dtoList;
            } else {
                return new ArrayList<>();
            }
        } else {
            throw new UserNotFoundException("69", "User not found");
        }
    }

    public List<DeviceDTO> updateDeviceByUserId(String userId) {
        return null;
    }


    private String getJsonfromHm(HashMap<String, DeviceDTO> hm) {
        try {
            return new ObjectMapper().writeValueAsString(hm);
        } catch (Exception e) {
            // logger.error("ERROR CONVERTING HM TO JSON DEVICES", e);
        }
        return null;
    }

    private HashMap<String, DeviceDTO> getHmFromJson(String jsonDevices) {
        HashMap<String, DeviceDTO> hmDevices = new HashMap<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            TypeFactory typeFactory = mapper.getTypeFactory();
            MapType mapType = typeFactory.constructMapType(HashMap.class, String.class, DeviceDTO.class);
            return mapper.readValue(jsonDevices, mapType);
        } catch (Exception e) {
            System.out.println(e);
            // logger.error("ERROR CONVERTING JSON TO HM DEVICES", e);
        }
        return hmDevices;
    }


}
