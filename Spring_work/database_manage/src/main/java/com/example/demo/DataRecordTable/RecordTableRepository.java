package com.example.demo.DataRecordTable;

import java.util.List;

import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
 
 
@Repository
public interface RecordTableRepository extends JpaRepository<RecordTable, Long> {
	@Query("SELECT R FROM RecordTable R WHERE(R.track_id=?1 AND R.name=?2)")
	List<RecordTable>findBytracking_idAndname(String track_id,String name);
	
	
}