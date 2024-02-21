package com.clx.registerDevices.entity.ecorp;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="REGISTERED_DEVICES")
public class RegisteredDevices implements Serializable {

    private static final long serialVersionUID = -6232437832490185591L;

    @Id
    @Column(name="ID")
    @Type(type="uuid-binary")
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid2")
    private UUID id;

    @Column(name="USER_ID")
    private String userId;

    @Column(name="DEVICE_ID")
    private String deviceId;

    @Column(name="DEVICE_NAME")
    private String deviceName;

    @Column(name="CHANNEL",nullable=false)
    private String channel;

    @Column(name = "REGISTERED_DATE", nullable = false)
    private LocalDateTime registeredDate;

    @Column(name = "LAST_LOG_IN", nullable = false)
    private LocalDateTime lastLogIn;

    public RegisteredDevices() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public LocalDateTime getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDateTime registeredDate) {
        this.registeredDate = registeredDate;
    }

    public LocalDateTime getLastLogIn() {
        return lastLogIn;
    }

    public void setLastLogIn(LocalDateTime lastLogIn) {
        this.lastLogIn = lastLogIn;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisteredDevices that = (RegisteredDevices) o;
        return Objects.equals(id, that.id) && Objects.equals(userId, that.userId) && Objects.equals(deviceId, that.deviceId) && Objects.equals(deviceName, that.deviceName) && channel == that.channel && Objects.equals(registeredDate, that.registeredDate) && Objects.equals(lastLogIn, that.lastLogIn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, deviceId, deviceName, channel, registeredDate, lastLogIn);
    }

    @Override
    public String toString() {
        return "RegisteredDevices{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", channel=" + channel +
                ", registeredDate=" + registeredDate +
                ", lastLogIn=" + lastLogIn +
                '}';
    }

}
