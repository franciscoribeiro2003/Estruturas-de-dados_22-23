class ED213{

    public static String maxSum(BTree<Integer> t){
         return maximo(t.getRoot(),"");
    }

    private static int maxSum(BTNode<Integer> t){
        if (t==null) {
            return 0;

        }
        return t.getValue() + Math.max(maxSum(t.getLeft()),maxSum(t.getRight()));
    }

    private static String maximo(BTNode<Integer> t,String out){

        if (t.getRight()==null && t.getLeft()==null) return out;    
        if (Math.max(maxSum(t.getLeft()),maxSum(t.getRight()))==maxSum(t.getRight())) {
            out+="D";
            return maximo(t.getRight(),out); 
        }

        if (Math.max(maxSum(t.getLeft()),maxSum(t.getRight()))==maxSum(t.getLeft())) {
            out+="E";
            return maximo(t.getLeft(),out); 
        }
        return out;


    } 
}
