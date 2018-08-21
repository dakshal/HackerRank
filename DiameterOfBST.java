class DiameterOfBST{
	
	int max = -1;
	
	public int findDiameter(Node root){
		if(root == null) {
			return 0;
		}

		int left = findDiameter(root.left);
		int right = findDiameter(root.right);
		int diameter = left + right +1;

		if(max < diameter){
			max = diameter;
		}

		return Math.max(left, right) + 1;
	}
}