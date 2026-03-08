
public class ComboLock {
	
	private int currentNum = 0;
	private boolean isOpen = false;
	private boolean isFirst = true;
	
	private boolean gotS1 = false;
	private boolean gotS2 = false;
	private boolean gotS3 = false;
	
	private int s1;
	private int s2;
	private int s3;
	
	public ComboLock(int secret1, int secret2, int secret3) {
		
		s1 = secret1;
		s2 = secret2;
		s3 = secret3;
		
	}
	
	public int getcurrentNumber() {
		return currentNum;
	}
	
	public void turnLeft(int ticks) {
		turn(ticks, false);
		if(currentNum == s2) {
			System.out.println("2 unlocked");
			gotS2 = true;
		}
	}
	
	public void turnRight(int ticks) {
		turn(ticks, true);
		if(isFirst) {
			if(currentNum == s1) {
				System.out.println("1 unlocked");
				gotS1 = true;
			}
			isFirst = false;
		} else {
			if(currentNum == s3) {
				System.out.println("3 unlocked");
				gotS3 = true;
			}
		}
	}
	
	private void turn(int ticks, boolean isRight) {
		if(isRight) {
			currentNum+=ticks;
			if(currentNum > 39) {
				currentNum -=40;
			}
		} else {
			currentNum-=ticks;
			if(currentNum <0) {
				currentNum+=39;
			}
		}
		System.out.println("current num: "+currentNum);
	}
	
	public boolean open() {
		if(gotS1 && gotS2 && gotS3) {
			System.out.println("Unlocked");
			return true;
		} else {
			System.out.println("still locked");
			currentNum = 0;
			isFirst = true;
			gotS1 = false;
			gotS2 = false;
			gotS3 = false;
			return false;
		}
	}

}
