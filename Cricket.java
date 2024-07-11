package javapro;
import java.util.Random;
import java.util.*;
class Teams{
Scanner sc = new Scanner(System.in);
public static String team1;
public static String team2;
public static int overs = 0;
public static String batting = "";
public static String bowling = "";
public static int temp;
public static int firstInningsScore=0;
void announceTeams() {
System.out.print("The Match is between "+team1+" and "+team2);
announceStadium();
}

void announceStadium(){
String home = "";
switch (team1) {
case "DC" : {home = "Delhi, Arun jaitley Stadium"; break ;}
case "CSK" : {home = "Chennai, M.a.Chidhambaram Stadium"; break ;}
case "MI" : {home = "Mumbai, Wankhade Stadium"; break ;}
case "KKR" : {home = "Kolkatta, Eden Gardens"; break ;}
case "RR" : {home = "Rajastan, Sawai Man Singh Stadium"; break ;}
case "PBKS" : {home = "Mullanpur,Maharaja Yadavindra Singh Stadium"; break ;}
case "LSG" : {home = "Lucknow, Ekana Stadium"; break ;}
case "GT" : {home = "Ahmedabad, Narendra Modi Stadium"; break ;}
case "SRH" : {home = "Hyderabad, Rajiv Gandhi Stadium"; break ;}
case "RCB" : {home = "Bangalore, Chinnasamy Stadium"; break ;}
default : {home = "The Oval"; break;}
}
System.out.print(" - Live from "+home);
System.out.println("\n---------------------------------------------------");
System.out.println("Enter the number of overs : ");
overs = sc.nextInt();
temp = overs;
overs *= 6;
}
String choice ;
String tossWinner;
String opt;
void coinToss(String toss) {
Random random = new Random();
int randomNumber = random.nextInt(2);
     if (randomNumber == 0) {
         choice = "H";
     } else {
         choice = "T";
     }
if(toss.equalsIgnoreCase(choice)) {
System.out.print(team1+" Have won the toss");
tossWinner = team1;
tossTeam();
}
else {
System.out.print(team2+" Have won the toss");
tossWinner = team2;
tossTeam();
}
System.out.println("\n---------------------------------------------------");
}
void tossTeam() {
Random random = new Random();
int randomNumber = random.nextInt(2);
 if (randomNumber == 0) {
         choice = "Bat";
     } else {
         choice = "Bowl";
     }
 opt = choice;
 System.out.println(" and elected to "+ choice + " first");
System.out.println("\n---------------------------------------------------");
 if(tossWinner.equals(team1) && opt.equals("Bat")) {
 playingEleven1();
 playingEleven2();

 batting = team1;
 bowling = team2;
//  printPlayerNames1();
//  printPlayerNames2();
 }
 else if(tossWinner.equals(team1) && opt.equals("Bowl")) {
 playingEleven2();
 playingEleven1();

 batting = team2;
 bowling = team1;
//  printPlayerNames2();
//  printPlayerNames1();
 }
 else  if(tossWinner.equals(team2) && opt.equals("Bat")) {
 playingEleven2();
 playingEleven1();

 batting = team2;
 bowling = team1;
//  printPlayerNames2();
//  printPlayerNames1();
 }
 else if(tossWinner.equals(team2) && opt.equals("Bowl")) {
 playingEleven1();
 playingEleven2();

 batting = team1;
 bowling = team2;
//  printPlayerNames1();
//  printPlayerNames2();
 }
 System.out.println(batting+" "+bowling);
System.out.println("\n---------------------------------------------------");
}
static HashMap<String,Integer>[] teamPlayerNames1 = new HashMap[11];
static HashMap<String,Integer>[] teamPlayerNames2 = new HashMap[11];
void playingEleven1() {
Scanner sc = new Scanner(System.in);
System.out.println("Enter the Playing XI of "+team1+" :");
for(int i = 0 ; i < 11; i ++) {
String name=sc.next();
HashMap<String,Integer> map=new HashMap<String, Integer>();
map.put(name, 0);
teamPlayerNames1[i]=map;
}
System.out.println("\n---------------------------------------------------");
}

void playingEleven2(){
Scanner sc = new Scanner(System.in);
System.out.println("Enter the Playing XI of "+team2+" :");
for(int i = 0 ; i < 11; i ++) {
String name=sc.next();
HashMap<String,Integer> map=new HashMap<String, Integer>();
map.put(name, 0);
teamPlayerNames2[i]=map;
}
System.out.println("\n---------------------------------------------------");
}
// void printPlayerNames1() {
// System.out.println("Playing XI of: "+batting);
// for(int i=0;i<teamPlayerNames1.length;i++) {
// for(Map.Entry<String, Integer> entry:teamPlayerNames1[i].entrySet()) {
// System.out.println(entry.getKey());
// }
// }
// }
// void printPlayerNames2() {
// System.out.println("Playing XI of: "+bowling);
// for(int i=0;i<teamPlayerNames2.length;i++) {
// for(Map.Entry<String, Integer> entrys:teamPlayerNames2[i].entrySet()) {
// System.out.println(entrys.getKey());
// }
// }
// }
}

class Bowling extends Teams{
Scanner sc = new Scanner(System.in);
public static int i = 0;
public static int []scoresArray = new int[overs];
public static int scores = 0;
public static int wickets = 0;
public int score=0;
public static boolean[] strike = {true,false};
public static int playerIndex1=0;
public static int playerIndex2=1;
void wide() {
System.out.println("dot -> d\t1 -> 1\t 2 -> 2\t 3 -> 3\t 4 -> 4 \t wicket -> w");

String run = sc.next();
switch(run) {
case "d": scoresArray[i] = 1 ;scores +=1 ; break;
case "1": scoresArray[i] = 2 ;scores += 2; strike[0]=!strike[0];strike[1]=!strike[1] ;break;
case "2": scoresArray[i] = 3 ;scores += 3 ;break;
case "3": scoresArray[i] = 4 ;scores += 4; strike[0]=!strike[0];strike[1]=!strike[1] ;break;
case "4": scoresArray[i] = 5 ;scores += 5 ;break;
case "w" :wicket();break;
}
i = i - 1;
}
void noBall() {
System.out.println("dot -> d\t1 -> 1\t 2 -> 2\t 3 -> 3\t 4 -> 4 \t wicket -> w");
String run = sc.next();
switch(run) {
case "d": scoresArray[i] = 1 ;scores +=1 ; break;
case "1": scoresArray[i] = 2 ;scores += 2; strike[0]=!strike[0];strike[1]=!strike[1] ;break;
case "2": scoresArray[i] = 3 ;scores += 3 ;break;
case "3": scoresArray[i] = 4 ;scores += 4; strike[0]=!strike[0];strike[1]=!strike[1] ;break;
case "4": scoresArray[i] = 5 ;scores += 5 ;break;
case "w" :wicket();break;
}
i = i - 1;
}
void legByes() {
System.out.println("dot -> d\t1 -> 1\t 2 -> 2\t 3 -> 3\t 4 -> 4 \t wicket -> w");
String run = sc.next();
switch(run) {
case "1": scoresArray[i] = 1 ;scores += 1;strike[0]=!strike[0];strike[1]=!strike[1] ;break;
case "2": scoresArray[i] = 2 ;scores += 2 ;break;
case "3": scoresArray[i] = 3 ;scores += 3; strike[0]=!strike[0];strike[1]=!strike[1] ;break;
case "4": scoresArray[i] = 4 ;scores += 4 ;break;
case "w" :wicket();break;
}
}
void byes() {
System.out.println("dot -> d\t1 -> 1\t 2 -> 2\t 3 -> 3\t 4 -> 4 \t wicket -> w");
String run = sc.next();
switch(run) {
case "1": scoresArray[i] = 1 ;scores += 1;strike[0]=!strike[0];strike[1]=!strike[1] ;break;
case "2": scoresArray[i] = 2 ;scores += 2 ;break;
case "3": scoresArray[i] = 3 ;scores += 3;strike[0]=!strike[0];strike[1]=!strike[1] ;break;
case "4": scoresArray[i] = 4 ;scores += 4 ;break;
case "w" :wicket();break;
}
}
void runOut() {
System.out.println("dot -> d\t 1 -> 1\t 2 -> 2\t 3 -> 3\t");
String run = sc.next();
switch(run) {
case "d": scoresArray[i] = 0 ;scores +=0 ; score = 0 ; break;
case "1": scoresArray[i] = 1 ;scores += 1; score=1; strike[0]=!strike[0];strike[1]=!strike[1];break;
case "2": scoresArray[i] = 2 ;scores += 2;score=2 ;break;
case "3": scoresArray[i] = 3 ;scores += 3;score=3; strike[0]=!strike[0];strike[1]=!strike[1] ;break;
}
wickets += 1;
}
void wicket() {
 System.out.println("Out -> o \t Runout -> ro");
String s = sc.next();
switch(s) {
case "o" : wickets += 1;
if(strike[0]) {
playerIndex1 = Math.max(playerIndex1, playerIndex2)+1;
}
else{
playerIndex2 = Math.max(playerIndex1, playerIndex2)+1;
};
break;
case "ro" : runOut(); break;
}
if(count == 0) {
if(wickets == 10) {
System.out.println("All Out !");
i = 0;
wickets = 0;
overs = temp * 6;
Arrays.fill(scoresArray, 0);
System.out.print(batting+" - "+scores);
firstInningsScore = scores;
scores = 0;
strike[0] = true;
strike[1] = false;
wickets = 0;
playerIndex1 = 0;
playerIndex2 = 1;
batting = team1;  
scoreCard();
count = count + 1;
}
}

}
public static int count = 0;
void scoreCard() {


for(i = 0 ; i < overs ; i ++) {
System.out.println("\ndot -> d 1 -> 1\t2 -> 2\t3 -> 3\t4 -> 4\t6 -> 6 \nWide -> wd\t Noball -> nb\t Legbyes -> lb\t Byes -> b\twicket -> w");
String s1 = sc.next();
switch(s1) {
case "d": scoresArray[i] = 0 ;scores +=0 ; score = 0 ; break;
case "1": scoresArray[i] = 1 ;scores += 1; score=1; ;break;
case "2": scoresArray[i] = 2 ;scores += 2; score=2 ;break;
case "3": scoresArray[i] = 3 ;scores += 3; score=3; ;break;
case "4": scoresArray[i] = 4 ;scores += 4; score=4 ;break;
case "6": scoresArray[i] = 6 ;scores += 6; score=6; ;break;
case "wd": wide() ;break;
case "nb":noBall(); break;
case "lb": legByes(); break;
case "b": byes(); break;
case "w": wicket(); break;
default:
i=i-1;
break;
}
displayScore();
if((i+1)%6==0) {
strike[0]=!strike[0];
strike[1]=!strike[1];
}
if(count == 0) {
if(i == overs-1) {
count=count+1;
System.out.println("Overs Completed !");
i = 0;
overs = temp * 6;
Arrays.fill(scoresArray, 0);
System.out.print(team2+" - "+scores);
firstInningsScore = scores;
scores = 0;
strike[0] = true;
strike[1] = false;
wickets = 0;
playerIndex1 = 0;
playerIndex2 = 1;
if(batting.equals(team1)) {
batting = team2;
bowling = team1;
}
else {
batting = team1;
bowling = team2;
}
scoreCard();
}
}
if(count != 0) {
if(scores > firstInningsScore) {
System.out.println(batting+" won the match");
overs = 0;
}
else if (scores == firstInningsScore && i == 11) {
System.out.println("The match is a tie");
}
else if(scores < firstInningsScore && i == 11) {
System.out.println(bowling+" won the match");
overs = 0;
}
}
}


}


public int nextPlayer;
void displayScore(){
if(wickets < 10) {
System.out.println("\n---------------------------------------------------");
System.out.println(batting+" - "+ scores + " / " +wickets + " ( " +(i+1)+" )");
if(batting.equals(team1)) {
if(strike[0]) {
 bowlingFirstStriker();
 bowlingSecondStriker();

 }
 else {
 bowlingSecondStriker();
 bowlingFirstStriker();
 }

}
else {
 if(strike[0]) {
 battingFirstStriker();
 battingSecondStriker();

 }
 else {
 battingSecondStriker();
 battingFirstStriker();
}
}

for(int j=0;j<=i;j++) {
System.out.print(scoresArray[j]+" ");
}
System.out.println("\n---------------------------------------------------");
}
}
void battingFirstStriker() {
for(Map.Entry<String, Integer> en: teamPlayerNames2[playerIndex1].entrySet()) {
if(score%2!=0  && score != 0) {
strike[0]=!strike[0];
strike[1]=!strike[1];
}
int score1=en.getValue()+score;
   teamPlayerNames2[playerIndex1].put(en.getKey(), score1);
   System.out.println(en.getKey()+" "+en.getValue());
   score = 0;
}
}
void battingSecondStriker() {
for(Map.Entry<String, Integer> en: teamPlayerNames2[playerIndex2].entrySet()) {

if(score%2!=0 && score != 0) {
strike[0]=!strike[0];
strike[1]=!strike[1];
}
int score1=en.getValue()+score;
   teamPlayerNames2[playerIndex2].put(en.getKey(), score1);
   System.out.println(en.getKey()+" "+en.getValue());
   score = 0;
}
     
}
void bowlingFirstStriker() {
for(Map.Entry<String, Integer> en: teamPlayerNames1[playerIndex1].entrySet()) {
if(score%2!=0  && score != 0) {
strike[0]=!strike[0];
strike[1]=!strike[1];
}
int score1=en.getValue()+score;
   teamPlayerNames1[playerIndex1].put(en.getKey(), score1);
   System.out.println(en.getKey()+" "+en.getValue());
   score = 0;
}
}
void bowlingSecondStriker() {
for(Map.Entry<String, Integer> en: teamPlayerNames1[playerIndex2].entrySet()) {

if(score%2!=0 && score != 0) {
strike[0]=!strike[0];
strike[1]=!strike[1];
}
int score1=en.getValue()+score;
   teamPlayerNames1[playerIndex2].put(en.getKey(), score1);
   System.out.println(en.getKey()+" "+en.getValue());
   score = 0;
}
}

}

public class project {

public static void main(String[] args) {
Scanner in = new Scanner(System.in);
System.out.println("Enter the name of Home team : ");
String team1 = in.next();
System.out.println("Enter the name of Away team : ");
String team2 = in.next();
team1 = team1.toUpperCase();
team2 = team2.toUpperCase();
Teams teams = new Teams();
teams.team1 = team1;
teams.team2 = team2;
teams.announceTeams();

System.out.println(team2+" : Select Heads or Tails (H/T):");
String toss = in.next();
teams.coinToss(toss);

Bowling bowling = new Bowling();
bowling.scoreCard();
}

}

