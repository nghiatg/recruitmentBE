package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ungvien")
public class Candidate {
	@Id
	@Column(name="ungVienId")
	private long ungVienId;
	
	@Column(name = "ten")
	private String tenUngVien;
	
	@Column(name = "sdt")
	private String sdt;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "diachi")
	private String diaChi;
	
	@Column(name = "trinhDoDaiHoc")
	private String trinhDoDaiHoc;
	
	@OneToMany(mappedBy = "ungVien", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<UngVienChungChi> chungChi = new ArrayList<>();
	
	@OneToMany(mappedBy = "ungVien", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<HistoryCandidate> lichSuHanhDong = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "ungvienSaveJob", joinColumns = { @JoinColumn(name = "ungVienId") }, inverseJoinColumns = {
			@JoinColumn(name = "jobId") })
	private List<Job> tinTuyenDung = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "ungVien")
	private List<Company> congTy = new ArrayList<>();
	
	public long getUngVienId() {
		return ungVienId;
	}
	public void setUngVienId(long ungVienId) {
		this.ungVienId = ungVienId;
	}
	public String getTenUngVien() {
		return tenUngVien;
	}
	public void setTenUngVien(String tenUngVien) {
		this.tenUngVien = tenUngVien;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getTrinhDoDaiHoc() {
		return trinhDoDaiHoc;
	}
	public void setTrinhDoDaiHoc(String trinhDoDaiHoc) {
		this.trinhDoDaiHoc = trinhDoDaiHoc;
	}
	
	
}
