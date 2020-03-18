class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int n : nums){
            if(freq.get(n)==null){
                freq.put(n,1);
            }
            else{
                freq.put(n,freq.get(n)+1);
            }
        }
        ArrayList<Num> nfreq = new ArrayList<>();
        for(Map.Entry<Integer, Integer> e: freq.entrySet()){
            nfreq.add(new Num(e.getKey(), e.getValue()));
        }
        Collections.sort(nfreq);
        display(nfreq);
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i <k; i++){
            res.add(nfreq.get(i).n);
        }
        return res;
        
    }
    public static void display(ArrayList<Num> x){
        for(Num i: x){
            System.out.print(i.n +" "+ i.fr+"\t");
        }
        System.out.println();
    }

}
    class Num implements Comparable<Num>{
        int n;
        int fr;
        Num(int n, int f){
            this.n = n;
            this.fr = f;
        }
        public int compareTo(Num x){
            return x.fr - this.fr; 
        }
        
    }
