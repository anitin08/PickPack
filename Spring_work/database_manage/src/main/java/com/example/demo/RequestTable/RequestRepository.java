package com.example.demo.RequestTable;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.DataRecordTable.RecordTable;
 
 
@Repository
public interface RequestRepository extends JpaRepository<RequestTable, Long> {
	
	
}