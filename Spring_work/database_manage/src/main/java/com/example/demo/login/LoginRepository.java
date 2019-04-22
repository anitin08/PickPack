package com.example.demo.login;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.DataRecordTable.RecordTable;
 
 
@Repository
public interface LoginRepository extends JpaRepository<LoginTable, Long> {
	
	@Query("SELECT R FROM LoginTable R WHERE(R.username=?1 AND R.password=?2)")
	LoginTable findByusernameAndpassword(String usrname,String password);
	
	
	@Query("SELECT R FROM LoginTable R WHERE(R.username=?1)")
	LoginTable findByusername(String usrname);
 
}