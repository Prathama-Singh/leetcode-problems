class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {   
     Map<List<Integer>, Integer> dp = new HashMap<>();
     return dfs(price, special, needs, dp);
    }

    int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> dp){
        if(dp.containsKey(needs))
            return dp.get(needs);

        int min_price = 0;
        for(int i = 0; i < needs.size(); i++)
            min_price = min_price + (needs.get(i) * price.get(i));

        for(int i = 0 ; i < special.size(); i++){
            List<Integer> newNeeds = new LinkedList<>();
            List<Integer> offer = special.get(i);
            boolean isValidOffer = true;
            for(int j = 0; j < needs.size() ; j ++){
                if(offer.get(j) > needs.get(j)){
                    isValidOffer = false;
                    break;
                }
                newNeeds.add(needs.get(j) - offer.get(j));
            }
            if(isValidOffer)
                min_price = Math.min( min_price, 
                    offer.get(needs.size()) + dfs(price, special, newNeeds, dp)
                );
        }
        dp.put(needs, min_price);
        return min_price;      
    }
}
