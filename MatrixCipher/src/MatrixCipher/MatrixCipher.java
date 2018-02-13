package MatrixCipher;
import java.util.Scanner;

public class MatrixCipher{

	public static int messageLength = 0;
	
	public final static int MODULUS = 29;
	
	//Beginning of getters and setters for access by GUI
	
	public static int getMessageLength(){
		return messageLength;
	}
	
	public static void setMessageLength(int num){
		messageLength = num;
	}
	
	//End of getters and setters for access by GUI
	
	
	public static int[][] stringToNumberMatrix(String message){
		int[][] matrixNumbers = new int[3][((int) messageLength/3) + 1];
		String[] letters = message.split("");
		for(int l = 0; l < letters.length; l++){
			String letter = letters[l];
			int i = 0;
			switch(letter){
			case "A": i = 1; break;
			case "B": i = 2; break;
			case "C": i = 3; break;
			case "D": i = 4; break;
			case "E": i = 5; break;
			case "F": i = 6; break;
			case "G": i = 7; break;
			case "H": i = 8; break;
			case "I": i = 9; break;
			case "J": i = 10; break;
			case "K": i = 11; break;
			case "L": i = 12; break;
			case "M": i = 13; break;
			case "N": i = 14; break;
			case "O": i = 15; break;
			case "P": i = 16; break;
			case "Q": i = 17; break;
			case "R": i = 18; break;
			case "S": i = 19; break;
			case "T": i = 20; break;
			case "U": i = 21; break;
			case "V": i = 22; break;
			case "W": i = 23; break;
			case "X": i = 24; break;
			case "Y": i = 25; break;
			case "Z": i = 26; break;
			case ",": i = 27; break;
			case ".": i = 28; break;
			default: i = 0; break;
			}
			matrixNumbers[l%3][(int) l/3] = i;
		}
		return matrixNumbers;
	}
	
	public static int[][] matrixDecrypt(int[][]matrixNumbers){
		int[][]inverseCodingMatrix = {{1,0,28},{28,1,28},{28,0,2}};
		int[][]decryptedMatrix = new int[3][((int) messageLength/3) + 1];
		for(int i = 0; i < messageLength; i++){ 
			int x = (inverseCodingMatrix[i%3][0] * matrixNumbers[0][(int) i/3]) + 
					(inverseCodingMatrix[i%3][1] * matrixNumbers[1][(int) i/3]) + (inverseCodingMatrix[i%3][2] * matrixNumbers[2][(int) i/3]);
			x %= MODULUS;
			decryptedMatrix[i%3][(int) i/3] = x;
		}
		return decryptedMatrix;
	}
	
	public static int[][] matrixEncrypt(int[][]matrixNumbers){
		int[][]codingMatrix = {{2,0,1},{3,1,2},{1,0,1}};
		int[][]encryptedMatrix = new int[3][((int) messageLength/3) + 1];
		for(int i = 0; i < messageLength; i++){ 
			int x = (codingMatrix[i%3][0] * matrixNumbers[0][(int) i/3]) + 
					(codingMatrix[i%3][1] * matrixNumbers[1][(int) i/3]) + (codingMatrix[i%3][2] * matrixNumbers[2][(int) i/3]);
			x %= MODULUS;
			encryptedMatrix[i%3][(int) i/3] = x;
		}
		return encryptedMatrix;
	}
	
	public static String numberMatrixToString(int[][] matrixNumbers) {
		String output = "";
		for(int i = 0; i < messageLength; i++){
			int num = matrixNumbers[i%3][(int) i/3];
			String l = "";
			switch(num){
			case 1: l = "A"; break;
			case 2: l = "B"; break;
			case 3: l = "C"; break;
			case 4: l = "D"; break;
			case 5: l = "E"; break;
			case 6: l = "F"; break;
			case 7: l = "G"; break;
			case 8: l = "H"; break;
			case 9: l = "I"; break;
			case 10: l = "J"; break;
			case 11: l = "K"; break;
			case 12: l = "L"; break;
			case 13: l = "M"; break;
			case 14: l = "N"; break;
			case 15: l = "O"; break;
			case 16: l = "P"; break;
			case 17: l = "Q"; break;
			case 18: l = "R"; break;
			case 19: l = "S"; break;
			case 20: l = "T"; break;
			case 21: l = "U"; break;
			case 22: l = "V"; break;
			case 23: l = "W"; break;
			case 24: l = "X"; break;
			case 25: l = "Y"; break;
			case 26: l = "Z"; break;
			case 27: l = ","; break;
			case 28: l = "."; break;
			default: l = " "; break;
			}
			output = output + l;
		}
		return output;
	}
	
	public static void main(String[]args){

		//GUI encryption
		new GUI().setVisible(true);
		
		
		//Console encryption
		/*
		Scanner sc = new Scanner(System.in);
		int[][] encryptedMatrix = new int[0][0];
		//Set choice to 1 for encryption, 2 for decryption
		int choice = 2;
		if(choice == 1){
			System.out.println("Type in a message you would like to be encrypted.");
		}
		if(choice == 2){
			System.out.println("Type in a message you would like to be decrypted.");
		}
		String message = sc.nextLine();
		messageLength = message.length();
		if (messageLength%3 !=0){
			messageLength = messageLength + (3 - messageLength%3);
		}
		message = message.toUpperCase();
		int[][] matrixNumbers = MatrixCipher.stringToNumberMatrix(message);
		if(choice == 1){
			encryptedMatrix = MatrixCipher.matrixEncrypt(matrixNumbers);
		}
		if(choice == 2){
			encryptedMatrix = MatrixCipher.matrixDecrypt(matrixNumbers);
		}
		String newMessage = MatrixCipher.numberMatrixToString(encryptedMatrix);
		System.out.println(newMessage);
		*/
	}
	
}


