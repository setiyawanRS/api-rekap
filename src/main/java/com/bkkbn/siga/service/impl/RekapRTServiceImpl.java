package com.bkkbn.siga.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bkkbn.siga.dao.RekapRTDao;
import com.bkkbn.siga.model.RekapRT;
import com.bkkbn.siga.request.RekapRTInsertRequest;
import com.bkkbn.siga.request.RekapRTUpdateRequest;
import com.bkkbn.siga.response.RekapRTResponse;
import com.bkkbn.siga.service.RekapRTService;

@Service
public class RekapRTServiceImpl implements RekapRTService{

	private static Logger logger = LoggerFactory.getLogger(RekapRTServiceImpl.class);
	
	@Autowired
	RekapRTDao rekapRTDao;
	
	@Override
	public List<RekapRTResponse> getAllListRekapRT(int id_kelurahan, int id_rw, int id_rt) {
		// TODO Auto-generated method stub
		List<RekapRT> listRekapRT = rekapRTDao.findAllRekapRTs(id_kelurahan, id_rw, id_rt);
		List<RekapRTResponse> lsResponseRekapRT = new ArrayList<RekapRTResponse>();
		for (RekapRT rekapRT : listRekapRT) {
			RekapRTResponse rekapRTResponse = new RekapRTResponse();
			BeanUtils.copyProperties(rekapRT, rekapRTResponse);
			lsResponseRekapRT.add(rekapRTResponse);
		}
		return lsResponseRekapRT;
	}

	@Override
	public RekapRTResponse getRekapRTbyId(String id) {
		// TODO Auto-generated method stub
		RekapRT rekapRT = rekapRTDao.findById(id);
		logger.debug("rekapRTId: "+rekapRT);
		RekapRTResponse rekapRTResponse = new RekapRTResponse();
		BeanUtils.copyProperties(rekapRT, rekapRTResponse);
		return rekapRTResponse;
	}

	@Override
	public RekapRTResponse insertRekapRT(RekapRTInsertRequest reqRekapRT) {
		// TODO Auto-generated method stub
		RekapRT rekapRT = new RekapRT();
		BeanUtils.copyProperties(reqRekapRT, rekapRT);
		rekapRTDao.createRekapRT(rekapRT);

		RekapRTResponse rekapRTResponse = new RekapRTResponse();
		BeanUtils.copyProperties(rekapRT, rekapRTResponse);
		return rekapRTResponse;
	}

	@Override
	public RekapRTResponse updateRekapRT(RekapRTUpdateRequest rekapRTUpdateRequest) {
		// TODO Auto-generated method stub
		RekapRT rekapRT = new RekapRT();
		BeanUtils.copyProperties(rekapRTUpdateRequest, rekapRT);
		rekapRTDao.updateRekapRT(rekapRT);
		
		RekapRTResponse rekapRTResponse = new RekapRTResponse();
		BeanUtils.copyProperties(rekapRT, rekapRTResponse);
		return rekapRTResponse;
	}

	@Override
	public void deleteRekapRTById(String id) {
		// TODO Auto-generated method stub
		rekapRTDao.deleteRekapRTById(id);
	}

	

	

}
