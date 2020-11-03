package com.bkkbn.siga.request;

import io.swagger.annotations.ApiModelProperty;

public class RekapRTUpdateRequest {
	
	@ApiModelProperty(required=true, dataType="String",position=0)
	String id;
	
	@ApiModelProperty(required=true, position=1)
	int jumlah_kk;
	
	@ApiModelProperty(required=true, position=2)
	int jumlah_kk_didata;
	
	@ApiModelProperty(required=true, position=3)
	int tidak_ditemui;
	
	@ApiModelProperty(required=true, position=4)
	int ditolak;
	
	@ApiModelProperty(required=true, position=5)
	int tidak_jawab;
	
	@ApiModelProperty(required=true, position=6)
	int yang_ada;
	
	@ApiModelProperty(required=true, position=7)
	int status;
	
	@ApiModelProperty(required=true, position=8)
	int id_kelurahan;
	
	@ApiModelProperty(required=true, position=9)
	int id_rw;
	
	@ApiModelProperty(required=true, position=10)
	int id_rt;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getJumlah_kk() {
		return jumlah_kk;
	}

	public void setJumlah_kk(int jumlah_kk) {
		this.jumlah_kk = jumlah_kk;
	}

	public int getJumlah_kk_didata() {
		return jumlah_kk_didata;
	}

	public void setJumlah_kk_didata(int jumlah_kk_didata) {
		this.jumlah_kk_didata = jumlah_kk_didata;
	}

	public int getTidak_ditemui() {
		return tidak_ditemui;
	}

	public void setTidak_ditemui(int tidak_ditemui) {
		this.tidak_ditemui = tidak_ditemui;
	}

	public int getDitolak() {
		return ditolak;
	}

	public void setDitolak(int ditolak) {
		this.ditolak = ditolak;
	}

	public int getTidak_jawab() {
		return tidak_jawab;
	}

	public void setTidak_jawab(int tidak_jawab) {
		this.tidak_jawab = tidak_jawab;
	}

	public int getYang_ada() {
		return yang_ada;
	}

	public void setYang_ada(int yang_ada) {
		this.yang_ada = yang_ada;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getId_kelurahan() {
		return id_kelurahan;
	}

	public void setId_kelurahan(int id_kelurahan) {
		this.id_kelurahan = id_kelurahan;
	}

	public int getId_rw() {
		return id_rw;
	}

	public void setId_rw(int id_rw) {
		this.id_rw = id_rw;
	}

	public int getId_rt() {
		return id_rt;
	}

	public void setId_rt(int id_rt) {
		this.id_rt = id_rt;
	}
	
}
