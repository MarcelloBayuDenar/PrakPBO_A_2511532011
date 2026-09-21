package pekan2;

import java.util.ArrayList;

public class Rekening {
	String nomorRekening;
	String namaPemilik;
	double saldo;
	
	ArrayList<Transaksi> riwayatTransaksi;
	
	public Rekening(String nomor, String nama, double saldoAwal) {
		nomorRekening = nomor;
		namaPemilik = nama;
		saldo = saldoAwal;
		
		this.riwayatTransaksi = new ArrayList<>();
		
		System.out.println("Rekening atas nama " + namaPemilik + " berhasil dibuat.");
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
	
	public void tarikTunai(double nominal) {
		if (saldo == 0) {
			System.out.println("Anda Tidak memiliki saldo di rekening anda");
			return;
		} 
		
		if (nominal > saldo) {
			System.out.println("Transaksi Gagal: Saldo tidak mencukupi. Saldo Anda: Rp " + saldo);
			return;
		}
		
		if (nominal < 10.000 ) {
			System.out.println("Transaksi Gagal: Minimal nominal Penarikan Rp 10.000 ");
			return;
		}
		
		String idTrx = "TRX-T-" + System.currentTimeMillis();
		Transaksi trxBaru = new Transaksi(idTrx, "Debit", nominal);
		riwayatTransaksi.add(trxBaru);
		
		saldo -= nominal;
		System.out.println("Transaksi anda berhasil. Sisa Saldo anda sekarang : Rp " + saldo);
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
}




