//NAME: Jayden Lu!

import java.util.*;

public class isu2 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Match Simulator!");
		List<String> teams = new ArrayList<String>();
		System.out.println("Enter 8 unique team names: ");
		for (int i = 0; i<8; i++) { //loop to take 8 teams
			String line = scanner.nextLine();
			if (teams.contains(line)) { //check if team has already been entered
				i--; //allow user to enter another if name already in teams, so that we have 8 unique teams
				System.out.println("You already enter this name! Enter another! ");
			} else {
				teams.add(line);
			}
		}
		System.out.println("Here are all your teams: " + teams);
		
		System.out.println("Do you confirm? (yes/no) ");
		String answer = scanner.nextLine();
		while (answer.equals("no")) { //until user says yes, is happy with the teams!
			System.out.println("Enter the team name you would like to change: ");
			String teamChange = scanner.nextLine();
			if (teams.contains(teamChange)) { //make sure team they want change exists
				System.out.println("What would you like to change the team name to? ");
				String replace = scanner.nextLine();
				 if (teams.contains(replace)) { //ensure team they want to replace with doesn't already exist
	                 System.out.println("The new name is already in the list. Please choose another name.");
	            } else {
	                 teams.set(teams.indexOf(teamChange), replace); //replace proper team
	                 System.out.println("Team name updated. Current teams: " + teams);
	            }
			} else {
				System.out.println("Team not found, please enter valid team"); //make user enter again
			}
			System.out.println("Do you confirm the team list now? (yes/no): " + teams);
            answer = scanner.nextLine();
		} 
		
		List<String> groupA = new ArrayList<String>();
		List<String> groupB = new ArrayList<String>();
		
		List<Integer> indexesUsed = new ArrayList<Integer>();
		while (groupA.size() < 4) { //once group size is 4, means finished making group A
            int randIndex = (int) (Math.random() * 8); //generate a random index 0-7
            if (!indexesUsed.contains(randIndex)) { //if index hasn't already been used, add to groupA
            	groupA.add(teams.get(randIndex));
            	indexesUsed.add(randIndex); //add to indexesUsed to ensure the same isn't added twice
            }
		}
		//add group b teams
		for (int i = 0; i<8; i++) {
			if (!indexesUsed.contains(i)) { //if index hasn't been used in groupB, means can add to groupB!
				groupB.add(teams.get(i));
			}
		}
		System.out.println("Okay! Groups have been randomly made, teams in each group will play each other! ");
		System.out.println("Group A teams consists of: " + groupA);
		System.out.println("Group B teams consists of: " + groupB);
		
		System.out.println("Enter anything to begin group A matches! ");
		answer = scanner.nextLine(); //allow user to enter key to begin simulations!
		//group A matches
		int[] pointsA = new int[4]; //initiate int[] array for points for each team in groupA, access using index
        int[] goalsScoredA = new int[4]; //same as above but for goals scored by each team
        int[] goalsReceivedA = new int[4]; //goals conceded by each team
		
        System.out.println("Group A matches: ");
		for (int i = 0; i<groupA.size(); i++) { //i = first team scoring
			for (int j = i+1; j<groupA.size(); j++) { //j = second team scoring, ensures all combinations of games are played
				int team1Goals = (int) (Math.random() * 5); //goals scored by team 1 (random)
				int team2Goals = (int) (Math.random() * 5); //goals scored by team 2 (random)
				
				goalsScoredA[i] += team1Goals; //add goals to correct team/index
                goalsReceivedA[i] += team2Goals; 
                goalsScoredA[j] += team2Goals;
                goalsReceivedA[j] += team1Goals;
                
                if (team1Goals > team2Goals) {
                    pointsA[i] += 3; //if team1 wins, means team with index i gets 3 points
                } else if (team1Goals < team2Goals) {
                    pointsA[j] += 3; //if team2 wins, means team with index j gets 3 points
                } else {
                    pointsA[i] += 1; //if tied, both teams get 1 point
                    pointsA[j] += 1;
                }
                System.out.println("Final score: " + groupA.get(i) + " " + team1Goals + " - " + team2Goals + " " + groupA.get(j)); //output final score of each game
			}
		}
		System.out.println("\nStandings for Group A:");
        for (int i = 0; i < 4; i++) { //output standings for group A, based off index of points array
            System.out.println(groupA.get(i) + " - Points: " + pointsA[i] + ", Goals Scored: " + goalsScoredA[i] + ", Goals Received: " + goalsReceivedA[i]);
        }
		
		System.out.println("Enter anything for group B matches to begin! ");
		answer = scanner.nextLine();
		//group B matches, same idea as group A
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
	    
        //determine top 2 teams in group a 
        System.out.println("\nTop 2 teams from Group A are:");
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
            	//if points of team at index j > team at index i, swap them to sort
                if (pointsA[j] > pointsA[i] || (pointsA[j] == pointsA[i] && goalsScoredA[j] >= goalsScoredA[i])) { //secondary tiebreaker condition, where if they have same points, see who has more goals
                	//swap points of 2 teams to help sort greatest to least
                    int tempPoints = pointsA[i];
                    pointsA[i] = pointsA[j];
                    pointsA[j] = tempPoints; 
                    
                    //now, swap team corresponding the point arrangement, to maintain alignment 
                    String tempTeam = groupA.get(i);
                    groupA.set(i, groupA.get(j));
                    groupA.set(j, tempTeam);
                    
                    //also swap goals for alignment
                    int tempGoals = goalsScoredA[i];
                    goalsScoredA[i] = goalsScoredA[j];
                    goalsScoredA[j] = tempGoals;
                }
            }
        }
        System.out.println(groupA.get(0) + " and " + groupA.get(1));
        String a1 = groupA.get(0); //first team in list has most points in groupA (after sorting)
        String a2 = groupA.get(1); //second team in list has second most poitns in groupA (after sorting)
        
        // determine top 2 teams in Group b (same method as for groupA)
        System.out.println("\nTop 2 teams from Group B are:");
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                if (pointsB[j] > pointsB[i] || (pointsB[j] == pointsB[i] && goalsScoredB[j] >= goalsScoredB[i])) {
                    int tempPoints = pointsB[i];
                    pointsB[i] = pointsB[j];
                    pointsB[j] = tempPoints;

                    String tempTeam = groupB.get(i);
                    groupB.set(i, groupB.get(j));
                    groupB.set(j, tempTeam);
                    
                    int tempGoals = goalsScoredA[i];
                    goalsScoredB[i] = goalsScoredB[j];
                    goalsScoredB[j] = tempGoals;
                }
            }
        }
        System.out.println(groupB.get(0) + " and " + groupB.get(1));
        String b1 = groupB.get(0);
        String b2 = groupB.get(1);
	    
	    System.out.println("The teams from group A that will make it to the playoffs are " + a1 + " and " + a2); 
	    System.out.println("The teams from group B that will make it to the playoffs are " + b1 + " and " + b2);
	    
	    System.out.println("Okay lets begin the first playoff stage, enter any key to begin! ");
	    answer = scanner.nextLine();
	    System.out.println("\nPlayoff Stage!! ");
	    
	    //simulate first semifinal game
        System.out.println("Semifinal 1: " + a1 + " vs " + b2);
        
        int a1Goals = (int) (Math.random() * 5);  // Goals scored by team a1 (not going to use loop since only 1 match)
        int b2Goals = (int) (Math.random() * 5);  // Goals scored by team b2
        if (a1Goals == b2Goals) { //if draw
        	System.out.println("Looks like we have a draw, going to penalties! ");
        	
        	int a1Score = 0; //initiate shootout score variables for each team
        	int b2Score = 0;
        	for (int i = 0; i<3; i++) {
        		int a1Turn = (int) (Math.random() * 2); //generates a 0 or 1, 0 means they score on their turn, 1 means they don't
        		if (a1Turn == 0) { //if 0, means they score, so add 1 to a1Score
        			System.out.println(a1 + " scores on their turn!");
        			a1Score++;
        		}
        		int b2Turn = (int) (Math.random() * 2);
        		if (b2Turn == 0) {
        			System.out.println(b2 + " scores on their turn!");
        			b2Score++;
        		}
        	}
        	
        	while (a1Score == b2Score) { //if still tied, will go to sudden death rounds, if 1 team scores and other doesn't, team that scores wins
        		System.out.println("We are in sudden death! ");
        		int a1Turn = (int) (Math.random() * 2);  // 0 = scores, 1 = doesn't score
                if (a1Turn == 0) {
                	System.out.println(a1 + " scores on their turn!");
                    a1Score++;
                }

                int b2Turn = (int) (Math.random() * 2);  // 0 = scores, 1 = doesn't score
                if (b2Turn == 0) {
                	System.out.println(b2 + " scores on their turn!");
                    b2Score++;
                }

                System.out.println("After sudden death round: " + a1 + ": " + a1Score + " - " + b2 + ": " + b2Score);
        	}
        	
        	if (a1Score > b2Score) {
        		System.out.println(a1 + " won the match in shootout with a score of " + a1Score + " - " + b2Score);
        		a1Goals++; //add 1 goal, to show they won in shootout, and can determine who won later
        	} else {
        		System.out.println(b2 + " won the match in shootout with a score of " + b2Score + " - " + a1Score);
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
        
        //simulate second semifinal match (same idea as first)
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
        			System.out.println(a2 + " scores on their turn!");
        			a2Score++;
        		}
        		int b1Turn = (int) (Math.random() * 2);
        		if (b1Turn == 0) {
        			System.out.println(b1 + " scores on their turn!");
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

                System.out.println("After sudden death round: " + b1 + ": " + b1Score + " - " + a2 + ": " + a2Score);
        	}
        	
        	if (a2Score > b1Score) {
        		System.out.println(a2 + " won the match in shootout with a score of " + a2Score + " - " + b1Score);
        		a2Goals++; //add 1 goal, to show they won in shootout
        	} else {
        		System.out.println(b1 + " won the match in shootout with a score of " + b1Score + " - " + a2Score);
        		b1Goals++;
        	}
        }
        
        String semiWinner2 = "";
        if (a2Goals > b1Goals) {
        	semiWinner2 = a2;
        	System.out.println(semiWinner2 + " won the second semifinal, with a final score of " + a2Goals + " - " + b1Goals);
        } else {
        	semiWinner2 = b1;
        	System.out.println(semiWinner2 + " won the second semifinal, with a final score of " + b1Goals + " - " + a2Goals);
        }
        
        //simulate finals!!
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
        			System.out.println(semiWinner1 + " scores on their turn!");
        			t1Score++;
        		}
        		int t2Turn = (int) (Math.random() * 2);
        		if (t2Turn == 0) {
        			System.out.println(semiWinner2 + " scores on their turn!");
        			t2Score++;
        		}
        	}
        	
        	while (t1Score == t2Score) {
        		System.out.println("We are in sudden death! ");
        		int t1Turn = (int) (Math.random() * 2);  // 0 = scores, 1 = doesn't score
                if (t1Turn == 0) {
                	System.out.println(semiWinner1 + " scores on their turn!");
                    t1Score++;
                }

                int t2Turn = (int) (Math.random() * 2);  // 0 = scores, 1 = doesn't score
                if (t2Turn == 0) {
                	System.out.println(semiWinner2 + " scores on their turn!");
                    t2Score++;
                }

                System.out.println("After sudden death round: " + semiWinner1 + ": " + t1Score + " - " + semiWinner2 + ": " + t2Score);
        	}
        	
        	if (t1Score > t2Score) {
        		System.out.println(semiWinner1 + " won the match in shootout with a score of " + t1Score + " - " + t2Score);
        		t1Goals++; //add 1 goal, to show they won in shootout, and can determine who won later
        	} else {
        		System.out.println(semiWinner2 + " won the match in shootout with a score of " + t2Score + " - " + t1Score);
        		t2Goals++;
        	}
        }
        
        String finalWinner = "";
        if (t1Goals > t2Goals) {
        	finalWinner = semiWinner1;
        	System.out.println(semiWinner1 + " won the tournament, with a final score of " + t1Goals + " - " + t2Goals + " and " + semiWinner2 + " got second place!"); //final standings
        } else {
        	finalWinner = semiWinner2;
        	System.out.println(semiWinner2 + " won the tournament, with a final score of " + t2Goals + " - " + t1Goals + " and " + semiWinner1 + " got second place!");
        }
        
        //3 key statistics going over tournament
        System.out.println("Let's look at some statistics! Enter any key to begin ");
        answer = scanner.nextLine();
        scanner.close(); //close scanner!
        
        System.out.println("\nHere are 3 key statistics for the whole tournament!");
        //find total goals
        int totalGoalsScored = 0;
        for (int i = 0; i < 4; i++) {
            totalGoalsScored += goalsScoredA[i] + goalsScoredB[i]; //add goals scored from group stage
        }
        totalGoalsScored += (a1Goals + b2Goals + a2Goals + b1Goals + t1Goals + t2Goals); //add goals from playoffs
        System.out.println(totalGoalsScored + " total goals were scored the entire tournament!");
        
        //find which team scored the most goals in group stage
        int mostGroupGoals = 0;
        String mostGoalsTeamGroup = "";
        for (int i = 0; i < groupA.size(); i++) { //check group A
            if (goalsScoredA[i] > mostGroupGoals) {
            	mostGroupGoals = goalsScoredA[i];
                mostGoalsTeamGroup = groupA.get(i);
            }
        }
        for (int i = 0; i < groupB.size(); i++) { //check group B
            if (goalsScoredB[i] > mostGroupGoals) {
            	mostGroupGoals = goalsScoredB[i];
                mostGoalsTeamGroup = groupB.get(i);
            }
        }
        System.out.println("The team that scored the most goals in the group stage was " + mostGoalsTeamGroup + "!");
        
        //find average goals scored by each team
        double avgGoals = totalGoalsScored/8.0; //just divide total goals by number of teams (8) to get
        System.out.println("On average, each team scored " + avgGoals + " goals in the tournament!");
        
        System.out.println("\nOkay that's it, congrats to " + finalWinner + " for winning Match Simulator, thanks for tuning in!");
	}
}
