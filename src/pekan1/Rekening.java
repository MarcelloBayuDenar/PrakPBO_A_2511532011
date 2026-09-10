package pekan1;

import java.util.ArrayList;

public class Rekening {
	String nomorRekening;
	String namaPemilik;
	double saldo;
	
	public Rekening(String nomor, String nama, double saldoAwal) {
		nomorRekening = nomor;
		namaPemilik = nama;
		saldo = saldoAwal;
	}
	
	public void setorTunai(double nominal) {
		if (nominal > 0) {
			saldo += nominal;
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
}



