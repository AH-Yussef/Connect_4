package com.connect_4.connect4_UI.Algo.Heuristic;

public class HeuristicCalculator {
    private int evaluate(int[][] board,int player){
        int count = 0;
        Mapper M = new Mapper();
        Counter C = new Counter();
        String [] rows,columns,downUp,upDown;
        rows = M.mapRows(board);
        columns = M.mapColumns(board);
        downUp = M.mapDownUp(board);
        upDown = M.mapUpDown(board);
        /* weight of four 90000 */
        int four = 120_000*C.countFour(rows,columns,downUp,upDown,player);
        /* 3 consecutive with twe free adjacent 80000 */
        int threeWith2FreeAdj = 90000*C.countThreeWith2FreeAdj(rows,columns,downUp,upDown,player);
        /* 3 consecutive with one side free & three separated 50000 */
        int threeWith1FreeAdj_case1 = 50000*C.countThreeWith1FreeAdj(rows,columns,downUp,upDown,player);
        int threeWith1FreeAdj_case2 = 50000*C.countThreeSeparated(rows,columns,downUp,upDown,player);
        /* 2 consecutive with two free adjacent 5000 */
        int twoWith2FreeAdj = 5000*C.countTwoWith2FreeAdj(rows,columns,downUp,upDown,player);
        /* 4000 3000 2000 1000 */
        int twoWith5Free = 4000*C.countTwoWith5Free(rows,columns,downUp,upDown,player);
        int twoWith4Free = 3000*C.countTwoWith4Free(rows,columns,downUp,upDown,player);
        int twoWith3Free = 2000*C.countTwoWith3Free(rows,columns,downUp,upDown,player);
        int twoWith2Free = 1000*C.countTwoWith2Free(rows,columns,downUp,upDown,player);
        /*d = 50 / 30 / 15 / 5 */
        int[][] ones = C.countOne(board,player);
        int[] oneWeights = {5,15,30,50,30,15,5};
        int weightSumOfOne = 0;
        for(int i = 0 ; i < 7 ;i++){
            for(int j = 0 ; j < 6 ;j++){
                if(ones[j][i]==1) {
                    weightSumOfOne = weightSumOfOne + oneWeights[i];
                }
            }
        }
        count = four + threeWith2FreeAdj +threeWith1FreeAdj_case1+threeWith1FreeAdj_case2+twoWith2FreeAdj
                +twoWith5Free+twoWith4Free+twoWith3Free+twoWith2Free+weightSumOfOne;

        return count;
    }

    public int evaluateHuman(int[][] board){
        return evaluate(board , 1);
    }
    public int evaluateComputer(int[][] board){
        return evaluate(board , 2);
    }
}
