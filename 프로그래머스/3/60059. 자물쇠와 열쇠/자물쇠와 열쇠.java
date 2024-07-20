import java.util.*;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int n = lock.length;
        int m = key.length;

        // 키의 4가지 회전 상태를 저장
        int[][][] rotatedKeys = new int[4][m][m];
        rotatedKeys[0] = key;
        for (int i = 1; i < 4; i++) {
            rotatedKeys[i] = rotate(rotatedKeys[i - 1]);
        }

        // lock을 n + 2 * (m - 1) 크기의 확장된 배열에 중앙에 배치
        int expandSize = n + 2 * (m - 1);
        int[][] expandedLock = new int[expandSize][expandSize];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                expandedLock[i + m - 1][j + m - 1] = lock[i][j];
            }
        }

        // 키를 모든 위치에서 시도해 봅니다.
        for (int r = 0; r < 4; r++) {
            int[][] currentKey = rotatedKeys[r];
            for (int x = 0; x < expandSize - m + 1; x++) {
                for (int y = 0; y < expandSize - m + 1; y++) {
                    if (canUnlock(expandedLock, currentKey, x, y, n)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private int[][] rotate(int[][] key) {
        int m = key.length;
        int[][] rotatedKey = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                rotatedKey[j][m - 1 - i] = key[i][j];
            }
        }
        return rotatedKey;
    }

    private boolean canUnlock(int[][] expandedLock, int[][] key, int x, int y, int n) {
        int m = key.length;
        int[][] tempLock = new int[expandedLock.length][expandedLock.length];
        for (int i = 0; i < expandedLock.length; i++) {
            tempLock[i] = Arrays.copyOf(expandedLock[i], expandedLock[i].length);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                tempLock[x + i][y + j] += key[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tempLock[i + m - 1][j + m - 1] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] key = { {0, 0, 0}, {1, 0, 0}, {0, 1, 1} };
        int[][] lock = { {1, 1, 1}, {1, 1, 0}, {1, 0, 1} };

        boolean result = solution.solution(key, lock);
        System.out.println("Can the key unlock the lock? " + result);
    }
}
