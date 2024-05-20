package com.logical.tronixpayadmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logical.tronixpayadmin.entity.QRCodeDetails;

public interface QRCodeDetailsRepository extends JpaRepository<QRCodeDetails, Long> {

	List<QRCodeDetails> findAllByRequestStatus(boolean requestStatus);

}
