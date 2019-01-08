
import java.util.Scanner;

public class Ganzenbord {

	public static void main(String[] args) {		
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Welkom bij Ganzenbord!\nOm te spelen moet je minimaal 2 en maximaal 6 spelers hebben.\nVoer nu in met hoeveel spelers je wil spelen: ");
		int aantal = scanner.nextInt();
		
		for (;aantal>6 || aantal<2;) {
			System.out.println("Dat kan helaas niet. Voer een spelersaantal van minimaal 2 en maximaal 6 in:");
			aantal=scanner.nextInt();		
		}
		
		Speler speler[] = new Speler[7];
		
		for (int i=1; aantal>=i ; i++) {
			System.out.print("\nSpeler " +i+ ", voer je naam in: ");
			speler[i] = new Speler();
			speler[i].naam = scanner.next();
			System.out.println("Welkom bij Ganzenbord, " +speler[i].naam+ ".");
			speler[i].nummer = i;
		}
		System.out.println("\nOk spelers, we gaan van start!");

		
		int hoogste =0;
		
		for (int ronde=0; hoogste <63; ronde++) {
			for (int i =1; aantal>=i && hoogste <63; i++) {
				
				if (speler[i].beurt == ronde) {
					speler[i].bepaalPositie();
					speler[i].beurt++;
					hoogste = speler[i].huidigeP;
				}
				else if (speler[i].beurt > ronde && speler[i].huidigeP == 19) {
					System.out.println("\n"+speler[i].naam+ " zit in de herberg en slaat deze beurt over.");
				}
				else if (speler[i].beurt > ronde && speler[i].huidigeP == 52) {
				System.out.println("\n"+speler[i].naam+ " zit in de gevangenis en slaat deze beurt over.");
				}
				else if (speler[i].huidigeP ==31) {
					if (speler[i].spelerInDePut == speler[i].nummer) {
						System.out.println("\n"+speler[i].naam+ " zit in de put en slaat deze beurt over.");
					} else {
						System.out.print("\n"+speler[i].naam+ " is inmiddels uit de put bevrijd en mag weer verder spelen!");
						speler[i].beurt=ronde +1;
						speler[i].bepaalPositie();
					}
				}
			}	
			
		}
		System.out.print("\nHet spel is afgelopen. Toets e om het eindresultaat te zien: ");
		String invoer = scanner.next();
		for (;!invoer.equals("e");) {
			System.out.println("Dit is geen geldige invoer. Toets e om het eindresultaat te zien: ");
			invoer = scanner.next();
		}		
		System.out.println("\nSpeler\t  Eindresultaat\n--------------------------------");
		
		for (int i=1; i<=aantal; i++) {
			System.out.println(speler[i].naam + "\t" +speler[i].eindresultaat);
		}
		System.out.println("\nBedankt voor het spelen!");
		
	}

}
