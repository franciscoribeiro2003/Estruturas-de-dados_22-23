class ED211{

    public static int countEven(BTree<Integer> t){
         return countEven(t.getRoot());
    }

    public static int countEven(BTNode<Integer> t){
        if (t==null) return 0; 
        if (t.getValue()%2==0) return 1 + countEven(t.getLeft()) + countEven(t.getRight());
        return (countEven(t.getLeft()) + countEven(t.getRight()));
    }
}
