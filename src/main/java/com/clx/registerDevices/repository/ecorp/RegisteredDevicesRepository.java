package com.clx.registerDevices.repository.ecorp;

import com.clx.registerDevices.entity.ecorp.RegisteredDevices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RegisteredDevicesRepository extends JpaRepository<RegisteredDevices, UUID>, JpaSpecificationExecutor<RegisteredDevices> {

    List<RegisteredDevices> findByUserId(String userId);
}
