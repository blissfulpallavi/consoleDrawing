package com.pallavi;

import java.util.Scanner;

public class DrawingMain {
    static char[][] grid;
    static int len = 0;
    static int width = 0;

    public static void main(String[] args) {
        DrawingMain drawingMain = new DrawingMain();
        System.out.println("---WELCOME---");
        Scanner in = new Scanner(System.in);

        while (in != null) {
            System.out.println("Enter one of the following letters as a command:");
            System.out.println("C : Creating a blank canvas");
            System.out.println("L : Creating a new line inside the canvas");
            System.out.println("R : Creating a rectangle inside the canvas");
            System.out.println("C : Coloring the canvas with your choice of character C");
            System.out.println("P : Print your canvas");
            System.out.println("Q : Quit");
            String command = in.nextLine();
            if ("Q".equalsIgnoreCase(command)) {
            System.out.println("Quitting..!");
                in.close();
                break;
            } else if ("C".equalsIgnoreCase(command)) {
                System.out.println("Enter the length & breadth of canvas");
                String parametersInput = in.nextLine();
                String[] parameters = parametersInput.split(" ");
                len = Integer.parseInt(parameters[0]);
                width = Integer.parseInt(parameters[1]);
                grid = new char[len + 2][width + 2];
                drawingMain.createCanvas(len, width);
            } else if ("L".equalsIgnoreCase(command)) {
                if (len == 0 || width == 0) {
                    System.out.println("Please create a canvas first");
                    continue;
                }
                System.out.println("Enter x1 y1 x2 y2 parameters for the line");
                String parametersInput = in.nextLine();
                String[] parameters = parametersInput.split(" ");
                int x1 = Integer.parseInt(parameters[0]);
                int y1 = Integer.parseInt(parameters[1]);
                int x2 = Integer.parseInt(parameters[2]);
                int y2 = Integer.parseInt(parameters[3]);
                drawingMain.drawLine(x1, y1, x2, y2);
            } else if ("R".equalsIgnoreCase(command)) {
                if (len == 0 || width == 0) {
                    System.out.println("Please create a canvas first");
                    continue;
                }
                System.out.println("Enter x1 y1 x2 y2 parameters for the rectangle");
                String parametersInput = in.nextLine();
                String[] parameters = parametersInput.split(" ");
                int x1 = Integer.parseInt(parameters[0]);
                int y1 = Integer.parseInt(parameters[1]);
                int x2 = Integer.parseInt(parameters[2]);
                int y2 = Integer.parseInt(parameters[3]);
                drawingMain.drawRectangle(x1, y1, x2, y2);
            } else if ("B".equalsIgnoreCase(command)) {
                if (len == 0 || width == 0) {
                    System.out.println("Please create a canvas first");
                    continue;
                }
                System.out.println("Enter x y c parameters for the rectangle");
                String parametersInput = in.nextLine();
                String[] parameters = parametersInput.split(" ");
                int x = Integer.parseInt(parameters[0]);
                int y = Integer.parseInt(parameters[1]);
                char c = parameters[2].charAt(0);
                drawingMain.colorFill(x, y, c);
            } else if ("P".equalsIgnoreCase(command)) {
                if (len == 0 || width == 0) {
                    System.out.println("Please create a canvas first");
                    continue;
                }
                drawingMain.printGrid();
            }
        }
    }

    static void printGrid() {
        for (int j = 0; j <= width + 1; j++) {
            for (int i = 0; i <= len + 1; i++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    private void createCanvas(int len, int width) {
        for (int j = 0; j <= width + 1; j++) {
            for (int i = 0; i <= len + 1; i++) {
                if (j == 0 || j == (width + 1)) {
                    grid[i][j] = '-';
                } else if (i == 0 || i == (len + 1)) {
                    grid[i][j] = '|';
                } else {
                    grid[i][j] = ' ';
                }
            }
        }
    }

    private void drawLine(int x1, int y1, int x2, int y2) {
        for (int j = 0; j <= width; j++) {
            for (int i = 0; i <= len; i++) {
                if (i >= x1 && i <= x2 && j >= y1 && j <= y2) {
                    grid[i][j] = 'x';
                }
            }
        }
    }

    private void drawRectangle(int x1, int y1, int x2, int y2) {
        if (x1 > len || x2 > len || y1 > width || y2 > width)
            return;
        for (int j = y1; j <= y2; j++) {
            for (int i = x1; i <= x2; i++) {
                if (i == x1 || j == y1 || i == x2 || j == y2) {
                    grid[i][j] = 'x';
                }
            }
        }
    }

    private void colorFill(int x, int y, char c) {
        if (x > len && y > width)
            return;
        if (grid[x][y] == ' ') {
            grid[x][y] = c;
        }
        if (grid[x + 1][y] == ' ') {
            grid[x][y] = c;
            colorFill(x + 1, y, c);
        }
        if (grid[x][y + 1] == ' ') {
            grid[x][y] = c;
            colorFill(x, y + 1, c);
        }
        if (grid[x - 1][y] == ' ') {
            grid[x][y] = c;
            colorFill(x - 1, y, c);
        }
        if (grid[x][y - 1] == ' ') {
            grid[x][y] = c;
            colorFill(x, y - 1, c);
        }

    }
}
