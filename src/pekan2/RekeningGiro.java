package pekan2;

public class RekeningGiro extends Rekening {
	private double batasOverDraft;
	
	public RekeningGiro( String nomor, String nama, double saldoAwal, String pinAwal, double batasOverDraft ) {
		super(nomor, nama, saldoAwal, pinAwal);
		this.batasOverDraft = batasOverDraft;
	}
	
	public double getBatasOverdraft() {
		return batasOverDraft;
	}
}
