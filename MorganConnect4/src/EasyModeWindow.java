/*
The window for the easy computer to play against in connect 4
 */

import java.awt.Color;
import javax.swing.JButton;

public class EasyModeWindow extends javax.swing.JFrame {

    Connect4 firstWindow;

    // arrays to find the winner
    JButton[][] grid = new JButton[6][7];
    int[][] winner = new int[6][7];
    boolean won = false;

    // varaibles for the turn
    int turn = 1;

    // variables for the columns
    int col1 = 0;
    int col2 = 0;
    int col3 = 0;
    int col4 = 0;
    int col5 = 0;
    int col6 = 0;
    int col7 = 0;

    // theese 7 column methods are used to simulate dropping a token in  a different column of the connect 4 grid
    public void column1(int r, int b) {
        grid[col1][0].setEnabled(true); // enables the button
        grid[col1][0].setBackground(new Color(r, 0, b)); // sets color of the button
        // sets the tile to a certian player to calculate the winner
        winner[col1][0] = turn;
        checkWinner();
        col1 += 1; // increases variable
        if (col1 > 5) { // if the variable becomes too high disable this button
            btnColumn1.setEnabled(false);
        }
    }

    public void column2(int r, int b) {
        grid[col2][1].setEnabled(true); // enables the button
        grid[col2][1].setBackground(new Color(r, 0, b)); // sets color of the button
        // sets the tile to a certian player to calculate the winner
        winner[col2][1] = turn;
        checkWinner();
        col2 += 1; // increases variable
        if (col2 > 5) { // if the variable becomes too high disable this button
            btnColumn2.setEnabled(false);
        }
    }

    public void column3(int r, int b) {
        grid[col3][2].setEnabled(true); // enables the button
        grid[col3][2].setBackground(new Color(r, 0, b)); // sets color of the button
        // sets the tile to a certian player to calculate the winner
        winner[col3][2] = turn;
        checkWinner();
        col3 += 1; // increases variable
        if (col3 > 5) { // if the variable becomes too high disable this button
            btnColumn3.setEnabled(false);
        }
    }

    public void column4(int r, int b) {
        grid[col4][3].setEnabled(true); // enables the button
        grid[col4][3].setBackground(new Color(r, 0, b)); // sets color of the button
        // sets the tile to a certian player to calculate the winner
        winner[col4][3] = turn;
        checkWinner();
        col4 += 1; // increases variable
        if (col4 > 5) { // if the variable becomes too high disable this button
            btnColumn4.setEnabled(false);
        }
    }

    public void column5(int r, int b) {
        grid[col5][4].setEnabled(true); // enables the button
        grid[col5][4].setBackground(new Color(r, 0, b)); // sets color of the button
        // sets the tile to a certian player to calculate the winner
        winner[col5][4] = turn;
        checkWinner();
        col5 += 1; // increases variable
        if (col5 > 5) { // if the variable becomes too high disable this button
            btnColumn5.setEnabled(false);
        }
    }

    public void column6(int r, int b) {
        grid[col6][5].setEnabled(true); // enables the button
        grid[col6][5].setBackground(new Color(r, 0, b)); // sets color of the button
        // sets the tile to a certian player to calculate the winner
        winner[col6][5] = turn;
        checkWinner();
        col6 += 1; // increases variable
        if (col6 > 5) { // if the variable becomes too high disable this button
            btnColumn6.setEnabled(false);
        }
    }

    public void column7(int r, int b) {
        grid[col7][6].setEnabled(true); // enables the button
        grid[col7][6].setBackground(new Color(r, 0, b)); // sets color of the button
        // sets the tile to a certian player to calculate the winner
        winner[col7][6] = turn;
        checkWinner();
        col7 += 1; // increases variable
        if (col7 > 5) { // if the variable becomes too high disable this button
            btnColumn7.setEnabled(false);
        }
    }

    public void turns() { // this method will switch the turn
        if (won == false) {
            turn = 2;
            int r = 0; // sets color so that the difference between players can be seen
            int b = 255;
            int random = (int) (Math.random() * 7) + 1; // generates a number between 1 and 7

            if (random == 1) {
                if (col1 <= 5) { // if the column is not full
                    column1(r, b); // calls the method and places a token
                } else {
                    turns(); // if it is full it recalls this method to choose a different number
                }
            } else if (random == 2) {
                if (col2 <= 5) {
                    column2(r, b);
                } else {
                    turns();
                }
            } else if (random == 3) {
                if (col3 <= 5) {
                    column3(r, b);
                } else {
                    turns();
                }
            } else if (random == 4) {
                if (col4 <= 5) {
                    column4(r, b);
                } else {
                    turns();
                }
            } else if (random == 5) {
                if (col5 <= 5) {
                    column5(r, b);
                } else {
                    turns();
                }
            } else if (random == 6) {
                if (col6 <= 5) {
                    column6(r, b);
                } else {
                    turns();
                }
            } else if (random == 7) {
                if (col7 <= 5) {
                    column7(r, b);
                } else {
                    turns();
                }
            }
        }
    }

    public void gameWon() {
        btnColumn1.setEnabled(false);
        btnColumn2.setEnabled(false); // disables all the buttons
        btnColumn3.setEnabled(false);
        btnColumn4.setEnabled(false);
        btnColumn5.setEnabled(false);
        btnColumn6.setEnabled(false);
        btnColumn7.setEnabled(false);

        txtOutput.setText("Congratulations Player " + turn + " Won"); // output statement
    }

    public void checkWinner() {

        for (int row = 0; row < winner.length; row++) {
            for (int col = 0; col < winner[row].length - 3; col++) {
                if (winner[row][col] == turn && winner[row][col + 1] == turn && winner[row][col + 2] == turn && winner[row][col + 3] == turn) {
                    // if 4 columns in the same row corespond to the same turn within that array the game is counted as won
                    won = true;
                    gameWon(); // calls the game won method to display the winner
                }
            }
        }

        for (int row = 0; row < winner.length - 3; row++) { // loop statement, -3 there is there so because the if statement is +3 so the -3 counteracts that and doesn't bring up a error message
            for (int col = 0; col < winner[row].length; col++) {
                if (winner[row][col] == turn && winner[row + 1][col] == turn && winner[row + 2][col] == turn && winner[row + 3][col] == turn) {
                    // if 4 rows in the same column corespond to the same turn that player will win
                    won = true;
                    gameWon();
                }
            }
        }

        for (int row = 0; row < winner.length - 3; row++) {
            for (int col = 0; col < winner[row].length - 3; col++) {
                if (winner[row][col] == turn && winner[row + 1][col + 1] == turn && winner[row + 2][col + 2] == turn && winner[row + 3][col + 3] == turn) {
                    // if 4 in a upwards diagonal are the same player then they win
                    won = true;
                    gameWon();
                }
            }
        }

        for (int row = 3; row < winner.length; row++) {
            for (int col = 0; col < winner[row].length - 3; col++) {
                if (winner[row][col] == turn && winner[row - 1][col + 1] == turn && winner[row - 2][col + 2] == turn && winner[row - 3][col + 3] == turn) {
                    // if 4 in a downwards diagonal are the same player then they win.
                    won = true;
                    gameWon();
                }
            }
        }

    }

    public EasyModeWindow(Connect4 m) {
        initComponents();

        firstWindow = m;

        // adding all the buttons to the grid
        grid[0][0] = btnRow1Col1;
        grid[0][1] = btnRow1Col2;
        grid[0][2] = btnRow1Col3;
        grid[0][3] = btnRow1Col4;
        grid[0][4] = btnRow1Col5;
        grid[0][5] = btnRow1Col6;
        grid[0][6] = btnRow1Col7;
        grid[1][0] = btnRow2Col1;
        grid[1][1] = btnRow2Col2;
        grid[1][2] = btnRow2Col3;
        grid[1][3] = btnRow2Col4;
        grid[1][4] = btnRow2Col5;
        grid[1][5] = btnRow2Col6;
        grid[1][6] = btnRow2Col7;
        grid[2][0] = btnRow3Col1;
        grid[2][1] = btnRow3Col2;
        grid[2][2] = btnRow3Col3;
        grid[2][3] = btnRow3Col4;
        grid[2][4] = btnRow3Col5;
        grid[2][5] = btnRow3Col6;
        grid[2][6] = btnRow3Col7;
        grid[3][0] = btnRow4Col1;
        grid[3][1] = btnRow4Col2;
        grid[3][2] = btnRow4Col3;
        grid[3][3] = btnRow4Col4;
        grid[3][4] = btnRow4Col5;
        grid[3][5] = btnRow4Col6;
        grid[3][6] = btnRow4Col7;
        grid[4][0] = btnRow5Col1;
        grid[4][1] = btnRow5Col2;
        grid[4][2] = btnRow5Col3;
        grid[4][3] = btnRow5Col4;
        grid[4][4] = btnRow5Col5;
        grid[4][5] = btnRow5Col6;
        grid[4][6] = btnRow5Col7;
        grid[5][0] = btnRow6Col1;
        grid[5][1] = btnRow6Col2;
        grid[5][2] = btnRow6Col3;
        grid[5][3] = btnRow6Col4;
        grid[5][4] = btnRow6Col5;
        grid[5][5] = btnRow6Col6;
        grid[5][6] = btnRow6Col7;
        // adding all the buttons to the grid

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        connect4Grid = new javax.swing.JPanel();
        btnRow1Col1 = new javax.swing.JButton();
        btnRow1Col2 = new javax.swing.JButton();
        btnRow1Col3 = new javax.swing.JButton();
        btnRow1Col4 = new javax.swing.JButton();
        btnRow1Col5 = new javax.swing.JButton();
        btnRow1Col6 = new javax.swing.JButton();
        btnRow1Col7 = new javax.swing.JButton();
        btnRow2Col1 = new javax.swing.JButton();
        btnRow2Col2 = new javax.swing.JButton();
        btnRow2Col3 = new javax.swing.JButton();
        btnRow2Col4 = new javax.swing.JButton();
        btnRow2Col5 = new javax.swing.JButton();
        btnRow2Col6 = new javax.swing.JButton();
        btnRow2Col7 = new javax.swing.JButton();
        btnRow3Col1 = new javax.swing.JButton();
        btnRow3Col2 = new javax.swing.JButton();
        btnRow3Col3 = new javax.swing.JButton();
        btnRow3Col4 = new javax.swing.JButton();
        btnRow3Col5 = new javax.swing.JButton();
        btnRow3Col6 = new javax.swing.JButton();
        btnRow3Col7 = new javax.swing.JButton();
        btnRow4Col1 = new javax.swing.JButton();
        btnRow4Col2 = new javax.swing.JButton();
        btnRow4Col3 = new javax.swing.JButton();
        btnRow4Col4 = new javax.swing.JButton();
        btnRow4Col5 = new javax.swing.JButton();
        btnRow4Col6 = new javax.swing.JButton();
        btnRow4Col7 = new javax.swing.JButton();
        btnRow5Col1 = new javax.swing.JButton();
        btnRow5Col2 = new javax.swing.JButton();
        btnRow5Col3 = new javax.swing.JButton();
        btnRow5Col4 = new javax.swing.JButton();
        btnRow5Col5 = new javax.swing.JButton();
        btnRow5Col6 = new javax.swing.JButton();
        btnRow5Col7 = new javax.swing.JButton();
        btnRow6Col1 = new javax.swing.JButton();
        btnRow6Col2 = new javax.swing.JButton();
        btnRow6Col3 = new javax.swing.JButton();
        btnRow6Col4 = new javax.swing.JButton();
        btnRow6Col5 = new javax.swing.JButton();
        btnRow6Col6 = new javax.swing.JButton();
        btnRow6Col7 = new javax.swing.JButton();
        txtOutput = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        btnMainMenu = new javax.swing.JButton();
        btnColumn1 = new javax.swing.JButton();
        btnColumn2 = new javax.swing.JButton();
        btnColumn3 = new javax.swing.JButton();
        btnColumn4 = new javax.swing.JButton();
        btnColumn5 = new javax.swing.JButton();
        btnColumn6 = new javax.swing.JButton();
        btnColumn7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        connect4Grid.setBackground(java.awt.Color.orange);

        btnRow1Col1.setEnabled(false);
        btnRow1Col1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRow1Col1ActionPerformed(evt);
            }
        });

        btnRow1Col2.setEnabled(false);

        btnRow1Col3.setEnabled(false);

        btnRow1Col4.setEnabled(false);

        btnRow1Col5.setEnabled(false);

        btnRow1Col6.setEnabled(false);
        btnRow1Col6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRow1Col6ActionPerformed(evt);
            }
        });

        btnRow1Col7.setEnabled(false);

        btnRow2Col1.setEnabled(false);

        btnRow2Col2.setEnabled(false);

        btnRow2Col3.setEnabled(false);

        btnRow2Col4.setDoubleBuffered(true);
        btnRow2Col4.setEnabled(false);

        btnRow2Col5.setEnabled(false);

        btnRow2Col6.setEnabled(false);

        btnRow2Col7.setEnabled(false);

        btnRow3Col1.setEnabled(false);

        btnRow3Col2.setEnabled(false);

        btnRow3Col3.setEnabled(false);

        btnRow3Col4.setEnabled(false);

        btnRow3Col5.setEnabled(false);

        btnRow3Col6.setEnabled(false);

        btnRow3Col7.setEnabled(false);

        btnRow4Col1.setEnabled(false);

        btnRow4Col2.setEnabled(false);

        btnRow4Col3.setEnabled(false);

        btnRow4Col4.setEnabled(false);

        btnRow4Col5.setEnabled(false);

        btnRow4Col6.setEnabled(false);

        btnRow4Col7.setEnabled(false);

        btnRow5Col1.setEnabled(false);

        btnRow5Col2.setEnabled(false);

        btnRow5Col3.setEnabled(false);

        btnRow5Col4.setEnabled(false);

        btnRow5Col5.setEnabled(false);

        btnRow5Col6.setEnabled(false);

        btnRow5Col7.setEnabled(false);

        btnRow6Col1.setEnabled(false);

        btnRow6Col2.setEnabled(false);

        btnRow6Col3.setEnabled(false);

        btnRow6Col4.setEnabled(false);

        btnRow6Col5.setEnabled(false);

        btnRow6Col6.setEnabled(false);

        btnRow6Col7.setEnabled(false);

        javax.swing.GroupLayout connect4GridLayout = new javax.swing.GroupLayout(connect4Grid);
        connect4Grid.setLayout(connect4GridLayout);
        connect4GridLayout.setHorizontalGroup(
            connect4GridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(connect4GridLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(connect4GridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(connect4GridLayout.createSequentialGroup()
                        .addComponent(btnRow2Col1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRow2Col2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRow2Col3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRow2Col4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRow2Col5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRow2Col6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRow2Col7))
                    .addGroup(connect4GridLayout.createSequentialGroup()
                        .addComponent(btnRow3Col1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRow3Col2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRow3Col3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRow3Col4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRow3Col5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRow3Col6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRow3Col7))
                    .addGroup(connect4GridLayout.createSequentialGroup()
                        .addComponent(btnRow4Col1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRow4Col2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRow4Col3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRow4Col4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRow4Col5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRow4Col6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRow4Col7))
                    .addGroup(connect4GridLayout.createSequentialGroup()
                        .addComponent(btnRow5Col1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRow5Col2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRow5Col3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRow5Col4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRow5Col5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRow5Col6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRow5Col7))
                    .addGroup(connect4GridLayout.createSequentialGroup()
                        .addComponent(btnRow6Col1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRow6Col2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRow6Col3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRow6Col4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRow6Col5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRow6Col6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRow6Col7))
                    .addGroup(connect4GridLayout.createSequentialGroup()
                        .addComponent(btnRow1Col1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRow1Col2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRow1Col3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRow1Col4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRow1Col5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRow1Col6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRow1Col7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        connect4GridLayout.setVerticalGroup(
            connect4GridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, connect4GridLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(connect4GridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRow6Col1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRow6Col2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRow6Col3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRow6Col4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRow6Col5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRow6Col6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRow6Col7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(connect4GridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRow5Col1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRow5Col2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRow5Col3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRow5Col4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRow5Col5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRow5Col6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRow5Col7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(connect4GridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRow4Col1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRow4Col2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRow4Col3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRow4Col4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRow4Col5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRow4Col6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRow4Col7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(connect4GridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRow3Col1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRow3Col2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRow3Col3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRow3Col4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRow3Col5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRow3Col6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRow3Col7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(connect4GridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRow2Col1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRow2Col2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRow2Col3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRow2Col4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRow2Col5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRow2Col6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRow2Col7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(connect4GridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRow1Col7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRow1Col6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRow1Col5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRow1Col4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRow1Col3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRow1Col2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRow1Col1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );

        txtOutput.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtOutput.setText("Player 1's Turn, Select A Column");

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnMainMenu.setText("Main Menu");
        btnMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMainMenuActionPerformed(evt);
            }
        });

        btnColumn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColumn1ActionPerformed(evt);
            }
        });

        btnColumn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColumn2ActionPerformed(evt);
            }
        });

        btnColumn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColumn3ActionPerformed(evt);
            }
        });

        btnColumn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColumn4ActionPerformed(evt);
            }
        });

        btnColumn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColumn5ActionPerformed(evt);
            }
        });

        btnColumn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColumn6ActionPerformed(evt);
            }
        });

        btnColumn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColumn7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtOutput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(connect4Grid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMainMenu, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(btnColumn1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnColumn2)
                        .addGap(10, 10, 10)
                        .addComponent(btnColumn3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnColumn4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnColumn5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnColumn6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnColumn7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(txtOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnReset)
                        .addGap(18, 18, 18)
                        .addComponent(btnMainMenu))
                    .addComponent(connect4Grid, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnColumn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnColumn2, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(btnColumn3, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(btnColumn4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(btnColumn5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(btnColumn6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(btnColumn7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRow1Col1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRow1Col1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRow1Col1ActionPerformed

    private void btnRow1Col6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRow1Col6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRow1Col6ActionPerformed

    private void btnColumn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColumn7ActionPerformed
        turn = 1; // setting the turn variable
        int r = 255; // changing color of the tokens
        int b = 0;

        column7(r, b); // calling the methid

        turns(); // makes the computer make a move
    }//GEN-LAST:event_btnColumn7ActionPerformed

    private void btnColumn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColumn1ActionPerformed
        turn = 1;
        int r = 255;
        int b = 0;

        column1(r, b); // calling the method

        turns(); // makes the computer make a move
    }//GEN-LAST:event_btnColumn1ActionPerformed

    private void btnColumn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColumn2ActionPerformed
        turn = 1;
        int r = 255;
        int b = 0;

        column2(r, b); // calling the method

        turns(); // makes the computer make a move
    }//GEN-LAST:event_btnColumn2ActionPerformed

    private void btnColumn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColumn3ActionPerformed
        turn = 1;
        int r = 255;
        int b = 0;

        column3(r, b); // calling the method

        turns(); // makes the computer make a move
    }//GEN-LAST:event_btnColumn3ActionPerformed

    private void btnColumn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColumn4ActionPerformed
        turn = 1;
        int r = 255;
        int b = 0;

        column4(r, b); // calling the mathod to place a token

        turns(); // makes the computer make a move
    }//GEN-LAST:event_btnColumn4ActionPerformed

    private void btnColumn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColumn5ActionPerformed
        turn = 1;
        int r = 255;
        int b = 0;

        column5(r, b); // calling the method to place a token

        turns(); // makes the computer make a move
    }//GEN-LAST:event_btnColumn5ActionPerformed

    private void btnColumn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColumn6ActionPerformed
        turn = 1;
        int r = 255;
        int b = 0;

        column6(r, b); // calling a method to place the token

        turns(); // makes the computer make a move
    }//GEN-LAST:event_btnColumn6ActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                grid[row][col].setEnabled(false); // a loop that will disable all the buttons on the grid
            }
        }

        for (int row = 0; row < winner.length; row++) {
            for (int col = 0; col < winner[row].length; col++) {
                winner[row][col] = 3; // a loop that will change all varaibles in the winner array to a meaningless number so that the game wont be won instnatly
            }
        }

        // enabling all the buttons of the columns and resetting the varaibles
        btnColumn1.setEnabled(true);
        col1 = 0;
        btnColumn2.setEnabled(true);
        col2 = 0;
        btnColumn3.setEnabled(true);
        col3 = 0;
        btnColumn4.setEnabled(true);
        col4 = 0;
        btnColumn5.setEnabled(true);
        col5 = 0;
        btnColumn6.setEnabled(true);
        col6 = 0;
        btnColumn7.setEnabled(true);
        col7 = 0;
        won = false;
        txtOutput.setText("Play 1's Turn, Select A column");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMainMenuActionPerformed
        firstWindow.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnMainMenuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnColumn1;
    private javax.swing.JButton btnColumn2;
    private javax.swing.JButton btnColumn3;
    private javax.swing.JButton btnColumn4;
    private javax.swing.JButton btnColumn5;
    private javax.swing.JButton btnColumn6;
    private javax.swing.JButton btnColumn7;
    private javax.swing.JButton btnMainMenu;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnRow1Col1;
    private javax.swing.JButton btnRow1Col2;
    private javax.swing.JButton btnRow1Col3;
    private javax.swing.JButton btnRow1Col4;
    private javax.swing.JButton btnRow1Col5;
    private javax.swing.JButton btnRow1Col6;
    private javax.swing.JButton btnRow1Col7;
    private javax.swing.JButton btnRow2Col1;
    private javax.swing.JButton btnRow2Col2;
    private javax.swing.JButton btnRow2Col3;
    private javax.swing.JButton btnRow2Col4;
    private javax.swing.JButton btnRow2Col5;
    private javax.swing.JButton btnRow2Col6;
    private javax.swing.JButton btnRow2Col7;
    private javax.swing.JButton btnRow3Col1;
    private javax.swing.JButton btnRow3Col2;
    private javax.swing.JButton btnRow3Col3;
    private javax.swing.JButton btnRow3Col4;
    private javax.swing.JButton btnRow3Col5;
    private javax.swing.JButton btnRow3Col6;
    private javax.swing.JButton btnRow3Col7;
    private javax.swing.JButton btnRow4Col1;
    private javax.swing.JButton btnRow4Col2;
    private javax.swing.JButton btnRow4Col3;
    private javax.swing.JButton btnRow4Col4;
    private javax.swing.JButton btnRow4Col5;
    private javax.swing.JButton btnRow4Col6;
    private javax.swing.JButton btnRow4Col7;
    private javax.swing.JButton btnRow5Col1;
    private javax.swing.JButton btnRow5Col2;
    private javax.swing.JButton btnRow5Col3;
    private javax.swing.JButton btnRow5Col4;
    private javax.swing.JButton btnRow5Col5;
    private javax.swing.JButton btnRow5Col6;
    private javax.swing.JButton btnRow5Col7;
    private javax.swing.JButton btnRow6Col1;
    private javax.swing.JButton btnRow6Col2;
    private javax.swing.JButton btnRow6Col3;
    private javax.swing.JButton btnRow6Col4;
    private javax.swing.JButton btnRow6Col5;
    private javax.swing.JButton btnRow6Col6;
    private javax.swing.JButton btnRow6Col7;
    private javax.swing.JPanel connect4Grid;
    private javax.swing.JLabel txtOutput;
    // End of variables declaration//GEN-END:variables
}
