public class solution{
    public ArrayList<ArrayList<Integer>> subset(int[] num){
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0){
            return result;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(num);
        subsetHelper(result, list, num, 0);

        return result;
    }

    private void subsetHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] num, int pos){
        result.add(new ArrayList<Integer>(list));//
        for(int i = pos; i< num.length; i++){
            list.add(num[i]);
            subsetHelper(result, list, num, i+1);
            list.remove(list.size()-1);
        } 
    }
}
