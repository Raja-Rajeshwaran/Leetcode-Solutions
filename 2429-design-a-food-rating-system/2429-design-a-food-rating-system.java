public class FoodRatings {
    private Map<String, Integer> foodToRating = new HashMap<>();
    private Map<String, String> foodToCuisine = new HashMap<>();
    private Map<String, TreeSet<FoodEntry>> cuisineToFoods = new HashMap<>();
    private static class FoodEntry {
        String food;
        int rating;

        FoodEntry(String food, int rating) {
            this.food = food;
            this.rating = rating;
        }
    }
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            foodToRating.put(food, rating);
            foodToCuisine.put(food, cuisine);

            cuisineToFoods
                .computeIfAbsent(cuisine, k -> new TreeSet<>((a, b) -> {
                    if (a.rating != b.rating) {
                        return b.rating - a.rating;
                    }
                    return a.food.compareTo(b.food); 
                }))
                .add(new FoodEntry(food, rating));
        }
    }
    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        TreeSet<FoodEntry> foodsSet = cuisineToFoods.get(cuisine);
        foodsSet.remove(new FoodEntry(food, foodToRating.get(food)));
        foodToRating.put(food, newRating);
        foodsSet.add(new FoodEntry(food, newRating));
    }

    public String highestRated(String cuisine) {
        return cuisineToFoods.get(cuisine).first().food;
    }
}

