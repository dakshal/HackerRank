public class SampleStack {
	static class CustomStack {
		int arr[] = new int[10];
		int max[] = new int[10];
		int size = -1, maxEnd = -1;

		public void printStack(String op){
			System.out.println(op);
			for(int i=0; i<=size; i++){
				System.out.print(arr[i]+"\t");
			}
			System.out.println();
		}

		public void push(int a){
			size++;
			if(arr.length == size){
				int tempArray[] = new int[size*2];
				for(int i=0; i< arr.length; i++){
					tempArray[i] = arr[i];
				}
				arr = tempArray;
			}
			arr[size] = a;
			maxEnd ++;
			if(a>=max[maxEnd]) {
				
				if(max.length == maxEnd){
					int tempArray[] = new int[maxEnd*2];
					for(int i=0; i< arr.length; i++){
						tempArray[i] = arr[i];
					}
					arr = tempArray;
				}
				printStack("push\t"+a);
				max[maxEnd] = a;
			} else {
				maxEnd--;
			}
			
		}

		public int pop(){
			if(size>=0){
				size--;
				printStack("pop");
				if(max[maxEnd] == arr[size+1]) {
					maxEnd--;
				}
				return arr[size+1];
			} else {
				System.out.println("Unable to do pop() on empty array");
			}
			return -1;

		}

		public int max(){
			return max[maxEnd];
		}

	}
	public static void main(String[] args){
		CustomStack stack = new CustomStack();

		stack.push(1);
		stack.push(2);
		stack.pop();
		stack.push(3);
		stack.push(5);
		System.out.println("max = \t"+stack.max());
		stack.pop();
		stack.push(1);
		System.out.println("max = \t"+stack.max());
		stack.push(6);
		System.out.println("max = \t"+stack.max());
	}

}