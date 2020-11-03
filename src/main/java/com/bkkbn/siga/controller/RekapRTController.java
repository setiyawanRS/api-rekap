package com.bkkbn.siga.controller;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bkkbn.siga.model.RekapRT;
import com.bkkbn.siga.request.RekapRTInsertRequest;
import com.bkkbn.siga.request.RekapRTUpdateRequest;
import com.bkkbn.siga.response.BaseResponse;
import com.bkkbn.siga.response.RekapRTResponse;
import com.bkkbn.siga.service.RekapRTService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value="Customer Management System", description="Operations pertaining to Rekap RT in Rekap-API Service")
@RestController
@RequestMapping("/apirekap/")
public class RekapRTController {

	private static Logger logger = LoggerFactory.getLogger(RekapRTController.class);
	
	@Autowired
	RekapRTService rekapRTService;
	
	//@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/listRekapRT")
	@ApiOperation(value = "View a list of available customers", response = ResponseEntity.class)
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successfully retrieved list"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
		})
	public ResponseEntity<Object> loadAllRekapRT(
			@RequestParam int id_kelurahan,
			@RequestParam int id_rw,
			@RequestParam int id_rt){
			logger.debug("Load All Rekap RT ");
			List<RekapRTResponse> listRekapRT = rekapRTService.getAllListRekapRT(id_kelurahan, id_rw, id_rt);
			BaseResponse baseResponse = new BaseResponse("Show All Data", listRekapRT);
			return new ResponseEntity<Object>(baseResponse, HttpStatus.OK);
	}
	
	@GetMapping("/listRekapRT/{id}")
	public ResponseEntity<Object> loadAllRekapRT(@PathVariable("id") String id) {
		logger.info("Load All Rekap by id " + id);
		RekapRTResponse rekapRTResponse = rekapRTService.getRekapRTbyId(id);
		BaseResponse baseResponse = new BaseResponse("Show Data Per RT", rekapRTResponse);
		return new ResponseEntity<Object>(baseResponse, HttpStatus.OK);
	}
	
	@PostMapping(value = "/insertRekapRT")
	@ApiOperation(value = "Insert available data RekapRT", response = ResponseEntity.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Insert data"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public ResponseEntity<Object> addRekapRT(@RequestBody RekapRTInsertRequest reqRekapRT) {
		logger.debug("Insert Data RekapRT");
		RekapRTResponse rekapRTResponse = rekapRTService.insertRekapRT(reqRekapRT);
		BaseResponse baseResponse = new BaseResponse("Rekap RT Insert", rekapRTResponse);
		return new ResponseEntity<Object>(baseResponse, HttpStatus.OK);
	}
	
	@PostMapping(value = "/update")
	@ApiOperation(value = "Udpate available data RekapRT", response = ResponseEntity.class)
	public ResponseEntity<Object> updateRekapRT(@RequestBody RekapRTUpdateRequest rekapRTUpdateRequest, @RequestParam("id") String id) {
		logger.debug("update Data RekapRT");
		rekapRTUpdateRequest.setId(id);
		RekapRTResponse rekapRTResponse = rekapRTService.updateRekapRT(rekapRTUpdateRequest);
		BaseResponse baseResponse = new BaseResponse("Rekap RT Update", rekapRTResponse);
		return new ResponseEntity<Object>(baseResponse, HttpStatus.OK);
	}
	
	@PostMapping(value = "/delete")
	@ApiOperation(value = "delete available data RekapRT", response = ResponseEntity.class)
	public ResponseEntity<Object> deleteRekapRT(@RequestParam("id") String id) {
		logger.debug("update Data RekapRT");
		rekapRTService.deleteRekapRTById(id);
		BaseResponse baseResponse = new BaseResponse("Success", "OK");
		return new ResponseEntity<Object>(baseResponse, HttpStatus.OK);
	}
	
	
}