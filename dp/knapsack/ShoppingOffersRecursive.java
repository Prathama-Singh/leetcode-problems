//https://leetcode.com/problems/shopping-offers/description/?envType=problem-list-v2&envId=50vif4uc
class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {   
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
                offer.get(needs.size()) + shoppingOffers(price, special, newNeeds)
            );
    }
    return min_price;       
    }
}
