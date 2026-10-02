class Solution {

    bool isRowValidFill(int val, int row, int c, vector<vector<char>>& board){
        for(int col = 0; col<board[0].size(); ++col){
            if(col ==c) continue;
            if((board[row][col]-'0') == val) return false;
        }
        return true;
    }

    bool isColValidFill(int val, int r, int col, vector<vector<char>>& board){
        for(int row = 0; row<board[0].size(); ++row){
            if(row == r) continue;
            if((board[row][col]-'0') == val) return false;
        }
        return true;
    }

    bool isSubBoxValidFill(int val, int row, int col, vector<vector<char>>& board){
        int rowStart = (row/3)*3;
        int colStart = (col/3)*3;
        for(int r = rowStart; r<(rowStart+3) ;++r){
            for(int c = colStart; c<(colStart+3) ; ++c){
                if(r == row && c==col) continue;
                if((board[r][c]-'0') == val) return false;
            }
        }
        return true;
    }

    bool isValidFill(int val, int row, int col, vector<vector<char>>& board){
        return isRowValidFill(val, row, col, board) && isColValidFill(val, row, col, board) && isSubBoxValidFill(val, row, col, board);
    }

public:
    // bool isValidSudoku(vector<vector<char>>& board) {
    //     int n = board.size(), m = board[0].size();
    //     for(int row = 0; row < n; ++row){
    //         for(int col = 0; col<m; ++col){
    //             if(board[row][col] == '.') continue;
    //             if(!isValidFill(board[row][col]-'0', row, col, board)){
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }
    bool isValidSudoku(vector<vector<char>>& board) {
        int n = board.size();
        int m = board[0].size();
        vector<unordered_set<int>> rows(n);
        vector<unordered_set<int>> cols(m);
        vector<unordered_set<int>> box(n);
        for(int row = 0; row<n; ++row){
            for(int col = 0; col<m; ++col){
                if(board[row][col] == '.') continue;
                int digit = board[row][col] - '0';
                if(
                    rows[row].count(digit) ||
                    cols[col].count(digit) ||
                    box[(row/3)*3 + col/3].count(digit)
                ) return false;
                rows[row].insert(digit);
                cols[col].insert(digit);
                box[(row/3)*3 + col/3].insert(digit);
            }
        }
        return true;
    }
};