package pekan2;

public class RekeningGiro extends Rekening {
	private double batasOverDraft;
	
	public RekeningGiro( String nomor, String nama, double saldoAwal, String pinAwal, double batasOverDraft ) {
		super(nomor, nama, saldoAwal, pinAwal);
		this.batasOverDraft = batasOverDraft;
	}
	
	@Override
	public boolean tarikTunai(double nominal) {
		if (nominal <= 0) {
			System.out.println("Gagal: Nominal tarik Giro harus lebih dari 0!");
			return false;
		} 
		
		else if (nominal > (saldo + batasOverDraft)) {
			System.out.println("Transaksi Gagal: Melebihi batas overdraft! Maksimal penarikan Rp" + (saldo + batasOverDraft));
			return false;
		}
		
		else  {
			saldo -= nominal;
			
			String idTrx = "TRX-G-" + System.currentTimeMillis();
			riwayatTransaksi.add(new Transaksi(idTrx, "Debit", nominal));
			
			System.out.println("Tarik tunai Giro Rp" + nominal + " berhasil. Saldo saat ini: Rp" + saldo);
			return true;
		}
	}
	
	public double getBatasOverdraft() {
		return batasOverDraft;
	}
}
