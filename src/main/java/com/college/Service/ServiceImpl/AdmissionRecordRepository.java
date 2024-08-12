package com.college.Service.ServiceImpl;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.Entities.AdmissionRecord;

public interface AdmissionRecordRepository extends JpaRepository<AdmissionRecord, Long> {

}
