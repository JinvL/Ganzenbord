import java.util.Random;
import java.util.Scanner;

class Speler {
	public int nummer;
	String naam;
	public int worp;
	public int tijdelijkeP;
	public int huidigeP;
	public String eindresultaat = "heeft niet gewonnen";
	public int beurt;
	public static int spelerInDePut = 0;

	
	public void setWorp() {
		Random random = new Random();
		int worp = 1+random.nextInt(6);
		System.out.print(naam+ " gooit " + worp);
		this.worp = worp;
	}
	
	
	public void bepaalPositie() {
		
		System.out.print("\n" +naam + " staat nu op vakje " +huidigeP+ ". Toets d om te dobbelen: ");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		if (input.equals("d")) {
			setWorp();
			tijdelijkeP=huidigeP+worp;
			
			if ((tijdelijkeP <63) && (tijdelijkeP !=6) && (tijdelijkeP !=19) && (tijdelijkeP != 31) && (tijdelijkeP != 42) && (tijdelijkeP != 52) && (tijdelijkeP != 58)){
				huidigeP=tijdelijkeP;
				System.out.println(" en staat nu op vakje "+huidigeP+".");
				eindresultaat = "is geëindigd op vakje " +huidigeP;
			
			} else if (tijdelijkeP==6) {
				System.out.println(", komt uit op vakje 6 en gaat via de brug naar vakje 12.");
				huidigeP = 12;
				eindresultaat = "is geëindigd op vakje " +huidigeP;
			
			} else if (tijdelijkeP==19) {
				huidigeP=tijdelijkeP;
				System.out.println(" en is in de herberg (vakje 19) beland. Dat betekent 1 beurt overslaan.");
				++beurt;
				eindresultaat = "is geëindigd op vakje " +huidigeP;

			} else if (tijdelijkeP==31) {
				System.out.println(" en belandt in de put (vakje 31).\nPas als een volgende speler in de put komt kan "+naam+" verder spelen.");
				huidigeP = tijdelijkeP;
				eindresultaat = "is geëindigd in de put";
				beurt = beurt+100;
				spelerInDePut = nummer;
			
			} else if (tijdelijkeP == 52){
				huidigeP=tijdelijkeP;
				System.out.println(" en is in de gevangenis (vakje 52) beland.\nDat wordt dus 3 beurten overslaan.");
				beurt+=3;
				eindresultaat = "is geëindigd in de gevangenis";
				
			} else if (tijdelijkeP==58) {
				System.out.println(" en komt op vakje 58 uit.\nDit betekent dat "+naam+ " dood is en weer bij 0 moet beginnen.");
				huidigeP = 0;
				eindresultaat = "is geëindigd op start";
				
			} else if (tijdelijkeP==42) {
				System.out.println(", komt uit op vakje 42 en belandt via het doolhof op vakje 39.");
				huidigeP = 39;
				eindresultaat = "is geëindigd op vakje " +huidigeP;

			} else if (tijdelijkeP==63) {
				huidigeP=tijdelijkeP;
				System.out.println(" en heeft de finish bereikt. Gefeliciteerd, "+naam+", je hebt de gewonnen!");
				eindresultaat ="heeft gewonnen!";
			}	else if (tijdelijkeP>63) {
					switch (tijdelijkeP) {
						case 64:
							huidigeP=62;
							System.out.println(" dus die denkt: ik loop gewoon de finish voorbij!\nLeuk geprobeerd, "+naam+", maar je moet teruglopen en eindigt op vakje " +huidigeP+ ".");
							eindresultaat = "is geëindigd op vakje " +huidigeP;
							break;
						case 65: 
							huidigeP=61;
							System.out.println(" dus die denkt: ik loop gewoon de finish voorbij!\nLeuk geprobeerd, "+naam+", maar je moet teruglopen en eindigt op vakje " +huidigeP+ ".");
							eindresultaat = "is geëindigd op vakje " +huidigeP;
							break;
						case 66: 
							huidigeP=60;
							System.out.println(" dus die denkt: ik loop gewoon de finish voorbij!\nLeuk geprobeerd, "+naam+", maar je moet teruglopen en eindigt op vakje " +huidigeP+ ".");
							eindresultaat = "is geëindigd op vakje " +huidigeP;
							break;
						case 67: 
							huidigeP=59;
							System.out.println(" dus die denkt: ik loop gewoon de finish voorbij!\nLeuk geprobeerd, "+naam+", maar je moet teruglopen en eindigt op vakje " +huidigeP+ ".");
							eindresultaat = "is geëindigd op vakje " +huidigeP;
							break;
						case 68: 
							huidigeP=58;
							System.out.println(" dus die denkt: ik loop gewoon de finish voorbij!\nLeuk geprobeerd, "+naam+", maar je moet teruglopen en eindigt op vakje 58, ook wel bekend als: de dood.");
							System.out.println("Dit betekent dat " +naam+ " weer bij 0 belandt!");
							huidigeP = 0;
							eindresultaat = "is geëindigd op vakje " +huidigeP;
							break;
					}
			}
		} else {
			System.out.println("Dit is geen geldige invoer.");
			bepaalPositie();		
		}
	}
}
