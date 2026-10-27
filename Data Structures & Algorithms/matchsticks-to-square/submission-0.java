class Solution {
    public boolean makesquare(int[] matchsticks) {
        int total = 0;

        for(int num: matchsticks){
            total += num;
        }

        if(total % 4 != 0){
            return false;
        }

        int target  = total /4;

    Arrays.sort(matchsticks);
    for(int i=0; i< matchsticks.length ; i++){

        int temp = matchsticks[i];
        matchsticks[i] = matchsticks[matchsticks.length - 1 -i];
         matchsticks[matchsticks.length - 1 -i] = temp;
    }

    if(matchsticks[0] > target){
        return false;
    }

    int []side = new int[4];

    return backtrack(matchsticks , target , 0 , side);
    }

    private boolean backtrack(int []matchsticks , int target , int index  ,int[] side){
        if(index == matchsticks.length){
            return side[0] == target && side[1] == target&& side[2] == target && side[3] == target;
        }

        int stick = matchsticks[index];
        for(int i =0; i< 4; i++){
            if(side[i] + stick  > target){
                continue;
            }

            side[i] += stick;
            if(backtrack(matchsticks , target  , index +1  , side)){
                return true;
            }
            side[i] -= stick;

            if(side [i]== 0){
                break;
            }
        }
        return false;
    }
}