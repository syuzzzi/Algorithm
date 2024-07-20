import java.util.*;

class Solution {
    public int[][] pillarMap; // 0: 비어있음, 1: 있음
    public int[][] boMap; // 0: 비어있음, 1: 있음
    public int n;

    public boolean checkPillarIdx(int x, int y) {
        return x >= 0 && y >= 0 && x <= n && y < n;
    }

    public boolean checkBoIdx(int x, int y) {
        return x >= 0 && y > 0 && x < n && y <= n;
    }

    public boolean isPillar(int x, int y) {
        return checkPillarIdx(x, y) && pillarMap[x][y] == 1;
    }

    public boolean isBo(int x, int y) {
        return checkBoIdx(x, y) && boMap[x][y] == 1;
    }

    public boolean canPillar(int x, int y) {
        return y == 0 || isPillar(x, y - 1) || isBo(x - 1, y) || isBo(x, y);
    }

    public boolean canBo(int x, int y) {
        return isPillar(x, y - 1) || isPillar(x + 1, y - 1) || (isBo(x - 1, y) && isBo(x + 1, y));
    }

    public boolean buildPillar(int x, int y) {
        if (canPillar(x, y)) {
            pillarMap[x][y] = 1;
            return true;
        }
        return false;
    }

    public boolean breakPillar(int x, int y) {
        pillarMap[x][y] = 0;
        if ((isBo(x, y + 1) && !canBo(x, y + 1)) || (isBo(x - 1, y + 1) && !canBo(x - 1, y + 1)) || (isPillar(x, y + 1) && !canPillar(x, y + 1))) {
            pillarMap[x][y] = 1;
            return false;
        }
        return true;
    }

    public boolean buildBo(int x, int y) {
        if (canBo(x, y)) {
            boMap[x][y] = 1;
            return true;
        }
        return false;
    }

    public boolean breakBo(int x, int y) {
        boMap[x][y] = 0;
        if ((isBo(x + 1, y) && !canBo(x + 1, y)) || (isBo(x - 1, y) && !canBo(x - 1, y)) || (isPillar(x, y) && !canPillar(x, y)) || (isPillar(x + 1, y) && !canPillar(x + 1, y))) {
            boMap[x][y] = 1;
            return false;
        }
        return true;
    }

    public int findRemoveIdx(int a, int b, int c, List<int[]> list) {
        for (int i = 0; i < list.size(); i++) {
            int[] entity = list.get(i);
            if (entity[0] == a && entity[1] == b && entity[2] == c) {
                return i;
            }
        }
        return -1;
    }

    public List<int[]> solution(int n, int[][] build_frame) {
        List<int[]> resultList = new LinkedList<>();
        this.n = n;
        this.pillarMap = new int[n + 1][n + 1];
        this.boMap = new int[n + 1][n + 1];

        for (int[] input : build_frame) {
            if (input[2] == 0 && checkPillarIdx(input[0], input[1])) {
                if (input[3] == 0) {
                    if (breakPillar(input[0], input[1])) {
                        int deleteIdx = findRemoveIdx(input[0], input[1], input[2], resultList);
                        resultList.remove(deleteIdx);
                    }
                } else if (input[3] == 1) {
                    if (buildPillar(input[0], input[1])) {
                        resultList.add(new int[]{input[0], input[1], input[2]});
                    }
                }
            } else if (input[2] == 1 && checkBoIdx(input[0], input[1])) {
                if (input[3] == 0) {
                    if (breakBo(input[0], input[1])) {
                        int deleteIdx = findRemoveIdx(input[0], input[1], input[2], resultList);
                        resultList.remove(deleteIdx);
                    }
                } else if (input[3] == 1) {
                    if (buildBo(input[0], input[1])) {
                        resultList.add(new int[]{input[0], input[1], input[2]});
                    }
                }
            }
        }
        resultList.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                if (o1[1] == o2[1]) {
                    return Integer.compare(o1[2], o2[2]);
                }
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });
        return resultList;
    }
}
