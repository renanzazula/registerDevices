package alahli.trustedDevices;

import org.joda.time.DateTime;


import java.io.Serializable;
import javax.persistence.Transient;

public class DeviceDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Transient
    private String userName;
    private String nameDevice;
    private final String registerTime;
    private String lastLogin;
    private String uuid;

    public DeviceDTO(String nameDevice) {
        super();
        this.nameDevice = nameDevice;
        this.registerTime= DateTime.now().toString();
    }

    public DeviceDTO() {
        this.registerTime= DateTime.now().toString();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNameDevice() {
        return nameDevice;
    }

    public void setNameDevice(String nameDevice) {
        this.nameDevice = nameDevice;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
