package marsrover;
import java.util.Objects;
import java.util.Scanner;
//Developed by Lourens Olivier
    public class Rover {
    	public static final Integer N = 1;
    	public static final Integer E = 2;
    	public static final Integer S = 3;
    	public static final Integer W = 4;
    	Integer x = 0;
    	Integer y = 0;
    	Integer facing = N;
    	public Rover() {
    	}
    	public void setPosition(Integer x, Integer y, Integer facing) {
    		this.x = x;
    		this.y = y;
    		this.facing = facing;
    	}
    	public void printPosition() {
            char dir = 'N';
    		if (null != facing) switch (facing) {
                    case 1:
                        dir = 'N';
                        break;
                    case 2:
                        dir = 'E';
                        break;
                    case 3:
                        dir = 'S';
                        break;
                    case 4:
                        dir = 'W';
                        break;
                    default:
                        break;
                }
    		System.out.println("Resulting location is: "+x+" " +y+ " "+dir);
    	}
    	public void process(String commands) {
    		for (int index = 0; index < commands.length(); index++  ) {
    			process(commands.charAt(index));
    		}
    	}
    	private void process(Character command) {
            switch (command) {
                    case 'L':
                        turnLeft();
                        break;
                    case 'R':
                        turnRight();
                        break;
                    case 'M':
                        move();
                        break;
                    default:
                        throw new IllegalArgumentException(
                                "You've entered an incorrect value");
                }
    	}
    	private void move() {
    		if (Objects.equals(facing, N)) {
    			this.y++;
    		} else if (Objects.equals(facing, E)) {
    			this.x++;
    		} else if (Objects.equals(facing, S)) {
    			this.y--;
    		} else if (Objects.equals(facing, W)) {
    			this.x--;
    		}
    	}
    	private void turnLeft() {
            if ((facing - 1) < N) {
                facing= W;
            }else{
                facing = facing - 1;
            }
    	}
    	private void turnRight() {
            if ((facing + 1) > W) {
                facing= N;
            }else{
                facing = facing + 1;
            }
    	}
    	public static void main(String args[]) {
            Scanner scanner = new Scanner(System.in);
            Rover rover = new Rover();
                System.out.print("Please enter Maximum Coordinates"); //Incomplete method
                System.out.println();
                String maxPos = scanner.nextLine();
                    while(true){               
                System.out.print("Please enter in the follwing format, x y Direction(N=1, E=2, S=3, W=4) :");
                System.out.println();
                String position = scanner.nextLine();
                    String[]positionArray = position.split(" ");
                    int x = Integer.parseInt(positionArray[0]);
                    int y = Integer.parseInt(positionArray[1]);
                    int pos = Integer.parseInt(positionArray[2]);
                            rover.setPosition(x,y,pos);
                            
                System.out.print("Please enter Movements) :");
                System.out.println();  
                     String input = scanner.nextLine();
                     rover.process(input);
                     rover.printPosition();                   
                }
    	}
    }