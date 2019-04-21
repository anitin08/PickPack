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
	
	@Query("SELECT R FROM RecordTable R WHERE(R.track_id=?1)")
	List<RecordTable>findBytracking_id(String track_id);
	
	
	@Query("SELECT R FROM RecordTable R WHERE(R.status='Unpicked')")
	List<RecordTable>findUnpicked();
	
	
//	@Query("UPDATE RecordTable R set R.remark =?2, R.status='Picked' WHERE(R.item_no=?1)")
//	RecordTable updateby_itemno(long item_no,String remark);
	
	
}
