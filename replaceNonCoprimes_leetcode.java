class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<nums.length; i++){
            stack.push(nums[i]);

            while(stack.size() > 1){
                int a = stack.pop();
                int b = stack.pop();

                if(gcd(a, b) > 1){
                    stack.push(lcm(a, b));
                }else{
                    stack.push(b);
                    stack.push(a);
                    break;
                }
            }
        }

        return new ArrayList<>(stack); 
    }

    public int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public int lcm(int a, int b){
        return a/gcd(a, b) * b;
    }
}
