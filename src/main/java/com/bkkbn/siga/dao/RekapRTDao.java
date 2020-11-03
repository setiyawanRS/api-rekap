package com.bkkbn.siga.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bkkbn.siga.model.RekapRT;

@Mapper
public interface RekapRTDao {

	/*RETRIEVE*/
	List<RekapRT> findAllRekapRTs(int id_kelurahan, int id_rw, int id_rt);
	
	RekapRT findById(String id);
	
	/*INSERT*/
	void createRekapRT(RekapRT rekapRT);
	
	/*UPDATE*/
	void updateRekapRT(RekapRT rekapRT);
	
	/*DELETE*/
	void deleteRekapRTById(String id);
		
}
