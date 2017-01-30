/*
   Creates a random maze, then solves it by finding a path from
   the upper left corner to the lower right corner.
        
   BY:  David Eck
        Department of Mathematics and Computer Science
        Hobart and William Smith Colleges
        Geneva, NY   14456
     
        E-mail:  eck@hws.edu     

   NOTE:  YOU CAN DO ANYTHING YOU WANT WITH THIS CODE AND APPLET,
          EXCEPT CLAIM CREDIT FOR THEM (such as by trying to
          copyright the code yourself).
 
   UPDATE HISTORY:
      1998.11.23
      snilsson@nada.kht.se
      Changed this program into an application, adapted it to
      JDK 1.1, and removed some code.

      2000.01.21
      snilsson@nada.kth.se
      Fixed null pointer exception in putSquare.
*/        

import java.awt.*;
import java.awt.event.*;

class Maze extends Frame {
    public static void main(String[] args) {
        Frame window = new Maze();

        // The program can be terminated by closing the frame.
        window.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        window.setSize(500, 500);
        window.setTitle("Maze");
        MazeCanvas maze = new MazeCanvas();
        window.add(maze);
        window.show();
        maze.run();
    }    
}

class MazeCanvas extends Canvas {
    // Description of state of maze. The value of maze[i][j] is
    // one of the constants WALL, PATH, EMPTY, or VISITED. (Value
    // can also be negative, temporarily, inside createMaze().)
    //    A maze is made up of walls and corridors. maze[i][j] is
    // either part of a wall or part of  a corridor.  A cell that
    // is part of a corridor is represented by PATH if it is part
    // of the current path through the maze, by VISITED if it has
    // already been explored without finding a solution, and by
    // EMPTY if it has not yet been explored.
    int[][] maze;

    final static int BACKGROUND = 0;
    final static int WALL = 1;
    final static int PATH = 2;
    final static int EMPTY = 3;
    final static int VISITED = 4;

    // Colors associated with the preceding 5 constants
    Color[] color = {Color.lightGray,
                     Color.black,
                     new Color(204, 0, 0),    // red
                     new Color(51, 102, 204), // blue
                     new Color(51, 102, 204)};

    // Number of rows and columns of cells in maze, including
    // a wall around edges. Should be odd numbers.
    int rows = 45;
    int columns = 45;

    // Short delay between steps in making and solving maze
    int speedSleep = 30;

    // Graphics context for canvas, created in putSquare()
    Graphics me = null;
    
    // The following fields are set by checkSize()
    int width = -1;   // width of canvas
    int height = -1;  // height of canvas
    int cellWidth;    // width of cell
    int cellHeight;   // height of cell
    int left;         // left edge of maze, allowing for border
    int top;          // top edge of maze, allowing for border
    
    public MazeCanvas() {
        super();
        setBackground(color[BACKGROUND]);
        maze = new int[rows][columns];
    }

    // Called every time something is about to be drawn to check
    // the canvas size and adjust variables that depend on the size.
    // Returns true if the size has changed.
    boolean checkSize() {
       if (getSize().width != width || getSize().height != height) {
          width  = getSize().width;
          height = getSize().height;
          cellWidth = width / columns;
          cellHeight = height / rows;
          left = (width - cellWidth*columns) / 2;
          top = (height - cellHeight*rows) / 2;
          return true;
       }
       return false;
    }

    // Draws the entire maze.
    public void paint(Graphics g) {
        checkSize();
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++) {
                if (maze[i][j] < 0)
                    g.setColor(color[EMPTY]);
                else
                    g.setColor(color[maze[i][j]]);
                g.fillRect(j*cellWidth + left, i*cellHeight + top,
                           cellWidth, cellHeight);
            }
    }

    // Draw one cell of the maze, to the graphics context "me".
    synchronized void putSquare(int row, int col, int colorNum) {
        if (checkSize() || me == null) {
          if (me != null)
              me.dispose(); // Get rid of old graphics context
          me = getGraphics();
        }
        me.setColor(color[colorNum]);
        me.fillRect(col*cellWidth + left, row*cellHeight + top,
                    cellWidth, cellHeight);
        try { Thread.sleep(speedSleep); }
        catch (InterruptedException e) { }
    }
 
    // Make a maze and then solve it.
    public void run() {
       makeMaze();
       solveMaze(1,1);
    }

    // Create a random maze. The strategy is to start with a
    // agrid of disconnnected "rooms" separated by walls and
    // then look at each of the separating walls, in a random
    // order. If tearing down a wall would not create a loop in
    // the maze, then tear it down. Otherwise, leave it in place.
    void makeMaze() {
        int emptyCt = 0; // number of rooms
        int wallCt = 0;  // number of walls

        // Position of walls between rooms
        int walls = (rows/2 - 1)*columns + rows*(columns/2 - 1);
        int[] wallrow = new int[walls];
        int[] wallcol = new int[walls];

        // Start with everything being a wall.
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                maze[i][j] = WALL;

        // Make a grid of empty rooms.
        for (int i = 1; i < rows - 1; i += 2)
            for (int j = 1; j < columns - 1; j += 2) {
                emptyCt++;
                // Each room is represented by a
                // different negative number
                maze[i][j] = -emptyCt;
                // Record info about wall below this room.
                if (i < rows - 2) {
                    wallrow[wallCt] = i + 1;
                    wallcol[wallCt] = j;
                    wallCt++;
                }
                // Record info about wall to right of this room.
                if (j < columns - 2) {
                    wallrow[wallCt] = i;
                    wallcol[wallCt] = j + 1;
                    wallCt++;
                }
             }
        repaint();
        for (int i = wallCt - 2; i > 0; i--) {
            // Choose a wall randomly and maybe tear it down.
            // Never choose the first or last wall. In this way the
            // maze will start and end at the end of a corridor.
            int r = 1 + (int) (Math.random() * (i + 1));
            tearDown(wallrow[r], wallcol[r]);
            wallrow[r] = wallrow[i];
            wallcol[r] = wallcol[i];
        }
        // Replace negative values in maze[][] with EMPTY.
        for (int i = 1; i < rows - 1; i++)
           for (int j = 1; j < columns - 1; j++)
              if (maze[i][j] < 0)
                  maze[i][j] = EMPTY;
    }

    // Tear down a wall, unless doing so will form a loop. Tearing
    // down a wall joins two "rooms" into one "room". (Rooms begin
    // to look like corridors as they grow.) When a wall is torn down,
    // the room codes on one side are converted to match those on the
    // other side, so all the cells in a room have the same code.
    // Note that if the room codes on both sides of a wall already have
    // the same code, then tearing down that wall would create a loop,
    // so the wall is left in place.
    void tearDown(int row, int col) {
        if (row%2 == 1 && maze[row][col-1] != maze[row][col+1]) {
            // Row is odd; wall separates rooms horizontally.
            fill(row, col-1, maze[row][col-1], maze[row][col+1]);
            maze[row][col] = maze[row][col+1];
            putSquare(row, col, EMPTY);
        } else if (row%2 == 0 && maze[row-1][col] != maze[row+1][col]) {
            // Row is even; wall separates rooms vertically.
            fill(row-1, col, maze[row-1][col], maze[row+1][col]);
            maze[row][col] = maze[row+1][col];
            putSquare(row, col, EMPTY);
        }
    }

    // Called by tearDown() to change "room codes".
    void fill(int row, int col, int replace, int replaceWith) {
        if (maze[row][col] == replace) {
            maze[row][col] = replaceWith;
            fill(row+1, col, replace, replaceWith);
            fill(row-1, col, replace, replaceWith);
            fill(row, col+1, replace, replaceWith);
            fill(row, col-1, replace, replaceWith);
        }
    }

    // Try to solve the maze by continuing current path from
    // position (row,col).  Return true if a solution is found.
    // The maze is considered to be solved if the path reaches the
    // lower right cell.
    boolean solveMaze(int row, int col) {
        if (maze[row][col] == EMPTY) { 
            // Add this cell to the path.
            maze[row][col] = PATH;
            putSquare(row, col, PATH);

            // Path has reached goal.
            if (row == rows-2 && col == columns-2)
                return true;

            // Try to solve maze by extending path in each
            // possible direction.
            if (solveMaze(row-1, col) ||
                solveMaze(row, col-1) ||
                solveMaze(row+1, col) ||
                solveMaze(row, col+1))
                return true;

            // Maze can't be solved from this cell,
            // so backtract out of the cell.
            maze[row][col] = VISITED;
            putSquare(row, col, VISITED);
        }
        return false;
    }
}