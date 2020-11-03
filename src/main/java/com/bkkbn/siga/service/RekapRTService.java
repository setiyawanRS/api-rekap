package com.bkkbn.siga.service;

import java.util.List;

import com.bkkbn.siga.model.RekapRT;
import com.bkkbn.siga.request.RekapRTInsertRequest;
import com.bkkbn.siga.request.RekapRTUpdateRequest;
import com.bkkbn.siga.response.RekapRTResponse;

public interface RekapRTService {
	
	/*RETRIEVE*/
	List<RekapRTResponse> getAllListRekapRT(int id_kelurahan, int id_rw, int id_rt);
	
	RekapRTResponse getRekapRTbyId(String id);
	
	/*INSERT*/
	RekapRTResponse insertRekapRT(RekapRTInsertRequest reqRekapRT);
	
	/*UPDATE*/
	RekapRTResponse updateRekapRT(RekapRTUpdateRequest rekapRTUpdateRequest);
	
	/*DELETE*/
	void deleteRekapRTById(String id);
	
	
}
