import java.util.*;

public class isu2 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Match Stimulator!");
		List<String> teams = new ArrayList<String>();
		System.out.println("Enter 8 unique team names: ");
		for (int i = 0; i<8; i++) {
			String line = scanner.nextLine();
			if (teams.contains(line)) {
				i--;
				System.out.println("You already enter this name! Enter another! ");
			} else {
				teams.add(line);
			}
		}
		System.out.println("Here are all your teams: " + teams);
		
		System.out.println("Do you confirm? (yes/no) ");
		String answer = scanner.next();
		while (answer.equals("no")) {
			System.out.println("Enter the team name you would like to change: ");
			String teamChange = scanner.nextLine();
			if (teams.contains(teamChange)) {
				System.out.println("What would you like to change the team name to? ");
				String replace = scanner.nextLine();
				 if (teams.contains(replace)) {
	                 System.out.println("The new name is already in the list. Please choose another name.");
	            } else {
	                 teams.set(teams.indexOf(teamChange), replace);
	                 System.out.println("Team name updated. Current teams: " + teams);
	            }
			} else {
				System.out.println("Team not found, please enter valid team");
			}
			System.out.println("Do you confirm the team list now? (yes/no): " + teams);
            answer = scanner.nextLine();
		} 
		
		List<String> groupA = new ArrayList<String>();
		List<String> groupB = new ArrayList<String>();
		
		List<Integer> indexesUsed = new ArrayList<Integer>();
		while (groupA.size() < 4) {
            int randIndex = (int) (Math.random() * 8);
            if (!indexesUsed.contains(randIndex)) {
            	groupA.add(teams.get(randIndex));
            	indexesUsed.add(randIndex);
            }
		}
		
		for (int i = 0; i<8; i++) {
			if (!indexesUsed.contains(i)) {
				groupB.add(teams.get(i));
			}
		}
		
		System.out.println("Okay! Groups have been randomly made, teams in each group will play each other! ");
		System.out.println("Group A teams consists of: " + groupA);
		System.out.println("Group B teams consists of: " + groupB);
		
		System.out.println("Enter anything to begin group A matches! ");
		answer = scanner.nextLine();
		//group A matches
		int[] pointsA = new int[4];
        int[] goalsScoredA = new int[4];
        int[] goalsReceivedA = new int[4];
		
        System.out.println("Group A matches: ");
		for (int i = 0; i<groupA.size(); i++) {
			for (int j = i+1; j<groupA.size(); j++) {
				int team1Goals = (int) (Math.random() * 5); //goals scored by team 1
				int team2Goals = (int) (Math.random() * 5); //goals scored by team 2
				
				goalsScoredA[i] += team1Goals;
                goalsReceivedA[i] += team2Goals;
                goalsScoredA[j] += team2Goals;
                goalsReceivedA[j] += team1Goals;
                
                if (team1Goals > team2Goals) {
                    pointsA[i] += 3;
                } else if (team1Goals < team2Goals) {
                    pointsA[j] += 3;
                } else {
                    pointsA[i] += 1;
                    pointsA[j] += 1;
                }
                System.out.println("Final score: " + groupB.get(i) + " " + team1Goals + " - " + team2Goals + " " + groupB.get(j));
			}
		}
		System.out.println("\nStandings for Group A:");
        for (int i = 0; i < 4; i++) {
            System.out.println(groupA.get(i) + " - Points: " + pointsA[i] + ", Goals Scored: " + goalsScoredA[i] + ", Goals Received: " + goalsReceivedA[i]);
        }
		
		System.out.println("Enter anything for group B matches to begin! ");
		answer = scanner.nextLine();
		//group B matches
		int[] pointsB = new int[4];
	    int[] goalsScoredB = new int[4];
	    int[] goalsReceivedB = new int[4];
	    
	    System.out.println("Group B matches: ");
	    for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                int team1Goals = (int) (Math.random() * 5); // goals scored by team 1
                int team2Goals = (int) (Math.random() * 5); // goals scored by team 2

                goalsScoredB[i] += team1Goals;
                goalsReceivedB[i] += team2Goals;
                goalsScoredB[j] += team2Goals;
                goalsReceivedB[j] += team1Goals;

                if (team1Goals > team2Goals) {
                    pointsB[i] += 3;
                } else if (team1Goals < team2Goals) {
                    pointsB[j] += 3;
                } else {
                    pointsB[i] += 1;
                    pointsB[j] += 1;
                }
                System.out.println("Final score: " + groupB.get(i) + " " + team1Goals + " - " + team2Goals + " " + groupB.get(j));
            }
	    }
	    System.out.println("\nStandings for Group B:");
        for (int i = 0; i < 4; i++) {
            System.out.println(groupB.get(i) + " - Points: " + pointsB[i] + ", Goals Scored: " + goalsScoredB[i] + ", Goals Received: " + goalsReceivedB[i]);
        }
	    /*
	    Arrays.sort(pointsA); //sorts least to greatest
	    Arrays.sort(pointsB); //sorts least to greatest
	    int a1 = pointsA[3]; //greatest points is last element of list, being index 3
	    int a2 = pointsA[2]; //second greatest points is second last element of list, being index 2
	    int b1 = pointsB[3];
	    int b2 = pointsB[2]; */
        System.out.println("\nTop 2 teams from Group A:");
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                if (pointsA[j] > pointsA[i]) {
                    int tempPoints = pointsA[i];
                    pointsA[i] = pointsA[j];
                    pointsA[j] = tempPoints;

                    String tempTeam = groupA.get(i);
                    groupA.set(i, groupA.get(j));
                    groupA.set(j, tempTeam);
                }
            }
        }
        System.out.println(groupA.get(0) + " and " + groupA.get(1));
        String a1 = groupA.get(0);
        String a2 = groupA.get(1);
        
        // Determine top 2 teams in Group B
        System.out.println("\nTop 2 teams from Group B:");
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                if (pointsB[j] > pointsB[i]) {
                    int tempPoints = pointsB[i];
                    pointsB[i] = pointsB[j];
                    pointsB[j] = tempPoints;

                    String tempTeam = groupB.get(i);
                    groupB.set(i, groupB.get(j));
                    groupB.set(j, tempTeam);
                }
            }
        }
        System.out.println(groupB.get(0) + " and " + groupB.get(1));
        String b1 = groupA.get(0);
        String b2 = groupA.get(1);
	    
	    System.out.println("The teams from group A that will make it to the playoffs are " + a1 + " and " + a2); 
	    System.out.println("The teams from group B that will make it to the playoffs are " + b2 + " and " + b2);
	    
	    System.out.println("Okay lets begin the first playoff stage, enter any key to begin! ");
	    answer = scanner.nextLine();
	    System.out.println("\nPlayoff Stage!! ");
	    
	    //simulate first semifinal game
        System.out.println("Semifinal 1: " + a1 + " vs " + b2);
        
        int a1Goals = (int) (Math.random() * 5);  // Goals scored by team a1 (not going to use loop since only 1 match)
        int b2Goals = (int) (Math.random() * 5);  // Goals scored by team b2
        if (a1Goals == b2Goals) {
        	System.out.println("Looks like we have a draw, going to penalties! ");
        	
        	int a1Score = 0;
        	int b2Score = 0;
        	for (int i = 0; i<3; i++) {
        		int a1Turn = (int) (Math.random() * 2); //generates a 0 or 1, 0 means they score on their turn, 1 means they don't
        		if (a1Turn == 0) { //if 0, means they score, so add 1 to a1Score
        			a1Score++;
        		}
        		int b2Turn = (int) (Math.random() * 2);
        		if (b2Turn == 0) {
        			b2Score++;
        		}
        	}
        	
        	while (a1Score == b2Score) {
        		System.out.println("We are in sudden death! ");
        		int a1Turn = (int) (Math.random() * 2);  // 0 = scores, 1 = doesn't score
                if (a1Turn == 0) {
                    a1Score++;
                }

                int b2Turn = (int) (Math.random() * 2);  // 0 = scores, 1 = doesn't score
                if (b2Turn == 0) {
                    b2Score++;
                }

                System.out.println("After sudden death round: Team A1: " + a1Score + " - Team B2: " + b2Score);
        	}
        	
        	if (a1Score > b2Score) {
        		System.out.println(a1 + " won the match in shootout");
        		a1Goals++; //add 1 goal, to show they won in shootout, and can determine who won later
        	} else {
        		System.out.println(b2 + " won the match in shootout");
        		b2Goals++;
        	}
        }
        
        String semiWinner1 = "";
        if (a1Goals > b2Goals) {
        	semiWinner1 = a1;
        	System.out.println(semiWinner1 + " won the first semifinal, with a final score of " + a1Goals + " - " + b2Goals);
        } else {
        	semiWinner1 = b2;
        	System.out.println(semiWinner1 + " won the first semifinal, with a final score of " + b2Goals + " - " + a1Goals);
        }
        
        //simulate second semifinal match
        System.out.println("Semifinal 2: " + a2 + " vs " + b1);
        int a2Goals = (int) (Math.random() * 5);  // Goals scored by team a2 
        int b1Goals = (int) (Math.random() * 5);  // Goals scored by team b1
        if (a2Goals == b1Goals) {
        	System.out.println("Looks like we have a draw, going to penalties! ");
        	
        	int a2Score = 0;
        	int b1Score = 0;
        	for (int i = 0; i<3; i++) {
        		int a2Turn = (int) (Math.random() * 2); //generates a 0 or 1, 0 means they score on their turn, 1 means they don't
        		if (a2Turn == 0) { //if 0, means they score, so add 1 to a1Score
        			a2Score++;
        		}
        		int b1Turn = (int) (Math.random() * 2);
        		if (b1Turn == 0) {
        			b1Score++;
        		}
        	}
        	
        	while (a2Score == b1Score) {
        		System.out.println("We are in sudden death! ");
        		int a2Turn = (int) (Math.random() * 2);  // 0 = scores, 1 = doesn't score
                if (a2Turn == 0) {
                    a2Score++;
                }

                int b1Turn = (int) (Math.random() * 2);  // 0 = scores, 1 = doesn't score
                if (b1Turn == 0) {
                    b1Score++;
                }

                System.out.println("After sudden death round: Team A1: " + a2Score + " - Team B2: " + b1Score);
        	}
        	
        	if (a2Score > b1Score) {
        		System.out.println(a1 + " won the match in shootout");
        		a1Goals++; //add 1 goal, to show they won in shootout
        	} else {
        		System.out.println(b2 + " won the match in shootout");
        		b2Goals++;
        	}
        }
        
        String semiWinner2 = "";
        if (a2Goals > b1Goals) {
        	semiWinner2 = a2;
        	System.out.println(semiWinner2 + " won the first semifinal, with a final score of " + a2Goals + " - " + b1Goals);
        } else {
        	semiWinner2 = b1;
        	System.out.println(semiWinner2 + " won the first semifinal, with a final score of " + b1Goals + " - " + a2Goals);
        }
        
        System.out.println("Okay lets begin the finals, enter any key to begin! ");
	    answer = scanner.nextLine();
	    System.out.println("\nFinals!! ");
	    
	    System.out.println("Final Match: " + semiWinner1 + " vs " + semiWinner2);
	    int t1Goals = (int) (Math.random() * 5);  // Goals scored by team 1
        int t2Goals = (int) (Math.random() * 5);  // Goals scored by team 2
        if (t1Goals == t2Goals) {
        	System.out.println("Looks like we have a draw, going to penalties! ");
        	
        	int t1Score = 0;
        	int t2Score = 0;
        	for (int i = 0; i<3; i++) {
        		int t1Turn = (int) (Math.random() * 2); //generates a 0 or 1, 0 means they score on their turn, 1 means they don't
        		if (t1Turn == 0) { //if 0, means they score, so add 1 to a1Score
        			t1Score++;
        		}
        		int t2Turn = (int) (Math.random() * 2);
        		if (t2Turn == 0) {
        			t2Score++;
        		}
        	}
        	
        	while (t1Score == t2Score) {
        		System.out.println("We are in sudden death! ");
        		int a1Turn = (int) (Math.random() * 2);  // 0 = scores, 1 = doesn't score
                if (a1Turn == 0) {
                    t1Score++;
                }

                int t2Turn = (int) (Math.random() * 2);  // 0 = scores, 1 = doesn't score
                if (t2Turn == 0) {
                    t2Score++;
                }

                System.out.println("After sudden death round: Team A1: " + t1Score + " - Team B2: " + t2Score);
        	}
        	
        	if (t1Score > t2Score) {
        		System.out.println(a1 + " won the match in shootout");
        		a1Goals++; //add 1 goal, to show they won in shootout, and can determine who won later
        	} else {
        		System.out.println(b2 + " won the match in shootout");
        		b2Goals++;
        	}
        }
        
        String finalWinner = "";
        if (t1Goals > t2Goals) {
        	finalWinner = semiWinner1;
        	System.out.println(semiWinner1 + " won the tournament, with a final score of " + t1Goals + " - " + t2Goals);
        } else {
        	finalWinner = semiWinner2;
        	System.out.println(semiWinner2 + " won the tournament, with a final score of " + t2Goals + " - " + t1Goals);
        }
        
        
	}
}
