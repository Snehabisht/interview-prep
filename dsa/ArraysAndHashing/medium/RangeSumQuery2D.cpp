class NumMatrix {
    vector<vector<int>> helperMatrix;
    int n;
    int m;
public:
    NumMatrix(vector<vector<int>>& matrix) {
        helperMatrix = matrix;
        n = matrix.size();
        m = matrix[0].size();
        for(int row = 0; row < n; ++row){
            for(int col = 1; col < m; ++col){
                helperMatrix[row][col] += helperMatrix[row][col-1];
            }
        }
        for(int col = 0; col < m; ++col){
            for(int row = 1; row < n; ++row){
                helperMatrix[row][col] += helperMatrix[row-1][col];
            }
        }
    }
    
    int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = helperMatrix[row2][col2];
        if(row1 > 0) sum -= helperMatrix[row1-1][col2];
        if(col1 > 0) sum -= helperMatrix[row2][col1-1];
        if((row1 > 0) && (col1 > 0))  sum += helperMatrix[row1-1][col1-1];
        return sum;
    }
};

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix* obj = new NumMatrix(matrix);
 * int param_1 = obj->sumRegion(row1,col1,row2,col2);
 */