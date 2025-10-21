package com.sebastian.app;

import java.util.Scanner;

import com.sebastian.service.FoodFestivalService;

public class FestivalApp {
    private FoodFestivalService service; 

    public FestivalApp(FoodFestivalService service){
        this.service = service; 
    }

    public void start(){
        Scanner sc = new Scanner(System.in);
        int dec = 0;
        do{
            System.out.println("Choose an aption:\n1. Filter dishes\n2. Get 3 dishes with the least calories\n3. Group By category\n4. Exit ");
            dec = Integer.valueOf(sc.nextLine());

            switch (dec) {
                case 1:
                    System.out.println("Give me the category (Vegan, Sweet, Spicy, Beverage or Classic)");
                    String category = sc.nextLine();
                    System.out.println("Give me your budget");
                    double budget = Double.parseDouble(sc.nextLine());
                    System.out.println(service.filterByBudgetAndCategory(category, budget));
                    break;
                case 2:
                    System.out.println(service.healthyTop3());
                    break;
                case 3: 
                    System.out.println(service.groupByCategory());
                    break;
                default:
                    System.out.println("The option you chose was incorrect. Try again.");
                    break;
            }
        }while(dec < 4);
    }
}
