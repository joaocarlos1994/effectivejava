package br.com.effectivejava.item2;

public class NutritionFacts {
	
	private final int servingSize;
	private final int servings;
	private final int calories;
	private final int fat;
	private final int sodium;
	private final int carbohydrate;
	
	
	public static class Builder {
		
		private final int servingSize;
		private final int servings;
		
		private int calories = 0;
		private int fat = 0;
		private int carbohydrate = 0;
		private int sodium = 0;
		
		public Builder (final int servingSize, final int servings){
			this.servingSize = servingSize;
			this.servings = servings;
		}
		
		public Builder calories(final int val){
			this.calories = val;
			return this;
		}
		
		public Builder fat(final int val){
			this.fat = val;
			return this;
		}
		
		public Builder carbohydrate(final int val){
			this.carbohydrate = val;
			return this;
		}
		
		public Builder sodium(final int val){
			this.sodium = val;
			return this;
		}
		
		public NutritionFacts build(){
			return new NutritionFacts(this);
		}
		
	}
	
	private NutritionFacts(final Builder builder){
		this.servingSize = builder.servingSize;
		this.servings = builder.servings;
		this.calories = builder.calories;
		this.fat = builder.fat;
		this.sodium = builder.sodium;
		this.carbohydrate = builder.carbohydrate;
	}
	
}
