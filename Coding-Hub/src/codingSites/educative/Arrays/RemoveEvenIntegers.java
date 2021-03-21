package codingSites.educative.Arrays;


class CheckRemoveEven {

	public static int[] removeEven(int[] arr) {
		int totalElement = arr.length;
		int result[] = new int[totalElement];
		int elementCounter = 0;
		for(int index = 0; index < totalElement; index++) {
			int num = arr[index];
			if(!isEven(num)) {
				result[elementCounter] = num;
				elementCounter++;
			}
		}
		arr = new int[elementCounter];
		for(int index = 0; index < elementCounter; index++) {
			arr[index] = result[index]; 
		}
		return arr; // change this and return the correct result array
	}

	public static boolean isEven(int num) {
		if( num == 0) return true;
		if (num == 2) return true;
		if(num % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}
}