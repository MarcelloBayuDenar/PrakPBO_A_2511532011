package pekan2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Rekening> daftarRekening = new ArrayList<>();
		Rekening akunAktif = null;
		boolean isRunning = true;

		System.out.println("=== SISTEM PERBANKAN MINI ===");

		while (isRunning) {
			System.out.println("\nMenu Utama:");
			System.out.println("1. Buka Rekening Baru");
			System.out.println("2. Setor Tunai");
			System.out.println("3. Tarik Tunai");
			System.out.println("4. Cek Informasi Rekening");
			System.out.println("5. Ganti Akun");
			System.out.println("6 Cetak Mutasi(Riwayat)");
			System.out.println("0. Keluar");
			System.out.print("Pilih Menu: ");

			int pilihan = input.nextInt();
			input.nextLine(); 

			switch (pilihan) {

				case 1:
					System.out.print("Masukkan No Rekening: ");
					String no = input.nextLine().trim();
					System.out.print("Masukkan Nama Pemilik: ");
					String nama = input.nextLine().trim();
					System.out.print("Buat PIN Rekening (6 Digit): ");
					String pin = input.next();
					System.out.print("Masukkan Saldo Awal: ");
					double saldo = input.nextDouble();
					
					input.nextLine();
					
					Rekening rekeningBaru = new Rekening(no, nama, saldo, pin);
					daftarRekening.add(rekeningBaru);
					akunAktif = rekeningBaru;

					System.out.println("Rekening berhasil dibuat dan dijadikan akun aktif!");
					break;

				case 2:
					if (akunAktif == null) {
						System.out.println("Error: Mohon maaf, Anda belum memiliki nomor rekening!");
					} else {
						System.out.print("Masukkan nominal setor: ");
						double setor = input.nextDouble();
						input.nextLine();
						akunAktif.setorTunai(setor);
					}
					break;

				case 3:
					if (akunAktif == null) {
						System.out.println("Error: Anda belum membuka rekening!");
					} else {
						
						System.out.print("Masukkan PIN Rekening Anda");
						pin = input.next();
						
						if(akunAktif.otentikasi(pin) == false) {
							System.out.println("Akses Ditolak: PIN yang Anda masukkan salah!");
							return;
						} else {
							System.out.print("Masukkan nominal yang ingin anda tarik: Rp");
							double nominal = input.nextDouble();
							input.nextLine();
							akunAktif.tarikTunai(nominal);
						}
						
					}
					break;

				case 4:
					if (akunAktif == null) {
						System.out.println("Error: Anda belum membuka rekening!");
					} else {
						akunAktif.cekInformasi();
					}
					break;

				case 5:
					if (daftarRekening.isEmpty()) {
						System.out.println("Error: Belum ada rekening yang terdaftar!");
					} else {
						System.out.print("Masukkan Nomor Rekening yang ingin diaktifkan: ");
						String noRek = input.nextLine().trim();

						Rekening ditemukan = Rekening.gantiAkun(daftarRekening, noRek);

						if (ditemukan != null) {
							akunAktif = ditemukan;
							System.out.println("Berhasil beralih ke rekening atas nama " + akunAktif.getNamaPemilik());
						} else {
							System.out.println("Error: Nomor rekening tidak ditemukan!");
						}
					}
					break;
				
				case 6:
					if (akunAktif == null) {
						System.out.println("Error: Anda belum membuka rekening!");
					
					} else {
						System.out.print("Masukkan PIN Rekening Anda");
						pin = input.next();
						
						if(akunAktif.otentikasi(pin) == false) {
							System.out.println("Akses Ditolak: PIN yang Anda masukkan salah!");
							return;
						} else {
							akunAktif.cetakMutasi();
						}
					}
					
					break;

				case 0:
					isRunning = false;
					System.out.println("Sistem ditutup, Terima Kasih!");
					break;

				default:
					System.out.println("Pilihan Tidak valid");
			}
		}

		input.close();
	}
}
