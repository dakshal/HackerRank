/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
class Solution {
    public boolean moveLeft(Robot robot){
        robot.turnLeft();
        if(!robot.move()){
            robot.turnRight();
            return false;
        }
        robot.turnRight();
        return true;
    }
    
    public boolean moveRight(Robot robot){
        robot.turnRight();
        if(!robot.move()){
            robot.turnLeft();
            return false;
        }
        robot.turnLeft();
        return true;
    }
    
    public boolean moveBack(Robot robot){
        robot.turnRight();
        robot.turnRight();
        if(!robot.move()){
            robot.turnRight();
            robot.turnRight();
            return false;
        }
        robot.turnRight();
        robot.turnRight();
        return true;
    }
    
    HashSet<String> set = new HashSet<>();
    
    public void cleanRoom(Robot robot) {
        robot.clean();
        cleanGrid(robot, 0, 0);
    }

    public int cleanGrid(Robot robot, int i, int j) {

        if(set.contains(i+":"+j)){
            return 1;
        } else {
            set.add(i+":"+j);
            robot.clean();
        }

        if(moveBack(robot)){
            cleanGrid(robot, i-1, j);
            robot.move();
        }
        if(robot.move()){
            cleanGrid(robot, i+1, j);
            moveBack(robot);
        } 
        if(moveLeft(robot)){
            cleanGrid(robot, i, j-1);
            moveRight(robot);
        } 
        if(moveRight(robot)){
            cleanGrid(robot, i, j+1);
            moveLeft(robot);
        }
        return 1;
    }
}