package pekan2;

import java.util.ArrayList;

public class Rekening {
	private String nomorRekening;
	private String namaPemilik;
	private String pin;
	
	protected double saldo;
	protected ArrayList<Transaksi> riwayatTransaksi;
	
	public Rekening(String nomor, String nama, double saldoAwal, String pinAwal) {
		nomorRekening = nomor;
		namaPemilik = nama;
		saldo = saldoAwal;
		
		if (pinAwal.length() == 6) {
			this.pin = pinAwal;
		} else {
			System.out.println("Peringatan: Pin Harus 6 Digit! MenggunakanPIN default 123456");
			this.pin = "123456";
		}
		
		this.riwayatTransaksi = new ArrayList<>();
		
		System.out.println("Rekening atas nama " + namaPemilik + " berhasil dibuat.");
	}
	
	public String getNomorRekening() {return nomorRekening;}
	public String getNamaPemilik() {return namaPemilik;}
	
	public boolean otentikasi(String inputPin) {
		return this.pin.equals(inputPin);
	}
	
	public void setorTunai(double nominal) {
		if (nominal > 0) {
			saldo += nominal;
			
			String idTrx = "TRX-S-" + System.currentTimeMillis();
			Transaksi trxBaru = new Transaksi(idTrx, "Kredit", nominal);
			riwayatTransaksi.add(trxBaru);
			
			System.out.println("Setor tunai Rp" + nominal + "berhasil. Saldo saat ini: Rp " + saldo);
			
		} else {
			System.out.println("Gagal: Nominal setor harus lebih besar dari 0! ");
		}
	}
	
	public void cekInformasi() {
		System.out.println("--- INFO REKENING ---");
		System.out.println("No. Rekening : " + nomorRekening);
		System.out.println("Nama Pemilik : " + namaPemilik);
		System.out.println("Saldo Akhir  Rp: " + saldo);
		System.out.println("--- INFO REKENING ---");
	}
	
	public boolean tarikTunai(double nominal) {
		if (nominal <= 0) {
			System.out.println("Gagal: Nominal tarik harus lebi dari 0!");
			return false;
		} 
		
		else if (nominal > saldo) {
			System.out.println("Transaksi Gagal: Saldo tidak mencukupi. Saldo Anda: Rp " + saldo);
			return false;
		}
		
		else  {
			saldo -= nominal;
			
			String idTrx = "TRX-T-" + System.currentTimeMillis();
			riwayatTransaksi.add(new Transaksi(idTrx, "Debit", nominal));
			
			System.out.println("Transaksi anda berhasil. Sisa Saldo anda sekarang : Rp " + saldo);
			return true;
		}
		
		
	}
	
	public static Rekening gantiAkun(ArrayList<Rekening> daftarRekening, String noRek) {
		for (Rekening r : daftarRekening) {
			if (r.nomorRekening.equals(noRek)) {
				return r;
			} 
		}
		System.out.println("tidak ada no rekening yang anda masukkan");
		return null;
	}
	
	public Transaksi cetakMutasi() {
		
		if (riwayatTransaksi.isEmpty()) {
			System.out.println("Belum Ada Transaksi Di rekening ini");
		} 
		
		int totalTx = riwayatTransaksi.size();
		
		for (Transaksi tx : riwayatTransaksi) {
			tx.cetakDetail();
		}
		return null;
		
	}
	
	public void transfer(Rekening Tujuan, double nominal, String pinInput) {
		if (this.otentikasi(pinInput) == false) {
			
			System.out.println("Pin yang anda masukkan salah");
			return;
			
		} else {
			
			boolean suksesTarik = this.tarikTunai(nominal);
			
			if (suksesTarik == true ) {
				Tujuan.setorTunai(nominal);
			}
		}
	}
}




